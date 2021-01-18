package com.longjun.cto.framework.sm.pay.union.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UnionQueryModel
 * 
 * @author yangxuan
 * @date 2019-11-02 02:52:27
 */
@TableName("t_union_query")
public class UnionQueryModel extends BaseModel<UnionQueryModel> {

	private static final long serialVersionUID = 1572677550711L;

	/**
	 * 删除状态 0正常 -1删除
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;

	/**
	 * 商户编号
	 */
	@TableField("mer_id")
	private java.lang.String merId;

	/**
	 * 1、交易查询 2、退款查询
	 */
	@TableField("query_type")
	private java.lang.Integer queryType;

	/**
	 * 单号 必填,下单时传递的 order_no
	 */
	@TableField("pay_waybillno")
	private java.lang.String payWaybillno;

	/**
	 * 使用场景
	 */
	@TableField("qrtype")
	private java.lang.String qrtype;

	/**
	 * 选填，app 支付，扫码支付，下单的时候 都会返回 queryId，支付通知和支付完成 详情页面都会有查询流水号。与 transDate 和 date，3
	 * 选 1
	 */
	@TableField("pay_trans_date")
	private java.lang.String payTransDate;

	/**
	 * 查询流水号
	 */
	@TableField("pay_query_id")
	private java.lang.String payQueryId;

	/**
	 * 订单金额
	 */
	@TableField("pay_resp_amount")
	private java.lang.String payRespAmount;

	/**
	 * 应答码
	 */
	@TableField("pay_resp_code")
	private java.lang.String payRespCode;

	/**
	 * 流水号
	 */
	@TableField("pay_resp_seqno")
	private java.lang.String payRespSeqno;

	/**
	 * 银行交易时间
	 */
	@TableField("pay_resp_pay_time")
	private java.lang.String payRespPayTime;

	/**
	 * 备注信息
	 */
	@TableField("pay_resp_memo")
	private java.lang.String payRespMemo;

	/**
	 * 支付方式
	 */
	@TableField("pay_resp_payway")
	private java.lang.String payRespPayway;

	/**
	 * 签名
	 */
	@TableField("pay_resp_mac")
	private java.lang.String payRespMac;

	/**
	 * 终端号
	 */
	@TableField("pay_resp_termid")
	private java.lang.String payRespTermid;

	/**
	 * 商户号
	 */
	@TableField("pay_resp_shopid")
	private java.lang.String payRespShopid;

	/**
	 * 清算日期
	 */
	@TableField("pay_resp_cleardate")
	private java.lang.String payRespCleardate;

	/**
	 * 订单状态
	 */
	@TableField("pay_resp_status")
	private java.lang.String payRespStatus;

	/**
	 * 退款单号
	 */
	@TableField("refund_no")
	private java.lang.String refundNo;

	/**
	 * 退款时间
	 */
	@TableField("refund_resp_refundtime")
	private java.lang.String refundRespRefundtime;

	/**
	 * 
	 */
	@TableField("refund_resp_refundstatus")
	private java.lang.String refundRespRefundstatus;

	/**
	 * 
	 */
	@TableField("refund_resp_refundamount")
	private java.lang.String refundRespRefundamount;

	/**
	 * 
	 */
	@TableField("refund_resp_mac")
	private java.lang.String refundRespMac;

	/**
	 * 
	 */
	@TableField("refund_resp_msg")
	private java.lang.String refundRespMsg;

	/**
	 * 
	 */
	@TableField("refund_resp_code")
	private java.lang.String refundRespCode;

	/**
	 * 
	 */
	@TableField("refund_query_id")
	private java.lang.String refundQueryId;

	public java.lang.String getRefundQueryId() {
		return refundQueryId;
	}

	public void setRefundQueryId(java.lang.String refundQueryId) {
		this.refundQueryId = refundQueryId;
	}

	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setMerId(java.lang.String merId) {
		this.merId = merId;
	}

	public java.lang.String getMerId() {
		return this.merId;
	}

	public void setQueryType(java.lang.Integer queryType) {
		this.queryType = queryType;
	}

	public java.lang.Integer getQueryType() {
		return this.queryType;
	}

	public void setPayWaybillno(java.lang.String payWaybillno) {
		this.payWaybillno = payWaybillno;
	}

	public java.lang.String getPayWaybillno() {
		return this.payWaybillno;
	}

