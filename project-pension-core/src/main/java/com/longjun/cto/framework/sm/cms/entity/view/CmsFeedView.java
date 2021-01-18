package com.longjun.cto.framework.sm.cms.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * CmsFeedModel
 * 
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
public class CmsFeedView extends BaseView {

	private static final long serialVersionUID = 1561297390952L;

	/**
	 * 
	 */
	private java.lang.Integer isDel;

	/**
	 * 
	 */
	private java.lang.String links;

	/**
	 * 联系类型：1 手机号 2邮箱
	 */
	private java.lang.Integer linkType;

	/**
	 * 用户ID
	 */
	private java.lang.Long userId;

	/**
	 * 联系人
	 */
	private java.lang.String linkName;

	/**
	 * 详细描述
	 */
	private java.lang.String feedContent;

	/**
	 * 反馈标题
	 */
	private java.lang.String feedTitle;

	/**
	 * 反馈分类。后续扩展。
	 */
	private java.lang.Integer feedType;

	/**
	 * 反馈编号-类主键
	 */
	private java.lang.Long feedNo;

	/**
	 * 回复时间
	 */
	private Date ackTime;

	/**
	 * 回复内容
	 */
	private String ackContent;

	public Date getAckTime() {
		return ackTime;
	}

	public void setAckTime(Date ackTime) {
		this.ackTime = ackTime;
	}

	public String getAckContent() {
		return ackContent;
	}

	public void setAckContent(String ackContent) {
		this.ackContent = ackContent;
	}

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
