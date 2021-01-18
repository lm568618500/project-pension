package com.longjun.cto.framework.sm.cms.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * CmsFeedModel
 * 
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
public class CmsFeedDto extends BaseDTO {

	private static final long serialVersionUID = 1561297391179L;

	/**
	 * 联系方式
	 */
	private String c_links;

	/**
	 * 联系人
	 */
	private String c_linkName;

	public String getC_links() {
		return c_links;
	}

	public void setC_links(String c_links) {
		this.c_links = c_links;
	}

	public String getC_linkName() {
		return c_linkName;
	}

	public void setC_linkName(String c_linkName) {
		this.c_linkName = c_linkName;
	}

}
