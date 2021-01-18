package com.longjun.cto.framework.sm.pay.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * PayMchNotifyModel
 * @author yangxuan
 * @date 2019-03-31 05:17:13
 */
public class PayMchNotifyModifyDto implements Serializable {

	private static final long serialVersionUID = 1554023839744L;
	
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
	 * 订单ID
	 */
	private long orderId;
	/**
	 * 商户ID
	 */
	private String mchId;
	/**
	 * 商户订单号
	 */
	private String mchOrderNo;
	/**
	 * 订单类型:1-支付,2-转账,3-退款
	 */
	private String orderType;
	/**
	 * 通知地址
	 */
	private String notifyUrl;
	/**
	 * 通知次数
	 */
	private int notifyCount;
	/**
	 * 通知响应结果
	 */
	private String result;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 通知状态,1-通知中,2-通知成功,3-通知失败
	 */
	private int status;
	
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
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getOrderId() {
		return this.orderId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getMchId() {
		return this.mchId;
	}
	public void setMchOrderNo(String mchOrderNo) {
		this.mchOrderNo = mchOrderNo;
	}

	public String getMchOrderNo() {
		return this.mchOrderNo;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderType() {
		return this.orderType;
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
	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return this.result;
	}
	public void setLastupdate(java.util.Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public java.util.Date getLastupdate() {
		return this.lastupdate;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}
}
