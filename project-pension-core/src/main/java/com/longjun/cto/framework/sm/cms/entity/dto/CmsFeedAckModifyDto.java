package com.longjun.cto.framework.sm.cms.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * CmsFeedAckModel
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
public class CmsFeedAckModifyDto implements Serializable {

	private static final long serialVersionUID = 1561297387127L;
	
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
	 * 状态
	 */
	private java.lang.Integer status;
	/**
	 * 删除状态 0正常 -1删除
	 */
	private java.lang.Integer isDel;
	/**
	 * 反馈编号
	 */
	private java.lang.Long feedNo;
	/**
	 * 管理员ID
	 */
	private java.lang.Long adminId;
	/**
	 * 回答时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date ackTime;
	/**
	 * 回答内容
	 */
	private java.lang.String ackContent;
	
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
	public void setFeedNo(java.lang.Long feedNo) {
		this.feedNo = feedNo;
	}

	public java.lang.Long getFeedNo() {
		return this.feedNo;
	}
	public void setAdminId(java.lang.Long adminId) {
		this.adminId = adminId;
	}

	public java.lang.Long getAdminId() {
		return this.adminId;
	}
	public void setAckTime(java.util.Date ackTime) {
		this.ackTime = ackTime;
	}

	public java.util.Date getAckTime() {
		return this.ackTime;
	}
	public void setAckContent(java.lang.String ackContent) {
		this.ackContent = ackContent;
	}

	public java.lang.String getAckContent() {
		return this.ackContent;
	}
}
