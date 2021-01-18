package com.longjun.cto.framework.sm.cms.entity.dto;

import java.io.Serializable;

/**
 * 意见反馈入参对象
 * 
 * @author yangxuan
 * @date Jun 23, 2019 - 9:51:02 PM
 */
public class CmsFeedInputDto implements Serializable {

	private static final long serialVersionUID = 8107148779778888685L;

	/**
	 * 联系方式 ， 手机、邮件、其它。入参后进行匹配
	 */
	private String links;

	/**
	 * 联系人
	 */
	private String linkName;

	/**
	 * 问题描述
	 */
	private String feedContent;

	/**
	 * 反馈标题
	 */
	private String feedTitle;

	public String getFeedTitle() {
		return feedTitle;
	}

	public void setFeedTitle(String feedTitle) {
		this.feedTitle = feedTitle;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getFeedContent() {
		return feedContent;
	}

	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}

}
