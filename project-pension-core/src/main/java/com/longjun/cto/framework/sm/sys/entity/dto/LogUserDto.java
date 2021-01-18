package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

public class LogUserDto extends BaseDTO{

	private static final long serialVersionUID = -5101785781956711553L;
	
	/**
	 * 操作人
	 */
	private String c_operaterName;
	
	/**
	 * 事件内容
	 */
	private String c_eventContet;

	/**
	 * 操作模块
	 */
	private long c_eventUseId;
	
	public long getC_eventUseId() {
		return c_eventUseId;
	}

	public void setC_eventUseId(long c_eventUseId) {
		this.c_eventUseId = c_eventUseId;
	}

	public String getC_operaterName() {
		return c_operaterName;
	}

	public void setC_operaterName(String c_operaterName) {
		this.c_operaterName = c_operaterName;
	}

	public String getC_eventContet() {
		return c_eventContet;
	}

	public void setC_eventContet(String c_eventContet) {
		this.c_eventContet = c_eventContet;
	}
	
	

}
