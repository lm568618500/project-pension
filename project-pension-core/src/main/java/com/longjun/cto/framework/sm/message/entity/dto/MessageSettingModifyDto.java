package com.longjun.cto.framework.sm.message.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * MessageSettingModel
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
public class MessageSettingModifyDto implements Serializable {

	private static final long serialVersionUID = 1554457189109L;
	
	/**
	 * ID
	 */
	private long id;
	/**
	 * 数据插入时间
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
	private int status;
	/**
	 * 是否删除 0 正常 -1删除
	 */
	private int isDel;
	/**
	 * 商户ID
	 */
	private long mechId;
	/**
	 * 设置类型 1短信 2邮箱 3推送
	 */
	private int settingType;
	/**
	 * 消息网关ID
	 */
	private long gatwayId;
	/**
	 * 配置文件信息。可配置JSON
	 */
	private String profile;
	
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
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}
	public void setMechId(long mechId) {
		this.mechId = mechId;
	}

	public long getMechId() {
		return this.mechId;
	}
	public void setSettingType(int settingType) {
		this.settingType = settingType;
	}

	public int getSettingType() {
		return this.settingType;
	}
	public void setGatwayId(long gatwayId) {
		this.gatwayId = gatwayId;
	}

	public long getGatwayId() {
		return this.gatwayId;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getProfile() {
		return this.profile;
	}
}
