package com.longjun.cto.framework.sm.message.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * MessageGatwayModel
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
public class MessageGatwayView extends BaseView {

	private static final long serialVersionUID = 1554457193830L;
	
	
	
	
	
	/**
	 * 是否删除 0 正常 -1删除
	 */
	private int isDel;
	
	/**
	 * 网关名称
	 */
	private String gatwayName;
	
	/**
	 * 网关值
	 */
	private String gatwayValue;
	
	/**
	 * 备注
	 */
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
