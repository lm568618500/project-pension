package com.longjun.cto.framework.sm.message.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * MessageMechModel
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
public class MessageMechView extends BaseView {

	private static final long serialVersionUID = 1554457186560L;
	
	
	
	
	
	/**
	 * 删除状态 -1删除 0正常
	 */
	private int isDel;
	
	/**
	 * 商户名称
	 */
	private String mechName;
	
	/**
	 * 短信支持1支持 0不支持
	 */
	private int supportSms;
	
	/**
	 * 邮件支持1支持 0不支持
	 */
	private int supportEmail;
	
	/**
	 * 推送支持1支持 0不支持
	 */
	private int supportPush;
	
	/**
	 * 余额 分 。暂不使用。后续支持
	 */
	private long amount;
	
	/**
	 * 锁定状态 1锁定 0正常
	 */
	private int lockStatus;
	
	/**
	 * 锁定开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lockStart;
	
	/**
	 * 锁定结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lockEnd;
	
	




	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

	public void setMechName(String mechName) {
		this.mechName = mechName;
	}

	public String getMechName() {
		return this.mechName;
	}

	public void setSupportSms(int supportSms) {
		this.supportSms = supportSms;
	}

	public int getSupportSms() {
		return this.supportSms;
	}

	public void setSupportEmail(int supportEmail) {
		this.supportEmail = supportEmail;
	}

	public int getSupportEmail() {
		return this.supportEmail;
	}

	public void setSupportPush(int supportPush) {
		this.supportPush = supportPush;
	}

	public int getSupportPush() {
		return this.supportPush;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getAmount() {
		return this.amount;
	}

	public void setLockStatus(int lockStatus) {
		this.lockStatus = lockStatus;
	}

	public int getLockStatus() {
		return this.lockStatus;
	}

	public void setLockStart(java.util.Date lockStart) {
		this.lockStart = lockStart;
	}

	public java.util.Date getLockStart() {
		return this.lockStart;
	}

	public void setLockEnd(java.util.Date lockEnd) {
		this.lockEnd = lockEnd;
	}

	public java.util.Date getLockEnd() {
		return this.lockEnd;
	}

}
