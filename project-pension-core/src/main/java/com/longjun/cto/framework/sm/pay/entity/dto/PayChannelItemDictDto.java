package com.longjun.cto.framework.sm.pay.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * PayChannelItemDictModel
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
public class PayChannelItemDictDto extends BaseDTO {

	private static final long serialVersionUID = 1554945273216L;

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
