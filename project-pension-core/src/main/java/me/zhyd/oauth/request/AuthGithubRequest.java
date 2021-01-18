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
import me.zhyd.oauth.utils.GlobalAuthUtil;
import me.zhyd.oauth.utils.UrlBuilder;

import java.util.Map;

/**
 * Github登录
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @since 1.8
 */
public class AuthGithubRequest extends BaseAuthRequest {

	public AuthGithubRequest(AuthConfig config) {
		super(config, AuthSource.GITHUB);
	}

	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getGithubAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				authCallback.getCode(), config.getRedirectUri());
		HttpResponse response = HttpRequest.post(accessTokenUrl).execute();
		Map<String, String> res = GlobalAuthUtil.parseStringToMap(response.body());
		if (res.containsKey("error")) {
			throw new AuthException(res.get("error") + ":" + res.get("error_description"));
		}
		AuthToken ret = new AuthToken();
		ret.setAccessToken(res.get("access_token"));
		return ret;
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		String accessToken = authToken.getAccessToken();
		HttpResponse response = HttpRequest.get(UrlBuilder.getGithubUserInfoUrl(accessToken)).execute();
		String userInfo = response.body();
		JSONObject object = JSONObject.parseObject(userInfo);
		AuthUser ret = new AuthUser();
		ret.setUuid(object.getString("id"));
		ret.setUsername(object.getString("login"));
		ret.setAvatar(object.getString("avatar_url"));
		ret.setBlog(object.getString("blog"));
		ret.setNickname(object.getString("name"));
		ret.setCompany(object.getString("company"));
		ret.setLocation(object.getString("location"));
		ret.setEmail(object.getString("email"));
		ret.setRemark(object.getString("bio"));
		ret.setGender(AuthUserGender.UNKNOW);
		ret.setToken(authToken);
		ret.setSource(AuthSource.GITHUB);
		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getGithubAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}
}
