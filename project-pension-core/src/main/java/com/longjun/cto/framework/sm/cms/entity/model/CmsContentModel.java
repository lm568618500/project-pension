package com.longjun.cto.framework.sm.cms.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CmsContentModel
 * 
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
@TableName("t_cms_content")
public class CmsContentModel extends BaseModel<CmsContentModel> {

	private static final long serialVersionUID = 1560848116929L;

	/**
	 * 父级id
	 */
	@TableField("parentid")
	private java.lang.Integer parentid;

	/**
	 * 文章类型
	 */
	@TableField("type_id")
	private java.lang.Integer typeId;

	/**
	 * 新闻标题
	 */
	@TableField("title")
	private java.lang.String title;

	/**
	 * 简介
	 */
	@TableField("remark")
	private java.lang.String remark;

	/**
	 * 新闻内容
	 */
	@TableField("contents")
	private java.lang.String contents;

	/**
	 * logo图
	 */
	@TableField("thumbimg")
	private java.lang.String thumbimg;

	/**
	 * 作者
	 */
	@TableField("adminid")
	private java.lang.Long adminid;

	/**
	 * 是否设置置顶
	 */
	@TableField("is_top")
	private java.lang.Integer isTop;

	/**
	 * 设置置顶时间
	 */
	@TableField("toptime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date toptime;

	/**
	 * 
	 */
	@TableField("seo_title")
	private java.lang.String seoTitle;

	/**
	 * 
	 */
	@TableField("seo_keywords")
	private java.lang.String seoKeywords;

	/**
	 * 
	 */
	@TableField("seo_description")
	private java.lang.String seoDescription;

	/**
	 * 浏览量
	 */
	@TableField("viewcount")
	private java.lang.Long viewcount;

	/**
	 * 是否有图片(对应前台 1是 0否)
	 */
	@TableField("is_image")
	private java.lang.Integer isImage;

	/**
	 * 视频封面图片
	 */
	@TableField("voide_images")
	private java.lang.String voideImages;

	/**
	 * 视频地址
	 */
	@TableField("viode_urls")
	private java.lang.String viodeUrls;

	/**
	 * 视频大小
	 */
	@TableField("size")
	private java.lang.String size;

	/**
	 * 1:新闻,2:视频
	 */
	@TableField("is_voide")
	private java.lang.Integer isVoide;

	/**
	 * 
	 */
	@TableField("wordcount")
	private java.lang.Integer wordcount;

	/**
	 * 是否删除(0否 -1是)
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;

	/**
	 * 是否推荐首页(0否 1是)
	 */
	@TableField("is_index")
	private java.lang.Integer isIndex;

	/**
	 * 来源
	 */
	@TableField("source")
	private String source;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public java.lang.Integer getIsIndex() {
		return isIndex;
	}

	public void setIsIndex(java.lang.Integer isIndex) {
		this.isIndex = isIndex;
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
