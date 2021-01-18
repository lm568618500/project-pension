package com.longjun.cto.framework.sm.message.es;

/**
 * 类型枚举
 * 
 * @author yangxuan
 * @date May 30, 2019 - 9:46:32 PM
 */
public enum SettingTypeEnums {

	SMS(1, "短信"),

	EMAIL(2, "邮箱"),

	PUSH(3, "推送"),

	WECHAT(4, "微信推送"),

	;

	private int type;

	private String typeName;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	SettingTypeEnums(int type, String typeName) {
		this.type = type;
		this.typeName = typeName;
	}

}
