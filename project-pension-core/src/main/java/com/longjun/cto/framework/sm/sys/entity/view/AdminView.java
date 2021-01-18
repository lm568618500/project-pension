package com.longjun.cto.framework.sm.sys.entity.view;

import com.baomidou.mybatisplus.annotations.TableField;
import com.eims.cto.framework.module.base.model.BaseView;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.longjun.cto.framework.sm.sys.entity.model.AdminModel;

/**
 * 管理员View
 * @author lp
 * @date 2018-12-20 20:10:49
 */
public class AdminView extends BaseView {

	private static final long serialVersionUID = 1545307849381L;

	public AdminView(AdminModel model) {
		//this.model = model;
		this.id = model.getId();
		this.account = model.getAccount();
		this.realName = model.getRealName();
		this.jobNumber = model.getJobNumber();
		this.mobile = model.getMobile();
		this.time = model.getTime();
		this.status = model.getStatus();
		this.password = model.getPassword();
		this.email = model.getEmail();
		this.lastLoginIp = model.getLastLoginIp();
		this.lastLoginTime = model.getLastLoginTime();
		this.type = model.getType();
		this.lockFlag = model.getLockFlag();
		this.photoimg = model.getPhotoimg();
		this.startlocktime = model.getStartlocktime();
		this.endlocktime = model.getEndlocktime();
		this.isuse = model.getIsuse();
		this.lastupdate = model.getLastupdate();
		this.isDel = model.getIsDel();
		this.remarks = model.getRemarks();
		this.isSuper =model.getIsSuper();
	}

	public AdminView() {
		
	}
	/**
	 * 备注
	 */
	private String remarks;


	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 账号
	 */
	private String account;

	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 工号
	 */
	private String jobNumber;
	/**
	 * 业务状态 1有效，0失效 3暂停授权 4离职资质已转出 5离职资质兼职保持
	 */
	private long businessStatus;
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 角色使用ID
	 */
	private long roleUseId;
	
	/**
	 * 角色描述
	 */
	private String roleDesc;
	
	private String adminOther;
	
	private Integer isSuper;
	
	
	public Integer getIsSuper() {
		return isSuper;
	}

	public void setIsSuper(Integer isSuper) {
		this.isSuper = isSuper;
	}

	public String getAdminOther() {
		return adminOther;
	}

	public void setAdminOther(String adminOther) {
		this.adminOther = adminOther;
	}

	public long getRoleUseId() {
		return roleUseId;
	}

	public void setRoleUseId(long roleUseId) {
		this.roleUseId = roleUseId;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 手机号码
	 */
	private long mobile;


	/**
	 * 密码
	 */
	private String password;



	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 最后登入IP
	 */
	private String lastLoginIp;

	/**
	 * 最后登入时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastLoginTime;

	/**
	 * 管理员类型 1管理员 2店长 
	 */
	private int type;

	/**
	 * 锁定状态，0正常，1锁定
	 */
	@TableField("lock_flag")
	private int lockFlag;

	/**
	 * 头像
	 */
	@TableField("photoimg")
	private String photoimg;

	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date startlocktime;

	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date endlocktime;

	/**
	 * 是否使用
	 */
	@TableField("isuse")
	private int isuse;


	/**
	 * 是否删除：1、是；0、否
	 */
	@TableField("is_del")
	private int isDel;

	
	public long getBusinessStatus() {
		return businessStatus;
	}

	public void setBusinessStatus(long businessStatus) {
		this.businessStatus = businessStatus;
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

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}

	public void setLockFlag(int lockFlag) {
		this.lockFlag = lockFlag;
	}

	public int getLockFlag() {
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

	public void setIsuse(int isuse) {
		this.isuse = isuse;
	}

	public int getIsuse() {
		return this.isuse;
	}


	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}
	
	

}
