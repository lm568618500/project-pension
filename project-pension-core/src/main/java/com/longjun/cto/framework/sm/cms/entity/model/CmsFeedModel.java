package com.longjun.cto.framework.sm.cms.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CmsFeedModel
 * 
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
@TableName("t_cms_feed")
public class CmsFeedModel extends BaseModel<CmsFeedModel> {

	private static final long serialVersionUID = 1561297387064L;

	/**
	 * 
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;

	/**
	 * 
	 */
	@TableField("links")
	private java.lang.String links;

	/**
	 * 联系类型：1 手机号 2邮箱
	 */
	@TableField("link_type")
	private java.lang.Integer linkType;

	/**
	 * 用户ID
	 */
	@TableField("user_id")
	private java.lang.Long userId;

	/**
	 * 联系人
	 */
	@TableField("link_name")
	private java.lang.String linkName;

	/**
	 * 详细描述
	 */
	@TableField("feed_content")
	private java.lang.String feedContent;

	/**
	 * 反馈标题
	 */
	@TableField("feed_title")
	private java.lang.String feedTitle;

	/**
	 * 反馈分类。后续扩展。
	 */
	@TableField("feed_type")
	private java.lang.Integer feedType;

	/**
	 * 反馈编号-类主键
	 */
	@TableField("feed_no")
	private java.lang.Long feedNo;

	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setLinks(java.lang.String links) {
		this.links = links;
	}

	public java.lang.String getLinks() {
		return this.links;
	}

	public void setLinkType(java.lang.Integer linkType) {
		this.linkType = linkType;
	}

	public java.lang.Integer getLinkType() {
		return this.linkType;
	}

	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}

	public java.lang.Long getUserId() {
		return this.userId;
	}

	public void setLinkName(java.lang.String linkName) {
		this.linkName = linkName;
	}

	public java.lang.String getLinkName() {
		return this.linkName;
	}

	public void setFeedContent(java.lang.String feedContent) {
		this.feedContent = feedContent;
	}

	public java.lang.String getFeedContent() {
		return this.feedContent;
	}

	public void setFeedTitle(java.lang.String feedTitle) {
		this.feedTitle = feedTitle;
	}

	public java.lang.String getFeedTitle() {
		return this.feedTitle;
	}

	public void setFeedType(java.lang.Integer feedType) {
		this.feedType = feedType;
	}

	public java.lang.Integer getFeedType() {
		return this.feedType;
	}

	public void setFeedNo(java.lang.Long feedNo) {
		this.feedNo = feedNo;
	}

	public java.lang.Long getFeedNo() {
		return this.feedNo;
	}

}
