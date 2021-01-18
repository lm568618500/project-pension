package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.ArrayList;
import java.util.List;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * 省- 视图
 * 
 * @author yangxuan
 * @date 2018年11月4日上午11:14:35
 */
public class CommonProvinceItemView extends BaseView {

	private static final long serialVersionUID = -225204298463689236L;

	/**
	 * 使用ID
	 */
	private long useId;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 邮编
	 */
	private String zipcode;

	/**
	 * 状态
	 */
	
	private List<CommonCityView> citys = new ArrayList<CommonCityView>();
	
	private int status;

	public long getUseId() {
		return useId;
	}

	public void setUseId(long useId) {
		this.useId = useId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public List<CommonCityView> getCitys() {
		return citys;
	}

	public void setCitys(List<CommonCityView> citys) {
		this.citys = citys;
	}

}
