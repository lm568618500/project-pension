package com.longjun.cto.framework.sm.pay.entity.view;

import com.baomidou.mybatisplus.annotations.TableField;
import com.eims.cto.framework.module.base.model.BaseView;
import com.longjun.cto.framework.sm.pay.entity.model.PayWxQueryModel;

/**
 * 微信支付-查询View
 * @author yangxuan
 * @date 2019-02-23 09:05:59
 */
public class PayWxQueryView extends BaseView {

	private static final long serialVersionUID = 1550883959563L;

	public PayWxQueryView(PayWxQueryModel model) {
		//this.model = model;
		this.id = model.getId();
		this.time = model.getTime();
		this.lastupdate = model.getLastupdate();
		this.status = model.getStatus();
		this.outTradeNo = model.getOutTradeNo();
		this.transactionId = model.getTransactionId();
		this.returnCode = model.getReturnCode();
		this.resultCode = model.getResultCode();
		this.returnMsg = model.getReturnMsg();
		this.errCode = model.getErrCode();
		this.errCodeDes = model.getErrCodeDes();
		this.appid = model.getAppid();
		this.mchId = model.getMchId();
		this.subAppId = model.getSubAppId();
		this.subMchId = model.getSubMchId();
		this.nonceStr = model.getNonceStr();
		this.sign = model.getSign();
		this.xmlString = model.getXmlString();
		this.promotionDetail = model.getPromotionDetail();
		this.deviceInfo = model.getDeviceInfo();
		this.openid = model.getOpenid();
		this.isSubscribe = model.getIsSubscribe();
		this.tradeType = model.getTradeType();
		this.tradeState = model.getTradeState();
		this.bankType = model.getBankType();
		this.totalFee = model.getTotalFee();
		this.settlementTotalFee = model.getSettlementTotalFee();
		this.feeType = model.getFeeType();
		this.cashFee = model.getCashFee();
		this.cashFeeType = model.getCashFeeType();
		this.couponFee = model.getCouponFee();
		this.couponCount = model.getCouponCount();
		this.coupons = model.getCoupons();
		this.attach = model.getAttach();
		this.timeEnd = model.getTimeEnd();
		this.tradeStateDesc = model.getTradeStateDesc();
	}

	public PayWxQueryView() {
		
	}
	
	//@TableField(exist = false)
	//private PayWxQueryModel model;

	//public PayWxQueryModel getModel() {
	//	return this.model;
	//}

	//public void setModel(PayWxQueryModel model) {
	//	this.model = model;
	//}





	/**
	 * 
	 */
	@TableField("out_trade_no")
	private String outTradeNo;

	/**
	 * 
	 */
	@TableField("transaction_id")
	private String transactionId;

	/**
	 * 
	 */
	@TableField("return_code")
	private String returnCode;

	/**
	 * 
	 */
	@TableField("result_code")
	private String resultCode;

	/**
	 * 
	 */
	@TableField("return_msg")
	private String returnMsg;

	/**
	 * 
	 */
	@TableField("err_code")
	private String errCode;

	/**
	 * 
	 */
	@TableField("err_code_des")
	private String errCodeDes;

	/**
	 * 
	 */
	@TableField("appid")
	private String appid;

	/**
	 * 
	 */
	@TableField("mch_id")
	private String mchId;

	/**
	 * 
	 */
	@TableField("sub_app_id")
	private String subAppId;

	/**
	 * 
	 */
	@TableField("sub_mch_id")
	private String subMchId;

	/**
	 * 
	 */
	@TableField("nonce_str")
	private String nonceStr;

	/**
	 * 
	 */
	@TableField("sign")
	private String sign;

	/**
	 * 
	 */
	@TableField("xml_string")
	private String xmlString;

	/**
	 * 
	 */
	@TableField("promotion_detail")
	private String promotionDetail;

	/**
	 * 
	 */
	@TableField("device_info")
	private String deviceInfo;

	/**
	 * 
	 */
	@TableField("openid")
	private String openid;

