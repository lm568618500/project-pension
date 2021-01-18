package com.longjun.cto.framework.sm.users.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * UserModel
 * 
 * @author yangxuan
 * @date 2019-06-19 02:29:35
 */
public class UserDto extends BaseDTO {

	private static final long serialVersionUID = 1560925782628L;

	/**
	 * 手机号码
	 */
	private String c_mobile;

	/**
	 * 用户名
	 */
	private String c_userName;

	/**
	 * 真实姓名
	 */
	private String c_realName;

	public String getC_mobile() {
		return c_mobile;
	}

	public void setC_mobile(String c_mobile) {
		this.c_mobile = c_mobile;
	}

	public String getC_userName() {
		return c_userName;
	}

	public void setC_userName(String c_userName) {
		this.c_userName = c_userName;
	}

	public String getC_realName() {
		return c_realName;
	}

	public void setC_realName(String c_realName) {
		this.c_realName = c_realName;
	}

}
