package com.longjun.cto.framework.sm.cms.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * CmsBannerModel
 * 
 * @author yangxuan
 * @date 2019-06-19 08:33:45
 */
public class CmsBannerDto extends BaseDTO {

	private static final long serialVersionUID = 1560904433272L;

	/**
	 * 客户端 0PC 1App
	 */
	private String c_bannerClient;

	/**
	 * 是否是广告 0否 1是
	 */
	private String c_isAd;

	/**
	 * 位置名称
	 */
	private String c_locationName;

	public String getC_bannerClient() {
		return c_bannerClient;
	}

	public void setC_bannerClient(String c_bannerClient) {
		this.c_bannerClient = c_bannerClient;
	}

	public String getC_isAd() {
		return c_isAd;
	}

	public void setC_isAd(String c_isAd) {
		this.c_isAd = c_isAd;
	}

	public String getC_locationName() {
		return c_locationName;
	}

	public void setC_locationName(String c_locationName) {
		this.c_locationName = c_locationName;
	}

}
