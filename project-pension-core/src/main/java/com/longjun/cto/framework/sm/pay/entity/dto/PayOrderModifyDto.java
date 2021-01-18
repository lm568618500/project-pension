package com.longjun.cto.framework.sm.pay.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * PayOrderModel
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
public class PayOrderModifyDto implements Serializable {

	private static final long serialVersionUID = 1554980628945L;
	
	/**
	 * 
	 */
	private long id;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 去支付时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date goPayTime;
	/**
	 * 支付订单号
	 */
	private long payOrderId;
	/**
	 * 商户ID
	 */
	private long mchId;
	/**
	 * 商户订单号
	 */
	private long mchOrderNo;
	/**
	 * 渠道ID冗余
	 */
	private long channelId;
	/**
	 * 支付方式ID
	 */
	private long channelItemsId;
	/**
	 * 支付金额,单位分
	 */
	private long amount;
	/**
	 * 三位货币代码,人民币:cny
	 */
	private String currency;
	/**
	 * 支付状态,0-订单生成,1-支付中(目前未使用),2-支付成功,3-业务处理完成
	 */
	private int status;
	/**
	 * 客户端IP
	 */
	private String clientIp;
	/**
	 * 设备
	 */
	private String device;
	/**
	 * 商品标题
	 */
	private String subject;
	/**
	 * 商品描述信息
	 */
	private String body;
	/**
	 * 特定渠道发起时额外参数
	 */
	private String extra;
	/**
	 * 渠道商户ID
	 */
	private String channelMchId;
	/**
	 * 渠道订单号
	 */
	private String channelOrderNo;
	/**
	 * Api返回结果
	 */
	private String apiResp;
	/**
	 * 渠道支付错误码
	 */
	private String errCode;
	/**
	 * 渠道支付错误描述
	 */
	private String errMsg;
	/**
	 * 扩展参数1
	 */
	private String param1;
	/**
	 * 扩展参数2
	 */
	private String param2;
	/**
	 * 通知地址
	 */
	private String notifyUrl;
	/**
	 * 通知次数
	 */
	private int notifyCount;
	/**
	 * 最后一次通知时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastNotifyTime;
	/**
	 * 订单失效时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date expireTime;
	/**
	 * 订单支付成功时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date paySuccTime;
	/**
	 * 业务通知地址
	 */
	private String buzNotifyUrl;
	/**
	 * 业务接口响应
	 */
	private String buzNotifyResp;
	/**
	 * 
	 */
	private int isDel;
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
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
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
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
	public void setChannelMchId(String channelMchId) {
		this.channelMchId = channelMchId;
	}

	public String getChannelMchId() {
		return this.channelMchId;
	}
	public void setChannelOrderNo(String channelOrderNo) {
		this.channelOrderNo = channelOrderNo;
	}

	public String getChannelOrderNo() {
		return this.channelOrderNo;
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
