package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * CommonUpgradeModel
 * @author yangxuan
 * @date 2019-04-04 07:49:24
 */
public class CommonUpgradeDto extends BaseDTO {

	private static final long serialVersionUID = 1554378573148L;
	
	/**
	 * 版本名称
	 */
	private String c_version;

	public String getC_version() {
		return c_version;
	}

	public void setC_version(String c_version) {
		this.c_version = c_version;
	}
	
}
