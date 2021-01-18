package com.longjun.cto.framework.sm.users.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * UserAddressModel
 * @author heqiang
 * @date 2019-07-03 06:22:57
 */
public class UserAddressDto extends BaseDTO {

	private static final long serialVersionUID = 1562149383706L;
	
	
	private String c_user_real_name;
	private String c_user_telephone;
	private String c_user_id;
	
	public String getC_user_real_name() {
		return c_user_real_name;
	}
	public void setC_user_real_name(String c_user_real_name) {
		this.c_user_real_name = c_user_real_name;
	}
	public String getC_user_telephone() {
		return c_user_telephone;
	}
	public void setC_user_telephone(String c_user_telephone) {
		this.c_user_telephone = c_user_telephone;
	}
	public String getC_user_id() {
		return c_user_id;
	}
	public void setC_user_id(String c_user_id) {
		this.c_user_id = c_user_id;
	}
	
}
