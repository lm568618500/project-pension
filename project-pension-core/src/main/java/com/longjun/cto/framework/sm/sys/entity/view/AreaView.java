package com.longjun.cto.framework.sm.sys.entity.view;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * 区域视图
 * @author yangxuan
 * @date 2018年11月4日下午8:59:47
 */
public class AreaView{

	/**
	 * 使用ID
	 */
	private long useId;
	
	/**
	 * 名称
	 */
	private String name;

	
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

}
