package com.longjun.cto.framework.sm.message.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * MessageSettingModel
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
public class MessageSettingDto extends BaseDTO {

	private static final long serialVersionUID = 1554457189761L;
	
	/**
	 * 商户名称
	 */
	private String c_mechName;
	
	/**
	 * 网关名称
	 */
	private String c_gatwayName;
	
	/**
	 * 配置类型
	 */
	private String c_settingType;

	public String getC_mechName() {
		return c_mechName;
	}

	public void setC_mechName(String c_mechName) {
		this.c_mechName = c_mechName;
	}

	public String getC_gatwayName() {
		return c_gatwayName;
	}

	public void setC_gatwayName(String c_gatwayName) {
		this.c_gatwayName = c_gatwayName;
	}

	public String getC_settingType() {
		return c_settingType;
	}

	public void setC_settingType(String c_settingType) {
		this.c_settingType = c_settingType;
	}
	
	
}
