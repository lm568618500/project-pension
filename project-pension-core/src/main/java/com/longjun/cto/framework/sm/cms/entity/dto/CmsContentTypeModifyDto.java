package com.longjun.cto.framework.sm.cms.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * CmsContentTypeModel
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
public class CmsContentTypeModifyDto implements Serializable {

	private static final long serialVersionUID = 1560848122736L;
	
	/**
	 * 
	 */
	private java.lang.Long id;
	/**
	 * 添加时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 状态
	 */
	private java.lang.Integer status;
	/**
	 * 是否删除 0正常 -1删除
	 */
	private java.lang.Integer isDel;
	/**
	 * 类型名称
	 */
	private java.lang.String typeName;
	/**
	 * 是否推荐首页
	 */
	private java.lang.Integer isRecommond;
	/**
	 * 父类ID
	 */
	private java.lang.Long parentId;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public java.util.Date getTime() {
		return this.time;
	}
	public void setLastupdate(java.util.Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public java.util.Date getLastupdate() {
		return this.lastupdate;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}
	public void setTypeName(java.lang.String typeName) {
		this.typeName = typeName;
	}

	public java.lang.String getTypeName() {
		return this.typeName;
	}
	public void setIsRecommond(java.lang.Integer isRecommond) {
		this.isRecommond = isRecommond;
	}

	public java.lang.Integer getIsRecommond() {
		return this.isRecommond;
	}
	public void setParentId(java.lang.Long parentId) {
		this.parentId = parentId;
	}

	public java.lang.Long getParentId() {
		return this.parentId;
	}
}
