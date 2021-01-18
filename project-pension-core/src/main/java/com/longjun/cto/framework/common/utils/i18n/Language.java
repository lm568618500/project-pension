package com.longjun.cto.framework.common.utils.i18n;

/**
 * 语言枚举
 * 
 * @author yangxuan
 * @date Sep 30, 2019 - 10:27:54 AM
 */
public enum Language {

	/**
	 * 中文
	 */
	DEFAULT("cn", "i18n/cn.setting"),

	/**
	 * 中文
	 */
	CN("cn", "i18n/cn.setting"),

	/**
	 * 英文
	 */
	EN("en", "i18n/en.setting"),

	;

	private String language;

	private String i18File;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getI18File() {
		return i18File;
	}

	public void setI18File(String i18File) {
		this.i18File = i18File;
	}

	Language(String language, String i18File) {
		this.language = language;
		this.i18File = i18File;
	}

}
