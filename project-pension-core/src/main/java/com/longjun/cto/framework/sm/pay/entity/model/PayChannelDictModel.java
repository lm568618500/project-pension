package com.longjun.cto.framework.sm.pay.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PayChannelDictModel
 * 
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
@TableName("t_pay_channel_dict")
public class PayChannelDictModel extends BaseModel<PayChannelDictModel> {

	private static final long serialVersionUID = 1554945273602L;

	/**
	 * 渠道名称
	 */
	@TableField("channel_name")
	private String channelName;

	/**
	 * 备注
	 */
	@TableField("mark")
	private String mark;

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelName() {
		return this.channelName;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return this.mark;
	}

}
