package com.longjun.cto.framework.sm.sys.entity.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 管理员Model
 * 
 * @author lp
 * @date 2018-12-20 20:10:49
 */
public class AdminMotifyDto {

	private static final long serialVersionUID = 1545307849094L;

	private long id;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 手机号码
	 */
	private long mobile;

	private String roleid;

	private String password;
	private String rePassword;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 锁定状态，0正常，1锁定
	 */
	private int lockFlag;
	
	/**
	 * 锁定状态，1正常，0停用
	 */
	private int isuse;
	
	private String remarks;
	
	

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getIsuse() {
		return isuse;
	}

	public void setIsuse(int isuse) {
		this.isuse = isuse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLockFlag() {
		return lockFlag;
	}

	public void setLockFlag(int lockFlag) {
		this.lockFlag = lockFlag;
	}

}
