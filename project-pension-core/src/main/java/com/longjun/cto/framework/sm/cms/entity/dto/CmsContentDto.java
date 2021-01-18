package com.longjun.cto.framework.sm.cms.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * CmsContentModel
 * 
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
public class CmsContentDto extends BaseDTO {

	private static final long serialVersionUID = 1560848116944L;

	/**
	 * 类型
	 */
	private String c_typeId;

	/**
	 * 名称
	 */
	private String c_title;

	/**
	 * 分类类型
	 */
	private String c_class_id;

	public String getC_class_id() {
		return c_class_id;
	}

	public void setC_class_id(String c_class_id) {
		this.c_class_id = c_class_id;
	}

	public String getC_title() {
		return c_title;
	}

	public void setC_title(String c_title) {
		this.c_title = c_title;
	}

	public String getC_typeId() {
		return c_typeId;
	}

	public void setC_typeId(String c_typeId) {
		this.c_typeId = c_typeId;
	}

}
