package com.longjun.cto.framework.sm.users.entity.dto;

import java.io.Serializable;

/**
 * 修改密码入参
 * 
 * @author yangxuan
 * @date Jun 19, 2019 - 10:35:36 PM
 */
public class ModifyPasswordDto implements Serializable {

	private static final long serialVersionUID = 6772888811722280516L;

	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 旧密码
	 */
	private String oldPassword;

	/**
	 * 新密码
	 */
	private String password;

	/**
	 * 重复新密码
	 */
	private String rePassword;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

}
