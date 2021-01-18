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
 * 腾讯云登录
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @since 1.8
 */
public class AuthTencentCloudRequest extends BaseAuthRequest {

	public AuthTencentCloudRequest(AuthConfig config) {
		super(config, AuthSource.TENCENT_CLOUD);
	}

	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getTencentCloudAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				authCallback.getCode());
		HttpResponse response = HttpRequest.get(accessTokenUrl).execute();
		JSONObject accessTokenObject = JSONObject.parseObject(response.body());
		if (accessTokenObject.getIntValue("code") != 0) {
			throw new AuthException("Unable to get token from tencent cloud using code [" + authCallback.getCode()
					+ "]: " + accessTokenObject.get("msg"));
		}
		AuthToken ret = new AuthToken();
		ret.setAccessToken(accessTokenObject.getString("access_token"));
		ret.setExpireIn(accessTokenObject.getIntValue("expires_in"));
		ret.setRefreshToken(accessTokenObject.getString("refresh_token"));
		return ret;
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		String accessToken = authToken.getAccessToken();
		HttpResponse response = HttpRequest.get(UrlBuilder.getTencentCloudUserInfoUrl(accessToken)).execute();
		JSONObject object = JSONObject.parseObject(response.body());
		if (object.getIntValue("code") != 0) {
			throw new AuthException(object.getString("msg"));
		}
		object = object.getJSONObject("data");
		AuthUser ret = new AuthUser();
		ret.setUuid(object.getString("id"));
		ret.setUsername(object.getString("name"));
		ret.setAvatar("https://dev.tencent.com/" + object.getString("avatar"));
		ret.setBlog("https://dev.tencent.com/" + object.getString("path"));
		ret.setNickname(object.getString("name"));
		ret.setCompany(object.getString("company"));
		ret.setLocation(object.getString("location"));
		ret.setGender(AuthUserGender.getRealGender(object.getString("sex")));
		ret.setEmail(object.getString("email"));
		ret.setRemark(object.getString("slogan"));
		ret.setToken(authToken);
		ret.setSource(AuthSource.TENCENT_CLOUD);
		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getTencentCloudAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}
}
