package com.longjun.cto.framework.sm.sys.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * AdminOtherModel
 * @author liuming
 * @date 2019-10-05 04:51:18
 */
public class AdminOtherModifyDto implements Serializable {

	private static final long serialVersionUID = 1570265482420L;
	
	/**
	 * id
	 */
	private java.lang.Long id;
	/**
	 * 管理员id
	 */
	private java.lang.Long adminId;
	/**
	 * 领域名称
	 */
	private java.lang.String domainName;
	/**
	 * 职能名称
	 */
	private java.lang.String functionName;
	/**
	 * 开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date startTime;
	/**
	 * 结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date endTime;
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
	 * 1开启，0关闭
	 */
	private java.lang.Integer status;
	/**
	 * 0正常，-1删除
	 */
	private java.lang.Integer isDel;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}
	public void setAdminId(java.lang.Long adminId) {
		this.adminId = adminId;
	}

	public java.lang.Long getAdminId() {
		return this.adminId;
	}
	public void setDomainName(java.lang.String domainName) {
		this.domainName = domainName;
	}

	public java.lang.String getDomainName() {
		return this.domainName;
	}
	public void setFunctionName(java.lang.String functionName) {
		this.functionName = functionName;
	}

	public java.lang.String getFunctionName() {
		return this.functionName;
	}
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}

	public java.util.Date getStartTime() {
		return this.startTime;
	}
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}

	public java.util.Date getEndTime() {
		return this.endTime;
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
	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}
}
