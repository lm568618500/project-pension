package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * 广告条信息表Dto
 * @author heqiang
 * @date 2018-12-08 08:44:03
 */
public class BannerDto extends BaseDTO {

	private static final long serialVersionUID = 1544229843818L;

	protected int c_type = -10001;
	
	protected String name;
	
	protected int plateId = -10001;

	public int getC_type() {
		return c_type;
	}

	public void setC_type(int c_type) {
		this.c_type = c_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}

}
