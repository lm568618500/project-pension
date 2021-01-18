package com.longjun.cto.framework.sm.pay.wechat.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PayWechatQueryModel
 * @author yangxuan
 * @date 2019-11-07 04:30:51
 */
@TableName("t_pay_wechat_query")
public class PayWechatQueryModel extends BaseModel<PayWechatQueryModel> {

	private static final long serialVersionUID = 1573115460700L;
	
	
	
	
	
	/**
	 * 
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;
	
	/**
	 * 微信订单号
	 */
	@TableField("transaction_id")
	private java.lang.String transactionId;
	
	/**
	 * 随机字符串
	 */
	@TableField("nonce_str")
	private java.lang.String nonceStr;
	
	/**
	 * 交易状态
	 */
	@TableField("trade_state")
	private java.lang.String tradeState;
	
	/**
	 * 付款银行
	 */
	@TableField("bank_type")
	private java.lang.String bankType;
	
	/**
	 * 用户标识
	 */
	@TableField("openid")
	private java.lang.String openid;
	
	/**
	 * 签名
	 */
	@TableField("sign")
	private java.lang.String sign;
	
	/**
	 * 返回信息
	 */
	@TableField("return_msg")
	private java.lang.String returnMsg;
	
	/**
	 * 标价币种
	 */
	@TableField("fee_type")
	private java.lang.String feeType;
	
	/**
	 * 商户号
	 */
	@TableField("mch_id")
	private java.lang.String mchId;
	
	/**
	 * 现金支付金额
	 */
	@TableField("cash_fee")
	private java.math.BigDecimal cashFee;
	
	/**
	 * 商户订单号
	 */
	@TableField("out_trade_no")
	private java.lang.String outTradeNo;
	
	/**
	 * 现金支付币种
	 */
	@TableField("cash_fee_type")
	private java.lang.String cashFeeType;
	
	/**
	 * 公众账号ID
	 */
	@TableField("appid")
	private java.lang.String appid;
	
	/**
	 * 标价金额
	 */
	@TableField("total_fee")
	private java.lang.Long totalFee;
	
	/**
	 * 交易状态描述
	 */
	@TableField("trade_state_desc")
	private java.lang.String tradeStateDesc;
	
	/**
	 * 交易类型
	 */
	@TableField("trade_type")
	private java.lang.String tradeType;
	
	/**
	 * 业务结果
	 */
	@TableField("result_code")
	private java.lang.String resultCode;
	
	/**
	 * 附加数据
	 */
	@TableField("attach")
	private java.lang.String attach;
	
	/**
	 * 支付完成时间
	 */
	@TableField("time_end")
	private java.lang.String timeEnd;
	
	/**
	 * 是否关注公众账号 
	 */
	@TableField("is_subscribe")
	private java.lang.String isSubscribe;
	
	/**
	 * 返回状态码
	 */
	@TableField("return_code")
	private java.lang.String returnCode;
	
	




	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setTransactionId(java.lang.String transactionId) {
		this.transactionId = transactionId;
	}

	public java.lang.String getTransactionId() {
		return this.transactionId;
	}

	public void setNonceStr(java.lang.String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public java.lang.String getNonceStr() {
		return this.nonceStr;
	}

	public void setTradeState(java.lang.String tradeState) {
		this.tradeState = tradeState;
	}

	public java.lang.String getTradeState() {
		return this.tradeState;
	}

	public void setBankType(java.lang.String bankType) {
		this.bankType = bankType;
	}

	public java.lang.String getBankType() {
		return this.bankType;
	}

	public void setOpenid(java.lang.String openid) {
		this.openid = openid;
	}

	public java.lang.String getOpenid() {
		return this.openid;
	}

	public void setSign(java.lang.String sign) {
		this.sign = sign;
	}

	public java.lang.String getSign() {
		return this.sign;
	}

	public void setReturnMsg(java.lang.String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public java.lang.String getReturnMsg() {
		return this.returnMsg;
	}

	public void setFeeType(java.lang.String feeType) {
		this.feeType = feeType;
	}

	public java.lang.String getFeeType() {
		return this.feeType;
	}

	public void setMchId(java.lang.String mchId) {
		this.mchId = mchId;
	}

	public java.lang.String getMchId() {
		return this.mchId;
	}

	public void setCashFee(java.math.BigDecimal cashFee) {
		this.cashFee = cashFee;
	}

	public java.math.BigDecimal getCashFee() {
		return this.cashFee;
	}

	public void setOutTradeNo(java.lang.String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public java.lang.String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setCashFeeType(java.lang.String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	public java.lang.String getCashFeeType() {
		return this.cashFeeType;
	}

	public void setAppid(java.lang.String appid) {
		this.appid = appid;
	}

	public java.lang.String getAppid() {
		return this.appid;
	}

	public void setTotalFee(java.lang.Long totalFee) {
		this.totalFee = totalFee;
	}

	public java.lang.Long getTotalFee() {
		return this.totalFee;
	}

	public void setTradeStateDesc(java.lang.String tradeStateDesc) {
		this.tradeStateDesc = tradeStateDesc;
	}

	public java.lang.String getTradeStateDesc() {
		return this.tradeStateDesc;
	}

	public void setTradeType(java.lang.String tradeType) {
		this.tradeType = tradeType;
	}

	public java.lang.String getTradeType() {
		return this.tradeType;
	}

	public void setResultCode(java.lang.String resultCode) {
		this.resultCode = resultCode;
	}

	public java.lang.String getResultCode() {
		return this.resultCode;
	}

	public void setAttach(java.lang.String attach) {
		this.attach = attach;
	}

	public java.lang.String getAttach() {
		return this.attach;
	}

	public void setTimeEnd(java.lang.String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public java.lang.String getTimeEnd() {
		return this.timeEnd;
	}

	public void setIsSubscribe(java.lang.String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public java.lang.String getIsSubscribe() {
		return this.isSubscribe;
	}

	public void setReturnCode(java.lang.String returnCode) {
		this.returnCode = returnCode;
	}

	public java.lang.String getReturnCode() {
		return this.returnCode;
	}

}
