package com.longjun.cto.framework.project.pension.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.longjun.cto.framework.common.utils.pojoconverter.PojoConverter;

/**
 * 装载Bean容器
 * @author carson deng
 * @date 2019/10/9 21:48
 */
@Configuration
public class BeanConfig {

    @Bean
    public PojoConverter pojoConverter() {
        return new PojoConverter("dozer/dozer-mapping.xml");
    }
}
