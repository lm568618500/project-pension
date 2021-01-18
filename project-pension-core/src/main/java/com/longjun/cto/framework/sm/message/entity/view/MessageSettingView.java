package com.longjun.cto.framework.sm.message.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * MessageSettingModel
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
public class MessageSettingView extends BaseView {

	private static final long serialVersionUID = 1554457185393L;
	
	
	
	
	
	/**
	 * 是否删除 0 正常 -1删除
	 */
	private int isDel;
	
	/**
	 * 商户ID
	 */
	private long mechId;
	
	/**
	 * 设置类型 1短信 2邮箱 3推送
	 */
	private int settingType;
	
	/**
	 * 消息网关ID
	 */
	private long gatwayId;
	
	/**
	 * 配置文件信息。可配置JSON
	 */
	private String profile;
	
	/**
	 * 商户名称
	 */
	private String mechName;
	
	
	/**
	 * 网关名称
	 */
	private String gatwayName;
	
	/**
	 * 网关值
	 */
	private String gatwayValue;
	
	public String getGatwayValue() {
		return gatwayValue;
	}

	public void setGatwayValue(String gatwayValue) {
		this.gatwayValue = gatwayValue;
	}

	public String getMechName() {
		return mechName;
	}

	public void setMechName(String mechName) {
		this.mechName = mechName;
	}

	public String getGatwayName() {
		return gatwayName;
	}

	public void setGatwayName(String gatwayName) {
		this.gatwayName = gatwayName;
	}

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
