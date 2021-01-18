package com.longjun.cto.framework.sm.pay.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * PayChannelModel
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
public class PayChannelModifyDto implements Serializable {

	private static final long serialVersionUID = 1554023837625L;
	
	/**
	 * 渠道主键ID
	 */
	private int id;
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
	 * 渠道状态,0-停止使用,1-使用中
	 */
	private int status;
	/**
	 * 
	 */
	private int isDel;
	/**
	 * 渠道ID
	 */
	private long channelId;
	/**
	 * 渠道名称,如:alipay,wechat
	 */
	private String channelName;
	/**
	 * 渠道商户ID
	 */
	private long channelMchId;
	/**
	 * 商户ID
	 */
	private String mchId;
	/**
	 * 配置参数,json字符串
	 */
	private String param;
	/**
	 * 备注
	 */
	private String remark;
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
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
	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public long getChannelId() {
		return this.channelId;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelName() {
		return this.channelName;
	}
	public void setChannelMchId(long channelMchId) {
		this.channelMchId = channelMchId;
	}

	public long getChannelMchId() {
		return this.channelMchId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getMchId() {
		return this.mchId;
	}
	public void setParam(String param) {
		this.param = param;
	}

	public String getParam() {
		return this.param;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}
}
