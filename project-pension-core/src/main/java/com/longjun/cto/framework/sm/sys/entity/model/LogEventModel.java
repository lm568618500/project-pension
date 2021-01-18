package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * LogEventModel
 * 
 * @author yangxuan
 * @date 2019-04-09 01:48:27
 */
@TableName("t_log_event")
public class LogEventModel extends BaseModel<LogEventModel> {

	private static final long serialVersionUID = 1554788911205L;

	/**
	 * 所属模块
	 */
	@TableField("beyond_module")
	private String beyondModule;

	/**
	 * 使用ID
	 */
	@TableField("use_id")
	private long useId;

	/**
	 * 1管理员 2用户 3系统
	 */
	@TableField("e_type")
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
