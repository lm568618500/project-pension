package com.longjun.cto.framework.sm.cms.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * CmsBannerLocationModel
 * 
 * @author yangxuan
 * @date 2019-06-19 08:33:45
 */
public class CmsBannerLocationDto extends BaseDTO {

	private static final long serialVersionUID = 1560904434613L;

	/**
	 * 广告位置名称
	 */
	private String c_locationName;

	public String getC_locationName() {
		return c_locationName;
	}

	public void setC_locationName(String c_locationName) {
		this.c_locationName = c_locationName;
	}

}
