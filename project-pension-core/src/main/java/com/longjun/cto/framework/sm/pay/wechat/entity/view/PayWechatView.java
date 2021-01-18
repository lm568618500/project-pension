package com.longjun.cto.framework.sm.pay.wechat.entity.view;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * PayWechatModel
 * 
 * @author yangxuan
 * @date 2019-11-07 02:13:18
 */
public class PayWechatView extends BaseView {

	private static final long serialVersionUID = 1573107200366L;

	/**
	 * 
	 */
	private java.lang.Integer isDel;

	/**
	 * 1、公众号支付 2、扫码付 3、App支付 4、刷脸支付 5、H5支付 6、刷卡支付
	 */
	private java.lang.Integer payType;

	/**
	 * 订单描述
	 */
	private java.lang.String body;

	/**
	 * 订单标题
	 */
	private java.lang.String subject;

	/**
	 * 订单金额
	 */
	private java.math.BigDecimal price;

	/**
	 * 
	 */
	private java.lang.String outTradeNo;

	/**
	 * 同步页面
	 */
	private java.lang.String returnUrl;

	/**
	 * 异步通知地址
	 */
	private java.lang.String notifysUrl;

	/**
	 * 1、app支付 2、pc网页支付 3、wap网页支付
	 */
	private java.lang.Integer authcode;

	/**
	 * 支付状态
	 */
	private java.lang.Integer payStatus;

	/**
	 * 订单关闭时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date closeTime;

	/**
	 * 成功支付时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date paySuccessTime;

	/**
	 * 备注
	 */
	private java.lang.String memo;

	/**
	 * 微信返回交易ID
	 */
	private java.lang.String transactionId;

	/**
	 * 退款编号
	 */
	private java.lang.String refundNo;

	/**
	 * 退款状态
	 */
	private Integer refundStatus;

	/**
	 * 退款金额
	 */
	private BigDecimal refundAmount;

	public java.lang.String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(java.lang.String transactionId) {
		this.transactionId = transactionId;
	}

	public java.lang.String getRefundNo() {
		return refundNo;
	}

	public void setRefundNo(java.lang.String refundNo) {
		this.refundNo = refundNo;
	}

	public Integer getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setPayType(java.lang.Integer payType) {
		this.payType = payType;
	}

	public java.lang.Integer getPayType() {
		return this.payType;
	}

	public void setBody(java.lang.String body) {
		this.body = body;
	}

	public java.lang.String getBody() {
		return this.body;
	}

	public void setSubject(java.lang.String subject) {
		this.subject = subject;
	}

	public java.lang.String getSubject() {
		return this.subject;
	}

	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}

	public java.math.BigDecimal getPrice() {
		return this.price;
	}

	public void setOutTradeNo(java.lang.String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public java.lang.String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setReturnUrl(java.lang.String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public java.lang.String getReturnUrl() {
		return this.returnUrl;
	}

	public void setNotifysUrl(java.lang.String notifysUrl) {
		this.notifysUrl = notifysUrl;
	}

	public java.lang.String getNotifysUrl() {
		return this.notifysUrl;
	}

	public void setAuthcode(java.lang.Integer authcode) {
		this.authcode = authcode;
	}

	public java.lang.Integer getAuthcode() {
		return this.authcode;
	}

	public void setPayStatus(java.lang.Integer payStatus) {
		this.payStatus = payStatus;
	}

	public java.lang.Integer getPayStatus() {
		return this.payStatus;
	}

	public void setCloseTime(java.util.Date closeTime) {
		this.closeTime = closeTime;
	}

	public java.util.Date getCloseTime() {
		return this.closeTime;
	}

	public void setPaySuccessTime(java.util.Date paySuccessTime) {
		this.paySuccessTime = paySuccessTime;
	}

	public java.util.Date getPaySuccessTime() {
		return this.paySuccessTime;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	public java.lang.String getMemo() {
		return this.memo;
	}

}
