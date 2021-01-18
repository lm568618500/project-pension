package com.longjun.cto.framework.sm.pay.alipay.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * PayAlipayOrderModel
 * @author yangxuan
 * @date 2019-11-07 05:39:27
 */
public class PayAlipayOrderView extends BaseView {

	private static final long serialVersionUID = 1573119573697L;
	
	
	
	
	
	/**
	 * 
	 */
	private java.lang.Integer isDel;
	
	/**
	 * 1、pc网页支付 2、wap 网页支付 3、app支付 4、
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
	 * 支付异步回调存储
	 */
	private java.lang.String transactionId;
	
	/**
	 * 退款状态 0 未退款 1部分退款 2全部退款
	 */
	private java.lang.Integer refundStatus;
	
	/**
	 * 退款编号
	 */
	private java.lang.String refundNo;
	
	/**
	 * 退款金额
	 */
	private java.math.BigDecimal refundAmount;
	
	




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

	public void setTransactionId(java.lang.String transactionId) {
		this.transactionId = transactionId;
	}

	public java.lang.String getTransactionId() {
		return this.transactionId;
	}

	public void setRefundStatus(java.lang.Integer refundStatus) {
		this.refundStatus = refundStatus;
	}

	public java.lang.Integer getRefundStatus() {
		return this.refundStatus;
	}

	public void setRefundNo(java.lang.String refundNo) {
		this.refundNo = refundNo;
	}

	public java.lang.String getRefundNo() {
		return this.refundNo;
	}

	public void setRefundAmount(java.math.BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public java.math.BigDecimal getRefundAmount() {
		return this.refundAmount;
	}

}
