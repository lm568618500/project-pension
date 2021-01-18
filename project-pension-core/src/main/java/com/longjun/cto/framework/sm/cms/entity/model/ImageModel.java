package com.longjun.cto.framework.sm.cms.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ImageModel
 * @author liuming
 * @date 2019-12-11 04:05:21
 */
@TableName("t_image")
public class ImageModel extends BaseModel<ImageModel> {

	private static final long serialVersionUID = 1576051523409L;
	
	
	/**
	 * 
	 */
	@TableField("uuid")
	private java.lang.String uuid;
	
	/**
	 * 
	 */
	@TableField("size")
	private java.lang.Long size;
	
	/**
	 * 
	 */
	@TableField("content_type")
	private java.lang.String contentType;
	
	/**
	 * 
	 */
	@TableField("original_name")
	private java.lang.String originalName;
	
	/**
	 * 
	 */
	@TableField("suffix")
	private java.lang.String suffix;
	
	/**
	 * 
	 */
	@TableField("store_path")
	private java.lang.String storePath;
	
	/**
	 * 访问地址
	 */
	@TableField("url")
	private java.lang.String url;
	
	/**
	 * 图片宽度，单位px
	 */
	@TableField("width")
	private java.lang.Integer width;
	
	/**
	 * 图片高度，单位px
	 */
	@TableField("height")
	private java.lang.Integer height;
	
	/**
	 * 缩略图图片id,关联image表自己
	 */
	@TableField("thumbnail_id")
	private java.lang.Long thumbnailId;
	
	
	
	
	

	public void setUuid(java.lang.String uuid) {
		this.uuid = uuid;
	}

	public java.lang.String getUuid() {
		return this.uuid;
	}

	public void setSize(java.lang.Long size) {
		this.size = size;
	}

	public java.lang.Long getSize() {
		return this.size;
	}

	public void setContentType(java.lang.String contentType) {
		this.contentType = contentType;
	}

	public java.lang.String getContentType() {
		return this.contentType;
	}

	public void setOriginalName(java.lang.String originalName) {
		this.originalName = originalName;
	}

	public java.lang.String getOriginalName() {
		return this.originalName;
	}

	public void setSuffix(java.lang.String suffix) {
		this.suffix = suffix;
	}

	public java.lang.String getSuffix() {
		return this.suffix;
	}

	public void setStorePath(java.lang.String storePath) {
		this.storePath = storePath;
	}

	public java.lang.String getStorePath() {
		return this.storePath;
	}

	public void setUrl(java.lang.String url) {
		this.url = url;
	}

	public java.lang.String getUrl() {
		return this.url;
	}

	public void setWidth(java.lang.Integer width) {
		this.width = width;
	}

	public java.lang.Integer getWidth() {
		return this.width;
	}

	public void setHeight(java.lang.Integer height) {
		this.height = height;
	}

	public java.lang.Integer getHeight() {
		return this.height;
	}

	public void setThumbnailId(java.lang.Long thumbnailId) {
		this.thumbnailId = thumbnailId;
	}

	public java.lang.Long getThumbnailId() {
		return this.thumbnailId;
	}




}
