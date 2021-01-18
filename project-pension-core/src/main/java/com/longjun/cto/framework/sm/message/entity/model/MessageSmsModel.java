package com.longjun.cto.framework.sm.message.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * MessageSmsModel
 * 
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
@TableName("t_message_sms")
public class MessageSmsModel extends BaseModel<MessageSmsModel> {

	private static final long serialVersionUID = 1554515959962L;

	/**
	 * 手机号码
	 */
	@TableField("mobile")
	private String mobile;

	/**
	 * 模板ID
	 */
	@TableField("temp_id")
	private long tempId;

	/**
	 * 内容
	 */
	@TableField("content")
	private String content;

	/**
	 * 模板内容
	 */
	@TableField("temp_content")
	private String tempContent;

	/**
	 * 模板參數绑定
	 */
	@TableField("temp_params_bind")
	private String tempParamsBind;

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
	private long mechId;

	/**
	 * 设置
	 */
	@TableField("setting_id")
	private long settingId;

	/**
	 * 创建时间戳
	 */
	@TableField("create_time")
	private long createTime;

	/**
	 * -1 删除 0 正常
	 */
	@TableField("is_del")
	private int isDel;

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setTempId(long tempId) {
		this.tempId = tempId;
	}

	public long getTempId() {
		return this.tempId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setTempContent(String tempContent) {
		this.tempContent = tempContent;
	}

	public String getTempContent() {
		return this.tempContent;
	}

	public void setTempParamsBind(String tempParamsBind) {
		this.tempParamsBind = tempParamsBind;
	}

	public String getTempParamsBind() {
		return this.tempParamsBind;
	}

	public void setSendTime(java.util.Date sendTime) {
		this.sendTime = sendTime;
	}

	public java.util.Date getSendTime() {
		return this.sendTime;
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

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

}
