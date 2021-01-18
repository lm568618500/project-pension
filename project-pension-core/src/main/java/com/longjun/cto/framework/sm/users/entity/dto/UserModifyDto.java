package com.longjun.cto.framework.sm.users.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * UserModel
 * @author yangxuan
 * @date 2019-06-19 02:29:35
 */
public class UserModifyDto implements Serializable {

	private static final long serialVersionUID = 1560925785153L;
	
	/**
	 * 主键id
	 */
	private java.lang.Long id;
	/**
	 * 注册时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 头像
	 */
	private java.lang.String photo;
	/**
	 * 用户名
	 */
	private java.lang.String userName;
	/**
	 * 真实姓名
	 */
	private java.lang.String realName;
	/**
	 * 手机号
	 */
	private java.lang.String mobile;
	/**
	 * 密码
	 */
	private java.lang.String password;
	/**
	 * 身份类型
	 */
	private java.lang.Integer userType;
	/**
	 * 会员状态 0 未认证 1已认证 
	 */
	private java.lang.Integer status;
	/**
	 * 1在线0离线
	 */
	private java.lang.Integer online;
	/**
	 * 备注
	 */
	private java.lang.String remark;
	/**
	 * 是否删除（1是，0否）
	 */
	private java.lang.Integer isDel;
	/**
	 * 最后一次修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 是否黑名单（1是0否）
	 */
	private java.lang.Integer isBlack;
	/**
	 * 是否锁定（1是0否）
	 */
	private java.lang.Integer isLock;
	/**
	 * 登录错误次数
	 */
	private java.lang.Integer loginErrorCount;
	/**
	 * 账号被锁定的开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lockTime;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public java.util.Date getTime() {
		return this.time;
	}
	public void setPhoto(java.lang.String photo) {
		this.photo = photo;
	}

	public java.lang.String getPhoto() {
		return this.photo;
	}
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public java.lang.String getUserName() {
		return this.userName;
	}
	public void setRealName(java.lang.String realName) {
		this.realName = realName;
	}

	public java.lang.String getRealName() {
		return this.realName;
	}
	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}

	public java.lang.String getMobile() {
		return this.mobile;
	}
	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.String getPassword() {
		return this.password;
	}
	public void setUserType(java.lang.Integer userType) {
		this.userType = userType;
	}

	public java.lang.Integer getUserType() {
		return this.userType;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setOnline(java.lang.Integer online) {
		this.online = online;
	}

	public java.lang.Integer getOnline() {
		return this.online;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}
	public void setLastupdate(java.util.Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public java.util.Date getLastupdate() {
		return this.lastupdate;
	}
	public void setIsBlack(java.lang.Integer isBlack) {
		this.isBlack = isBlack;
	}

	public java.lang.Integer getIsBlack() {
		return this.isBlack;
	}
	public void setIsLock(java.lang.Integer isLock) {
		this.isLock = isLock;
	}

	public java.lang.Integer getIsLock() {
		return this.isLock;
	}
	public void setLoginErrorCount(java.lang.Integer loginErrorCount) {
		this.loginErrorCount = loginErrorCount;
	}

	public java.lang.Integer getLoginErrorCount() {
		return this.loginErrorCount;
	}
	public void setLockTime(java.util.Date lockTime) {
		this.lockTime = lockTime;
	}

	public java.util.Date getLockTime() {
		return this.lockTime;
	}
}
