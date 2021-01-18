package com.longjun.cto.framework.sm.sys.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * LogEventModel
 * @author yangxuan
 * @date 2019-04-09 01:48:27
 */
public class LogEventModifyDto implements Serializable {

	private static final long serialVersionUID = 1554788913687L;
	
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
	 * 所属模块
	 */
	private String beyondModule;
	/**
	 * 使用ID
	 */
	private long useId;
	/**
	 *  1管理员 2用户 3系统
	 */
	private int eType;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 有效状态（1是 0否）
	 */
	private int status;
	
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
	public void setBeyondModule(String beyondModule) {
		this.beyondModule = beyondModule;
	}

	public String getBeyondModule() {
		return this.beyondModule;
	}
	public void setUseId(long useId) {
		this.useId = useId;
	}

	public long getUseId() {
		return this.useId;
	}
	public void setEType(int eType) {
		this.eType = eType;
	}

	public int getEType() {
		return this.eType;
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
}