	/**
	 * 
	 */
	@TableField("is_subscribe")
	private String isSubscribe;

	/**
	 * 
	 */
	@TableField("trade_type")
	private String tradeType;

	/**
	 * 
	 */
	@TableField("trade_state")
	private String tradeState;

	/**
	 * 
	 */
	@TableField("bank_type")
	private String bankType;

	/**
	 * 
	 */
	@TableField("total_fee")
	private long totalFee;

	/**
	 * 
	 */
	@TableField("settlement_total_fee")
	private long settlementTotalFee;

	/**
	 * 
	 */
	@TableField("fee_type")
	private String feeType;

	/**
	 * 
	 */
	@TableField("cash_fee")
	private long cashFee;

	/**
	 * 
	 */
	@TableField("cash_fee_type")
	private String cashFeeType;

	/**
	 * 
	 */
	@TableField("coupon_fee")
	private long couponFee;

	/**
	 * 
	 */
	@TableField("coupon_count")
	private int couponCount;

	/**
	 * 
	 */
	@TableField("coupons")
	private String coupons;

	/**
	 * 
	 */
	@TableField("attach")
	private String attach;

	/**
	 * 
	 */
	@TableField("time_end")
	private String timeEnd;

	/**
	 * 
	 */
	@TableField("trade_state_desc")
	private String tradeStateDesc;

	




	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnCode() {
		return this.returnCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultCode() {
		return this.resultCode;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getReturnMsg() {
		return this.returnMsg;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCode() {
		return this.errCode;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}

	public String getErrCodeDes() {
		return this.errCodeDes;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppid() {
		return this.appid;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getMchId() {
		return this.mchId;
	}

	public void setSubAppId(String subAppId) {
		this.subAppId = subAppId;
	}

	public String getSubAppId() {
		return this.subAppId;
	}

	public void setSubMchId(String subMchId) {
		this.subMchId = subMchId;
	}

	public String getSubMchId() {
		return this.subMchId;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getNonceStr() {
		return this.nonceStr;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign() {
		return this.sign;
	}

	public void setXmlString(String xmlString) {
		this.xmlString = xmlString;
	}

	public String getXmlString() {
		return this.xmlString;
	}

	public void setPromotionDetail(String promotionDetail) {
		this.promotionDetail = promotionDetail;
	}

	public String getPromotionDetail() {
		return this.promotionDetail;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getDeviceInfo() {
		return this.deviceInfo;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getIsSubscribe() {
		return this.isSubscribe;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getTradeType() {
		return this.tradeType;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	public String getTradeState() {
		return this.tradeState;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getBankType() {
		return this.bankType;
	}

	public void setTotalFee(long totalFee) {
		this.totalFee = totalFee;
	}

	public long getTotalFee() {
		return this.totalFee;
	}

	public void setSettlementTotalFee(long settlementTotalFee) {
		this.settlementTotalFee = settlementTotalFee;
	}

	public long getSettlementTotalFee() {
		return this.settlementTotalFee;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getFeeType() {
		return this.feeType;
	}

	public void setCashFee(long cashFee) {
		this.cashFee = cashFee;
	}

	public long getCashFee() {
		return this.cashFee;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	public String getCashFeeType() {
		return this.cashFeeType;
	}

	public void setCouponFee(long couponFee) {
		this.couponFee = couponFee;
	}

	public long getCouponFee() {
		return this.couponFee;
	}

	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}

	public int getCouponCount() {
		return this.couponCount;
	}

	public void setCoupons(String coupons) {
		this.coupons = coupons;
	}

	public String getCoupons() {
		return this.coupons;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getAttach() {
		return this.attach;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getTimeEnd() {
		return this.timeEnd;
	}

	public void setTradeStateDesc(String tradeStateDesc) {
		this.tradeStateDesc = tradeStateDesc;
	}

	public String getTradeStateDesc() {
		return this.tradeStateDesc;
	}

}
