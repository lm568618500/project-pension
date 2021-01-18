package com.longjun.cto.framework.sm.cms.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * ImageModel
 * @author liuming
 * @date 2019-12-11 04:05:21
 */
public class ImageModifyDto implements Serializable {

	private static final long serialVersionUID = 1576051528934L;
	
	/**
	 * 
	 */
	private java.lang.Long id;
	/**
	 * 
	 */
	private java.lang.String uuid;
	/**
	 * 
	 */
	private java.lang.Long size;
	/**
	 * 
	 */
	private java.lang.String contentType;
	/**
	 * 
	 */
	private java.lang.String originalName;
	/**
	 * 
	 */
	private java.lang.String suffix;
	/**
	 * 
	 */
	private java.lang.String storePath;
	/**
	 * 访问地址
	 */
	private java.lang.String url;
	/**
	 * 图片宽度，单位px
	 */
	private java.lang.Integer width;
	/**
	 * 图片高度，单位px
	 */
	private java.lang.Integer height;
	/**
	 * 缩略图图片id,关联image表自己
	 */
	private java.lang.Long thumbnailId;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 状态（0 正常 1 禁用）
	 */
	private java.lang.Integer status;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}
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
}
