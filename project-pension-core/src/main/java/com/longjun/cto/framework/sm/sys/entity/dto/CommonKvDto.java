package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * 管理员Dto
 * 
 * @author lp
 * @date 2018-12-20 20:10:49
 */
public class CommonKvDto extends BaseDTO {

	private static final long serialVersionUID = 1545307849401L;
	
	/**
	 * 参数名
	 */
	private String c_k;
	
	/**
	 * 参数值
	 */
	private String c_v;

	public String getC_k() {
		return c_k;
	}

	public void setC_k(String c_k) {
		this.c_k = c_k;
	}

	public String getC_v() {
		return c_v;
	}

	public void setC_v(String c_v) {
		this.c_v = c_v;
	}
	

}
