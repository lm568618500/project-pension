package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * AuthRoleModel
 * @author yangxuan
 * @date 2019-04-07 03:17:44
 */
@TableName("t_auth_role")
public class AuthRoleModel extends BaseModel<AuthRoleModel> {

	private static final long serialVersionUID = 1554621470473L;
	
	
	
	/**
	 * 使用ID
	 */
	@TableField("use_id")
	private long useId;
	
	/**
	 * 名称
	 */
	@TableField("rolename")
	private String rolename;
	
	/**
	 * 父ID
	 */
	@TableField("parent_id")
	private long parentId;
	
	/**
	 * 描述
	 */
	@TableField("role_desc")
	private String roleDesc;
	
	
	
	/**
	 * 是否删除 1是0否
	 */
	@TableField("is_del")
	private int isDel;
	
	/** 
	 * 用户是否选中该角色 1是，0否
	 */
	@TableField(exist=false)
	private int isUse;
	


	public int getIsUse() {
		return isUse;
	}

	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}

	public void setUseId(long useId) {
		this.useId = useId;
	}

	public long getUseId() {
		return this.useId;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getParentId() {
		return this.parentId;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}



	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

}
