package com.longjun.cto.framework.sm.message.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * MessageTempEmailModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public class MessageTempEmailModifyDto implements Serializable {

	private static final long serialVersionUID = 1554515960224L;
	
	/**
	 * 
	 */
	private long id;
	/**
	 * 商户ID
	 */
	private long mechId;
	/**
	 * 模板名称
	 */
	private String tempUid;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 邮件开关0关闭 1开启
	 */
	private int status;
	/**
	 * 邮件内容
	 */
	private String emailContent;
	/**
	 * 邮件立刻0非立刻 1立刻
	 */
	private int emailimmediately;
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
	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public java.util.Date getTime() {
		return this.time;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public String getEmailContent() {
		return this.emailContent;
	}
	public void setEmailimmediately(int emailimmediately) {
		this.emailimmediately = emailimmediately;
	}

	public int getEmailimmediately() {
		return this.emailimmediately;
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
