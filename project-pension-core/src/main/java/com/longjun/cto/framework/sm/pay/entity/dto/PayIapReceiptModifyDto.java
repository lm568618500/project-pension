package com.longjun.cto.framework.sm.pay.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * PayIapReceiptModel
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
public class PayIapReceiptModifyDto implements Serializable {

	private static final long serialVersionUID = 1554023834914L;
	
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
	 * 处理状态:0-未处理,1-处理成功,-1-处理失败
	 */
	private int status;
	/**
	 * 
	 */
	private int isDel;
	/**
	 * 支付订单号
	 */
	private String payOrderId;
	/**
	 * 商户ID
	 */
	private String mchId;
	/**
	 * IAP业务号
	 */
	private String transactionId;
	/**
	 * 渠道ID
	 */
	private String receiptData;
	/**
	 * 处理次数
	 */
	private int handleCount;
	
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
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}
	public void setPayOrderId(String payOrderId) {
		this.payOrderId = payOrderId;
	}

	public String getPayOrderId() {
		return this.payOrderId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getMchId() {
		return this.mchId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionId() {
		return this.transactionId;
	}
	public void setReceiptData(String receiptData) {
		this.receiptData = receiptData;
	}

	public String getReceiptData() {
		return this.receiptData;
	}
	public void setHandleCount(int handleCount) {
		this.handleCount = handleCount;
	}

	public int getHandleCount() {
		return this.handleCount;
	}
}
