package com.longjun.cto.framework.sm.sys.entity.es;

import java.util.HashMap;
import java.util.Map;

public enum CommonVerificationRetEnums {

	FAIL(-1, "验证码错误"), EXPRIRE(-2, "验证码失效，请重新获取验证码"), OK(1, "验证成功"),

	;

	private int code;

	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private static Map<Integer, CommonVerificationRetEnums> dict = new HashMap<>();

	static {

	}

	CommonVerificationRetEnums(int code, String msg) {
		this.code = code;
		this.msg = msg;

	}

}
