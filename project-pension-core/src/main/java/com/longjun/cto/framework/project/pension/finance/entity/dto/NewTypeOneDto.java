package com.longjun.cto.framework.project.pension.finance.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * NewTypeOneModel
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
public class NewTypeOneDto extends BaseDTO {

	private static final long serialVersionUID = 1610157317613L;

	private String c_name ;

	private long c_parent_one_id=-10001;

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public long getC_parent_one_id() {
		return c_parent_one_id;
	}

	public void setC_parent_one_id(long c_parent_one_id) {
		this.c_parent_one_id = c_parent_one_id;
	}
}
