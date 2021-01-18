package com.longjun.cto.framework.sm.message.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * MessageTempEmailModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
@TableName("t_message_temp_email")
public class MessageTempEmailModel extends BaseModel<MessageTempEmailModel> {

	private static final long serialVersionUID = 1554515962059L;
	
	
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
	 * 邮件内容
	 */
	@TableField("email_content")
	private String emailContent;
	
	/**
	 * 邮件立刻0非立刻 1立刻
	 */
	@TableField("emailimmediately")
	private int emailimmediately;
	
	
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
