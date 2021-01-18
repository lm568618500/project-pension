package com.longjun.cto.framework.project.pension.finance.entity.view;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * NewsModel
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
public class NewsView extends BaseView {

	private static final long serialVersionUID = 1610157311415L;


	/**
	 * 一级菜单id
	 */
	private Long typeOneId;

	/**
	 * 二级菜单id
	 */
	private Long typeTwoId;

	/**
	 * 三级菜单id
	 */
	private Long typeThreeId;

	/**
	 * 四级菜单id
	 */
	private Long typeFourId;
	
	/**
	 * 新闻名称
	 */
	private String name;

	/**
	 * 名称英文
	 */
	private String nameEn;
	/**
	 * 新闻描述
	 */
	private String describes;
	/**
	 * 新闻描述英文
	 */
	private String describeEn;


	/**
	 * 新闻内容
	 */
	private String conten;
	/**
	 * 新闻内容英文
	 */
	private String contenEn;

	/**
	 * 视频
	 */
	private String video;
	
	/**
	 * 主图片
	 */
	private String images;
	
	/**
	 * 图片合集
	 */
	private String imagesList;

	/**
	 * 是否删除：1、是；0、否
	 */
	private Integer isDel;
	
	/**
	 * 排序
	 */
	private Integer sort;
	
	/**
	 * 关联产品id(本新闻id)
	 */
	private String relationId;

	private String parentOneName;

	private String parentTwoName;

	private String parentThreeName;

	private String parentFourName;

	public void setTypeTwoId(Long typeTwoId) {
		this.typeTwoId = typeTwoId;
	}

	public Long getTypeTwoId() {
		return this.typeTwoId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setConten(String conten) {
		this.conten = conten;
	}

	public String getConten() {
		return this.conten;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getVideo() {
		return this.video;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getImages() {
		return this.images;
	}

	public void setImagesList(String imagesList) {
		this.imagesList = imagesList;
	}

	public String getImagesList() {
		return this.imagesList;
	}




	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public String getRelationId() {
		return this.relationId;
	}

	public Long getTypeOneId() {
		return typeOneId;
	}

	public void setTypeOneId(Long typeOneId) {
		this.typeOneId = typeOneId;
	}

	public Long getTypeThreeId() {
		return typeThreeId;
	}

	public void setTypeThreeId(Long typeThreeId) {
		this.typeThreeId = typeThreeId;
	}

	public Long getTypeFourId() {
		return typeFourId;
	}

	public void setTypeFourId(Long typeFourId) {
		this.typeFourId = typeFourId;
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

	public String getParentThreeName() {
		return parentThreeName;
	}

	public void setParentThreeName(String parentThreeName) {
		this.parentThreeName = parentThreeName;
	}

	public String getParentFourName() {
		return parentFourName;
	}

	public void setParentFourName(String parentFourName) {
		this.parentFourName = parentFourName;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getContenEn() {
		return contenEn;
	}

	public void setContenEn(String contenEn) {
		this.contenEn = contenEn;
	}

	public String getDescribeEn() {
		return describeEn;
	}

	public void setDescribeEn(String describeEn) {
		this.describeEn = describeEn;
	}

	public String getDescribes() {
		return describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}
}
