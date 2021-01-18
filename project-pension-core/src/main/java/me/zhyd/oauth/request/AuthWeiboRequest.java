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
import me.zhyd.oauth.utils.IpUtils;
import me.zhyd.oauth.utils.StringUtils;
import me.zhyd.oauth.utils.UrlBuilder;

/**
 * 微博登录
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @since 1.8
 */
public class AuthWeiboRequest extends BaseAuthRequest {

	public AuthWeiboRequest(AuthConfig config) {
		super(config, AuthSource.WEIBO);
	}

	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getWeiboAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				authCallback.getCode(), config.getRedirectUri());
		HttpResponse response = HttpRequest.post(accessTokenUrl).execute();
		String accessTokenStr = response.body();
		JSONObject accessTokenObject = JSONObject.parseObject(accessTokenStr);
		if (accessTokenObject.containsKey("error")) {
			throw new AuthException("Unable to get token from weibo using code [" + authCallback.getCode() + "]:"
					+ accessTokenObject.getString("error_description"));
		}
		AuthToken ret = new AuthToken();
		ret.setAccessToken(accessTokenObject.getString("access_token"));
		ret.setUid(accessTokenObject.getString("uid"));
		ret.setOpenId(accessTokenObject.getString("uid"));
		ret.setExpireIn(accessTokenObject.getIntValue("expires_in"));
		return ret;
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		String accessToken = authToken.getAccessToken();
		String uid = authToken.getUid();
		String oauthParam = String.format("uid=%s&access_token=%s", uid, accessToken);
		HttpResponse response = HttpRequest.get(UrlBuilder.getWeiboUserInfoUrl(oauthParam))
				.header("Authorization", "OAuth2 " + oauthParam).header("API-RemoteIP", IpUtils.getIp()).execute();
		String userInfo = response.body();
		JSONObject object = JSONObject.parseObject(userInfo);
		if (object.containsKey("error")) {
			throw new AuthException(object.getString("error"));
		}
		AuthUser ret = new AuthUser();
		ret.setUuid(object.getString("id"));
		ret.setUsername(object.getString("name"));
		ret.setAvatar(object.getString("profile_image_url"));
		ret.setBlog(
				StringUtils.isEmpty(object.getString("url")) ? "https://weibo.com/" + object.getString("profile_url")
						: object.getString("url"));
		ret.setNickname(object.getString("screen_name"));
		ret.setLocation(object.getString("location"));
		ret.setRemark(object.getString("description"));
		ret.setGender(AuthUserGender.getRealGender(object.getString("gender")));
		ret.setToken(authToken);
		ret.setSource(AuthSource.WEIBO);
		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getWeiboAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}
}
