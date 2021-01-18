package com.longjun.cto.framework.sm.sys.filter;


import javax.servlet.DispatcherType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.conf.SysSetting;
import com.eims.cto.framework.common.configuration.filter.cookie.CookieFilter;
import com.eims.cto.framework.common.configuration.filter.file.FileFilter;
import com.eims.cto.framework.common.configuration.filter.referer.RefererFilter;
import com.eims.cto.framework.common.configuration.filter.xss.XssFilter;

import cn.hutool.core.util.StrUtil;

@Configuration
public class SmSysFilterConfig {
	
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SmSysFilter smSysFilter;
	
	 /**
     * FileFilter过滤器,主要针对 Unix 文件参数变更、Windows 文件参数变更处理
     * @return
     */
    @Bean
    public FilterRegistrationBean smSysFilterRegistration() {
    	FilterRegistrationBean registration = new FilterRegistrationBean();
    	registration.setDispatcherTypes(DispatcherType.REQUEST);
    	registration.setFilter(smSysFilter);
    	registration.addUrlPatterns("/*");
    	registration.setName("smSysFilter");
    	registration.setOrder(Integer.MAX_VALUE);
    	return registration;
    }
}
