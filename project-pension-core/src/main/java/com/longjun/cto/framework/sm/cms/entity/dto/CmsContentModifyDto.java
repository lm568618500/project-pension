package com.longjun.cto.framework.sm.cms.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * CmsContentModel
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
public class CmsContentModifyDto implements Serializable {

	private static final long serialVersionUID = 1560848121904L;
	
	/**
	 * 
	 */
	private java.lang.Long id;
	/**
	 * 父级id
	 */
	private java.lang.Integer parentid;
	/**
	 * 文章类型
	 */
	private java.lang.Integer typeId;
	/**
	 * 新闻标题
	 */
	private java.lang.String title;
	/**
	 * 简介
	 */
	private java.lang.String remark;
	/**
	 * 新闻内容
	 */
	private java.lang.String contents;
	/**
	 * logo图
	 */
	private java.lang.String thumbimg;
	/**
	 * 作者
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
	 * 是否设置置顶
	 */
	private java.lang.Integer isTop;
	/**
	 * 设置置顶时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date toptime;
	/**
	 * 
	 */
	private java.lang.String seoTitle;
	/**
	 * 
	 */
	private java.lang.String seoKeywords;
	/**
	 * 
	 */
	private java.lang.String seoDescription;
	/**
	 * 浏览量
	 */
	private java.lang.Long viewcount;
	/**
	 * 是否有图片(对应前台 1是 0否)
	 */
	private java.lang.Integer isImage;
	/**
	 * 视频封面图片
	 */
	private java.lang.String voideImages;
	/**
	 * 视频地址
	 */
	private java.lang.String viodeUrls;
	/**
	 * 视频大小
	 */
	private java.lang.String size;
	/**
	 * 1:新闻,2:视频
	 */
	private java.lang.Integer isVoide;
	/**
	 * 
	 */
	private java.lang.Integer wordcount;
	/**
	 * 是否删除(0否 -1是)
	 */
	private java.lang.Integer isDel;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}
	public void setParentid(java.lang.Integer parentid) {
		this.parentid = parentid;
	}

	public java.lang.Integer getParentid() {
		return this.parentid;
	}
	public void setTypeId(java.lang.Integer typeId) {
		this.typeId = typeId;
	}

	public java.lang.Integer getTypeId() {
		return this.typeId;
	}
	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.lang.String getTitle() {
		return this.title;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setContents(java.lang.String contents) {
		this.contents = contents;
	}

	public java.lang.String getContents() {
		return this.contents;
	}
	public void setThumbimg(java.lang.String thumbimg) {
		this.thumbimg = thumbimg;
	}

	public java.lang.String getThumbimg() {
		return this.thumbimg;
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
	public void setIsTop(java.lang.Integer isTop) {
		this.isTop = isTop;
	}

	public java.lang.Integer getIsTop() {
		return this.isTop;
	}
	public void setToptime(java.util.Date toptime) {
		this.toptime = toptime;
	}

	public java.util.Date getToptime() {
		return this.toptime;
	}
	public void setSeoTitle(java.lang.String seoTitle) {
		this.seoTitle = seoTitle;
	}

	public java.lang.String getSeoTitle() {
		return this.seoTitle;
	}
	public void setSeoKeywords(java.lang.String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public java.lang.String getSeoKeywords() {
		return this.seoKeywords;
	}
	public void setSeoDescription(java.lang.String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public java.lang.String getSeoDescription() {
		return this.seoDescription;
	}
	public void setViewcount(java.lang.Long viewcount) {
		this.viewcount = viewcount;
	}

	public java.lang.Long getViewcount() {
		return this.viewcount;
	}
	public void setIsImage(java.lang.Integer isImage) {
		this.isImage = isImage;
	}

	public java.lang.Integer getIsImage() {
		return this.isImage;
	}
	public void setVoideImages(java.lang.String voideImages) {
		this.voideImages = voideImages;
	}

	public java.lang.String getVoideImages() {
		return this.voideImages;
	}
	public void setViodeUrls(java.lang.String viodeUrls) {
		this.viodeUrls = viodeUrls;
	}

	public java.lang.String getViodeUrls() {
		return this.viodeUrls;
	}
	public void setSize(java.lang.String size) {
		this.size = size;
	}

	public java.lang.String getSize() {
		return this.size;
	}
	public void setIsVoide(java.lang.Integer isVoide) {
		this.isVoide = isVoide;
	}

	public java.lang.Integer getIsVoide() {
		return this.isVoide;
	}
	public void setWordcount(java.lang.Integer wordcount) {
		this.wordcount = wordcount;
	}

	public java.lang.Integer getWordcount() {
		return this.wordcount;
	}
	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}
}
