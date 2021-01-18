/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.longjun.cto.framework.project.pension.shiro;

import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.core.utils.WebKit;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * oauth2过滤器
 *
 * @author Mark sunlightcs@gmail.com
 */
public class OAuth2Filter extends AuthenticatingFilter {

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
		// 获取请求token
		String token = getRequestToken((HttpServletRequest) request);

		if (StringUtils.isBlank(token)) {
			return null;
		}

		return new OAuth2Token(token);
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		if (((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())) {
			return true;
		}

		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// 获取请求token，如果token不存在，直接返回401
		String token = getRequestToken((HttpServletRequest) request);
//		if (StringUtils.isBlank(token)) {
//			HttpServletResponse httpResponse = (HttpServletResponse) response;
//			httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
//			httpResponse.setHeader("Access-Control-Allow-Origin", "*");
//			JSONObject jsonObj = new JSONObject();
//			jsonObj.put("code", 403);
//			jsonObj.put("msg", "invalid token");
//			httpResponse.getWriter().print(jsonObj.toJSONString());
//			return false;
//		}

		return executeLogin(request, response);
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		boolean isAjax = WebKit.isAjax(req);
		if(!isAjax) {
			try {
				httpResponse.sendRedirect("/mgn/login");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		httpResponse.setContentType("application/json;charset=utf-8");
		httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		try {
			// 处理登录失败的异常
			Throwable throwable = e.getCause() == null ? e : e.getCause();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("code", 401);
			jsonObj.put("msg", throwable.getMessage());
			httpResponse.getWriter().print(jsonObj.toJSONString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return false;
	}

	/**
	 * 获取请求的token
	 */
	private String getRequestToken(HttpServletRequest httpRequest) {
		// 从header中获取token
		String token = httpRequest.getHeader("token");

		// 如果header中不存在token，则从参数中获取token
		if (StringUtils.isBlank(token)) {
			token = httpRequest.getParameter("token");
		}

		if(StringUtils.isBlank(token)) {
			token = httpRequest.getSession().getId();
		}
		return token;
	}

}
