package com.longjun.cto.framework.sm.message.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * MessageEmailModel
 * 
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public class MessageEmailView extends BaseView {

	private static final long serialVersionUID = 1554515957863L;

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
	private Long tempId;

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
	 * 商户ID
	 */
	private Long mechId;

	/**
	 * 设置ID
	 */
	private Long settingId;

	/**
	 * 创建时间戳
	 */
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
