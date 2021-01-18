package me.zhyd.oauth.request;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.config.AuthSource;
import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.model.*;
import me.zhyd.oauth.utils.UrlBuilder;

/**
 * 抖音登录
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @since 1.8
 */
public class AuthDouyinRequest<AuthDouyinRequest> extends BaseAuthRequest {

	public AuthDouyinRequest(AuthConfig config) {
		super(config, AuthSource.DOUYIN);
	}

	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getDouyinAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				authCallback.getCode());
		return this.getToken(accessTokenUrl);
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		String accessToken = authToken.getAccessToken();
		String openId = authToken.getOpenId();
		String url = UrlBuilder.getDouyinUserInfoUrl(accessToken, openId);
		HttpResponse response = HttpRequest.get(url).execute();
		JSONObject object = JSONObject.parseObject(response.body());

		JSONObject userInfoObject = this.checkResponse(object);
		AuthUser ret = new AuthUser();
		ret.setUuid(userInfoObject.getString("union_id"));
		ret.setUsername(userInfoObject.getString("nickname"));
		ret.setNickname(userInfoObject.getString("nickname"));
		ret.setAvatar(userInfoObject.getString("avatar"));
		ret.setRemark(userInfoObject.getString("description"));
		ret.setGender(AuthUserGender.UNKNOW);
		ret.setToken(authToken);
		ret.setSource(AuthSource.DOUYIN);
		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getDouyinAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}

	@Override
	public AuthResponse refresh(AuthToken oldToken) {
		String refreshTokenUrl = UrlBuilder.getDouyinRefreshUrl(config.getClientId(), oldToken.getRefreshToken());
		AuthResponse ret = new AuthResponse();
		ret.setCode(ResponseStatus.SUCCESS.getCode());
		ret.setData(this.getToken(refreshTokenUrl));
		return ret;
	}

	/**
	 * 检查响应内容是否正确
	 *
	 * @param object 请求响应内容
	 * @return 实际请求数据的json对象
	 */
	private JSONObject checkResponse(JSONObject object) {
		String message = object.getString("message");
		JSONObject data = object.getJSONObject("data");
		int errorCode = data.getIntValue("error_code");
		if ("error".equals(message) || errorCode != 0) {
			throw new AuthException(errorCode, data.getString("description"));
		}
		return data;
	}

	/**
	 * 获取token，适用于获取access_token和刷新token
	 *
	 * @param accessTokenUrl 实际请求token的地址
	 * @return token对象
	 */
	private AuthToken getToken(String accessTokenUrl) {
		HttpResponse response = HttpRequest.post(accessTokenUrl).execute();
		String accessTokenStr = response.body();
		JSONObject object = JSONObject.parseObject(accessTokenStr);

		JSONObject accessTokenObject = this.checkResponse(object);
		AuthToken ret = new AuthToken();
		ret.setAccessToken(accessTokenObject.getString("access_token"));
		ret.setOpenId(accessTokenObject.getString("open_id"));
		ret.setExpireIn(accessTokenObject.getIntValue("expires_in"));
		ret.setRefreshToken(accessTokenObject.getString("refresh_token"));
		ret.setScope(accessTokenObject.getString("scope"));
		return ret;
	}
}
