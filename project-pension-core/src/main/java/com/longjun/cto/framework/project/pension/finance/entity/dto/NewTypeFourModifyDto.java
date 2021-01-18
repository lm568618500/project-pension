package com.longjun.cto.framework.project.pension.finance.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * NewTypeFourModel
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
public class NewTypeFourModifyDto implements Serializable {

	private static final long serialVersionUID = 1610157315326L;
	
	/**
	 * id
	 */
	private Long id;
	/**
	 * 一级父节点id，默认为0
	 */
	private Long oneParentId;
	/**
	 * 二级父节点id，默认为0
	 */
	private Long twoParentId;
	/**
	 * 三级父节点id，默认为0
	 */
	private Long threeParentId;
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
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}
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
	public void setThreeParentId(Long threeParentId) {
		this.threeParentId = threeParentId;
	}

	public Long getThreeParentId() {
		return this.threeParentId;
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

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
}
