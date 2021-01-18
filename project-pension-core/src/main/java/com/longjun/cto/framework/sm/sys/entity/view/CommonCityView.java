package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * CommonCityModel
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
public class CommonCityView extends BaseView {

	private static final long serialVersionUID = 1554372819620L;
	
	
	
	
	/**
	 * 试用ID
	 */
	private long useId;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 省份UseId
	 */
	private long provinceId;
	
	/**
	 * 省份名称
	 */
	private String provinceName;
	
	/**
	 * 邮编
	 */
	private String zipcode;
	

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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

	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}

	public long getProvinceId() {
		return this.provinceId;
	}


}
