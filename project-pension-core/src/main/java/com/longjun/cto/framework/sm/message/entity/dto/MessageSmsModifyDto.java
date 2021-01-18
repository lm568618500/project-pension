package com.longjun.cto.framework.sm.message.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * MessageSmsModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public class MessageSmsModifyDto implements Serializable {

	private static final long serialVersionUID = 1554515956222L;
	
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
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 模板ID
	 */
	private long tempId;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 模板内容
	 */
	private String tempContent;
	/**
	 * 模板參數绑定
	 */
	private String tempParamsBind;
	/**
	 * 发送时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date sendTime;
	/**
	 * 商户ID
	 */
	private long mechId;
	/**
	 * 设置
	 */
	private long settingId;
	/**
	 * 状态
	 */
	private int status;
	/**
	 * 创建时间戳
	 */
	private long createTime;
	/**
	 * -1 删除 0 正常
	 */
	private int isDel;
	
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
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
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
