package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * CommonAreaModel
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
public class CommonAreaDto extends BaseDTO {

	private static final long serialVersionUID = 1554372824597L;
	
	/**
	 * 区域名称
	 */
	private String c_name;
	
	/**
	 * 省份名称
	 */
	private String c_cityName;
	
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

	public String getC_cityName() {
		return c_cityName;
	}

	public void setC_cityName(String c_cityName) {
		this.c_cityName = c_cityName;
	}

	public String getC_provinceName() {
		return c_provinceName;
	}

	public void setC_provinceName(String c_provinceName) {
		this.c_provinceName = c_provinceName;
	}
	
}
