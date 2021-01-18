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
 * Facebook登录
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @since 1.8
 */
public class AuthFacebookRequest extends BaseAuthRequest {

	public AuthFacebookRequest(AuthConfig config) {
		super(config, AuthSource.FACEBOOK);
	}

	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getFacebookAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				authCallback.getCode(), config.getRedirectUri());
		HttpResponse response = HttpRequest.post(accessTokenUrl).execute();
		JSONObject accessTokenObject = JSONObject.parseObject(response.body());

		if (accessTokenObject.containsKey("error")) {
			throw new AuthException(accessTokenObject.getJSONObject("error").getString("message"));
		}
		AuthToken ret = new AuthToken();
		ret.setAccessToken(accessTokenObject.getString("access_token"));
		ret.setExpireIn(accessTokenObject.getIntValue("expires_in"));
		ret.setTokenType(accessTokenObject.getString("token_type"));
		return ret;
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		String accessToken = authToken.getAccessToken();
		HttpResponse response = HttpRequest.get(UrlBuilder.getFacebookUserInfoUrl(accessToken)).execute();
		String userInfo = response.body();
		JSONObject object = JSONObject.parseObject(userInfo);
		if (object.containsKey("error")) {
			throw new AuthException(object.getJSONObject("error").getString("message"));
		}
		String picture = null;
		if (object.containsKey("picture")) {
			JSONObject pictureObj = object.getJSONObject("picture");
			pictureObj = pictureObj.getJSONObject("data");
			if (null != pictureObj) {
				picture = pictureObj.getString("url");
			}
		}
		AuthUser ret = new AuthUser();
		ret.setUuid(object.getString("id"));
		ret.setUsername(object.getString("name"));
		ret.setNickname(object.getString("name"));
		ret.setAvatar(picture);
		ret.setLocation(object.getString("locale"));
		ret.setEmail(object.getString("email"));
		ret.setGender(AuthUserGender.getRealGender(object.getString("gender")));
		ret.setToken(authToken);
		ret.setSource(AuthSource.FACEBOOK);
		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getFacebookAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}
}
