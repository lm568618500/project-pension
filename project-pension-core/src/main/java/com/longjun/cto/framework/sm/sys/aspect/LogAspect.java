package com.longjun.cto.framework.sm.sys.aspect;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.core.utils.WebKit;
import com.longjun.cto.framework.sm.sys.annotation.Log;
import com.longjun.cto.framework.sm.sys.entity.view.AdminView;
import com.longjun.cto.framework.sm.sys.service.ILogAdminService;

import eu.bitwalker.useragentutils.UserAgent;

/**
 * 日志切面
 * 
 * @author yangxuan
 * @date Jun 29, 2019 - 9:18:17 AM
 */
//@Aspect
//@Component
public class LogAspect {
	@Autowired
	ILogAdminService iLogAdminService;
	@Autowired
	WebKit webKit;

	@Pointcut("execution(public *  com.eims.cto.framework..*..*.web..*.*(..))")
	public void sysLogAnnotation() {
	}

	@Before("sysLogAnnotation()")
	public void doBefore(final JoinPoint joinPoint) {
	}
	
	@AfterReturning(pointcut = "sysLogAnnotation()", returning = "returnValue")
	public void doAfter(final JoinPoint joinPoint, final Object returnValue) {
		this.saveLog(joinPoint);
	}

	private void saveLog(final JoinPoint joinPoint ) {
		AdminView admin = (AdminView) SecurityUtils.getSubject().getPrincipal();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Log logAnnotation = method.getAnnotation(Log.class);
		
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		if (logAnnotation != null) {
			Map<String, String[]> parmas = request.getParameterMap();
		
			this.iLogAdminService.saveLog(admin.getId(), logAnnotation.eventUseId(),
					logAnnotation.contet() + "{" + JSONObject.toJSONString(parmas) + "}", webKit.getIp());
		}
	}
}
