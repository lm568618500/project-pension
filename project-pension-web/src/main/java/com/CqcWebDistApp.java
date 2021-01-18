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

/**
 * CQC客户端端启动类
 * 
 * @author yangxuan
 * @date Sep 25, 2019 - 3:48:36 PM
 */
@EnableScheduling
@EnableTransactionManagement
@EnableCaching
@SpringBootApplication
public class CqcWebDistApp extends SpringBootServletInitializer {

	static Logger logger = LoggerFactory.getLogger(CqcWebDistApp.class);

	public static void main(String[] args) {
		logger.info("******** CqcWebDistApp Start ... ********");
		SpringApplication.run(CqcWebDistApp.class, args);
		logger.info("******** CqcWebDistApp End ... ********");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
}
