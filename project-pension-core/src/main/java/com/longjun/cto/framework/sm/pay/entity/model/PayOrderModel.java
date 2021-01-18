package com.longjun.cto.framework.sm.pay.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 支付订单实体
 * 
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
@TableName("t_pay_order")
public class PayOrderModel extends BaseModel<PayOrderModel> {

	private static final long serialVersionUID = 1554980628572L;

	/**
	 * 去支付时间
	 */
	@TableField("go_pay_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date goPayTime;

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
	 * 商户订单号
	 */
	@TableField("mch_order_no")
	private long mchOrderNo;

	/**
	 * 渠道ID冗余
	 */
	@TableField("channel_id")
	private long channelId;

	/**
	 * 支付方式ID
	 */
	@TableField("channel_items_id")
	private long channelItemsId;

	/**
	 * 支付金额,单位分
	 */
	@TableField("amount")
	private long amount;

	/**
	 * 三位货币代码,人民币:cny
	 */
	@TableField("currency")
	private String currency;

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
	 * 商品标题
	 */
	@TableField("subject")
	private String subject;

	/**
	 * 商品描述信息
	 */
	@TableField("body")
	private String body;

	/**
	 * 特定渠道发起时额外参数
	 */
	@TableField("extra")
	private String extra;

	/**
	 * Api返回结果
	 */
	@TableField("api_resp")
	private String apiResp;

	/**
	 * 渠道支付错误码
	 */
	@TableField("err_code")
	private String errCode;

	/**
	 * 渠道支付错误描述
	 */
	@TableField("err_msg")
	private String errMsg;

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
	 * 通知地址
	 */
	@TableField("notify_url")
	private String notifyUrl;

	/**
	 * 异步通知xml
	 */
	@TableField("notify_xml")
	private String notifyXml;

	/**
	 * 通知次数
	 */
	@TableField("notify_count")
	private int notifyCount;

	/**
	 * 最后一次通知时间
	 */
	@TableField("last_notify_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastNotifyTime;

	/**
	 * 订单失效时间
	 */
	@TableField("expire_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date expireTime;

	/**
	 * 订单支付成功时间
	 */
	@TableField("pay_succ_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date paySuccTime;

	/**
	 * 通知次数
	 */
	@TableField("buz_notify_count")
	private int buzNotifyCount;

	/**
	 * 业务通知地址
	 */
	@TableField("buz_notify_url")
	private String buzNotifyUrl;

	/**
	 * 业务通知地址-同步地址
	 */
	@TableField("buz_callback_url")
	private String buzCallbackUrl;

	/**
	 * 业务接口响应
	 */
	@TableField("buz_notify_resp")
	private String buzNotifyResp;

	/**
	 * 
	 */
	@TableField("is_del")
	private int isDel;

	public String getBuzCallbackUrl() {
		return buzCallbackUrl;
	}

	public void setBuzCallbackUrl(String buzCallbackUrl) {
		this.buzCallbackUrl = buzCallbackUrl;
	}

	public String getNotifyXml() {
		return notifyXml;
	}

	public void setNotifyXml(String notifyXml) {
		this.notifyXml = notifyXml;
	}

	public int getBuzNotifyCount() {
		return buzNotifyCount;
	}

	public void setBuzNotifyCount(int buzNotifyCount) {
		this.buzNotifyCount = buzNotifyCount;
	}

	public void setGoPayTime(java.util.Date goPayTime) {
		this.goPayTime = goPayTime;
	}

	public java.util.Date getGoPayTime() {
		return this.goPayTime;
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

	public void setMchOrderNo(long mchOrderNo) {
		this.mchOrderNo = mchOrderNo;
	}

	public long getMchOrderNo() {
		return this.mchOrderNo;
	}

	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public long getChannelId() {
		return this.channelId;
	}

	public void setChannelItemsId(long channelItemsId) {
		this.channelItemsId = channelItemsId;
	}

	public long getChannelItemsId() {
		return this.channelItemsId;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getAmount() {
		return this.amount;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return this.currency;
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

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return this.body;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getExtra() {
		return this.extra;
	}

	public void setApiResp(String apiResp) {
		this.apiResp = apiResp;
	}

	public String getApiResp() {
		return this.apiResp;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCode() {
		return this.errCode;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrMsg() {
		return this.errMsg;
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

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getNotifyUrl() {
		return this.notifyUrl;
	}

	public void setNotifyCount(int notifyCount) {
		this.notifyCount = notifyCount;
	}

	public int getNotifyCount() {
		return this.notifyCount;
	}

	public void setLastNotifyTime(java.util.Date lastNotifyTime) {
		this.lastNotifyTime = lastNotifyTime;
	}

	public java.util.Date getLastNotifyTime() {
		return this.lastNotifyTime;
	}

	public void setExpireTime(java.util.Date expireTime) {
		this.expireTime = expireTime;
	}

	public java.util.Date getExpireTime() {
		return this.expireTime;
	}

	public void setPaySuccTime(java.util.Date paySuccTime) {
		this.paySuccTime = paySuccTime;
	}

	public java.util.Date getPaySuccTime() {
		return this.paySuccTime;
	}

	public void setBuzNotifyUrl(String buzNotifyUrl) {
		this.buzNotifyUrl = buzNotifyUrl;
	}

	public String getBuzNotifyUrl() {
		return this.buzNotifyUrl;
	}

	public void setBuzNotifyResp(String buzNotifyResp) {
		this.buzNotifyResp = buzNotifyResp;
	}

	public String getBuzNotifyResp() {
		return this.buzNotifyResp;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

}
