package com.longjun.cto.framework.sm.cms.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * CmsFeedModel
 * 
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
public class CmsFeedModifyDto implements Serializable {

	private static final long serialVersionUID = 1561297390718L;

	/**
	 * 
	 */
	private java.lang.Long id;
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
	 * 
	 */
	private java.lang.Integer status;
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
	 * 反馈备注
	 */
	private String feedAck;

	/**
	 * 管理员ID
	 */
	private Long adminId;

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getFeedAck() {
		return feedAck;
	}

	public void setFeedAck(String feedAck) {
		this.feedAck = feedAck;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
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
