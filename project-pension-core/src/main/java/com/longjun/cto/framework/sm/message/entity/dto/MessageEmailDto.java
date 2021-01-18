package com.longjun.cto.framework.sm.message.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * MessageEmailModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public class MessageEmailDto extends BaseDTO {

	private static final long serialVersionUID = 1554515962606L;
	
	/**
	 * 收件人
	 */
	private String c_email;
	

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

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}
	
}
