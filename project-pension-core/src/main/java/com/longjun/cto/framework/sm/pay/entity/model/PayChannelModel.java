package com.longjun.cto.framework.sm.pay.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * PayChannelModel
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
@TableName("t_pay_channel")
public class PayChannelModel extends BaseModel<PayChannelModel> {

	private static final long serialVersionUID = 1554023834290L;
	
	/**
	 * 
	 */
	@TableField("is_del")
	private int isDel;
	
	/**
	 * 渠道ID
	 */
	@TableField("channel_id")
	private long channelId;
	
	/**
	 * 渠道ID
	 */
	@TableField("channel_items_id")
	private long channelItemsId;
	
	/**
	 * 商户ID
	 */
	@TableField("mch_id")
	private long mchId;
	
	/**
	 * 配置参数,json字符串
	 */
	@TableField("param")
	private String param;
	
	/**
	 * 备注
	 */
	@TableField("remark")
	private String remark;
	
	

	public long getChannelItemsId() {
		return channelItemsId;
	}

	public void setChannelItemsId(long channelItemsId) {
		this.channelItemsId = channelItemsId;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public long getChannelId() {
		return this.channelId;
	}

	public void setMchId(long mchId) {
		this.mchId = mchId;
	}

	public long getMchId() {
		return this.mchId;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getParam() {
		return this.param;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

}
