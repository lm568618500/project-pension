package com.longjun.cto.framework.sm.sys.entity.dto;

import java.io.Serializable;

/**
 * 短信验证码返回对象
 * 
 * @author yangxuan
 * @date Jun 10, 2019 - 11:59:14 AM
 */
public class VerificationCodeSmsRetDto implements Serializable {

	private static final long serialVersionUID = 7519035540995520323L;

	private String token;

	private String codeVal;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCodeVal() {
		return codeVal;
	}

	public void setCodeVal(String codeVal) {
		this.codeVal = codeVal;
	}

}
