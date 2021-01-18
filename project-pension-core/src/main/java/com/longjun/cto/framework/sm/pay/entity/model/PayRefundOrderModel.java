package com.longjun.cto.framework.sm.pay.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PayRefundOrderModel
 * 
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
@TableName("t_pay_refund_order")
public class PayRefundOrderModel extends BaseModel<PayRefundOrderModel> {

	private static final long serialVersionUID = 1554980630205L;

	/**
	 * 退款订单号
	 */
	@TableField("refund_order_id")
	private long refundOrderId;

	/**
	 * 支付订单号
	 */
	@TableField("pay_order_id")
	private long payOrderId;

	/**
	 * 商户ID
	 */
	@TableField("mch_id")
	private long mchId;

	/**
	 * 商户退款单号
	 */
	@TableField("mch_refund_no")
	private long mchRefundNo;

	/**
	 * 支付金额,单位分
	 */
	@TableField("pay_amount")
	private long payAmount;

	/**
	 * 退款金额,单位分
	 */
	@TableField("refund_amount")
	private long refundAmount;

	/**
	 * 三位货币代码,人民币:cny
	 */
	@TableField("currency")
	private String currency;

	/**
	 * 退款结果:0-不确认结果,1-等待手动处理,2-确认成功,3-确认失败
	 */
	@TableField("result")
	private int result;

	/**
	 * 客户端IP
	 */
	@TableField("client_ip")
	private String clientIp;

	/**
	 * 设备
	 */
	@TableField("device")
	private String device;

	/**
	 * 备注
	 */
	@TableField("remark_info")
	private String remarkInfo;

	/**
	 * 渠道用户标识,如微信openId,支付宝账号
	 */
	@TableField("channel_user")
	private String channelUser;

	/**
	 * 用户姓名
	 */
	@TableField("user_name")
	private String userName;

	/**
	 * 支付方式ID
	 */
	@TableField("channel_items_id")
	private long channelItemsId;

	/**
	 * 渠道ID
	 */
	@TableField("channel_id")
	private long channelId;

	/**
	 * 渠道错误码
	 */
	@TableField("channel_err_code")
	private String channelErrCode;

	/**
	 * 渠道错误描述
	 */
	@TableField("channel_err_msg")
	private String channelErrMsg;

	/**
	 * 特定渠道发起时额外参数
	 */
	@TableField("extra")
	private String extra;

	/**
	 * 通知地址
	 */
	@TableField("notify_url")
	private String notifyUrl;

	/**
	 * 扩展参数1
	 */
	@TableField("param1")
	private String param1;

	/**
	 * 扩展参数2
	 */
	@TableField("param2")
	private String param2;

	/**
	 * 订单失效时间
	 */
	@TableField("expire_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date expireTime;

	/**
	 * 订单退款成功时间
	 */
	@TableField("refund_succ_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date refundSuccTime;

	/**
	 * 
	 */
	@TableField("buz_notify")
	private String buzNotify;

	/**
	 * 
	 */
	@TableField("buz_resp")
	private String buzResp;

	/**
	 * 
	 */
	@TableField("is_del")
	private int isDel;

	public void setRefundOrderId(long refundOrderId) {
		this.refundOrderId = refundOrderId;
	}

	public long getRefundOrderId() {
		return this.refundOrderId;
	}

	public void setPayOrderId(long payOrderId) {
		this.payOrderId = payOrderId;
	}

	public long getPayOrderId() {
		return this.payOrderId;
	}

	public void setMchId(long mchId) {
		this.mchId = mchId;
	}

	public long getMchId() {
		return this.mchId;
	}

	public void setMchRefundNo(long mchRefundNo) {
		this.mchRefundNo = mchRefundNo;
	}

	public long getMchRefundNo() {
		return this.mchRefundNo;
	}

	public void setPayAmount(long payAmount) {
		this.payAmount = payAmount;
	}

	public long getPayAmount() {
		return this.payAmount;
	}

	public void setRefundAmount(long refundAmount) {
		this.refundAmount = refundAmount;
	}

	public long getRefundAmount() {
		return this.refundAmount;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getResult() {
		return this.result;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getClientIp() {
		return this.clientIp;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDevice() {
		return this.device;
	}

	public void setRemarkInfo(String remarkInfo) {
		this.remarkInfo = remarkInfo;
	}

	public String getRemarkInfo() {
		return this.remarkInfo;
	}

	public void setChannelUser(String channelUser) {
		this.channelUser = channelUser;
	}

	public String getChannelUser() {
		return this.channelUser;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setChannelItemsId(long channelItemsId) {
		this.channelItemsId = channelItemsId;
	}

	public long getChannelItemsId() {
		return this.channelItemsId;
	}

	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public long getChannelId() {
		return this.channelId;
	}

	public void setChannelErrCode(String channelErrCode) {
		this.channelErrCode = channelErrCode;
	}

	public String getChannelErrCode() {
		return this.channelErrCode;
	}

	public void setChannelErrMsg(String channelErrMsg) {
		this.channelErrMsg = channelErrMsg;
	}

	public String getChannelErrMsg() {
		return this.channelErrMsg;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getExtra() {
		return this.extra;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getNotifyUrl() {
		return this.notifyUrl;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam1() {
		return this.param1;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam2() {
		return this.param2;
	}

	public void setExpireTime(java.util.Date expireTime) {
		this.expireTime = expireTime;
	}

	public java.util.Date getExpireTime() {
		return this.expireTime;
	}

	public void setRefundSuccTime(java.util.Date refundSuccTime) {
		this.refundSuccTime = refundSuccTime;
	}

	public java.util.Date getRefundSuccTime() {
		return this.refundSuccTime;
	}

	public void setBuzNotify(String buzNotify) {
		this.buzNotify = buzNotify;
	}

	public String getBuzNotify() {
		return this.buzNotify;
	}

	public void setBuzResp(String buzResp) {
		this.buzResp = buzResp;
	}

	public String getBuzResp() {
		return this.buzResp;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

}
