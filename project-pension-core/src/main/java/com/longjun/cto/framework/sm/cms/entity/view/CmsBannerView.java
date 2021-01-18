package com.longjun.cto.framework.sm.cms.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * CmsBannerModel
 * 
 * @author yangxuan
 * @date 2019-06-19 08:33:45
 */
public class CmsBannerView extends BaseView {

	private static final long serialVersionUID = 1560904430008L;

	/**
	 * t_cms_banner_location id
	 */
	private java.lang.Long locationId;

	/**
	 * 说明
	 */
	private java.lang.String title;

	/**
	 * 跳转地址
	 */
	private java.lang.String urls;

	/**
	 * banner图
	 */
	private java.lang.String images;

	/**
	 * 排序
	 */
	private java.lang.Integer bSort;

	/**
	 * 是否外链（1，是，2，否）
	 */
	private java.lang.Integer iswai;

	/**
	 * 操作用户
	 */
	private java.lang.Long adminid;

	/**
	 * 是否删除(0否，-1是)
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

	public java.lang.Integer getbSort() {
		return bSort;
	}

	public void setbSort(java.lang.Integer bSort) {
		this.bSort = bSort;
	}

	public java.lang.Integer getBannerClient() {
		return bannerClient;
	}

	public void setBannerClient(java.lang.Integer bannerClient) {
		this.bannerClient = bannerClient;
	}

	public java.lang.Integer getbWidth() {
		return bWidth;
	}

	public void setbWidth(java.lang.Integer bWidth) {
		this.bWidth = bWidth;
	}

	public java.lang.Integer getbHight() {
		return bHight;
	}

	public void setbHight(java.lang.Integer bHight) {
		this.bHight = bHight;
	}

	public java.lang.String getLocationName() {
		return locationName;
	}

	public void setLocationName(java.lang.String locationName) {
		this.locationName = locationName;
	}

	public java.lang.Integer getIsMore() {
		return isMore;
	}

	public void setIsMore(java.lang.Integer isMore) {
		this.isMore = isMore;
	}

	public java.lang.Integer getIsAd() {
		return isAd;
	}

	public void setIsAd(java.lang.Integer isAd) {
		this.isAd = isAd;
	}

	public void setLocationId(java.lang.Long locationId) {
		this.locationId = locationId;
	}

	public java.lang.Long getLocationId() {
		return this.locationId;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.lang.String getTitle() {
		return this.title;
	}

	public void setUrls(java.lang.String urls) {
		this.urls = urls;
	}

	public java.lang.String getUrls() {
		return this.urls;
	}

	public void setImages(java.lang.String images) {
		this.images = images;
	}

	public java.lang.String getImages() {
		return this.images;
	}

	public void setBSort(java.lang.Integer bSort) {
		this.bSort = bSort;
	}

	public java.lang.Integer getBSort() {
		return this.bSort;
	}

	public void setIswai(java.lang.Integer iswai) {
		this.iswai = iswai;
	}

	public java.lang.Integer getIswai() {
		return this.iswai;
	}

	public void setAdminid(java.lang.Long adminid) {
		this.adminid = adminid;
	}

	public java.lang.Long getAdminid() {
		return this.adminid;
	}

	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

}
