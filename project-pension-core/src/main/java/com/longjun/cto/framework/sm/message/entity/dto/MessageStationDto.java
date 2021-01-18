package com.longjun.cto.framework.sm.message.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * MessageStationModel
 * 
 * @author yangxuan
 * @date 2019-07-04 07:33:46
 */
public class MessageStationDto extends BaseDTO {

	private static final long serialVersionUID = 1562240027177L;

	/**
	 * 用户编号
	 */
	private String c_userNo;

	public String getC_userNo() {
		return c_userNo;
	}

	public void setC_userNo(String c_userNo) {
		this.c_userNo = c_userNo;
	}

}
