package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * CommonProvinceModel
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
public class CommonProvinceDto extends BaseDTO {

	private static final long serialVersionUID = 1554372824588L;
	
	/**
	 * 名称查询
	 */
	private String c_name;

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	
	
	
}
