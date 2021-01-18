package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * CQC后台管理端启动类
 * 
 * @author yangxuan
 * @date Sep 25, 2019 - 3:48:36 PM
 */
@EnableScheduling
@EnableTransactionManagement
@EnableCaching
@SpringBootApplication
public class CqcAdminDistApp extends SpringBootServletInitializer {

	static Logger logger = LoggerFactory.getLogger(CqcAdminDistApp.class);

	public static void main(String[] args) {
		logger.info("******** CqcAdminDistApp Start ... ********");
		SpringApplication.run(CqcAdminDistApp.class, args);
		logger.info("******** CqcAdminDistApp End ... ********");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
}
