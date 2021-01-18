package com.longjun.cto.framework.sm.cms.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * CmsBannerModel
 * @author yangxuan
 * @date 2019-06-19 08:33:45
 */
public class CmsBannerModifyDto implements Serializable {

	private static final long serialVersionUID = 1560904433835L;
	
	/**
	 * 
	 */
	private java.lang.Long id;
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
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 是否启用（1是 0否）
	 */
	private java.lang.Integer status;
	/**
	 * 是否删除(0否，-1是)
	 */
	private java.lang.Integer isDel;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
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
	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public java.util.Date getTime() {
		return this.time;
	}
	public void setLastupdate(java.util.Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public java.util.Date getLastupdate() {
		return this.lastupdate;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}
}
