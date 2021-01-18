package com.longjun.cto.framework.sm.message.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * MessageTempModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public class MessageTempDto extends BaseDTO {

	private static final long serialVersionUID = 1554515962673L;
	
	/**
	 * 模板名称
	 */
	private String c_tempName;


	public String getC_tempName() {
		return c_tempName;
	}


	public void setC_tempName(String c_tempName) {
		this.c_tempName = c_tempName;
	}
	
	
	
}
