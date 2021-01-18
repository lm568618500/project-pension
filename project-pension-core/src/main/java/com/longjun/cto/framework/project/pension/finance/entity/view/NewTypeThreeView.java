package com.longjun.cto.framework.project.pension.finance.entity.view;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * NewTypeThreeModel
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
public class NewTypeThreeView extends BaseView {

	private static final long serialVersionUID = 1610157316516L;
	
	
	/**
	 * 一级父节点id，默认为0
	 */
	private Long oneParentId;
	
	/**
	 * 二级父节点id，默认为0
	 */
	private Long twoParentId;
	
	/**
	 * 名称
	 */
	private String name;

	/**
	 * 名称英文
	 */
	private String nameEn;
	
	
	/**
	 * 是否删除：1、是；0、否
	 */
	private Integer isDel;
	
	/**
	 * 备注
	 */
	private String breaks;
	
	/**
	 * 排序
	 */
	private Integer sort;
	

	private String parentOneName;

	private String parentTwoName;




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

	public String getParentOneName() {
		return parentOneName;
	}

	public void setParentOneName(String parentOneName) {
		this.parentOneName = parentOneName;
	}

	public String getParentTwoName() {
		return parentTwoName;
	}

	public void setParentTwoName(String parentTwoName) {
		this.parentTwoName = parentTwoName;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
}
