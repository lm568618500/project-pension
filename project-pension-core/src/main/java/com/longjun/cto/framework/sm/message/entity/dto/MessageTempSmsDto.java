package com.longjun.cto.framework.sm.message.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * MessageTempSmsModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public class MessageTempSmsDto extends BaseDTO {

	private static final long serialVersionUID = 1554515963879L;
	
	
	/**
	 * 模板名称
	 */
	private String c_tempName;
	
	/**
	 * 第三方模板ID
	 */
	private String c_otherTemplateId;
	
	/**
	 * 短信内容
	 */
	private String c_smsContent;

	public String getC_tempName() {
		return c_tempName;
	}

	public void setC_tempName(String c_tempName) {
		this.c_tempName = c_tempName;
	}

	public String getC_otherTemplateId() {
		return c_otherTemplateId;
	}

	public void setC_otherTemplateId(String c_otherTemplateId) {
		this.c_otherTemplateId = c_otherTemplateId;
	}

	public String getC_smsContent() {
		return c_smsContent;
	}

	public void setC_smsContent(String c_smsContent) {
		this.c_smsContent = c_smsContent;
	}
	
	
}
