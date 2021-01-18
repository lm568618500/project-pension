package me.zhyd.oauth.request;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.config.AuthSource;
import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.model.*;
import me.zhyd.oauth.utils.UrlBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * 微软登录
 *
 * @author yangkai.shen (https://xkcoding.com)
 * @version 1.5
 * @since 1.5
 */
public class AuthMicrosoftRequest extends BaseAuthRequest {
	public AuthMicrosoftRequest(AuthConfig config) {
		super(config, AuthSource.MICROSOFT);
	}

	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getMicrosoftAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				config.getRedirectUri(), authCallback.getCode());

		return getToken(accessTokenUrl);
	}

	/**
	 * 获取token，适用于获取access_token和刷新token
	 *
	 * @param accessTokenUrl 实际请求token的地址
	 * @return token对象
	 */
	private AuthToken getToken(String accessTokenUrl) {
		Map<String, Object> paramMap = new HashMap<>(6);
		HttpUtil.decodeParamMap(accessTokenUrl, "UTF-8").forEach(paramMap::put);
		HttpResponse response = HttpRequest.post(accessTokenUrl).header("Host", "https://login.microsoftonline.com")
				.header("Content-Type", "application/x-www-form-urlencoded").form(paramMap).execute();
		String accessTokenStr = response.body();
		JSONObject accessTokenObject = JSONObject.parseObject(accessTokenStr);

		this.checkResponse(accessTokenObject);
		AuthToken ret = new AuthToken();
		ret.setAccessToken(accessTokenObject.getString("access_token"));
		ret.setExpireIn(accessTokenObject.getIntValue("expires_in"));
		ret.setScope(accessTokenObject.getString("scope"));
		ret.setTokenType(accessTokenObject.getString("token_type"));
		ret.setRefreshToken(accessTokenObject.getString("refresh_token"));
		return ret;
	}

	private void checkResponse(JSONObject response) {
		if (response.containsKey("error")) {
			throw new AuthException(response.getString("error_description"));
		}
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		String token = authToken.getAccessToken();
		String tokenType = authToken.getTokenType();
		String jwt = tokenType + " " + token;
		HttpResponse response = HttpRequest.get(UrlBuilder.getMicrosoftUserInfoUrl()).header("Authorization", jwt)
				.execute();
		String userInfo = response.body();
		JSONObject object = JSONObject.parseObject(userInfo);
		AuthUser ret = new AuthUser();
		ret.setUuid(object.getString("id"));
		ret.setUsername(object.getString("userPrincipalName"));
		ret.setNickname(object.getString("displayName"));
		ret.setLocation(object.getString("officeLocation"));
		ret.setEmail(object.getString("mail"));
		ret.setGender(AuthUserGender.UNKNOW);
		ret.setToken(authToken);
		ret.setSource(AuthSource.MICROSOFT);
		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getMicrosoftAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}

	/**
	 * 刷新access token （续期）
	 *
	 * @param authToken 登录成功后返回的Token信息
	 * @return AuthResponse
	 */
	@Override
	public AuthResponse refresh(AuthToken authToken) {
		String refreshTokenUrl = UrlBuilder.getMicrosoftRefreshUrl(config.getClientId(), config.getClientSecret(),
				config.getRedirectUri(), authToken.getRefreshToken());
		AuthResponse ret = new AuthResponse();
		ret.setCode(ResponseStatus.SUCCESS.getCode());
		ret.setData(this.getToken(refreshTokenUrl));
		return ret;
	}
}