	public void setQrtype(java.lang.String qrtype) {
		this.qrtype = qrtype;
	}

	public java.lang.String getQrtype() {
		return this.qrtype;
	}

	public void setPayTransDate(java.lang.String payTransDate) {
		this.payTransDate = payTransDate;
	}

	public java.lang.String getPayTransDate() {
		return this.payTransDate;
	}

	public void setPayQueryId(java.lang.String payQueryId) {
		this.payQueryId = payQueryId;
	}

	public java.lang.String getPayQueryId() {
		return this.payQueryId;
	}

	public void setPayRespAmount(java.lang.String payRespAmount) {
		this.payRespAmount = payRespAmount;
	}

	public java.lang.String getPayRespAmount() {
		return this.payRespAmount;
	}

	public void setPayRespCode(java.lang.String payRespCode) {
		this.payRespCode = payRespCode;
	}

	public java.lang.String getPayRespCode() {
		return this.payRespCode;
	}

	public void setPayRespSeqno(java.lang.String payRespSeqno) {
		this.payRespSeqno = payRespSeqno;
	}

	public java.lang.String getPayRespSeqno() {
		return this.payRespSeqno;
	}

	public void setPayRespPayTime(java.lang.String payRespPayTime) {
		this.payRespPayTime = payRespPayTime;
	}

	public java.lang.String getPayRespPayTime() {
		return this.payRespPayTime;
	}

	public void setPayRespMemo(java.lang.String payRespMemo) {
		this.payRespMemo = payRespMemo;
	}

	public java.lang.String getPayRespMemo() {
		return this.payRespMemo;
	}

	public void setPayRespPayway(java.lang.String payRespPayway) {
		this.payRespPayway = payRespPayway;
	}

	public java.lang.String getPayRespPayway() {
		return this.payRespPayway;
	}

	public void setPayRespMac(java.lang.String payRespMac) {
		this.payRespMac = payRespMac;
	}

	public java.lang.String getPayRespMac() {
		return this.payRespMac;
	}

	public void setPayRespTermid(java.lang.String payRespTermid) {
		this.payRespTermid = payRespTermid;
	}

	public java.lang.String getPayRespTermid() {
		return this.payRespTermid;
	}

	public void setPayRespShopid(java.lang.String payRespShopid) {
		this.payRespShopid = payRespShopid;
	}

	public java.lang.String getPayRespShopid() {
		return this.payRespShopid;
	}

	public void setPayRespCleardate(java.lang.String payRespCleardate) {
		this.payRespCleardate = payRespCleardate;
	}

	public java.lang.String getPayRespCleardate() {
		return this.payRespCleardate;
	}

	public void setPayRespStatus(java.lang.String payRespStatus) {
		this.payRespStatus = payRespStatus;
	}

	public java.lang.String getPayRespStatus() {
		return this.payRespStatus;
	}

	public void setRefundNo(java.lang.String refundNo) {
		this.refundNo = refundNo;
	}

	public java.lang.String getRefundNo() {
		return this.refundNo;
	}

	public void setRefundRespRefundtime(java.lang.String refundRespRefundtime) {
		this.refundRespRefundtime = refundRespRefundtime;
	}

	public java.lang.String getRefundRespRefundtime() {
		return this.refundRespRefundtime;
	}

	public void setRefundRespRefundstatus(java.lang.String refundRespRefundstatus) {
		this.refundRespRefundstatus = refundRespRefundstatus;
	}

	public java.lang.String getRefundRespRefundstatus() {
		return this.refundRespRefundstatus;
	}

	public void setRefundRespRefundamount(java.lang.String refundRespRefundamount) {
		this.refundRespRefundamount = refundRespRefundamount;
	}

	public java.lang.String getRefundRespRefundamount() {
		return this.refundRespRefundamount;
	}

	public void setRefundRespMac(java.lang.String refundRespMac) {
		this.refundRespMac = refundRespMac;
	}

	public java.lang.String getRefundRespMac() {
		return this.refundRespMac;
	}

	public void setRefundRespMsg(java.lang.String refundRespMsg) {
		this.refundRespMsg = refundRespMsg;
	}

	public java.lang.String getRefundRespMsg() {
		return this.refundRespMsg;
	}

	public void setRefundRespCode(java.lang.String refundRespCode) {
		this.refundRespCode = refundRespCode;
	}

	public java.lang.String getRefundRespCode() {
		return this.refundRespCode;
	}

}
