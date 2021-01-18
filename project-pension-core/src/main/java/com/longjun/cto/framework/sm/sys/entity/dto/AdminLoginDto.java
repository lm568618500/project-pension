package com.longjun.cto.framework.sm.sys.entity.dto;

import java.io.Serializable;

/**
 * 管理员登录Dto
 * 
 * @author yangxuan
 * @date 2019年3月25日 下午7:57:18
 */
public class AdminLoginDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7332451552322425975L;

	/**
	 * 账号
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	private String code;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
