package com.longjun.cto.framework.sm.sys.entity.es;

/**
 * 系统设置输入枚举
 * 
 * @author yangxuan
 * @date Jun 6, 2019 - 2:00:12 PM
 */
public enum CommonOptionInputEnums {

	TEXT("TEXT", "文本输入框"), 
	IMAGE("IMAGE", "图片输入框"),
	RICHEDIT("RICHEDIT", "富文本"),
	

	;

	/**
	 * 输入类型;TEXT、PASSPORD、IMAGE
	 * 
	 * @param inputType
	 * @param inputTypeName
	 */
	private String inputType;

	private String inputTypeName;

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getInputTypeName() {
		return inputTypeName;
	}

	public void setInputTypeName(String inputTypeName) {
		this.inputTypeName = inputTypeName;
	}

	CommonOptionInputEnums(String inputType, String inputTypeName) {
		this.inputType = inputType;
		this.inputTypeName = inputTypeName;
	}

}
