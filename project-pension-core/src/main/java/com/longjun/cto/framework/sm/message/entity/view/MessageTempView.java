package com.longjun.cto.framework.sm.message.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * MessageTempModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public class MessageTempView extends BaseView {

	private static final long serialVersionUID = 1554515960017L;
	
	
	
	
	
	/**
	 * 模板名称
	 */
	private String tempName;
	
	/**
	 * 模板使用ID
	 */
	private String tempUid;
	
	/**
	 * 模板类型
	 */
	private int tempType;
	
	/**
	 * 备注
	 */
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
