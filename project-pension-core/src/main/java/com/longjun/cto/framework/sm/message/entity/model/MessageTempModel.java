package com.longjun.cto.framework.sm.message.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * MessageTempModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
@TableName("t_message_temp")
public class MessageTempModel extends BaseModel<MessageTempModel> {

	private static final long serialVersionUID = 1554515960008L;
	
	
	
	
	
	/**
	 * 模板名称
	 */
	@TableField("temp_name")
	private String tempName;
	
	/**
	 * 模板使用ID
	 */
	@TableField("temp_uid")
	private String tempUid;
	
	/**
	 * 模板类型
	 */
	@TableField("temp_type")
	private int tempType;
	
	/**
	 * 备注
	 */
	@TableField("mark")
	private String mark;
	
	




	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

	public String getTempName() {
		return this.tempName;
	}

	public void setTempUid(String tempUid) {
		this.tempUid = tempUid;
	}

	public String getTempUid() {
		return this.tempUid;
	}

	public void setTempType(int tempType) {
		this.tempType = tempType;
	}

	public int getTempType() {
		return this.tempType;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return this.mark;
	}

}
