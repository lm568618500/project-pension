package com.longjun.cto.framework.sm.pay.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * PayChannelDictModel
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
public class PayChannelDictView extends BaseView {

	private static final long serialVersionUID = 1554945275847L;
	
	
	
	
	
	/**
	 * 渠道名称
	 */
	private String channelName;
	
	/**
	 * 备注
	 */
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
