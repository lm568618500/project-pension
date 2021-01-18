package com.longjun.cto.framework.sm.pay.alipay.entity.model;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PayAlipayNotifyModel
 * 
 * @author yangxuan
 * @date 2019-11-07 06:58:15
 */
@TableName("t_pay_alipay_notify")
public class PayAlipayNotifyModel extends BaseModel<PayAlipayNotifyModel> {

	private static final long serialVersionUID = 1573124297651L;

	/**
	 * 
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;

	/**
	 * 
	 */
	@TableField("app_id")
	private java.lang.String appId;

	/**
	 * 开发者的app_id
	 */
	@TableField("auth_app_id")
	private java.lang.String authAppId;

	/**
	 * 编码格式
	 */
	@TableField("charset")
	private java.lang.String charset;

	/**
	 * 
	 */
	@TableField("method")
	private java.lang.String method;

	/**
	 * 商户订单号
	 */
	@TableField("out_trade_no")
	private java.lang.String outTradeNo;

	/**
	 * 卖家支付宝用户号
	 */
	@TableField("seller_id")
	private java.lang.String sellerId;

	/**
	 * 签名
	 */
	@TableField("sign")
	private java.lang.String sign;

	/**
	 * 签名类型
	 */
	@TableField("sign_type")
	private java.lang.String signType;

	/**
	 * 
	 */
	@TableField("notify_timestamp")
	private java.lang.String notifyTimestamp;

	/**
	 * 订单金额
	 */
	@TableField("total_amount")
	private BigDecimal totalAmount;

	/**
	 * 支付宝交易号
	 */
	@TableField("trade_no")
	private java.lang.String tradeNo;

	/**
	 * 接口版本
	 */
	@TableField("version")
	private java.lang.String version;

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

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
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
