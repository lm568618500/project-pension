package com.longjun.cto.framework.project.pension.conf;

import com.eims.cto.framework.common2.utils.setting.SettingKit;

/**
 * CQC配置文件
 * 
 * @author yangxuan
 * @date Sep 25, 2019 - 3:41:19 PM
 */
public class CqcConfig {

	private static String FILEPATH = "conf/cqc.setting";

	// INIT
	/**
	 * 版本号
	 */
	public static String INIT_VERSION = SettingKit.getValue(FILEPATH, "init", "version");

	/**
	 * 前台部分配置文件
	 */
	public static String WEB_VERSION = SettingKit.getValue(FILEPATH, "web", "version");

	/**
	 * 后台部分配置文件
	 */
	public static String ADMIN_VERSION = SettingKit.getValue(FILEPATH, "admin", "version");

}
