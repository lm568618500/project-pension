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
 * Gitee登录
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @since 1.8
 */
public class AuthGiteeRequest extends BaseAuthRequest {

	public AuthGiteeRequest(AuthConfig config) {
		super(config, AuthSource.GITEE);
	}

	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getGiteeAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				authCallback.getCode(), config.getRedirectUri());
		HttpResponse response = HttpRequest.post(accessTokenUrl).execute();
		JSONObject accessTokenObject = JSONObject.parseObject(response.body());
		if (accessTokenObject.containsKey("error")) {
			throw new AuthException("Unable to get token from gitee using code [" + authCallback.getCode() + "]");
		}
		AuthToken ret = new AuthToken();
		ret.setAccessToken(accessTokenObject.getString("access_token"));
		return ret;
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		String accessToken = authToken.getAccessToken();
		HttpResponse response = HttpRequest.get(UrlBuilder.getGiteeUserInfoUrl(accessToken)).execute();
		String userInfo = response.body();
		JSONObject object = JSONObject.parseObject(userInfo);
		AuthUser ret = new AuthUser();
		ret.setUuid(object.getString("id"));
		ret.setUsername(object.getString("login"));
		ret.setAvatar(object.getString("avatar_url"));
		ret.setBlog(object.getString("blog"));
		ret.setNickname(object.getString("name"));
		ret.setCompany(object.getString("company"));
		ret.setLocation(object.getString("address"));
		ret.setEmail(object.getString("email"));
		ret.setRemark(object.getString("bio"));
		ret.setGender(AuthUserGender.UNKNOW);
		ret.setToken(authToken);
		ret.setSource(AuthSource.GITEE);
		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getGiteeAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}
}
