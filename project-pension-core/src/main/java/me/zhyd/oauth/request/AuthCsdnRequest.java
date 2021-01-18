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
 * CSDN登录
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @since 1.8
 */
public class AuthCsdnRequest extends BaseAuthRequest {

	public AuthCsdnRequest(AuthConfig config) {
		super(config, AuthSource.CSDN);
	}

	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getCsdnAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				authCallback.getCode(), config.getRedirectUri());
		HttpResponse response = HttpRequest.post(accessTokenUrl).execute();
		JSONObject accessTokenObject = JSONObject.parseObject(response.body());
		if (accessTokenObject.containsKey("error_code")) {
			throw new AuthException("Unable to get token from csdn using code [" + authCallback.getCode() + "]");
		}
		AuthToken ret = new AuthToken();
		ret.setAccessToken(accessTokenObject.getString("access_token"));
		return ret;
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		String accessToken = authToken.getAccessToken();
		HttpResponse response = HttpRequest.get(UrlBuilder.getCsdnUserInfoUrl(accessToken)).execute();
		JSONObject object = JSONObject.parseObject(response.body());
		if (object.containsKey("error_code")) {
			throw new AuthException(object.getString("error"));
		}
		AuthUser ret = new AuthUser();
		ret.setUuid(object.getString("username"));
		ret.setUsername(object.getString("username"));
		ret.setRemark(object.getString("description"));
		ret.setBlog(object.getString("website"));
		ret.setGender(AuthUserGender.UNKNOW);
		ret.setToken(authToken);
		ret.setSource(AuthSource.CSDN);
		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getCsdnAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}
}
