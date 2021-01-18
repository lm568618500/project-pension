package com.longjun.cto.framework.common.utils.i18n;

import cn.hutool.setting.Setting;

/**
 * 国际化工具
 * 
 * @author yangxuan
 * @date Sep 30, 2019 - 10:31:26 AM
 */
public class I18NKit {

	/**
	 * 默认国际化
	 * 
	 * @param key
	 * @return
	 */
	public static String getMsg(String key) {
		String msg = getMsg(key, Language.DEFAULT);
		return msg;
	}

	/**
	 * 获取国际化资源
	 * 
	 * @param key
	 * @param language
	 * @return
	 */
	public static String getMsg(String key, Language language) {
		String msg = getVal(key, language.getI18File());
		return msg;
	}

	/**
	 * 读取信息
	 * 
	 * @param key
	 * @param settingPath
	 * @return
	 */
	private static String getVal(String key, String settingPath) {
		Setting setting = new Setting(settingPath);
		String val = setting.get(key);
		return val;
	}

	public static void main(String[] args) {
		String hello = getMsg("hello", Language.EN);
		System.out.println(hello);
	}

}
