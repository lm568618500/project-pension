package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * 管理员-角色View
 * @author yangxuan
 * @date 2018年11月15日下午7:46:57
 */
public class AdminRoleView extends BaseView{

	private static final long serialVersionUID = -8256473274686544484L;

	/**
	 * 管理员ID
	 */
	private long adminId;

	/**
	 * 权限ID
	 */
	private long roleId;

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}


}
