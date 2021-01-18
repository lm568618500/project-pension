package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CommonAreaModel
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
@TableName("t_common_area")
public class CommonAreaModel extends BaseModel<CommonAreaModel> {

	private static final long serialVersionUID = 1554372824433L;
	
	
	
	
	/**
	 * 使用ID
	 */
	@TableField("use_id")
	private long useId;
	
	/**
	 * 名称
	 */
	@TableField("name")
	private String name;
	
	/**
	 * 城市ID
	 */
	@TableField("city_id")
	private long cityId;
	
	
	



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

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public long getCityId() {
		return this.cityId;
	}


}
