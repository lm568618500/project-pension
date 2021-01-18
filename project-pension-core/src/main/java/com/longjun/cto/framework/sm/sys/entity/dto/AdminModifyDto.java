package com.longjun.cto.framework.sm.sys.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * AdminModel
 * @author liuming
 * @date 2019-10-05 04:51:19
 */
public class AdminModifyDto implements Serializable {

	private static final long serialVersionUID = 1570265481555L;
	
	/**
	 * 
	 */
	private java.lang.Long id;
	/**
	 * 账号
	 */
	private java.lang.String account;
	/**
	 * 真实姓名
	 */
	private java.lang.String realName;
	/**
	 * 工号
	 */
	private java.lang.String jobNumber;
	/**
	 * 手机号码
	 */
	private java.lang.Long mobile;
	/**
	 * 时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 状态，1正常，0删除
	 */
	private java.lang.Integer status;
	/**
	 * 密码
	 */
	private java.lang.String password;
	/**
	 * 邮箱
	 */
	private java.lang.String email;
	/**
	 * 最后登入IP
	 */
	private java.lang.String lastLoginIp;
	/**
	 * 最后登入时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastLoginTime;
	/**
	 * 管理员类型 1管理员 2店长 
	 */
	private java.lang.Integer type;
	/**
	 * 锁定状态，0正常，1锁定
	 */
	private java.lang.Integer lockFlag;
	/**
	 * 头像
	 */
	private java.lang.String photoimg;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date startLockTime;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date endLockTime;
	/**
	 * 是否使用(1是，0否)
	 */
	private java.lang.Integer isuse;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 是否删除：1、是；0、否
	 */
	private java.lang.Integer isDel;
	private String remarks;
	
	
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}
	public void setAccount(java.lang.String account) {
		this.account = account;
	}

	public java.lang.String getAccount() {
		return this.account;
	}
	public void setRealName(java.lang.String realName) {
		this.realName = realName;
	}

	public java.lang.String getRealName() {
		return this.realName;
	}
	public void setJobNumber(java.lang.String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public java.lang.String getJobNumber() {
		return this.jobNumber;
	}
	public void setMobile(java.lang.Long mobile) {
		this.mobile = mobile;
	}

	public java.lang.Long getMobile() {
		return this.mobile;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public java.util.Date getTime() {
		return this.time;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.String getPassword() {
		return this.password;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getEmail() {
		return this.email;
	}
	public void setLastLoginIp(java.lang.String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public java.lang.String getLastLoginIp() {
		return this.lastLoginIp;
	}
	public void setLastLoginTime(java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public java.util.Date getLastLoginTime() {
		return this.lastLoginTime;
	}
	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.Integer getType() {
		return this.type;
	}
	public void setLockFlag(java.lang.Integer lockFlag) {
		this.lockFlag = lockFlag;
	}

	public java.lang.Integer getLockFlag() {
		return this.lockFlag;
	}
	public void setPhotoimg(java.lang.String photoimg) {
		this.photoimg = photoimg;
	}

	public java.lang.String getPhotoimg() {
		return this.photoimg;
	}
	public void setStartLockTime(java.util.Date startLockTime) {
		this.startLockTime = startLockTime;
	}

	public java.util.Date getStartLockTime() {
		return this.startLockTime;
	}
	public void setEndLockTime(java.util.Date endLockTime) {
		this.endLockTime = endLockTime;
	}

	public java.util.Date getEndLockTime() {
		return this.endLockTime;
	}
	public void setIsuse(java.lang.Integer isuse) {
		this.isuse = isuse;
	}

	public java.lang.Integer getIsuse() {
		return this.isuse;
	}
	public void setLastupdate(java.util.Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public java.util.Date getLastupdate() {
		return this.lastupdate;
	}
	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}
	
}
