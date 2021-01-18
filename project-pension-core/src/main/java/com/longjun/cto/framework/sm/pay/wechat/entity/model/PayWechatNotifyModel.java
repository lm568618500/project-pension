package com.longjun.cto.framework.sm.pay.wechat.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PayWechatNotifyModel
 * @author yangxuan
 * @date 2019-11-07 02:51:57
 */
@TableName("t_pay_wechat_notify")
public class PayWechatNotifyModel extends BaseModel<PayWechatNotifyModel> {

	private static final long serialVersionUID = 1573109527012L;
	
	
	
	
	
	/**
	 * 
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;
	
	/**
	 * 公众账号ID
	 */
	@TableField("appid")
	private java.lang.String appid;
	
	/**
	 * 付款银行
	 */
	@TableField("bank_type")
	private java.lang.String bankType;
	
	/**
	 * 现金支付金额
	 */
	@TableField("cash_fee")
	private java.lang.Long cashFee;
	
	/**
	 * 货币种类
	 */
	@TableField("fee_type")
	private java.lang.String feeType;
	
	/**
	 * 是否关注公众账号
	 */
	@TableField("is_subscribe")
	private java.lang.String isSubscribe;
	
	/**
	 * 商户号
	 */
	@TableField("mch_id")
	private java.lang.String mchId;
	
	/**
	 * 随机字符串
	 */
	@TableField("nonce_str")
	private java.lang.String nonceStr;
	
	/**
	 * 用户标识
	 */
	@TableField("openid")
	private java.lang.String openid;
	
	/**
	 * 商户订单号
	 */
	@TableField("out_trade_no")
	private java.lang.String outTradeNo;
	
	/**
	 * 业务结果
	 */
	@TableField("result_code")
	private java.lang.String resultCode;
	
	/**
	 * 返回状态码
	 */
	@TableField("return_code")
	private java.lang.String returnCode;
	
	/**
	 * 
	 */
	@TableField("sign")
	private java.lang.String sign;
	
	/**
	 * 支付完成时间
	 */
	@TableField("time_end")
	private java.lang.String timeEnd;
	
	/**
	 * 订单金额（分）
	 */
	@TableField("total_fee")
	private java.lang.Long totalFee;
	
	/**
	 * 
	 */
	@TableField("trade_type")
	private java.lang.String tradeType;
	
	/**
	 * 
	 */
	@TableField("transaction_id")
	private java.lang.String transactionId;
	
	




	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setAppid(java.lang.String appid) {
		this.appid = appid;
	}

	public java.lang.String getAppid() {
		return this.appid;
	}

	public void setBankType(java.lang.String bankType) {
		this.bankType = bankType;
	}

	public java.lang.String getBankType() {
		return this.bankType;
	}

	public void setCashFee(java.lang.Long cashFee) {
		this.cashFee = cashFee;
	}

	public java.lang.Long getCashFee() {
		return this.cashFee;
	}

	public void setFeeType(java.lang.String feeType) {
		this.feeType = feeType;
	}

	public java.lang.String getFeeType() {
		return this.feeType;
	}

	public void setIsSubscribe(java.lang.String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public java.lang.String getIsSubscribe() {
		return this.isSubscribe;
	}

	public void setMchId(java.lang.String mchId) {
		this.mchId = mchId;
	}

	public java.lang.String getMchId() {
		return this.mchId;
	}

	public void setNonceStr(java.lang.String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public java.lang.String getNonceStr() {
		return this.nonceStr;
	}

	public void setOpenid(java.lang.String openid) {
		this.openid = openid;
	}

	public java.lang.String getOpenid() {
		return this.openid;
	}

	public void setOutTradeNo(java.lang.String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public java.lang.String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setResultCode(java.lang.String resultCode) {
		this.resultCode = resultCode;
	}

	public java.lang.String getResultCode() {
		return this.resultCode;
	}

	public void setReturnCode(java.lang.String returnCode) {
		this.returnCode = returnCode;
	}

	public java.lang.String getReturnCode() {
		return this.returnCode;
	}

	public void setSign(java.lang.String sign) {
		this.sign = sign;
	}

	public java.lang.String getSign() {
		return this.sign;
	}

	public void setTimeEnd(java.lang.String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public java.lang.String getTimeEnd() {
		return this.timeEnd;
	}

	public void setTotalFee(java.lang.Long totalFee) {
		this.totalFee = totalFee;
	}

	public java.lang.Long getTotalFee() {
		return this.totalFee;
	}

	public void setTradeType(java.lang.String tradeType) {
		this.tradeType = tradeType;
	}

	public java.lang.String getTradeType() {
		return this.tradeType;
	}

	public void setTransactionId(java.lang.String transactionId) {
		this.transactionId = transactionId;
	}

	public java.lang.String getTransactionId() {
		return this.transactionId;
	}

}
