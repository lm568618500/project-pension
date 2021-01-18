package me.zhyd.oauth.request;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.config.AuthSource;
import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthToken;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.model.AuthUserGender;
import me.zhyd.oauth.utils.UrlBuilder;

/**
 * Google登录
 *
 * @author yangkai.shen (https://xkcoding.com)
 * @version 1.3
 * @since 1.3
 */
public class AuthGoogleRequest extends BaseAuthRequest {

	public AuthGoogleRequest(AuthConfig config) {
		super(config, AuthSource.GOOGLE);
	}

	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getGoogleAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				authCallback.getCode(), config.getRedirectUri());
		HttpResponse response = HttpRequest.post(accessTokenUrl).execute();
		JSONObject accessTokenObject = JSONObject.parseObject(response.body());

		if (accessTokenObject.containsKey("error") || accessTokenObject.containsKey("error_description")) {
			throw new AuthException("get google access_token has error:[" + accessTokenObject.getString("error")
					+ "], error_description:[" + accessTokenObject.getString("error_description") + "]");
		}
		AuthToken ret = new AuthToken();
		ret.setAccessToken(accessTokenObject.getString("access_token"));
		ret.setExpireIn(accessTokenObject.getIntValue("expires_in"));
		ret.setScope(accessTokenObject.getString("scope"));
		ret.setTokenType(accessTokenObject.getString("token_type"));
		ret.setIdToken(accessTokenObject.getString("id_token"));
		return ret;
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		String accessToken = authToken.getIdToken();
		HttpResponse response = HttpRequest.get(UrlBuilder.getGoogleUserInfoUrl(accessToken)).execute();
		String userInfo = response.body();
		JSONObject object = JSONObject.parseObject(userInfo);
		AuthUser ret = new AuthUser();
		ret.setUuid(object.getString("sub"));
		ret.setUsername(object.getString("name"));
		ret.setAvatar(object.getString("picture"));
		ret.setNickname(object.getString("name"));
		ret.setLocation(object.getString("locale"));
		ret.setEmail(object.getString("email"));
		ret.setGender(AuthUserGender.UNKNOW);
		ret.setToken(authToken);
		ret.setSource(AuthSource.GOOGLE);
		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getGoogleAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}
}
