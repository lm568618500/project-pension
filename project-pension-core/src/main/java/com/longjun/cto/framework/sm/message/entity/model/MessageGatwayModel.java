package com.longjun.cto.framework.sm.message.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * MessageGatwayModel
 * @author yangxuan
 * @date 2019-04-05 05:39:43
 */
@TableName("t_message_gatway")
public class MessageGatwayModel extends BaseModel<MessageGatwayModel> {

	private static final long serialVersionUID = 1554457185073L;
	
	
	
	
	
	/**
	 * 是否删除 0 正常 -1删除
	 */
	@TableField("is_del")
	private int isDel;
	
	/**
	 * 网关名称
	 */
	@TableField("gatway_name")
	private String gatwayName;
	
	/**
	 * 网关值
	 */
	@TableField("gatway_value")
	private String gatwayValue;
	
	/**
	 * 备注
	 */
	@TableField("mark")
	private String mark;
	
	




	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

	public void setGatwayName(String gatwayName) {
		this.gatwayName = gatwayName;
	}

	public String getGatwayName() {
		return this.gatwayName;
	}

	public void setGatwayValue(String gatwayValue) {
		this.gatwayValue = gatwayValue;
	}

	public String getGatwayValue() {
		return this.gatwayValue;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMark() {
		return this.mark;
	}

}
