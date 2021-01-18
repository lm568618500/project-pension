package com.longjun.cto.framework.sm.message.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * MessagePushModel
 * @author yangxuan
 * @date 2019-05-30 09:21:36
 */
public class MessagePushView extends BaseView {

	private static final long serialVersionUID = 1559222506583L;
	
	
	
	
	
	/**
	 * 删除状态
	 */
	private int isDel;
	
	/**
	 * 商户ID
	 */
	private long mchId;
	
	/**
	 * 设置ID
	 */
	private long settingId;
	
	/**
	 * 1安卓 2苹果
	 */
	private int osType;
	
	/**
	 * 
	 */
	private String ticker;
	
	/**
	 * 
	 */
	private String title;
	
	/**
	 * 
	 */
	private String pushText;
	
	/**
	 * 
	 */
	private String extrafield;
	
	/**
	 * 
	 */
	private String devicetoken;
	
	/**
	 * 
	 */
	private String customizedMap;
	
	/**
	 * 发送时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date sendTime;
	
	/**
	 * 发送时间戳
	 */
	private long sendTimestamp;
	
	/**
	 * 是否计划发送
	 */
	private int isPlain;
	
	/**
	 * 计划发送时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date plainTime;
	
	




	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

	public void setMchId(long mchId) {
		this.mchId = mchId;
	}

	public long getMchId() {
		return this.mchId;
	}

	public void setSettingId(long settingId) {
		this.settingId = settingId;
	}

	public long getSettingId() {
		return this.settingId;
	}

	public void setOsType(int osType) {
		this.osType = osType;
	}

	public int getOsType() {
		return this.osType;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getTicker() {
		return this.ticker;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setPushText(String pushText) {
		this.pushText = pushText;
	}

	public String getPushText() {
		return this.pushText;
	}

	public void setExtrafield(String extrafield) {
		this.extrafield = extrafield;
	}

	public String getExtrafield() {
		return this.extrafield;
	}

	public void setDevicetoken(String devicetoken) {
		this.devicetoken = devicetoken;
	}

	public String getDevicetoken() {
		return this.devicetoken;
	}

	public void setCustomizedMap(String customizedMap) {
		this.customizedMap = customizedMap;
	}

	public String getCustomizedMap() {
		return this.customizedMap;
	}

	public void setSendTime(java.util.Date sendTime) {
		this.sendTime = sendTime;
	}

	public java.util.Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTimestamp(long sendTimestamp) {
		this.sendTimestamp = sendTimestamp;
	}

	public long getSendTimestamp() {
		return this.sendTimestamp;
	}

	public void setIsPlain(int isPlain) {
		this.isPlain = isPlain;
	}

	public int getIsPlain() {
		return this.isPlain;
	}

	public void setPlainTime(java.util.Date plainTime) {
		this.plainTime = plainTime;
	}

	public java.util.Date getPlainTime() {
		return this.plainTime;
	}

}
