package com.longjun.cto.framework.sm.users.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * UserScoreSenceModel
 * @author yangxuan
 * @date 2019-07-01 05:05:46
 */
public class UserScoreSenceModifyDto implements Serializable {

	private static final long serialVersionUID = 1561971947231L;
	
	/**
	 * ID
	 */
	private java.lang.Long id;
	/**
	 * 添加时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 业务状态
	 */
	private java.lang.Integer status;
	/**
	 * 删除状态 0正常 -1删除
	 */
	private java.lang.Integer isDel;
	/**
	 * 场景名称
	 */
	private java.lang.String senceName;
	/**
	 * 场景编号
	 */
	private java.lang.Long senceNo;
	/**
	 * 出入账情况 1、积分入账 2、积分出账
	 */
	private java.lang.Integer income;
	
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
	public void setSenceName(java.lang.String senceName) {
		this.senceName = senceName;
	}

	public java.lang.String getSenceName() {
		return this.senceName;
	}
	public void setSenceNo(java.lang.Long senceNo) {
		this.senceNo = senceNo;
	}

	public java.lang.Long getSenceNo() {
		return this.senceNo;
	}
	public void setIncome(java.lang.Integer income) {
		this.income = income;
	}

	public java.lang.Integer getIncome() {
		return this.income;
	}
}
