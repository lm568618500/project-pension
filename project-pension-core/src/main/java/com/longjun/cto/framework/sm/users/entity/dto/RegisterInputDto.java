package com.longjun.cto.framework.sm.users.entity.dto;

import java.io.Serializable;

/**
 * 注册入参Dto
 * 
 * @author yangxuan
 * @date Jun 19, 2019 - 3:44:36 PM
 */
public class RegisterInputDto implements Serializable {

	private static final long serialVersionUID = -7433917760618191962L;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 手机号码
	 */
	private String mobile; // 手机号码

	/**
	 * 验证码key
	 */
	private String key; // 验证码key

	/**
	 * 短信验证码
	 */
	private String smsCode; // 短信验证码

	/**
	 * 密码
	 */
	private String password; // 密码

	/**
	 * 重复密码
	 */
	private String rePassword; // 重复密码

	/**
	 * 用户身份
	 */
	private String userType; // 用户身份

	/**
	 * 用户头像
	 */
	private String userPhoto;

	/**
	 * 真实姓名
	 */
	private String realName;

	private Integer agreePact;

	public Integer getAgreePact() {
		return agreePact;
	}

	public void setAgreePact(Integer agreePact) {
		this.agreePact = agreePact;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
