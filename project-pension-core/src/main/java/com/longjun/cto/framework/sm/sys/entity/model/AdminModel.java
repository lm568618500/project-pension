package com.longjun.cto.framework.sm.sys.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 管理员Model
 * @author lp
 * @date 2018-12-20 20:10:49
 */
@TableName("t_admin")
public class AdminModel extends BaseModel<AdminModel> {

	private static final long serialVersionUID = 1545307849094L;

	/**
	 * 账号
	 */
	@TableField("account")
	private String account;

	/**
	 * 真实姓名
	 */
	@TableField("real_name")
	private String realName;
	/**
	 * 工号
	 */
	@TableField("job_number")
	private String jobNumber;
	
	/**
	 * 手机号码
	 */
	@TableField("mobile")
	private long mobile;
	
	/**
	 * 密码
	 */
	@TableField("password")
	private String password;


	/**
	 * 邮箱
	 */
	@TableField("email")
	private String email;

	/**
	 * 最后登入IP
	 */
	@TableField("last_login_ip")
	private String lastLoginIp;

	/**
	 * 最后登入时间
	 */
	@TableField("last_login_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastLoginTime;

	/**
	 * 管理员类型 1管理员 2店长 
	 */
	@TableField("type")
	private Integer type;

	/**
	 * 锁定状态，0正常，1锁定
	 */
	@TableField("lock_flag")
	private Integer lockFlag;

	/**
	 * 头像
	 */
	@TableField("photoimg")
	private String photoimg;

	/**
	 * 
	 */
	@TableField("start_lock_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date startlocktime;

	/**
	 * 
	 */
	@TableField("end_lock_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date endlocktime;

	/**
	 * 是否使用
	 */
	@TableField("isuse")
	private Integer isuse;


	/**
	 * 是否删除：1、是；0、否
	 */
	@TableField("is_del")
	private Integer isDel;
	/**
	 * 备注
	 */
	@TableField("remarks")
	private String remarks;
	/**
	 * 是否根据管理员id查询录入卡号，录入卡号,总部寄出模块，0,否，1是
	 */
	@TableField("is_super")
	private Integer isSuper;


	
	public Integer getIsSuper() {
		return isSuper;
	}

	public void setIsSuper(Integer isSuper) {
		this.isSuper = isSuper;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccount() {
		return this.account;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRealName() {
		return this.realName;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public long getMobile() {
		return this.mobile;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginTime(java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public java.util.Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setLockFlag(Integer lockFlag) {
		this.lockFlag = lockFlag;
	}

	public Integer getLockFlag() {
		return this.lockFlag;
	}

	public void setPhotoimg(String photoimg) {
		this.photoimg = photoimg;
	}

	public String getPhotoimg() {
		return this.photoimg;
	}

	public void setStartlocktime(java.util.Date startlocktime) {
		this.startlocktime = startlocktime;
	}

	public java.util.Date getStartlocktime() {
		return this.startlocktime;
	}

	public void setEndlocktime(java.util.Date endlocktime) {
		this.endlocktime = endlocktime;
	}

	public java.util.Date getEndlocktime() {
		return this.endlocktime;
	}

	public void setIsuse(Integer isuse) {
		this.isuse = isuse;
	}

	public Integer getIsuse() {
		return this.isuse;
	}


	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

}
