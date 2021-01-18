package com.longjun.cto.framework.sm.users.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * UserModel
 * 
 * @author yangxuan
 * @date 2019-06-19 02:29:35
 */
public class UserView extends BaseView {

	private static final long serialVersionUID = 1560925780345L;

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
	 * 用户编号
	 */
	private Long userNo;

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
	 * 积分
	 */
	private Long score;

	/**
	 * 积分等级
	 */
	private Long levelId;

	/**
	 * 等级名称
	 */
	private String levelName;

	/**
	 * 等级图片
	 */
	private String levelImg;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 年
	 */
	private Integer year;

	/**
	 * 月
	 */
	private Integer month;

	/**
	 * 日
	 */
	private Integer day;

	/**
	 * 生日
	 */
	private Date birthday;

	/**
	 * 省份名称
	 */
	private String pName;

	/**
	 * 城市名称
	 */
	private String cName;

	/**
	 * 区域名称
	 */
	private String aName;

	/**
	 * 职业名称
	 */
	private String jobName;

	public String getLevelImg() {
		return levelImg;
	}

	public void setLevelImg(String levelImg) {
		this.levelImg = levelImg;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
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

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
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
