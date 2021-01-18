package com.longjun.cto.framework.project.pension.runner;

import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 项目启动Runner
 * @author yangxuan
 * @date Sep 25, 2019 - 3:44:44 PM
 */
@Component
public class StartupRunner implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "redisTemplate")
    RedisTemplate<String, String> redis;
	
	private void cleanRedisCache(String key) {
		if (key != null) {
			Set<String> stringSet = redis.keys(key);
			redis.delete(stringSet);// 删除缓存
			logger.info("清除 " + key + " 缓存");
		}
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		logger.info("项目启动初始化runner ....正在进行数据初始化...");
		cleanRedisCache("*buz-cache-standard-*");
		logger.info("项目启动初始化runner ....数据初始化完成...");
	}

}
