package com.longjun.cto.framework.sm.sys.entity.dto;

import java.util.List;
import java.io.Serializable;

/**
 * AuthRoleModel
 * @author yangxuan
 * @date 2019-04-07 03:17:44
 */
public class AuthRoleModifyDto implements Serializable {

	private static final long serialVersionUID = 1554621468296L;

	private long id;
	
	/**
	 * 名称
	 */
	private String rolename;
	
	/**
	 * 描述
	 */
	private String roleDesc;
	
	/**
	 * 权限集合
	 */
	private List<Long> authids;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public List<Long> getAuthids() {
		return authids;
	}

	public void setAuthids(List<Long> authids) {
		this.authids = authids;
	}
}
