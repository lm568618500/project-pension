package com.longjun.cto.framework.sm.sys.intercepter;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.eims.cto.framework.common.conf.SysSetting;
import com.eims.cto.framework.common.core.utils.cache.ICache;
import com.longjun.cto.framework.sm.sys.service.ICommonOptionService;

/**
 * SmSysInterceptor 拦截器 
 * @author yangxuan
 * @date 2018年11月6日 下午3:35:14
 */
@Component
public class SmSysInterceptor implements HandlerInterceptor{
	
	static Logger log = LoggerFactory.getLogger(SmSysInterceptor.class);
	
	@Autowired
	ICache iCache;
	
	@Autowired
	ICommonOptionService iCommonOptionService;
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 填充值
	 */
	public void fullValue(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView mv) {
		Map<String , Object> initMap = iCommonOptionService.initMap();
		request.setAttribute("GlobalMap", initMap);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView mv) {
		this.fullValue(request,response,arg2,mv);
	}

}
