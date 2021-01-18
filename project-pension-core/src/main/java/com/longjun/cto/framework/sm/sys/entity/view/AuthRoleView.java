package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * AuthRoleModel
 * @author yangxuan
 * @date 2019-04-07 03:17:44
 */
public class AuthRoleView extends BaseView {

	private static final long serialVersionUID = 1554621469330L;
	
	
	
	/**
	 * 使用ID
	 */
	private long useId;
	
	/**
	 * 名称
	 */
	private String rolename;
	
	/**
	 * 父ID
	 */
	private long parentId;
	
	/**
	 * 描述
	 */
	private String roleDesc;
	
	
	
	/**
	 * 是否删除 1是0否
	 */
	private int isDel;
	
	


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
