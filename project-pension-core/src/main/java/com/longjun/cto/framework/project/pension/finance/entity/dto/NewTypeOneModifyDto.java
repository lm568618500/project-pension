package com.longjun.cto.framework.project.pension.finance.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * NewTypeOneModel
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
public class NewTypeOneModifyDto implements Serializable {

	private static final long serialVersionUID = 1610157316459L;
	
	/**
	 * id
	 */
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 名称英文
	 */
	private String nameEn;
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


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
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

	public String getImageBanner() {
		return imageBanner;
	}

	public void setImageBanner(String imageBanner) {
		this.imageBanner = imageBanner;
	}
}
