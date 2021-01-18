package com.longjun.cto.framework.project.pension.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.eims.cto.framework.common.core.utils.WebKit;

/**
 * CQC管理端拦截器
 * 
 * @author yangxuan
 * @date Sep 25, 2019 - 3:50:16 PM
 */
@Component
public class CqcAdminIntercepter implements HandlerInterceptor {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WebKit webKit;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
