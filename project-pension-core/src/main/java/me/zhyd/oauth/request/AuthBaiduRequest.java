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
 * 百度账号登录
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @since 1.8
 */
public class AuthBaiduRequest extends BaseAuthRequest {

	public AuthBaiduRequest(AuthConfig config) {
		super(config, AuthSource.BAIDU);
	}

	@Override
	protected AuthToken getAccessToken(AuthCallback authCallback) {
		String accessTokenUrl = UrlBuilder.getBaiduAccessTokenUrl(config.getClientId(), config.getClientSecret(),
				authCallback.getCode(), config.getRedirectUri());
		HttpResponse response = HttpRequest.post(accessTokenUrl).execute();
		JSONObject accessTokenObject = JSONObject.parseObject(response.body());
		AuthBaiduErrorCode errorCode = AuthBaiduErrorCode.getErrorCode(accessTokenObject.getString("error"));
		if (AuthBaiduErrorCode.OK != errorCode) {
			throw new AuthException(errorCode.getDesc());
		}
		AuthToken ret = new AuthToken();
		ret.setAccessToken(accessTokenObject.getString("access_token"));
		ret.setRefreshToken(accessTokenObject.getString("refresh_token"));
		ret.setScope(accessTokenObject.getString("scope"));
		ret.setExpireIn(accessTokenObject.getIntValue("expires_in"));
		return ret;
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		String accessToken = authToken.getAccessToken();
		HttpResponse response = HttpRequest.get(UrlBuilder.getBaiduUserInfoUrl(accessToken)).execute();
		String userInfo = response.body();
		JSONObject object = JSONObject.parseObject(userInfo);
		AuthBaiduErrorCode errorCode = AuthBaiduErrorCode.getErrorCode(object.getString("error"));
		if (AuthBaiduErrorCode.OK != errorCode) {
			throw new AuthException(errorCode.getDesc());
		}
		AuthUser ret = new AuthUser();
		ret.setUuid(object.getString("userid"));
		ret.setUsername(object.getString("username"));
		ret.setNickname(object.getString("username"));
		ret.setGender(AuthUserGender.getRealGender(object.getString("sex")));
		ret.setToken(authToken);
		ret.setSource(AuthSource.BAIDU);
		return ret;
	}

	/**
	 * 返回认证url，可自行跳转页面
	 *
	 * @return 返回授权地址
	 */
	@Override
	public String authorize() {
		return UrlBuilder.getBaiduAuthorizeUrl(config.getClientId(), config.getRedirectUri(), config.getState());
	}

	@Override
	public AuthResponse revoke(AuthToken authToken) {
		String accessToken = authToken.getAccessToken();
		HttpResponse response = HttpRequest.get(UrlBuilder.getBaiduRevokeUrl(accessToken)).execute();
		String userInfo = response.body();
		JSONObject object = JSONObject.parseObject(userInfo);
		if (object.containsKey("error_code")) {
			AuthResponse ret = new AuthResponse();
			ret.setCode(ResponseStatus.FAILURE.getCode());
			ret.setMsg(object.getString("error_msg"));
			return ret;
		}
		ResponseStatus status = object.getIntValue("result") == 1 ? ResponseStatus.SUCCESS : ResponseStatus.FAILURE;
		AuthResponse ret = new AuthResponse();
		ret.setCode(status.getCode());
		ret.setMsg(status.getMsg());
		return ret;
	}

}
