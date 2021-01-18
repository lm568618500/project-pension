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
 * 微信登录
 *
 * @author yangkai.shen (https://xkcoding.com)
 * @version 1.0
 * @since 1.8
 */
public class AuthWeChatRequest extends BaseAuthRequest {
	public AuthWeChatRequest(AuthConfig config) {
		super(config, AuthSource.WECHAT);
	}

	/**
	 * 微信的特殊性，此时返回的信息同时包含 openid 和 access_token
	 *
	 * @param authCallback 回调返回的参数
	 * @return 所有信息
	 */
	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getWeChatAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				authCallback.getCode());
		return this.getToken(accessTokenUrl);
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		String accessToken = authToken.getAccessToken();
		String openId = authToken.getOpenId();

		HttpResponse response = HttpRequest.get(UrlBuilder.getWeChatUserInfoUrl(accessToken, openId)).execute();
		JSONObject object = JSONObject.parseObject(response.body());

		this.checkResponse(object);

		String location = String.format("%s-%s-%s", object.getString("country"), object.getString("province"),
				object.getString("city"));
		AuthUser ret = new AuthUser();
		ret.setUsername(object.getString("nickname"));
		ret.setNickname(object.getString("nickname"));
		ret.setAvatar(object.getString("headimgurl"));
		ret.setLocation(location);
		ret.setUuid(openId);
		ret.setGender(AuthUserGender.getRealGender(object.getString("sex")));
		ret.setToken(authToken);
		ret.setSource(AuthSource.WECHAT);
		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getWeChatAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}

	@Override
	public AuthResponse refresh(AuthToken oldToken) {
		String refreshTokenUrl = UrlBuilder.getWeChatRefreshUrl(config.getClientId(), oldToken.getRefreshToken());
		AuthResponse ret = new AuthResponse();
		ret.setCode(ResponseStatus.SUCCESS.getCode());
		ret.setData(this.getToken(refreshTokenUrl));
		return ret;
	}

	/**
	 * 检查响应内容是否正确
	 *
	 * @param object 请求响应内容
	 */
	private void checkResponse(JSONObject object) {
		if (object.containsKey("errcode")) {
			throw new AuthException(object.getIntValue("errcode"), object.getString("errmsg"));
		}
	}

	/**
	 * 获取token，适用于获取access_token和刷新token
	 *
	 * @param accessTokenUrl 实际请求token的地址
	 * @return token对象
	 */
	private AuthToken getToken(String accessTokenUrl) {
		HttpResponse response = HttpRequest.get(accessTokenUrl).execute();
		JSONObject accessTokenObject = JSONObject.parseObject(response.body());

		this.checkResponse(accessTokenObject);
		AuthToken ret = new AuthToken();
		ret.setAccessToken(accessTokenObject.getString("access_token"));
		ret.setRefreshToken(accessTokenObject.getString("refresh_token"));
		ret.setExpireIn(accessTokenObject.getIntValue("expires_in"));
		ret.setOpenId(accessTokenObject.getString("openid"));
		return ret;
	}
}
