package com.longjun.cto.framework.sm.cms.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CmsBannerModel
 * @author yangxuan
 * @date 2019-06-19 08:33:45
 */
@TableName("t_cms_banner")
public class CmsBannerModel extends BaseModel<CmsBannerModel> {

	private static final long serialVersionUID = 1560904429259L;
	
	
	/**
	 * t_cms_banner_location id
	 */
	@TableField("location_id")
	private java.lang.Long locationId;
	
	/**
	 * 说明
	 */
	@TableField("title")
	private java.lang.String title;
	
	/**
	 * 跳转地址
	 */
	@TableField("urls")
	private java.lang.String urls;
	
	/**
	 * banner图
	 */
	@TableField("images")
	private java.lang.String images;
	
	/**
	 * 排序
	 */
	@TableField("b_sort")
	private java.lang.Integer bSort;
	
	/**
	 * 是否外链（1，是，2，否）
	 */
	@TableField("iswai")
	private java.lang.Integer iswai;
	
	/**
	 * 操作用户
	 */
	@TableField("adminid")
	private java.lang.Long adminid;
	
	
	
	
	/**
	 * 是否删除(0否，-1是)
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;
	
	

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
