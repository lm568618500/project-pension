package com.longjun.cto.framework.sm.message.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * MessageTempEmailModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public class MessageTempEmailView extends BaseView {

	private static final long serialVersionUID = 1554515956768L;
	
	
	/**
	 * 商户ID
	 */
	private long mechId;
	
	/**
	 * 模板名称
	 */
	private String tempUid;
	
	
	
	/**
	 * 邮件内容
	 */
	private String emailContent;
	
	/**
	 * 邮件立刻0非立刻 1立刻
	 */
	private int emailimmediately;
	
	
	/**
	 * 提示
	 */
	private String tips;
	
	/**
	 * 商户名称
	 */
	private String mechName;
	
	/**
	 * 商户锁定状态
	 */
	private int mechLockStatus;
	
	/**
	 * 模板名称
	 */
	private String tempName;
	
	/**
	 * 商户邮件支持
	 */
	private int mechSupportEmail;
	
	/**
	 * 商户短信支持
	 */
	private int mechSupportSms;
	
	/**
	 * 商户推送支持
	 */
	private int mechSupportPush;
	
	

	public String getMechName() {
		return mechName;
	}

	public void setMechName(String mechName) {
		this.mechName = mechName;
	}

	public int getMechLockStatus() {
		return mechLockStatus;
	}

	public void setMechLockStatus(int mechLockStatus) {
		this.mechLockStatus = mechLockStatus;
	}

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

	public int getMechSupportEmail() {
		return mechSupportEmail;
	}

	public void setMechSupportEmail(int mechSupportEmail) {
		this.mechSupportEmail = mechSupportEmail;
	}

	public int getMechSupportSms() {
		return mechSupportSms;
	}

	public void setMechSupportSms(int mechSupportSms) {
		this.mechSupportSms = mechSupportSms;
	}

	public int getMechSupportPush() {
		return mechSupportPush;
	}

	public void setMechSupportPush(int mechSupportPush) {
		this.mechSupportPush = mechSupportPush;
	}

	public void setMechId(long mechId) {
		this.mechId = mechId;
	}

	public long getMechId() {
		return this.mechId;
	}

	public void setTempUid(String tempUid) {
		this.tempUid = tempUid;
	}

	public String getTempUid() {
		return this.tempUid;
	}



	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public String getEmailContent() {
		return this.emailContent;
	}

	public void setEmailimmediately(int emailimmediately) {
		this.emailimmediately = emailimmediately;
	}

	public int getEmailimmediately() {
		return this.emailimmediately;
	}


	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getTips() {
		return this.tips;
	}

}
