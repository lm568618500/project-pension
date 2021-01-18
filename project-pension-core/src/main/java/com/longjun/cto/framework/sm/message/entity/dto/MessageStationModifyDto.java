package com.longjun.cto.framework.sm.message.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * MessageStationModel
 * @author yangxuan
 * @date 2019-07-04 07:33:46
 */
public class MessageStationModifyDto implements Serializable {

	private static final long serialVersionUID = 1562240031426L;
	
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
	 * 删除状态 0 正常 -1删除
	 */
	private java.lang.Integer isDel;
	/**
	 * 用户编号
	 */
	private java.lang.Long userNo;
	/**
	 * 发送时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date sendTime;
	/**
	 * 发送时间戳
	 */
	private java.lang.Long sendTimestamp;
	/**
	 * 内容
	 */
	private java.lang.String content;
	/**
	 * 创建者
	 */
	private java.lang.String creator;
	/**
	 * 标题
	 */
	private java.lang.String title;
	/**
	 * 已读状态 0未读 1已读
	 */
	private java.lang.Integer isRead;
	
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
	public void setUserNo(java.lang.Long userNo) {
		this.userNo = userNo;
	}

	public java.lang.Long getUserNo() {
		return this.userNo;
	}
	public void setSendTime(java.util.Date sendTime) {
		this.sendTime = sendTime;
	}

	public java.util.Date getSendTime() {
		return this.sendTime;
	}
	public void setSendTimestamp(java.lang.Long sendTimestamp) {
		this.sendTimestamp = sendTimestamp;
	}

	public java.lang.Long getSendTimestamp() {
		return this.sendTimestamp;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
	}
	public void setCreator(java.lang.String creator) {
		this.creator = creator;
	}

	public java.lang.String getCreator() {
		return this.creator;
	}
	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.lang.String getTitle() {
		return this.title;
	}
	public void setIsRead(java.lang.Integer isRead) {
		this.isRead = isRead;
	}

	public java.lang.Integer getIsRead() {
		return this.isRead;
	}
}
