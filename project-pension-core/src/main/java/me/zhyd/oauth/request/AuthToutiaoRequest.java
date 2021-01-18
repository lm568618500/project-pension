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
 * 今日头条登录
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.5
 * @since 1.5
 */
public class AuthToutiaoRequest extends BaseAuthRequest {

	public AuthToutiaoRequest(AuthConfig config) {
		super(config, AuthSource.TOUTIAO);
	}

	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getToutiaoAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				authCallback.getCode());
		HttpResponse response = HttpRequest.get(accessTokenUrl).execute();
		JSONObject accessTokenObject = JSONObject.parseObject(response.body());

		if (accessTokenObject.containsKey("error_code")) {
			throw new AuthException(
					AuthToutiaoErrorCode.getErrorCode(accessTokenObject.getIntValue("error_code")).getDesc());
		}
		AuthToken ret = new AuthToken();
		ret.setAccessToken(accessTokenObject.getString("access_token"));
		ret.setExpireIn(accessTokenObject.getIntValue("expires_in"));
		ret.setOpenId(accessTokenObject.getString("open_id"));
		return ret;
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		HttpResponse userResponse = HttpRequest
				.get(UrlBuilder.getToutiaoUserInfoUrl(config.getClientId(), authToken.getAccessToken())).execute();

		JSONObject userProfile = JSONObject.parseObject(userResponse.body());

		if (userProfile.containsKey("error_code")) {
			throw new AuthException(AuthToutiaoErrorCode.getErrorCode(userProfile.getIntValue("error_code")).getDesc());
		}

		JSONObject user = userProfile.getJSONObject("data");

		boolean isAnonymousUser = user.getIntValue("uid_type") == 14;
		String anonymousUserName = "匿名用户";
		AuthUser ret = new AuthUser();
		ret.setUuid(user.getString("uid"));
		ret.setUsername(isAnonymousUser ? anonymousUserName : user.getString("screen_name"));
		ret.setNickname(isAnonymousUser ? anonymousUserName : user.getString("screen_name"));
		ret.setAvatar(user.getString("avatar_url"));
		ret.setRemark(user.getString("description"));
		ret.setGender(AuthUserGender.getRealGender(user.getString("gender")));
		ret.setToken(authToken);
		ret.setSource(AuthSource.TOUTIAO);
		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getToutiaoAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}
}
