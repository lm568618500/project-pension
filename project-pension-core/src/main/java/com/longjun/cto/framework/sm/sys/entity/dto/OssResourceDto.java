package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * OssResourceModel
 * @author yangxuan
 * @date 2019-04-01 07:19:42
 */
public class OssResourceDto extends BaseDTO {

	private static final long serialVersionUID = 1554117588090L;
	
	/**
	 * 资源名称
	 */
	private String c_resName;

	public String getC_resName() {
		return c_resName;
	}

	public void setC_resName(String c_resName) {
		this.c_resName = c_resName;
	}
	
}
