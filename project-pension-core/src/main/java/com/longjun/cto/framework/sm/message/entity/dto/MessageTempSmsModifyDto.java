package com.longjun.cto.framework.sm.message.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * MessageTempSmsModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public class MessageTempSmsModifyDto implements Serializable {

	private static final long serialVersionUID = 1554515961699L;
	
	/**
	 * 
	 */
	private long id;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 商户ID
	 */
	private long mechId;
	/**
	 * 模板名称
	 */
	private String tempUid;
	/**
	 * 第三方模板ID
	 */
	private String otherTemplateId;
	/**
	 * 短信内容
	 */
	private String smsContent;
	/**
	 * 短信开关0关闭 1开启
	 */
	private int status;
	/**
	 * 短信立刻0非立刻 1立刻
	 */
	private int immediately;
	/**
	 * 最后修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 提示
	 */
	private String tips;
	
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
	public void setMechId(long mechId) {
		this.mechId = mechId;
	}

	public long getMechId() {
		return this.mechId;
	}
	public void setTempUid(String tempUid) {
		this.tempUid = tempUid;
	}

	public String getTempUid() {
		return this.tempUid;
	}
	public void setOtherTemplateId(String otherTemplateId) {
		this.otherTemplateId = otherTemplateId;
	}

	public String getOtherTemplateId() {
		return this.otherTemplateId;
	}
	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getSmsContent() {
		return this.smsContent;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}
	public void setImmediately(int immediately) {
		this.immediately = immediately;
	}

	public int getImmediately() {
		return this.immediately;
	}
	public void setLastupdate(java.util.Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public java.util.Date getLastupdate() {
		return this.lastupdate;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getTips() {
		return this.tips;
	}
}
