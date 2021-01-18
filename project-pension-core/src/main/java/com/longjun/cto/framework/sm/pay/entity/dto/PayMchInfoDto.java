package com.longjun.cto.framework.sm.pay.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * PayMchInfoModel
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
public class PayMchInfoDto extends BaseDTO {

	private static final long serialVersionUID = 1554023839787L;
	
	/**
	 * 商户ID
	 */
	private String c_mchId;
	
	/**
	 * 商户名称
	 */
	private String c_mchName;

	public String getC_mchId() {
		return c_mchId;
	}

	public void setC_mchId(String c_mchId) {
		this.c_mchId = c_mchId;
	}

	public String getC_mchName() {
		return c_mchName;
	}

	public void setC_mchName(String c_mchName) {
		this.c_mchName = c_mchName;
	}
	
	
	
}
