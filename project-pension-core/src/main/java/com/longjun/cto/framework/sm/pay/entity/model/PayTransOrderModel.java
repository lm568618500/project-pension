package com.longjun.cto.framework.sm.pay.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PayTransOrderModel
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
@TableName("t_pay_trans_order")
public class PayTransOrderModel extends BaseModel<PayTransOrderModel> {

	private static final long serialVersionUID = 1554980630605L;
	
	
	
	
	
	/**
	 * 
	 */
	@TableField("is_del")
	private int isDel;
	
	/**
	 * 转账订单号
	 */
	@TableField("trans_order_id")
	private long transOrderId;
	
	/**
	 * 商户ID
	 */
	@TableField("mch_id")
	private long mchId;
	
	/**
	 * 商户转账单号
	 */
	@TableField("mch_trans_no")
	private long mchTransNo;
	
	/**
	 * 渠道ID
	 */
	@TableField("channel_id")
	private long channelId;
	
	/**
	 * 支付方式
	 */
	@TableField("channel_items_id")
	private long channelItemsId;
	
	/**
	 * 转账金额,单位分
	 */
	@TableField("amount")
	private long amount;
	
	/**
	 * 三位货币代码,人民币:cny
	 */
	@TableField("currency")
	private String currency;
	
	/**
	 * 转账结果:0-不确认结果,1-等待手动处理,2-确认成功,3-确认失败
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
	@TableField("userName")
	private String username;
	
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
	 * 订单转账成功时间
	 */
	@TableField("trans_succ_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date transSuccTime;
	
	/**
	 * 
	 */
	@TableField("buz_notify_url")
	private String buzNotifyUrl;
	
	/**
	 * 
	 */
	@TableField("buz_notify_resp")
	private String buzNotifyResp;
	
	/**
	 * 
	 */
	@TableField("buz_status")
	private int buzStatus;
	
	




	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

	public void setTransOrderId(long transOrderId) {
		this.transOrderId = transOrderId;
	}

	public long getTransOrderId() {
		return this.transOrderId;
	}

	public void setMchId(long mchId) {
		this.mchId = mchId;
	}

	public long getMchId() {
		return this.mchId;
	}

	public void setMchTransNo(long mchTransNo) {
		this.mchTransNo = mchTransNo;
	}

	public long getMchTransNo() {
		return this.mchTransNo;
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

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
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

	public void setTransSuccTime(java.util.Date transSuccTime) {
		this.transSuccTime = transSuccTime;
	}

	public java.util.Date getTransSuccTime() {
		return this.transSuccTime;
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

	public void setBuzStatus(int buzStatus) {
		this.buzStatus = buzStatus;
	}

	public int getBuzStatus() {
		return this.buzStatus;
	}

}
