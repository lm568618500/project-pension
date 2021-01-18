package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * OssResStoreModel
 * @author yangxuan
 * @date 2019-04-16 06:45:47
 */
public class OssResStoreDto extends BaseDTO {

	private static final long serialVersionUID = 1555411556588L;
	/**
	 * 资源名称
	 */
	private String c_resName;
	
	/**
	 * 资源地址
	 */
	private String c_resHref;
	
	private String setName;//归类名称
	private String setId;//归类id

	public String getC_resName() {
		return c_resName;
	}

	public void setC_resName(String c_resName) {
		this.c_resName = c_resName;
	}

	public String getC_resHref() {
		return c_resHref;
	}

	public void setC_resHref(String c_resHref) {
		this.c_resHref = c_resHref;
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	public String getSetId() {
		return setId;
	}

	public void setSetId(String setId) {
		this.setId = setId;
	}
	
}
