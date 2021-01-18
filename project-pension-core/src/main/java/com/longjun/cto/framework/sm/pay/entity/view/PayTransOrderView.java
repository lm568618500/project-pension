package com.longjun.cto.framework.sm.pay.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * PayTransOrderModel
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
public class PayTransOrderView extends BaseView {

	private static final long serialVersionUID = 1554980632233L;
	
	
	
	
	
	/**
	 * 
	 */
	private int isDel;
	
	/**
	 * 转账订单号
	 */
	private long transOrderId;
	
	/**
	 * 商户ID
	 */
	private long mchId;
	
	/**
	 * 商户转账单号
	 */
	private long mchTransNo;
	
	/**
	 * 渠道ID
	 */
	private long channelId;
	
	/**
	 * 支付方式
	 */
	private long channelItemsId;
	
	/**
	 * 转账金额,单位分
	 */
	private long amount;
	
	/**
	 * 三位货币代码,人民币:cny
	 */
	private String currency;
	
	/**
	 * 转账结果:0-不确认结果,1-等待手动处理,2-确认成功,3-确认失败
	 */
	private int result;
	
	/**
	 * 客户端IP
	 */
	private String clientIp;
	
	/**
	 * 设备
	 */
	private String device;
	
	/**
	 * 备注
	 */
	private String remarkInfo;
	
	/**
	 * 渠道用户标识,如微信openId,支付宝账号
	 */
	private String channelUser;
	
	/**
	 * 用户姓名
	 */
	private String username;
	
	/**
	 * 渠道错误码
	 */
	private String channelErrCode;
	
	/**
	 * 渠道错误描述
	 */
	private String channelErrMsg;
	
	/**
	 * 特定渠道发起时额外参数
	 */
	private String extra;
	
	/**
	 * 通知地址
	 */
	private String notifyUrl;
	
	/**
	 * 扩展参数1
	 */
	private String param1;
	
	/**
	 * 扩展参数2
	 */
	private String param2;
	
	/**
	 * 订单失效时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date expireTime;
	
	/**
	 * 订单转账成功时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date transSuccTime;
	
	/**
	 * 
	 */
	private String buzNotifyUrl;
	
	/**
	 * 
	 */
	private String buzNotifyResp;
	
	/**
	 * 
	 */
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
