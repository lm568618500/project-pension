package com.longjun.cto.framework.sm.users.entity.es;

/**
 * 积分出入枚举
 * 
 * @author yangxuan
 * @date Jul 1, 2019 - 4:48:50 PM
 */
public enum ScoreIncomeEnums {

	IN(1, "积分入账"),

	OUT(2, "积分出账"),

	;

	/**
	 * 出入账类型
	 */
	private int type;

	/**
	 * 名称消息
	 */
	private String msg;

	ScoreIncomeEnums(int type, String msg) {
		this.type = type;
		this.msg = msg;
	}
}
