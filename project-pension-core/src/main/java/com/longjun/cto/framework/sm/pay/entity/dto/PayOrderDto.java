package com.longjun.cto.framework.sm.pay.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * PayOrderModel
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
public class PayOrderDto extends BaseDTO {

	private static final long serialVersionUID = 1554980628445L;
	
	/**
	 * 商户订单号
	 */
	private String c_mchOrderNo;
	
	/**
	 * 支付订单号
	 */
	private String c_payOrderId;

	public String getC_mchOrderNo() {
		return c_mchOrderNo;
	}

	public void setC_mchOrderNo(String c_mchOrderNo) {
		this.c_mchOrderNo = c_mchOrderNo;
	}

	public String getC_payOrderId() {
		return c_payOrderId;
	}

	public void setC_payOrderId(String c_payOrderId) {
		this.c_payOrderId = c_payOrderId;
	}
	
}
