package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;

/**
 * 管理员-角色Model
 * @author yangxuan
 * @date 2018年11月15日下午7:45:24
 */
@TableName("t_admin_role")
public class AdminRoleModel extends BaseModel<AdminRoleModel> {

	private static final long serialVersionUID = -7209672856269303763L;

	/**
	 * 管理员ID
	 */
	@TableField("admin_id")
	private long adminId;

	/**
	 * 权限ID
	 */
	@TableField("role_id")
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
