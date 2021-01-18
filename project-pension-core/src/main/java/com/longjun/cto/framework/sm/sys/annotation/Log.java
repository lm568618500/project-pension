package com.longjun.cto.framework.sm.sys.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 * 
 * @author yangxuan
 * @date Jun 29, 2019 - 9:16:58 AM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	/**
	 * 事件id
	 */
	long eventUseId() default 0L;

	/**
	 * 内容
	 * 
	 * @return
	 */
	String contet() default "";
}
