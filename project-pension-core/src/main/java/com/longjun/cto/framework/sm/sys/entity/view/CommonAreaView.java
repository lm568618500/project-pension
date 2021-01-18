package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * CommonAreaModel
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
public class CommonAreaView extends BaseView {

	private static final long serialVersionUID = 1554372824725L;
	
	
	
	
	/**
	 * 使用ID
	 */
	private long useId;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 城市ID
	 */
	private long cityId;
	
	/**
	 * 城市名称
	 */
	private String cityName;
	
	/**
	 * 省份使用ID
	 */
	private long provinceId;
	
	/**
	 * 省份名称
	 */
	private String provinceName;
	

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

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
