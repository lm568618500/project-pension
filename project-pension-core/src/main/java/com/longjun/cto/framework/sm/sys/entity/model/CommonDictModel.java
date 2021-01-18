package com.longjun.cto.framework.sm.sys.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;

/**
 * 通用字典表Model
 * 
 * @author jerry
 * @date 2018-11-30 14:01:05
 */
@TableName("t_common_dict")
public class CommonDictModel extends BaseModel<CommonDictModel> {

	private static final long serialVersionUID = 1543557665041L;

	/**
	 * 类型，从关联t_common_type 字典表来
	 */
	@TableField("type_id")
	private Long typeId;

	/**
	 * 真实使用的ID
	 */
	@TableField("use_id")
	private Long useId;

	/**
	 * 
	 */
	@TableField("show_name")
	private String showName;

	/**
	 * 排序字段
	 */
	@TableField("use_sort")
	private Integer useSort;

	/**
	 * 是否启用
	 */
	@TableField("is_use")
	private Integer isUse;

	/**
	 * 描述
	 */
	@TableField("description")
	private String description;

	/**
	 * 父ID
	 */
	@TableField("parent_use_id")
	private Long parentUseId;

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getUseId() {
		return useId;
	}

	public void setUseId(Long useId) {
		this.useId = useId;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Integer getUseSort() {
		return useSort;
	}

	public void setUseSort(Integer useSort) {
		this.useSort = useSort;
	}

	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getParentUseId() {
		return parentUseId;
	}

	public void setParentUseId(Long parentUseId) {
		this.parentUseId = parentUseId;
	}

}
