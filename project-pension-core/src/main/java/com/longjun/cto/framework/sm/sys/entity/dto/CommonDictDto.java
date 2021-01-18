package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * 通用字典表Dto
 * 
 * @author jerry
 * @date 2018-11-29 10:03:22
 */
public class CommonDictDto extends BaseDTO {

	private static final long serialVersionUID = 1543457003162L;

	/**
	 * 分类
	 */
	private String c_type_id;

	/**
	 * 名称
	 */
	private String c_show_name;

	public String getC_type_id() {
		return c_type_id;
	}

	public void setC_type_id(String c_type_id) {
		this.c_type_id = c_type_id;
	}

	public String getC_show_name() {
		return c_show_name;
	}

	public void setC_show_name(String c_show_name) {
		this.c_show_name = c_show_name;
	}

}
