package com.longjun.cto.framework.sm.pay.union.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * UnionRefundModel
 * @author yangxuan
 * @date 2019-11-02 10:59:36
 */
public class UnionRefundModifyDto implements Serializable {

	private static final long serialVersionUID = 1572663578606L;
	
	/**
	 * 
	 */
	private java.lang.Long id;
	/**
	 * 
	 */
	private java.lang.Integer status;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 最后修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 删除状态 0正常 -1删除
	 */
	private java.lang.Integer isDel;
	/**
	 * 商户编号
	 */
	private java.lang.String merId;
	/**
	 * 单号 必填
	 */
	private java.lang.String orderNo;
	/**
	 * 使用场景 必填，下单的时候传递什么，查询的时 候也传递什么
	 */
	private java.lang.String qrtype;
	/**
	 * 选填，app 支付，扫码支付，下单的时候 都会返回 queryId，支付通知和支付完成 详情页面都会有查询流水号。与 cleardate ，2 选 1
	 */
	private java.lang.String queryId;
	/**
	 * 清算日期 选填，清算日期 yyyyMMdd，与 queryId， 2 选 1，
传递清算日期需要传递 bank_trace
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date cleardate;
	/**
	 * 银联检索参考号 (查询交易返回 的 seqno，支付通 知返回的 banktrace)传递 cleardate 必须传递 bank_trace，确定 唯一支付记录，进行退款 

	 */
	private java.lang.String bankTrace;
	/**
	 * 退款金额(单位 是元) 
 选填，不填时 refund_amt 就是支付的总 金额，如果涉及分账 refund_amt 金额必 填，并且 refund_amt= platformAmount+ subOrders 里面的子商户金额 totalAmount，请注意单位换算; 如果购物车分账希望一次退全部金额， 此处传递的参数值要等于下单传入的金 额
	 */
	private java.math.BigDecimal refundAmt;
	/**
	 * 退款单号 选填，同一笔交易分多次，比如分账交 易退款时必传，只退一次可以不填; 如果购物车分账希望一次退全部金额， 此参数不传
	 */
	private java.lang.String refundNo;
	/**
	 * 分账退款子商户 信息(单位是分)选填，分账交易退款必传，一次只能传 递一个子商户进行退款,如果只退平台方 的金额，subOrders 里的金额传递 0，如 果子商户和平台方一起退，需要传递平 台方金额 platformAmount 和 subOrders 里的 totalAmount，多个子商户，一次只 能退一个，分多次退款; 如果购物车分账希望一次退全部金额， 此参数不传 


	 */
	private java.lang.String subOrders;
	/**
	 * 平台方退款金额
(单位是分)选填,分账交易必传,如果多次退款，平台 方已经退完，只需要退子商户，此时传 递 0， 

	 */
	private java.lang.Long platformAmount;
	/**
	 * 退款描述 退款通知，会原样返回
	 */
	private java.lang.String refundDesc;
	/**
	 * 签名 必填
	 */
	private java.lang.String mac;
	/**
	 * 接口请求地址
	 */
	private java.lang.String reqUrl;
	/**
	 * 同步接口请求
	 */
	private java.lang.String resp;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getStatus() {
		return this.status;
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
	public void setOrderNo(java.lang.String orderNo) {
		this.orderNo = orderNo;
	}

	public java.lang.String getOrderNo() {
		return this.orderNo;
	}
	public void setQrtype(java.lang.String qrtype) {
		this.qrtype = qrtype;
	}

	public java.lang.String getQrtype() {
		return this.qrtype;
	}
	public void setQueryId(java.lang.String queryId) {
		this.queryId = queryId;
	}

	public java.lang.String getQueryId() {
		return this.queryId;
	}
	public void setCleardate(java.util.Date cleardate) {
		this.cleardate = cleardate;
	}

	public java.util.Date getCleardate() {
		return this.cleardate;
	}
	public void setBankTrace(java.lang.String bankTrace) {
		this.bankTrace = bankTrace;
	}

	public java.lang.String getBankTrace() {
		return this.bankTrace;
	}
	public void setRefundAmt(java.math.BigDecimal refundAmt) {
		this.refundAmt = refundAmt;
	}

	public java.math.BigDecimal getRefundAmt() {
		return this.refundAmt;
	}
	public void setRefundNo(java.lang.String refundNo) {
		this.refundNo = refundNo;
	}

	public java.lang.String getRefundNo() {
		return this.refundNo;
	}
	public void setSubOrders(java.lang.String subOrders) {
		this.subOrders = subOrders;
	}

	public java.lang.String getSubOrders() {
		return this.subOrders;
	}
	public void setPlatformAmount(java.lang.Long platformAmount) {
		this.platformAmount = platformAmount;
	}

	public java.lang.Long getPlatformAmount() {
		return this.platformAmount;
	}
	public void setRefundDesc(java.lang.String refundDesc) {
		this.refundDesc = refundDesc;
	}

	public java.lang.String getRefundDesc() {
		return this.refundDesc;
	}
	public void setMac(java.lang.String mac) {
		this.mac = mac;
	}

	public java.lang.String getMac() {
		return this.mac;
	}
	public void setReqUrl(java.lang.String reqUrl) {
		this.reqUrl = reqUrl;
	}

	public java.lang.String getReqUrl() {
		return this.reqUrl;
	}
	public void setResp(java.lang.String resp) {
		this.resp = resp;
	}

	public java.lang.String getResp() {
		return this.resp;
	}
}
