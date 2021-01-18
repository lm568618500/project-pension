package com.longjun.cto.framework.sm.pay.logs.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * PayApiLogsModel
 * @author yangxuan
 * @date 2019-11-07 05:48:12
 */
public class PayApiLogsModifyDto implements Serializable {

	private static final long serialVersionUID = 1573120097759L;
	
	/**
	 * 
	 */
	private java.lang.Long id;
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
	 * 
	 */
	private java.lang.Integer status;
	/**
	 * 
	 */
	private java.lang.Integer isDel;
	/**
	 * 
	 */
	private java.lang.String request;
	/**
	 * 
	 */
	private java.lang.String response;
	/**
	 * 接口指令
	 */
	private java.lang.Integer apiCmd;
	/**
	 * 支付渠道1、微信 2、支付宝 3、银联
	 */
	private java.lang.Integer payChannal;
	/**
	 * 订单流水号
	 */
	private java.lang.String outTradeNo;
	/**
	 * 
	 */
	private java.lang.String tradeNo;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
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
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}
	public void setRequest(java.lang.String request) {
		this.request = request;
	}

	public java.lang.String getRequest() {
		return this.request;
	}
	public void setResponse(java.lang.String response) {
		this.response = response;
	}

	public java.lang.String getResponse() {
		return this.response;
	}
	public void setApiCmd(java.lang.Integer apiCmd) {
		this.apiCmd = apiCmd;
	}

	public java.lang.Integer getApiCmd() {
		return this.apiCmd;
	}
	public void setPayChannal(java.lang.Integer payChannal) {
		this.payChannal = payChannal;
	}

	public java.lang.Integer getPayChannal() {
		return this.payChannal;
	}
	public void setOutTradeNo(java.lang.String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public java.lang.String getOutTradeNo() {
		return this.outTradeNo;
	}
	public void setTradeNo(java.lang.String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public java.lang.String getTradeNo() {
		return this.tradeNo;
	}
}
