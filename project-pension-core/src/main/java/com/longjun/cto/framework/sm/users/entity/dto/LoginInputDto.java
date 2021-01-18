package com.longjun.cto.framework.sm.users.entity.dto;

import java.io.Serializable;

/**
 * 登录入参Dto
 * 
 * @author yangxuan
 * @date Jun 19, 2019 - 3:44:36 PM
 */
public class LoginInputDto implements Serializable {

	private static final long serialVersionUID = 7024844454414270040L;

	/**
	 * 手机号码
	 */
	private String mobile; // 手机号码

	/**
	 * 密码
	 */
	private String password; // 密码

	/**
	 * 用户身份
	 */
	private String userType; // 用户身份

	/**
	 * 图片验证码key
	 */
	private String captchaKey;

	/**
	 * 验证码
	 */
	private String captcha;

	public String getCaptchaKey() {
		return captchaKey;
	}

	public void setCaptchaKey(String captchaKey) {
		this.captchaKey = captchaKey;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
