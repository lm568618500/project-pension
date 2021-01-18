package com.longjun.cto.framework.sm.sys.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;

@TableName("t_auth_role_resource")
public class AuthRoleResourcesModel extends BaseModel<AuthRoleResourcesModel>{
	
	private static final long serialVersionUID = -4544525948975281196L;

	@TableField(value = "role_id")
	private long roleId;
	
	@TableField(value = "resources_id")
	private long resourcesId;
	

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getResourcesId() {
		return resourcesId;
	}

	public void setResourcesId(long resourcesId) {
		this.resourcesId = resourcesId;
	}
	

}
