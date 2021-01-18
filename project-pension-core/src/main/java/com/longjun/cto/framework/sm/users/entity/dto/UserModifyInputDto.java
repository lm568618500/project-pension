package com.longjun.cto.framework.sm.users.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * 个人信息修改
 * 
 * @author yangxuan
 * @date Jun 27, 2019 - 7:02:50 PM
 */
public class UserModifyInputDto implements Serializable {

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

	/**
	 * 性别 1男 2女
	 */
	private Integer sex;

	/**
	 * 职业
	 */
	private Long job;

	/**
	 * 省份ID
	 */
	private Long pId;

	/**
	 * 城市ID
	 */
	private Long cId;

	/**
	 * 区域ID
	 */
	private Long aId;

	/**
	 * 个性签名
	 */
	private String signature;
	
	/**
	 * 生日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date birthday;
	
	/**
	 * 积分
	 */
	private Long score;
	
	/**
	 * 积分等级
	 */
	private Long levelId;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 年
	 */
	private java.lang.Integer year;
	
	/**
	 * 月
	 */
	private java.lang.Integer month;
	
	/**
	 * 日
	 */
	private java.lang.Integer day;
	

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getLevelId() {
		return levelId;
	}

	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.lang.Integer getYear() {
		return year;
	}

	public void setYear(java.lang.Integer year) {
		this.year = year;
	}

	public java.lang.Integer getMonth() {
		return month;
	}

	public void setMonth(java.lang.Integer month) {
		this.month = month;
	}

	public java.lang.Integer getDay() {
		return day;
	}

	public void setDay(java.lang.Integer day) {
		this.day = day;
	}


	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public Long getaId() {
		return aId;
	}

	public void setaId(Long aId) {
		this.aId = aId;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Long getJob() {
		return job;
	}

	public void setJob(Long job) {
		this.job = job;
	}

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
