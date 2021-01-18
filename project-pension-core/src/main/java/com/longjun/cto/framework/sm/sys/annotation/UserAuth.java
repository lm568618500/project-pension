package com.longjun.cto.framework.sm.sys.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验登录注解
 * 
 * @author yangxuan
 * @date May 31, 2019 - 5:06:44 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAuth {

	/**
	 * 校验登录
	 * 
	 * @return
	 */
	boolean checkLogin() default true;

}
