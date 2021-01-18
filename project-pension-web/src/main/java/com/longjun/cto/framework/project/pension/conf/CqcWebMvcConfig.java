package com.longjun.cto.framework.project.pension.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.longjun.cto.framework.project.pension.intercepter.CqcWebIntercepter;
import com.longjun.cto.framework.sm.sys.intercepter.SmSysInterceptor;

/**
 * CQC admin mvc配置
 *
 * @author yangxuan
 * @date Sep 25, 2019 - 3:52:14 PM
 */
@Configuration
@EnableWebMvc
public class CqcWebMvcConfig extends WebMvcConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SmSysInterceptor smSysInterceptor;

    @Autowired
    CqcWebIntercepter cqcWebIntercepter;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/resources/", "classpath:/static/",
                "classpath:/res/", "classpath:/config/", "classpath:/web/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(smSysInterceptor).addPathPatterns("/**").excludePathPatterns("/res/**", "/favicon.ico",
                "/open/**", "/static/**", "/web/**");
        registry.addInterceptor(cqcWebIntercepter).addPathPatterns("/**").excludePathPatterns("/res/**",
                "/favicon.ico", "/images/**","/web/sys/upload", "/login", "/logout",
                "/open/**", "/static/**","/web/user/**","/web/css/**","/web/js/**",
                "/web/images/**","/web/pay/aliNotify","/web/pay/wxNotify","/jw/**");
        super.addInterceptors(registry);
    }

}
