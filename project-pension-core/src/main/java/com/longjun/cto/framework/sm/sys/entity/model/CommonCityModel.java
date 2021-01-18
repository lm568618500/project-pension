package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CommonCityModel
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
@TableName("t_common_city")
public class CommonCityModel extends BaseModel<CommonCityModel> {

	private static final long serialVersionUID = 1554372822655L;
	
	
	
	
	/**
	 * 试用ID
	 */
	@TableField("use_id")
	private long useId;
	
	/**
	 * 名称
	 */
	@TableField("name")
	private String name;
	
	/**
	 * 省份UseId
	 */
	@TableField("province_id")
	private long provinceId;
	
	
	



	public void setUseId(long useId) {
		this.useId = useId;
	}

	public long getUseId() {
		return this.useId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}

	public long getProvinceId() {
		return this.provinceId;
	}


}
