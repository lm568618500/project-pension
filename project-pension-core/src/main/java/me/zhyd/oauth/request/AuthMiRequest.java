package me.zhyd.oauth.request;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.config.AuthSource;
import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.model.*;
import me.zhyd.oauth.utils.UrlBuilder;

import java.text.MessageFormat;

/**
 * 小米登录
 *
 * @author yangkai.shen (https://xkcoding.com)
 * @version 1.5
 * @since 1.5
 */
public class AuthMiRequest extends BaseAuthRequest {
	private static final String PREFIX = "&&&START&&&";

	public AuthMiRequest(AuthConfig config) {
		super(config, AuthSource.MI);
	}

	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getMiAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				config.getRedirectUri(), authCallback.getCode());
		return getToken(accessTokenUrl);
	}

	private AuthToken getToken(String accessTokenUrl) {
		HttpResponse response = HttpRequest.get(accessTokenUrl).execute();
		String jsonStr = StrUtil.replace(response.body(), PREFIX, StrUtil.EMPTY);
		JSONObject accessTokenObject = JSONObject.parseObject(jsonStr);

		if (accessTokenObject.containsKey("error")) {
			throw new AuthException(accessTokenObject.getString("error_description"));
		}
		AuthToken ret = new AuthToken();
		ret.setAccessToken(accessTokenObject.getString("access_token"));
		ret.setExpireIn(accessTokenObject.getIntValue("expires_in"));
		ret.setScope(accessTokenObject.getString("scope"));
		ret.setTokenType(accessTokenObject.getString("token_type"));
		ret.setRefreshToken(accessTokenObject.getString("refresh_token"));
		ret.setOpenId(accessTokenObject.getString("openId"));
		ret.setMacAlgorithm(accessTokenObject.getString("mac_algorithm"));
		ret.setMacKey(accessTokenObject.getString("mac_key"));
		return ret;
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		// 获取用户信息
		HttpResponse userResponse = HttpRequest
				.get(UrlBuilder.getMiUserInfoUrl(config.getClientId(), authToken.getAccessToken())).execute();

		JSONObject userProfile = JSONObject.parseObject(userResponse.body());
		if ("error".equalsIgnoreCase(userProfile.getString("result"))) {
			throw new AuthException(userProfile.getString("description"));
		}

		JSONObject user = userProfile.getJSONObject("data");
		AuthUser ret = new AuthUser();
		ret.setUuid(authToken.getOpenId());
		ret.setUsername(user.getString("miliaoNick"));
		ret.setNickname(user.getString("miliaoNick"));
		ret.setAvatar(user.getString("miliaoIcon"));
		ret.setEmail(user.getString("mail"));
		ret.setGender(AuthUserGender.UNKNOW);
		ret.setToken(authToken);
		ret.setSource(AuthSource.MI);

		// 获取用户邮箱手机号等信息
		String emailPhoneUrl = MessageFormat.format("{0}?clientId={1}&token={2}",
				"https://open.account.xiaomi.com/user/phoneAndEmail", config.getClientId(), authToken.getAccessToken());

		HttpResponse emailResponse = HttpRequest.get(emailPhoneUrl).execute();
		JSONObject userEmailPhone = JSONObject.parseObject(emailResponse.body());
		if (!"error".equalsIgnoreCase(userEmailPhone.getString("result"))) {
			JSONObject emailPhone = userEmailPhone.getJSONObject("data");
			ret.setEmail(emailPhone.getString("email"));
		}

		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getMiAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}

	/**
	 * 刷新access token （续期）
	 *
	 * @param authToken 登录成功后返回的Token信息
	 * @return AuthResponse
	 */
	@Override
	public AuthResponse refresh(AuthToken authToken) {
		String miRefreshUrl = UrlBuilder.getMiRefreshUrl(config.getClientId(), config.getClientSecret(),
				config.getRedirectUri(), authToken.getRefreshToken());
		AuthResponse ret = new AuthResponse();
		ret.setCode(ResponseStatus.SUCCESS.getCode());
		ret.setData(this.getToken(miRefreshUrl));
		return ret;
	}
}
