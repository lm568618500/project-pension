package com.longjun.cto.framework.sm.message.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * MessageSmsModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public class MessageSmsDto extends BaseDTO {

	private static final long serialVersionUID = 1554515960151L;
	
	/**
	 * 手机号
	 */
	private String c_mobile;
	
	/**
	 * 模板ID
	 */
	private String c_tempUid;
	
	public String getC_tempUid() {
		return c_tempUid;
	}

	public void setC_tempUid(String c_tempUid) {
		this.c_tempUid = c_tempUid;
	}

	public String getC_mobile() {
		return c_mobile;
	}

	public void setC_mobile(String c_mobile) {
		this.c_mobile = c_mobile;
	}
	
	
	
}
