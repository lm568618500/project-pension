package com.longjun.cto.framework.sm.pay.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * PayIapReceiptModel
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
public class PayIapReceiptView extends BaseView {

	private static final long serialVersionUID = 1554023833963L;
	
	
	
	
	
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
