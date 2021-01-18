package com.longjun.cto.framework.sm.pay.es;

/**
 * 退款查询状态
 * @author yangxuan
 * @date Jun 2, 2019 - 12:08:00 AM
 */
public enum RefundsQueryState {

	ING(1, "处理中"), FAIL(-1, "处理中"), SUCCESS(2, "处理中"),

	;

	private int code;

	private String state;

	RefundsQueryState(int code, String state) {
		this.code = code;
		this.state = state;
	}

}
