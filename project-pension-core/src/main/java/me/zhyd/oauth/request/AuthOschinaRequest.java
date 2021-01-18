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
 * oschina登录
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @since 1.8
 */
public class AuthOschinaRequest extends BaseAuthRequest {

	public AuthOschinaRequest(AuthConfig config) {
		super(config, AuthSource.OSCHINA);
	}

	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getOschinaAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				authCallback.getCode(), config.getRedirectUri());
		HttpResponse response = HttpRequest.post(accessTokenUrl).execute();
		JSONObject accessTokenObject = JSONObject.parseObject(response.body());
		if (accessTokenObject.containsKey("error")) {
			throw new AuthException("Unable to get token from oschina using code [" + authCallback.getCode() + "]");
		}
		AuthToken ret = new AuthToken();
		ret.setAccessToken(accessTokenObject.getString("access_token"));
		ret.setRefreshToken(accessTokenObject.getString("refresh_token"));
		ret.setUid(accessTokenObject.getString("uid"));
		ret.setExpireIn(accessTokenObject.getIntValue("expires_in"));
		return ret;
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		String accessToken = authToken.getAccessToken();
		HttpResponse response = HttpRequest.get(UrlBuilder.getOschinaUserInfoUrl(accessToken)).execute();
		JSONObject object = JSONObject.parseObject(response.body());
		if (object.containsKey("error")) {
			throw new AuthException(object.getString("error_description"));
		}
		AuthUser ret = new AuthUser();
		ret.setUuid(object.getString("id"));
		ret.setUsername(object.getString("name"));
		ret.setNickname(object.getString("name"));
		ret.setAvatar(object.getString("avatar"));
		ret.setBlog(object.getString("url"));
		ret.setLocation(object.getString("location"));
		ret.setGender(AuthUserGender.getRealGender(object.getString("gender")));
		ret.setEmail(object.getString("email"));
		ret.setToken(authToken);
		ret.setSource(AuthSource.OSCHINA);
		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getOschinaAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}
}
