package com.longjun.cto.framework.sm.pay.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PayChannelItemDictModel
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
@TableName("t_pay_channel_item_dict")
public class PayChannelItemDictModel extends BaseModel<PayChannelItemDictModel> {

	private static final long serialVersionUID = 1554945270748L;
	
	
	
	
	
	/**
	 * 渠道名称
	 */
	@TableField("channel_id")
	private long channelId;
	
	/**
	 * 渠道子方式名称
	 */
	@TableField("channel_items_name")
	private String channelItemsName;
	
	/**
	 * 备注
	 */
	@TableField("mark")
	private String mark;
	
	




	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public long getChannelId() {
		return this.channelId;
	}

	public void setChannelItemsName(String channelItemsName) {
		this.channelItemsName = channelItemsName;
	}

	public String getChannelItemsName() {
		return this.channelItemsName;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return this.mark;
	}

}
