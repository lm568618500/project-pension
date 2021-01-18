package com.longjun.cto.framework.sm.message.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * MessageTempEmailModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public class MessageTempEmailDto extends BaseDTO {

	private static final long serialVersionUID = 1554515961428L;
	
	/**
	 * 邮件内容
	 */
	private String c_emailContent;
	
	/**
	 * 模板名称
	 */
	private String c_tempName;

	public String getC_emailContent() {
		return c_emailContent;
	}

	public void setC_emailContent(String c_emailContent) {
		this.c_emailContent = c_emailContent;
	}

	public String getC_tempName() {
		return c_tempName;
	}

	public void setC_tempName(String c_tempName) {
		this.c_tempName = c_tempName;
	}
	
	
}
