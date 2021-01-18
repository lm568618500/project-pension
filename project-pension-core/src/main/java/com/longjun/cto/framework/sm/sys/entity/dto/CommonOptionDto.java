package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * 系统配置Dto
 * 
 * @author yangxuan
 * @date Jun 6, 2019 - 2:21:21 PM
 */
public class CommonOptionDto extends BaseDTO {

	private static final long serialVersionUID = -1683385468423954093L;
	/**
	 * 键
	 */
	private String c_key;

	public String getC_key() {
		return c_key;
	}

	public void setC_key(String c_key) {
		this.c_key = c_key;
	}

}
