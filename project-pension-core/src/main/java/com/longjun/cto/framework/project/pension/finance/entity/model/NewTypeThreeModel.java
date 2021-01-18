package com.longjun.cto.framework.project.pension.finance.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;

/**
 * NewTypeThreeModel
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
@TableName("t_new_type_three")
public class NewTypeThreeModel extends BaseModel<NewTypeThreeModel> {

	private static final long serialVersionUID = 1610157316780L;
	
	
	/**
	 * 一级父节点id，默认为0
	 */
	@TableField("one_parent_id")
	private Long oneParentId;
	
	/**
	 * 二级父节点id，默认为0
	 */
	@TableField("two_parent_id")
	private Long twoParentId;
	
	/**
	 * 名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 名称英文
	 */
	@TableField("name_en")
	private String nameEn;
	
	
	/**
	 * 是否删除：1、是；0、否
	 */
	@TableField("is_del")
	private Integer isDel;
	
	/**
	 * 备注
	 */
	@TableField("breaks")
	private String breaks;
	
	/**
	 * 排序
	 */
	@TableField("sort")
	private Integer sort;
	
	

	public void setOneParentId(Long oneParentId) {
		this.oneParentId = oneParentId;
	}

	public Long getOneParentId() {
		return this.oneParentId;
	}

	public void setTwoParentId(Long twoParentId) {
		this.twoParentId = twoParentId;
	}

	public Long getTwoParentId() {
		return this.twoParentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}




	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setBreaks(String breaks) {
		this.breaks = breaks;
	}

	public String getBreaks() {
		return this.breaks;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
}
