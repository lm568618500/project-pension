package com.longjun.cto.framework.project.pension.finance.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;

import java.util.List;

/**
 * NewTypeOneModel
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
@TableName("t_new_type_one")
public class NewTypeOneModel extends BaseModel<NewTypeOneModel> {

	private static final long serialVersionUID = 1610157312463L;
	
	
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

	/**
	 * 图片
	 */
	@TableField("image")
	private String image;

	/**
	 * 图片
	 */
	@TableField("image_banner")
	private String imageBanner;

	/**
	 * 二级分类（web首页用）
	 */
	@TableField(exist = false)
	private List<NewTypeTwoModel> twoList;
	

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

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getImageBanner() {
		return imageBanner;
	}

	public void setImageBanner(String imageBanner) {
		this.imageBanner = imageBanner;
	}

	public List<NewTypeTwoModel> getTwoList() {
		return twoList;
	}

	public void setTwoList(List<NewTypeTwoModel> twoList) {
		this.twoList = twoList;
	}
}
