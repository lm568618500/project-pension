package com.longjun.cto.framework.project.pension.finance.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;

/**
 * NewsModel
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
@TableName("t_news")
public class NewsModel extends BaseModel<NewsModel> {

	private static final long serialVersionUID = 1610157315661L;


	/**
	 * 一级菜单id
	 */
	@TableField("type_one_id")
	private Long typeOneId;

	/**
	 * 二级菜单id
	 */
	@TableField("type_two_id")
	private Long typeTwoId;
	
	/**
	 * 三级菜单id
	 */
	@TableField("type_three_id")
	private Long typeThreeId;
	
	/**
	 * 四级菜单id
	 */
	@TableField("type_four_id")
	private Long typeFourId;
	
	/**
	 * 新闻名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 名称英文
	 */
	@TableField("name_en")
	private String nameEn;
	/**
	 * 新闻描述
	 */
	@TableField("describes")
	private String describes;
	/**
	 * 新闻描述英文
	 */
	@TableField("describe_en")
	private String describeEn;

	/**
	 * 新闻内容
	 */
	@TableField("conten")
	private String conten;
	/**
	 * 新闻内容英文
	 */
	@TableField("conten_en")
	private String contenEn;

	/**
	 * 视频
	 */
	@TableField("video")
	private String video;
	
	/**
	 * 主图片
	 */
	@TableField("images")
	private String images;
	
	/**
	 * 图片合集
	 */
	@TableField("images_list")
	private String imagesList;
	
	
	
	
	/**
	 * 是否删除：1、是；0、否
	 */
	@TableField("is_del")
	private Integer isDel;
	
	/**
	 * 排序
	 */
	@TableField("sort")
	private Integer sort;
	
	/**
	 * 关联产品id(本新闻id)
	 */
	@TableField("relation_id")
	private String relationId;
	
	


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

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	public void setDescribeEn(String describeEn) {
		this.describeEn = describeEn;
	}

	public String getDescribes() {
		return describes;
	}

	public String getDescribeEn() {
		return describeEn;
	}
}
