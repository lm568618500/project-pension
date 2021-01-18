package com.longjun.cto.framework.sm.sys.aspect;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.alibaba.fastjson.JSONArray;
import com.eims.cto.framework.plugins.sensiwords.BannerResp;
import com.longjun.cto.framework.sm.sys.entity.model.SysSensiWordsHintsModel;
import com.longjun.cto.framework.sm.sys.service.ISysSensiWordsHintsService;

import eu.bitwalker.useragentutils.UserAgent;

/**
 * SmSysInterceptor 拦截器 
 * @author yangxuan
 * @date 2018年11月6日 下午3:35:14
 */
//@Aspect
//@Component
public class SensiWordAspect {

	static Logger logger = LoggerFactory.getLogger(SensiWordAspect.class);

	private ThreadLocal<Date> threadLocal = new ThreadLocal<>();
	
	@Autowired
	ISysSensiWordsHintsService iSysSensiWordsHintsService;
	
	
	@Pointcut("execution(public *  com.eims.cto.framework..*..*.web..*.*(..))")
	public void sensiAnnotation() {
	}
	
	@Before("sensiAnnotation()")
	public void doBefore(final JoinPoint joinPoint) {
		this.threadLocal.set(new Date(System.currentTimeMillis()));
		this.handleSensi(joinPoint);
	}

	@AfterReturning(pointcut = "sensiAnnotation()", returning = "returnValue")
	public void doAfter(final JoinPoint joinPoint, final Object returnValue) {
		final Date endTime = new Date(System.currentTimeMillis());
		final Date startTime = this.threadLocal.get();
	}

	private void handleSensi(final JoinPoint joinPoint ) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		final UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		final String os = userAgent.getOperatingSystem().getName();
		final String browser = userAgent.getBrowser().getName();
		final String browserVerion = userAgent.getBrowserVersion() == null ? "" :userAgent.getBrowserVersion().getVersion();
		Map<String, String[]> params = request.getParameterMap();
		BannerResp sensiWordResp = null;
		SysSensiWordsHintsModel hintModel = null;
		for (Entry<String, String[]> entry : params.entrySet()) {
			logger.info(entry.getKey() + " : " + Arrays.toString(entry.getValue()));
//			sensiWordResp = iSysSensiWordsHintsService.hints(Arrays.toString(entry.getValue()));
			sensiWordResp = iSysSensiWordsHintsService.hints("杨宣");
			if(sensiWordResp == null) {
				continue;
			}
			if(sensiWordResp.isHasSensitiveWords()) {
				logger.warn("击中关键词 : {}" , JSONArray.toJSONString(sensiWordResp));
				hintModel = new SysSensiWordsHintsModel();
				hintModel.setTime(new Date());
				hintModel.setLastupdate(new Date());
				hintModel.setStatus(1);
				hintModel.setWords(JSONArray.toJSONString(sensiWordResp));
				hintModel.setFilterStr(sensiWordResp.getFilterStr());
				iSysSensiWordsHintsService.saveModel(hintModel);
			}
			
		}
	}
	
}
