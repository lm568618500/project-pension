package com.longjun.cto.framework.sm.cms.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * CmsBannerLocationModel
 * @author yangxuan
 * @date 2019-06-19 08:33:45
 */
public class CmsBannerLocationView extends BaseView {

	private static final long serialVersionUID = 1560904433636L;
	
	
	
	
	
	/**
	 * 删除状态 0正常 -1删除
	 */
	private java.lang.Integer isDel;
	
	/**
	 * 客户端 0 PC 1App
	 */
	private java.lang.Integer bannerClient;
	
	/**
	 * 宽
	 */
	private java.lang.Integer bWidth;
	
	/**
	 * 高
	 */
	private java.lang.Integer bHight;
	
	/**
	 * 位置名称
	 */
	private java.lang.String locationName;
	
	/**
	 * 是否多图 0否 1是
	 */
	private java.lang.Integer isMore;
	
	/**
	 * 是否广告 0否 1是
	 */
	private java.lang.Integer isAd;
	
	




	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setBannerClient(java.lang.Integer bannerClient) {
		this.bannerClient = bannerClient;
	}

	public java.lang.Integer getBannerClient() {
		return this.bannerClient;
	}

	public void setBWidth(java.lang.Integer bWidth) {
		this.bWidth = bWidth;
	}

	public java.lang.Integer getBWidth() {
		return this.bWidth;
	}

	public void setBHight(java.lang.Integer bHight) {
		this.bHight = bHight;
	}

	public java.lang.Integer getBHight() {
		return this.bHight;
	}

	public void setLocationName(java.lang.String locationName) {
		this.locationName = locationName;
	}

	public java.lang.String getLocationName() {
		return this.locationName;
	}

	public void setIsMore(java.lang.Integer isMore) {
		this.isMore = isMore;
	}

	public java.lang.Integer getIsMore() {
		return this.isMore;
	}

	public void setIsAd(java.lang.Integer isAd) {
		this.isAd = isAd;
	}

	public java.lang.Integer getIsAd() {
		return this.isAd;
	}

}
