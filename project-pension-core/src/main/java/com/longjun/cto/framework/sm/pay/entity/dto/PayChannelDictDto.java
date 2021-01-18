package com.longjun.cto.framework.sm.pay.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * PayChannelDictModel
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
public class PayChannelDictDto extends BaseDTO {

	private static final long serialVersionUID = 1554945271292L;
	
	/**
	 * 渠道ID
	 */
	private long c_channelId;

	public long getC_channelId() {
		return c_channelId;
	}

	public void setC_channelId(long c_channelId) {
		this.c_channelId = c_channelId;
	}
	
}
