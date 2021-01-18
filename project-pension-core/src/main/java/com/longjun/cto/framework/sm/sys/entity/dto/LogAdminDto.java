package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

public class LogAdminDto extends BaseDTO{
	
	private static final long serialVersionUID = -6363965285349815277L;
	
	private long c_eventUseId;
	
	private String c_keys;
	
	private String c_operaterName;
	
	private String c_eventContet;
	
	
	
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

	public String getC_keys() {
		return c_keys;
	}

	public void setC_keys(String c_keys) {
		this.c_keys = c_keys;
	}

	public long getC_eventUseId() {
		return c_eventUseId;
	}

	public void setC_eventUseId(long c_eventUseId) {
		this.c_eventUseId = c_eventUseId;
	}

	

}
