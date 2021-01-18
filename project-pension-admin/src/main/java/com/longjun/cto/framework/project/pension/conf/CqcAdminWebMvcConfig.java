package com.longjun.cto.framework.project.pension.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.longjun.cto.framework.project.pension.intercepter.CqcAdminIntercepter;
import com.longjun.cto.framework.sm.sys.intercepter.SmSysInterceptor;

/**
 * CQC admin mvc配置
 * 
 * @author yangxuan
 * @date Sep 25, 2019 - 3:52:14 PM
 */
@Configuration
@EnableWebMvc
public class CqcAdminWebMvcConfig extends WebMvcConfigurerAdapter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SmSysInterceptor smSysInterceptor;

	@Autowired
	CqcAdminIntercepter cqcAdminIntercepter;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/resources/", "classpath:/static/",
				"classpath:/res/", "classpath:/config/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(smSysInterceptor).addPathPatterns("/**").excludePathPatterns("/res/**", "/favicon.ico",
				"/open/**","/static/**");
		registry.addInterceptor(cqcAdminIntercepter).addPathPatterns("/**").excludePathPatterns("/res/**",
				"/favicon.ico", "/mgn/genCaptcha", "/mgn/login", "/open/**","/static/**","/common/image");

	}

}
