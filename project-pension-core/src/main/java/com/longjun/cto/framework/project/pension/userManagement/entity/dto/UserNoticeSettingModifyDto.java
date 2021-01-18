package com.longjun.cto.framework.project.pension.userManagement.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * UserNoticeSettingModel
 * @author Meisf
 * @date 2019-11-14 03:44:11
 */
public class UserNoticeSettingModifyDto implements Serializable {

	private static final long serialVersionUID = 1573717456619L;
	
	/**
	 * 
	 */
	private java.lang.Long id;
	/**
	 * 用户id
	 */
	private java.lang.Long userId;
	/**
	 * 受理短信：0开启，1关闭
	 */
	private java.lang.Integer acceptSms;
	/**
	 * 受理邮箱：0开启，1关闭
	 */
	private java.lang.Integer acceptEmail;
	/**
	 * 送样短信：0开启，1关闭
	 */
	private java.lang.Integer sampleSms;
	/**
	 * 送样邮箱：0开启，1关闭
	 */
	private java.lang.Integer sampleEmail;
	/**
	 * 工厂检查短信：0开启，1关闭
	 */
	private java.lang.Integer factorySms;
	/**
	 * 工厂检查邮箱：0开启，1关闭
	 */
	private java.lang.Integer factoryEmail;
	/**
	 * 费用结算短信：0开启，1关闭
	 */
	private java.lang.Integer costSms;
	/**
	 * 费用结算邮箱：0开启，1关闭
	 */
	private java.lang.Integer costEmail;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 
	 */
	private java.lang.Integer status;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}
	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}

	public java.lang.Long getUserId() {
		return this.userId;
	}
	public void setAcceptSms(java.lang.Integer acceptSms) {
		this.acceptSms = acceptSms;
	}

	public java.lang.Integer getAcceptSms() {
		return this.acceptSms;
	}
	public void setAcceptEmail(java.lang.Integer acceptEmail) {
		this.acceptEmail = acceptEmail;
	}

	public java.lang.Integer getAcceptEmail() {
		return this.acceptEmail;
	}
	public void setSampleSms(java.lang.Integer sampleSms) {
		this.sampleSms = sampleSms;
	}

	public java.lang.Integer getSampleSms() {
		return this.sampleSms;
	}
	public void setSampleEmail(java.lang.Integer sampleEmail) {
		this.sampleEmail = sampleEmail;
	}

	public java.lang.Integer getSampleEmail() {
		return this.sampleEmail;
	}
	public void setFactorySms(java.lang.Integer factorySms) {
		this.factorySms = factorySms;
	}

	public java.lang.Integer getFactorySms() {
		return this.factorySms;
	}
	public void setFactoryEmail(java.lang.Integer factoryEmail) {
		this.factoryEmail = factoryEmail;
	}

	public java.lang.Integer getFactoryEmail() {
		return this.factoryEmail;
	}
	public void setCostSms(java.lang.Integer costSms) {
		this.costSms = costSms;
	}

	public java.lang.Integer getCostSms() {
		return this.costSms;
	}
	public void setCostEmail(java.lang.Integer costEmail) {
		this.costEmail = costEmail;
	}

	public java.lang.Integer getCostEmail() {
		return this.costEmail;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public java.util.Date getTime() {
		return this.time;
	}
	public void setLastupdate(java.util.Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public java.util.Date getLastupdate() {
		return this.lastupdate;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}
}
