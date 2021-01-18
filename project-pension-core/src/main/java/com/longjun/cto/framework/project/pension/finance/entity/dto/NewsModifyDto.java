package com.longjun.cto.framework.project.pension.finance.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * NewsModel
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
public class NewsModifyDto implements Serializable {

	private static final long serialVersionUID = 1610157315696L;
	
	/**
	 * id
	 */
	private Long id;
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
	 * 新闻内容
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
	 * 时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date time;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lastupdate;
	/**
	 * 状态
	 */
	private Integer status;
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
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}
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
	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return this.time;
	}
	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public Date getLastupdate() {
		return this.lastupdate;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
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

	public String getContenEn() {
		return contenEn;
	}

	public void setContenEn(String contenEn) {
		this.contenEn = contenEn;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getDescribes() {
		return describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	public String getDescribeEn() {
		return describeEn;
	}

	public void setDescribeEn(String describeEn) {
		this.describeEn = describeEn;
	}
}
