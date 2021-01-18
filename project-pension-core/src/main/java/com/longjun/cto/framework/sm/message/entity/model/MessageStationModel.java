package com.longjun.cto.framework.sm.message.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * MessageStationModel
 * @author yangxuan
 * @date 2019-07-04 07:33:46
 */
@TableName("t_message_station")
public class MessageStationModel extends BaseModel<MessageStationModel> {

	private static final long serialVersionUID = 1562240029643L;
	
	
	
	
	
	/**
	 * 删除状态 0 正常 -1删除
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;
	
	/**
	 * 用户编号
	 */
	@TableField("user_no")
	private java.lang.Long userNo;
	
	/**
	 * 发送时间
	 */
	@TableField("send_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date sendTime;
	
	/**
	 * 发送时间戳
	 */
	@TableField("send_timestamp")
	private java.lang.Long sendTimestamp;
	
	/**
	 * 内容
	 */
	@TableField("content")
	private java.lang.String content;
	
	/**
	 * 创建者
	 */
	@TableField("creator")
	private java.lang.String creator;
	
	/**
	 * 标题
	 */
	@TableField("title")
	private java.lang.String title;
	
	/**
	 * 已读状态 0未读 1已读
	 */
	@TableField("is_read")
	private java.lang.Integer isRead;
	
	




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
