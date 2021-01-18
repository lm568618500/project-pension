package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * LogEventModel
 * @author yangxuan
 * @date 2019-04-09 01:48:27
 */
public class LogEventView extends BaseView {

	private static final long serialVersionUID = 1554788915131L;
	
	
	
	/**
	 * 所属模块
	 */
	private String beyondModule;
	
	/**
	 * 使用ID
	 */
	private long useId;
	
	/**
	 *  1管理员 2用户 3系统
	 */
	private int eType;
	
	
	
	


	public void setBeyondModule(String beyondModule) {
		this.beyondModule = beyondModule;
	}

	public String getBeyondModule() {
		return this.beyondModule;
	}

	public void setUseId(long useId) {
		this.useId = useId;
	}

	public long getUseId() {
		return this.useId;
	}

	public void setEType(int eType) {
		this.eType = eType;
	}

	public int getEType() {
		return this.eType;
	}



}
