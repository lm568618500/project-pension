package com.longjun.cto.framework.project.pension.finance.entity.view;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * NewTypeOneModel
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
public class NewTypeOneView extends BaseView {

	private static final long serialVersionUID = 1610157317999L;
	
	
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

	/**
	 * 图片
	 */
	private String image;

	/**
	 * 图片
	 */
	private String imageBanner;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNameEn() {
		return nameEn;
	}

	public String getImageBanner() {
		return imageBanner;
	}

	public void setImageBanner(String imageBanner) {
		this.imageBanner = imageBanner;
	}
}
