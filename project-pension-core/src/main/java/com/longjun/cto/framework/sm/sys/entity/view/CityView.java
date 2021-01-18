package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.ArrayList;
import java.util.List;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * 城市视图
 * @author yangxuan
 * @date 2018年11月4日下午7:42:43
 */
public class CityView{

	
	/**
	 * 使用ID
	 */
	private long useId;
	
	/**
	 * 名称
	 */
	private String name;
	

	private List<AreaView> data = new ArrayList<AreaView>();

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

	public List<AreaView> getData() {
		return data;
	}

	public void setData(List<AreaView> data) {
		this.data = data;
	}
	
}
