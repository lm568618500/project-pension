package com.longjun.cto.framework.sm.pay.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * PayChannelModel
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
public class PayChannelDto extends BaseDTO {

	private static final long serialVersionUID = 1554023835394L;
	
	/**
	 * 渠道ID
	 */
	private String c_channelId;

	public String getC_channelId() {
		return c_channelId;
	}

	public void setC_channelId(String c_channelId) {
		this.c_channelId = c_channelId;
	}
	
}
