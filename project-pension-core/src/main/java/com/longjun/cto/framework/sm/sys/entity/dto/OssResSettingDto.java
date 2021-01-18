package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * OssResSettingModel
 * @author yangxuan
 * @date 2019-04-16 06:45:48
 */
public class OssResSettingDto extends BaseDTO {

	private static final long serialVersionUID = 1555411552803L;
	
	/**
	 * 一级分类
	 */
	private String c_firstSetting;
	
	/**
	 * 二级分类
	 */
	private String c_secSetting;
	
	/**
	 *  分类名称
	 */
	private String c_setName;
	

	public String getC_setName() {
		return c_setName;
	}

	public void setC_setName(String c_setName) {
		this.c_setName = c_setName;
	}

	public String getC_firstSetting() {
		return c_firstSetting;
	}

	public void setC_firstSetting(String c_firstSetting) {
		this.c_firstSetting = c_firstSetting;
	}

	public String getC_secSetting() {
		return c_secSetting;
	}

	public void setC_secSetting(String c_secSetting) {
		this.c_secSetting = c_secSetting;
	}
	
}
