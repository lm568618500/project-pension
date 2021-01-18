package com.longjun.cto.framework.sm.sys.entity.view;

import com.baomidou.mybatisplus.annotations.TableField;
import com.eims.cto.framework.module.base.model.BaseView;
import com.longjun.cto.framework.sm.sys.entity.model.CommonDictModel;

/**
 * 通用字典表View
 * 
 * @author jerry
 * @date 2018-11-30 14:01:05
 */
public class CommonDictView extends BaseView {

	private static final long serialVersionUID = 1543557665306L;

	public CommonDictView(CommonDictModel model) {
		// this.model = model;
		this.id = model.getId();
		this.typeId = model.getTypeId();
		this.useId = model.getUseId();
		this.showName = model.getShowName();
		this.useSort = model.getUseSort();
		this.isUse = model.getIsUse();
		this.description = model.getDescription();
		this.time = model.getTime();
		this.lastupdate = model.getLastupdate();
		this.status = model.getStatus();
		this.parentUseId = model.getParentUseId();
	}

	public CommonDictView() {

	}

	/**
	 * 类型，从关联t_common_type 字典表来
	 */
	private long typeId;

	/**
	 * 真实使用的ID
	 */
	private long useId;

	/**
	 * 
	 */
	private String showName;

	/**
	 * 排序字段
	 */
	private int useSort;

	/**
	 * 是否启用
	 */
	private int isUse;

	/**
	 * 描述
	 */
	private String description;

	private long parentUseId;

	public long getParentUseId() {
		return parentUseId;
	}

	public void setParentUseId(long parentUseId) {
		this.parentUseId = parentUseId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public long getTypeId() {
		return this.typeId;
	}

	public void setUseId(long useId) {
		this.useId = useId;
	}

	public long getUseId() {
		return this.useId;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getShowName() {
		return this.showName;
	}

	public void setUseSort(int useSort) {
		this.useSort = useSort;
	}

	public int getUseSort() {
		return this.useSort;
	}

	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}

	public int getIsUse() {
		return this.isUse;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

}
