package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * AdminOtherModel
 * @author liuming
 * @date 2019-10-05 04:51:18
 */
@TableName("t_admin_other")
public class AdminOtherModel extends BaseModel<AdminOtherModel> {

	private static final long serialVersionUID = 1570265485881L;
	
	
	/**
	 * 管理员id
	 */
	@TableField("admin_id")
	private java.lang.Long adminId;
	
	/**
	 * 领域名称
	 */
	@TableField("domain_name")
	private java.lang.String domainName;
	
	/**
	 * 职能名称
	 */
	@TableField("function_name")
	private java.lang.String functionName;
	
	/**
	 * 开始时间
	 */
	@TableField("start_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date startTime;
	
	/**
	 * 结束时间
	 */
	@TableField("end_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date endTime;
	
	
	
	
	/**
	 * 0正常，-1删除
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;
	
	

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




	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

}
