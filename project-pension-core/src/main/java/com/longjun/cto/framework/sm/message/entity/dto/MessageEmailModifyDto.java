package com.longjun.cto.framework.sm.message.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * MessageEmailModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public class MessageEmailModifyDto implements Serializable {

	private static final long serialVersionUID = 1554515957756L;
	
	/**
	 * 
	 */
	private long id;
	/**
	 * 数据插入时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 最后修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 收件人邮箱
	 */
	private String email;
	/**
	 * 抄送
	 */
	private String cc;
	/**
	 * 附件
	 */
	private String attaments;
	/**
	 * 模板ID
	 */
	private long tempId;
	/**
	 * 邮件标题
	 */
	private String title;
	/**
	 * 邮件内容
	 */
	private String content;
	/**
	 * 发送者邮箱
	 */
	private String sender;
	/**
	 * 发送者名字
	 */
	private String senderName;
	/**
	 * 发送时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date sendTime;
	/**
	 * 业务状态
	 */
	private int status;
	/**
	 * 商户ID
	 */
	private long mechId;
	/**
	 * 设置ID
	 */
	private long settingId;
	/**
	 * 创建时间戳
	 */
	private long createTime;
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
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
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getCc() {
		return this.cc;
	}
	public void setAttaments(String attaments) {
		this.attaments = attaments;
	}

	public String getAttaments() {
		return this.attaments;
	}
	public void setTempId(long tempId) {
		this.tempId = tempId;
	}

	public long getTempId() {
		return this.tempId;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSender() {
		return this.sender;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderName() {
		return this.senderName;
	}
	public void setSendTime(java.util.Date sendTime) {
		this.sendTime = sendTime;
	}

	public java.util.Date getSendTime() {
		return this.sendTime;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}
	public void setMechId(long mechId) {
		this.mechId = mechId;
	}

	public long getMechId() {
		return this.mechId;
	}
	public void setSettingId(long settingId) {
		this.settingId = settingId;
	}

	public long getSettingId() {
		return this.settingId;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getCreateTime() {
		return this.createTime;
	}
}
