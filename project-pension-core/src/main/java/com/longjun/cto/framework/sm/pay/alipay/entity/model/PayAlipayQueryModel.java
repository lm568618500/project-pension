package com.longjun.cto.framework.sm.pay.alipay.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PayAlipayQueryModel
 * @author yangxuan
 * @date 2019-11-07 06:58:14
 */
@TableName("t_pay_alipay_query")
public class PayAlipayQueryModel extends BaseModel<PayAlipayQueryModel> {

	private static final long serialVersionUID = 1573124297604L;
	
	
	
	
	
	/**
	 * 
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;
	
	/**
	 * 
	 */
	@TableField("msg")
	private java.lang.String msg;
	
	/**
	 * 开发者的app_id
	 */
	@TableField("code")
	private java.lang.String code;
	
	/**
	 * 买家在支付宝的用户id 
	 */
	@TableField("buyer_user_id")
	private java.lang.String buyerUserId;
	
	/**
	 * 本次交易打款给卖家的时间 
	 */
	@TableField("send_pay_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date sendPayDate;
	
	/**
	 * 交易中用户支付的可开具发票的金额，单位为元，两位小数。该金额代表该笔交易中可以给用户开具发票的金额 
	 */
	@TableField("invoice_amount")
	private java.math.BigDecimal invoiceAmount;
	
	/**
	 *  商家订单号 
	 */
	@TableField("out_trade_no")
	private java.lang.String outTradeNo;
	
	/**
	 * 交易的订单金额，单位为元，两位小数。该参数的值为支付时传入的total_amount
	 */
	@TableField("total_amount")
	private java.math.BigDecimal totalAmount;
	
	/**
	 * 交易状态：WAIT_BUYER_PAY（交易创建，等待买家付款）、TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）、TRADE_SUCCESS（交易支付成功）、TRADE_FINISHED（交易结束，不可退款） 
	 */
	@TableField("trade_status")
	private java.lang.String tradeStatus;
	
	/**
	 * 支付宝交易号，和商户订单号不能同时为空 
	 */
	@TableField("trade_no")
	private java.lang.String tradeNo;
	
	/**
	 * 买家支付宝账号 
	 */
	@TableField("buyer_logon_id")
	private java.lang.String buyerLogonId;
	
	/**
	 * 实收金额，单位为元，两位小数。该金额为本笔交易，商户账户能够实际收到的金额 
	 */
	@TableField("receipt_amount")
	private java.math.BigDecimal receiptAmount;
	
	/**
	 * 积分支付的金额，单位为元，两位小数。该金额代表该笔交易中用户使用积分支付的金额，比如集分宝或者支付宝实时优惠等 
	 */
	@TableField("point_amount")
	private java.math.BigDecimal pointAmount;
	
	/**
	 * 买家实付金额，单位为元，两位小数。该金额代表该笔交易买家实际支付的金额，不包含商户折扣等金额 
	 */
	@TableField("buyer_pay_amount")
	private java.math.BigDecimal buyerPayAmount;
	
	




	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setMsg(java.lang.String msg) {
		this.msg = msg;
	}

	public java.lang.String getMsg() {
		return this.msg;
	}

	public void setCode(java.lang.String code) {
		this.code = code;
	}

	public java.lang.String getCode() {
		return this.code;
	}

	public void setBuyerUserId(java.lang.String buyerUserId) {
		this.buyerUserId = buyerUserId;
	}

	public java.lang.String getBuyerUserId() {
		return this.buyerUserId;
	}

	public void setSendPayDate(java.util.Date sendPayDate) {
		this.sendPayDate = sendPayDate;
	}

	public java.util.Date getSendPayDate() {
		return this.sendPayDate;
	}

	public void setInvoiceAmount(java.math.BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return this.invoiceAmount;
	}

	public void setOutTradeNo(java.lang.String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public java.lang.String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setTotalAmount(java.math.BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.totalAmount;
	}

	public void setTradeStatus(java.lang.String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public java.lang.String getTradeStatus() {
		return this.tradeStatus;
	}

	public void setTradeNo(java.lang.String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public java.lang.String getTradeNo() {
		return this.tradeNo;
	}

	public void setBuyerLogonId(java.lang.String buyerLogonId) {
		this.buyerLogonId = buyerLogonId;
	}

	public java.lang.String getBuyerLogonId() {
		return this.buyerLogonId;
	}

	public void setReceiptAmount(java.math.BigDecimal receiptAmount) {
		this.receiptAmount = receiptAmount;
	}

	public java.math.BigDecimal getReceiptAmount() {
		return this.receiptAmount;
	}

	public void setPointAmount(java.math.BigDecimal pointAmount) {
		this.pointAmount = pointAmount;
	}

	public java.math.BigDecimal getPointAmount() {
		return this.pointAmount;
	}

	public void setBuyerPayAmount(java.math.BigDecimal buyerPayAmount) {
		this.buyerPayAmount = buyerPayAmount;
	}

	public java.math.BigDecimal getBuyerPayAmount() {
		return this.buyerPayAmount;
	}

}
