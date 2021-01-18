package com.longjun.cto.framework.project.pension.finance.entity.view;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * NewTypeTwoModel
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
public class NewTypeTwoView extends BaseView {

	private static final long serialVersionUID = 1610157313821L;
	
	
	/**
	 * 一级父节点id，默认为0
	 */
	private Long parentOneId;
	
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



	public void setParentOneId(Long parentOneId) {
		this.parentOneId = parentOneId;
	}

	public Long getParentOneId() {
		return this.parentOneId;
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

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
}
