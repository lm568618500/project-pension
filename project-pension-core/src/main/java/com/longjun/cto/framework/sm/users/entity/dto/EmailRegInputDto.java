package com.longjun.cto.framework.sm.users.entity.dto;

import java.io.Serializable;

/**
 * 邮箱注册参数
 * 
 * @author yangxuan
 * @date Jun 26, 2019 - 10:02:01 AM
 */
public class EmailRegInputDto implements Serializable {

	private static final long serialVersionUID = 1883091477465170739L;

	/**
	 * 账号
	 */
	private String account;

	/**
	 * 邮箱地址
	 */
	private String email;

	/**
	 * 邮箱注册码key
	 */
	private String codeKey;

	/**
	 * 邮箱注册码
	 */
	private String code;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 重复密码
	 */
	private String repassword;

	/**
	 * 同意注册协议 0不同意 1同意
	 */
	private int agreePact;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodeKey() {
		return codeKey;
	}

	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public int getAgreePact() {
		return agreePact;
	}

	public void setAgreePact(int agreePact) {
		this.agreePact = agreePact;
	}

}
