package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * AdminOtherModel
 * @author liuming
 * @date 2019-10-05 04:51:18
 */
public class AdminOtherView extends BaseView {

	private static final long serialVersionUID = 1570265484830L;
	
	
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
	 * 0正常，-1删除
	 */
	private java.lang.Integer isDel;
	
	//不持久字段
	/**
	 * 姓名
	 */
	private String realName;
	/**
	 * 专业
	 */
	private String professionalName;
	/**
	 * 状态
	 */
    private Integer businessStatus;
    
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getProfessionalName() {
		return professionalName;
	}

	public void setProfessionalName(String professionalName) {
		this.professionalName = professionalName;
	}

	public Integer getBusinessStatus() {
		return businessStatus;
	}

	public void setBusinessStatus(Integer businessStatus) {
		this.businessStatus = businessStatus;
	}
	
	

}
