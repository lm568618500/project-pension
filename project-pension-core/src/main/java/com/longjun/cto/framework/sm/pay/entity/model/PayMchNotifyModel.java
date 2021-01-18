package com.longjun.cto.framework.sm.pay.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PayMchNotifyModel
 * @author yangxuan
 * @date 2019-03-31 05:17:13
 */
@TableName("t_pay_mch_notify")
public class PayMchNotifyModel extends BaseModel<PayMchNotifyModel> {

	private static final long serialVersionUID = 1554023839171L;
	
	
	
	/**
	 * 订单ID
	 */
	@TableField("order_id")
	private long orderId;
	
	/**
	 * 商户ID
	 */
	@TableField("mch_id")
	private String mchId;
	
	/**
	 * 商户订单号
	 */
	@TableField("mch_order_no")
	private String mchOrderNo;
	
	/**
	 * 订单类型:1-支付,2-转账,3-退款
	 */
	@TableField("order_type")
	private String orderType;
	
	/**
	 * 通知地址
	 */
	@TableField("notify_url")
	private String notifyUrl;
	
	/**
	 * 通知次数
	 */
	@TableField("notify_count")
	private int notifyCount;
	
	/**
	 * 通知响应结果
	 */
	@TableField("result")
	private String result;
	
	
	
	


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



}
