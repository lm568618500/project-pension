package com.longjun.cto.framework.sm.cms.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * CmsLinksModel
 * 
 * @author yangxuan
 * @date 2019-06-18 03:18:47
 */
public class CmsLinksDto extends BaseDTO {

	private static final long serialVersionUID = 1560842330030L;

	/**
	 * 伙伴名称
	 */
	private String c_linkName;

	/**
	 * 类型 1友情连接 2合作伙伴
	 */
	private String c_linkType;

	public String getC_linkName() {
		return c_linkName;
	}

	public void setC_linkName(String c_linkName) {
		this.c_linkName = c_linkName;
	}

	public String getC_linkType() {
		return c_linkType;
	}

	public void setC_linkType(String c_linkType) {
		this.c_linkType = c_linkType;
	}

}
