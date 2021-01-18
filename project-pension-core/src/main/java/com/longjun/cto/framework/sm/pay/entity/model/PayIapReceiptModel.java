package com.longjun.cto.framework.sm.pay.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PayIapReceiptModel
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
@TableName("t_pay_iap_receipt")
public class PayIapReceiptModel extends BaseModel<PayIapReceiptModel> {

	private static final long serialVersionUID = 1554023839547L;
	
	
	
	
	
	/**
	 * 
	 */
	@TableField("is_del")
	private int isDel;
	
	/**
	 * 支付订单号
	 */
	@TableField("pay_order_id")
	private String payOrderId;
	
	/**
	 * 商户ID
	 */
	@TableField("mch_id")
	private String mchId;
	
	/**
	 * IAP业务号
	 */
	@TableField("transaction_id")
	private String transactionId;
	
	/**
	 * 渠道ID
	 */
	@TableField("receipt_data")
	private String receiptData;
	
	/**
	 * 处理次数
	 */
	@TableField("handle_count")
	private int handleCount;
	
	




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
