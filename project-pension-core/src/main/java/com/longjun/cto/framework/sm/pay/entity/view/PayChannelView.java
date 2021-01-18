package com.longjun.cto.framework.sm.pay.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * PayChannelModel
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
public class PayChannelView extends BaseView {

	private static final long serialVersionUID = 1554023834901L;
	
	
	
	
	
	/**
	 * 
	 */
	private int isDel;
	
	/**
	 * 渠道ID
	 */
	private long channelId;
	
	private long channelItemsId;
	
	
	/**
	 * 商户ID
	 */
	private long mchId;
	
	/**
	 * 配置参数,json字符串
	 */
	private String param;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 商户名称
	 */
	private String mchName;
	
	/**
	 * 商户请求私钥
	 */
	private String reqKey;
	
	/**
	 * 商户响应私钥
	 */
	private String resKey;
	
	/**
	 * t_pay_mch_info status
	 */
	private int miStatus;
	
	/**
	 * t_pay_channel_item_dict - channel_items_name 渠道支付名称
	 */
	private String channelItemsName;
	
	private String cidMark;
	
	/**
	 * 渠道名称
	 */
	private String channelName;
	
	/**
	 * 渠道状态
	 */
	private int cdStatus;
	

	public String getMchName() {
		return mchName;
	}

	public void setMchName(String mchName) {
		this.mchName = mchName;
	}

	public String getReqKey() {
		return reqKey;
	}

	public void setReqKey(String reqKey) {
		this.reqKey = reqKey;
	}

	public String getResKey() {
		return resKey;
	}

	public void setResKey(String resKey) {
		this.resKey = resKey;
	}

	public int getMiStatus() {
		return miStatus;
	}

	public void setMiStatus(int miStatus) {
		this.miStatus = miStatus;
	}

	public String getChannelItemsName() {
		return channelItemsName;
	}

	public void setChannelItemsName(String channelItemsName) {
		this.channelItemsName = channelItemsName;
	}

	public String getCidMark() {
		return cidMark;
	}

	public void setCidMark(String cidMark) {
		this.cidMark = cidMark;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getCdStatus() {
		return cdStatus;
	}

	public void setCdStatus(int cdStatus) {
		this.cdStatus = cdStatus;
	}

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
