package com.longjun.cto.framework.sm.pay.logs.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PayApiLogsModel
 * @author yangxuan
 * @date 2019-11-07 05:48:12
 */
@TableName("t_pay_api_logs")
public class PayApiLogsModel extends BaseModel<PayApiLogsModel> {

	private static final long serialVersionUID = 1573120093566L;
	
	
	
	
	
	/**
	 * 
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;
	
	/**
	 * 
	 */
	@TableField("request")
	private java.lang.String request;
	
	/**
	 * 
	 */
	@TableField("response")
	private java.lang.String response;
	
	/**
	 * 接口指令
	 */
	@TableField("api_cmd")
	private java.lang.Integer apiCmd;
	
	/**
	 * 支付渠道1、微信 2、支付宝 3、银联
	 */
	@TableField("pay_channal")
	private java.lang.Integer payChannal;
	
	/**
	 * 订单流水号
	 */
	@TableField("out_trade_no")
	private java.lang.String outTradeNo;
	
	/**
	 * 
	 */
	@TableField("trade_no")
	private java.lang.String tradeNo;
	
	




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
