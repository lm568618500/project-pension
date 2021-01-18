package com.longjun.cto.framework.sm.message.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * MessageGatwayModel
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
public class MessageGatwayModifyDto implements Serializable {

	private static final long serialVersionUID = 1554457188568L;
	
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
	 * 网关名称
	 */
	private String gatwayName;
	/**
	 * 网关值
	 */
	private String gatwayValue;
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
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}
	public void setGatwayName(String gatwayName) {
		this.gatwayName = gatwayName;
	}

	public String getGatwayName() {
		return this.gatwayName;
	}
	public void setGatwayValue(String gatwayValue) {
		this.gatwayValue = gatwayValue;
	}

	public String getGatwayValue() {
		return this.gatwayValue;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return this.mark;
	}
}
