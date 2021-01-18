package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * CommonCityModel
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
public class CommonCityDto extends BaseDTO {

	private static final long serialVersionUID = 1554372819216L;
	
	/**
	 * 城市名称
	 */
	private String c_name;
	
	/**
	 * 省份名称
	 */
	private String c_provinceName;

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_provinceName() {
		return c_provinceName;
	}

	public void setC_provinceName(String c_provinceName) {
		this.c_provinceName = c_provinceName;
	}
	
	
}
