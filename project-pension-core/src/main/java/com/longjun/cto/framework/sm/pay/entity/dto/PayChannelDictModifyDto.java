package com.longjun.cto.framework.sm.pay.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * PayChannelDictModel
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
public class PayChannelDictModifyDto implements Serializable {

	private static final long serialVersionUID = 1554945271871L;
	
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
	 * 状态
	 */
	private int status;
	/**
	 * 渠道名称
	 */
	private String channelName;
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
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelName() {
		return this.channelName;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return this.mark;
	}
}
