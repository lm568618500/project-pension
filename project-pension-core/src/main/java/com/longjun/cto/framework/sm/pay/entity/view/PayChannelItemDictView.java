package com.longjun.cto.framework.sm.pay.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * PayChannelItemDictModel
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
public class PayChannelItemDictView extends BaseView {

	private static final long serialVersionUID = 1554945275715L;
	
	
	
	
	
	/**
	 * 渠道名称
	 */
	private long channelId;
	
	/**
	 * 渠道子方式名称
	 */
	private String channelItemsName;
	
	/**
	 * 备注
	 */
	private String mark;
	
	/**
	 * 渠道名称
	 */
	private String channelName;
	
	/**
	 * 渠道状态
	 */
	private String channelStatus;
	



	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelStatus() {
		return channelStatus;
	}

	public void setChannelStatus(String channelStatus) {
		this.channelStatus = channelStatus;
	}

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
