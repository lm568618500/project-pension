package com.longjun.cto.framework.sm.pay.alipay.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * PayAlipayNotifyModel
 * @author yangxuan
 * @date 2019-11-07 06:58:15
 */
public class PayAlipayNotifyModifyDto implements Serializable {

	private static final long serialVersionUID = 1573124298112L;
	
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
	private java.lang.String appId;
	/**
	 * 开发者的app_id
	 */
	private java.lang.String authAppId;
	/**
	 * 编码格式
	 */
	private java.lang.String charset;
	/**
	 * 
	 */
	private java.lang.String method;
	/**
	 * 商户订单号
	 */
	private java.lang.String outTradeNo;
	/**
	 * 卖家支付宝用户号
	 */
	private java.lang.String sellerId;
	/**
	 * 签名
	 */
	private java.lang.String sign;
	/**
	 * 签名类型
	 */
	private java.lang.String signType;
	/**
	 * 
	 */
	private java.lang.String notifyTimestamp;
	/**
	 * 订单金额
	 */
	private java.lang.Long totalAmount;
	/**
	 * 支付宝交易号
	 */
	private java.lang.String tradeNo;
	/**
	 * 接口版本
	 */
	private java.lang.String version;
	
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
	public void setAppId(java.lang.String appId) {
		this.appId = appId;
	}

	public java.lang.String getAppId() {
		return this.appId;
	}
	public void setAuthAppId(java.lang.String authAppId) {
		this.authAppId = authAppId;
	}

	public java.lang.String getAuthAppId() {
		return this.authAppId;
	}
	public void setCharset(java.lang.String charset) {
		this.charset = charset;
	}

	public java.lang.String getCharset() {
		return this.charset;
	}
	public void setMethod(java.lang.String method) {
		this.method = method;
	}

	public java.lang.String getMethod() {
		return this.method;
	}
	public void setOutTradeNo(java.lang.String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public java.lang.String getOutTradeNo() {
		return this.outTradeNo;
	}
	public void setSellerId(java.lang.String sellerId) {
		this.sellerId = sellerId;
	}

	public java.lang.String getSellerId() {
		return this.sellerId;
	}
	public void setSign(java.lang.String sign) {
		this.sign = sign;
	}

	public java.lang.String getSign() {
		return this.sign;
	}
	public void setSignType(java.lang.String signType) {
		this.signType = signType;
	}

	public java.lang.String getSignType() {
		return this.signType;
	}
	public void setNotifyTimestamp(java.lang.String notifyTimestamp) {
		this.notifyTimestamp = notifyTimestamp;
	}

	public java.lang.String getNotifyTimestamp() {
		return this.notifyTimestamp;
	}
	public void setTotalAmount(java.lang.Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public java.lang.Long getTotalAmount() {
		return this.totalAmount;
	}
	public void setTradeNo(java.lang.String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public java.lang.String getTradeNo() {
		return this.tradeNo;
	}
	public void setVersion(java.lang.String version) {
		this.version = version;
	}

	public java.lang.String getVersion() {
		return this.version;
	}
}
