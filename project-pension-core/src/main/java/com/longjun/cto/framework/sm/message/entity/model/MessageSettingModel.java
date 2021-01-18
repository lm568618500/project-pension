package com.longjun.cto.framework.sm.message.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * MessageSettingModel
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
@TableName("t_message_setting")
public class MessageSettingModel extends BaseModel<MessageSettingModel> {

	private static final long serialVersionUID = 1554457185842L;
	
	
	
	
	
	/**
	 * 是否删除 0 正常 -1删除
	 */
	@TableField("is_del")
	private int isDel;
	
	/**
	 * 商户ID
	 */
	@TableField("mech_id")
	private long mechId;
	
	/**
	 * 设置类型 1短信 2邮箱 3推送
	 */
	@TableField("setting_type")
	private int settingType;
	
	/**
	 * 消息网关ID
	 */
	@TableField("gatway_id")
	private long gatwayId;
	
	/**
	 * 配置文件信息。可配置JSON
	 */
	@TableField("profile")
	private String profile;
	
	




	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

	public void setMechId(long mechId) {
		this.mechId = mechId;
	}

	public long getMechId() {
		return this.mechId;
	}

	public void setSettingType(int settingType) {
		this.settingType = settingType;
	}

	public int getSettingType() {
		return this.settingType;
	}

	public void setGatwayId(long gatwayId) {
		this.gatwayId = gatwayId;
	}

	public long getGatwayId() {
		return this.gatwayId;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getProfile() {
		return this.profile;
	}

}
