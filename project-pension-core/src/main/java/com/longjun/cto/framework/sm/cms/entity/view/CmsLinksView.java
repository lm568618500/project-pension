package com.longjun.cto.framework.sm.cms.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * CmsLinksModel
 * @author yangxuan
 * @date 2019-06-18 03:18:47
 */
public class CmsLinksView extends BaseView {

	private static final long serialVersionUID = 1560842334249L;
	
	
	
	
	
	/**
	 * 删除状态 0正常 -1删除
	 */
	private java.lang.Integer isDel;
	
	/**
	 * 名称
	 */
	private java.lang.String linkName;
	
	/**
	 * 图片地址
	 */
	private java.lang.String linkImg;
	
	/**
	 * 超链接
	 */
	private java.lang.String linkHref;
	
	/**
	 * 排序
	 */
	private java.lang.Integer linkSort;
	
	/**
	 * 1、友情链接 2、合作伙伴
	 */
	private java.lang.Integer linkType;
	
	/**
	 * 是否推荐到首页
	 */
	private java.lang.Integer isRecommend;
	
	




	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setLinkName(java.lang.String linkName) {
		this.linkName = linkName;
	}

	public java.lang.String getLinkName() {
		return this.linkName;
	}

	public void setLinkImg(java.lang.String linkImg) {
		this.linkImg = linkImg;
	}

	public java.lang.String getLinkImg() {
		return this.linkImg;
	}

	public void setLinkHref(java.lang.String linkHref) {
		this.linkHref = linkHref;
	}

	public java.lang.String getLinkHref() {
		return this.linkHref;
	}

	public void setLinkSort(java.lang.Integer linkSort) {
		this.linkSort = linkSort;
	}

	public java.lang.Integer getLinkSort() {
		return this.linkSort;
	}

	public void setLinkType(java.lang.Integer linkType) {
		this.linkType = linkType;
	}

	public java.lang.Integer getLinkType() {
		return this.linkType;
	}

	public void setIsRecommend(java.lang.Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public java.lang.Integer getIsRecommend() {
		return this.isRecommend;
	}

}
