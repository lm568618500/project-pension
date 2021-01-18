package com.longjun.cto.framework.sm.message.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * MessageEmailModel
 * 
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
@TableName("t_message_email")
public class MessageEmailModel extends BaseModel<MessageEmailModel> {

	private static final long serialVersionUID = 1554515957428L;

	/**
	 * 收件人邮箱
	 */
	@TableField("email")
	private String email;

	/**
	 * 抄送
	 */
	@TableField("cc")
	private String cc;

	/**
	 * 附件
	 */
	@TableField("attaments")
	private String attaments;

	/**
	 * 模板ID
	 */
	@TableField("temp_id")
	private Long tempId;

	/**
	 * 邮件标题
	 */
	@TableField("title")
	private String title;

	/**
	 * 邮件内容
	 */
	@TableField("content")
	private String content;

	/**
	 * 发送者邮箱
	 */
	@TableField("sender")
	private String sender;

	/**
	 * 发送者名字
	 */
	@TableField("sender_name")
	private String senderName;

	/**
	 * 发送时间
	 */
	@TableField("send_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date sendTime;

	/**
	 * 商户ID
	 */
	@TableField("mech_id")
	private Long mechId;

	/**
	 * 设置ID
	 */
	@TableField("setting_id")
	private Long settingId;

	/**
	 * 创建时间戳
	 */
	@TableField("create_time")
	private Long createTime;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getAttaments() {
		return attaments;
	}

	public void setAttaments(String attaments) {
		this.attaments = attaments;
	}

	public Long getTempId() {
		return tempId;
	}

	public void setTempId(Long tempId) {
		this.tempId = tempId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public java.util.Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(java.util.Date sendTime) {
		this.sendTime = sendTime;
	}

	public Long getMechId() {
		return mechId;
	}

	public void setMechId(Long mechId) {
		this.mechId = mechId;
	}

	public Long getSettingId() {
		return settingId;
	}

	public void setSettingId(Long settingId) {
		this.settingId = settingId;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

}
