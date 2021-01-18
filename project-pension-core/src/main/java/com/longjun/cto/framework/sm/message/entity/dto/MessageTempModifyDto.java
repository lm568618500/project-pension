package com.longjun.cto.framework.sm.message.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * MessageTempModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public class MessageTempModifyDto implements Serializable {

	private static final long serialVersionUID = 1554515957818L;
	
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
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 状态1开启2停用
	 */
	private int status;
	/**
	 * 模板名称
	 */
	private String tempName;
	/**
	 * 模板使用ID
	 */
	private String tempUid;
	/**
	 * 模板类型
	 */
	private int tempType;
	/**
	 * 备注
	 */
	private String mark;
	
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
	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

	public String getTempName() {
		return this.tempName;
	}
	public void setTempUid(String tempUid) {
		this.tempUid = tempUid;
	}

	public String getTempUid() {
		return this.tempUid;
	}
	public void setTempType(int tempType) {
		this.tempType = tempType;
	}

	public int getTempType() {
		return this.tempType;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return this.mark;
	}
}
