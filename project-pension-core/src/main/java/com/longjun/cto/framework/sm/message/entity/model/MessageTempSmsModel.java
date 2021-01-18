package com.longjun.cto.framework.sm.message.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * MessageTempSmsModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
@TableName("t_message_temp_sms")
public class MessageTempSmsModel extends BaseModel<MessageTempSmsModel> {

	private static final long serialVersionUID = 1554515955992L;
	
	
	
	/**
	 * 商户ID
	 */
	@TableField("mech_id")
	private long mechId;
	
	/**
	 * 模板名称
	 */
	@TableField("temp_uid")
	private String tempUid;
	
	/**
	 * 第三方模板ID
	 */
	@TableField("other_template_id")
	private String otherTemplateId;
	
	/**
	 * 短信内容
	 */
	@TableField("sms_content")
	private String smsContent;
	
	
	/**
	 * 短信立刻0非立刻 1立刻
	 */
	@TableField("immediately")
	private int immediately;
	
	
	/**
	 * 提示
	 */
	@TableField("tips")
	private String tips;
	
	


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

	public void setOtherTemplateId(String otherTemplateId) {
		this.otherTemplateId = otherTemplateId;
	}

	public String getOtherTemplateId() {
		return this.otherTemplateId;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getSmsContent() {
		return this.smsContent;
	}


	public void setImmediately(int immediately) {
		this.immediately = immediately;
	}

	public int getImmediately() {
		return this.immediately;
	}


	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getTips() {
		return this.tips;
	}

}
