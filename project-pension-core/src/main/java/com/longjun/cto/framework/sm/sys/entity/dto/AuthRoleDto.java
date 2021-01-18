package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * AuthRoleModel
 * @author yangxuan
 * @date 2019-04-07 03:17:44
 */
public class AuthRoleDto extends BaseDTO {

	private static final long serialVersionUID = 1554621469744L;
	
	/**
	 * 角色名称
	 */
	private String c_rolename;

	public String getC_rolename() {
		return c_rolename;
	}

	public void setC_rolename(String c_rolename) {
		this.c_rolename = c_rolename;
	}
	
}
