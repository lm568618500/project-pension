package com.longjun.cto.framework.sm.cms.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CmsContentTypeModel
 * 
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
@TableName("t_cms_content_type")
public class CmsContentTypeModel extends BaseModel<CmsContentTypeModel> {

	private static final long serialVersionUID = 1560848120160L;

	/**
	 * 是否删除 0正常 -1删除
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;

	/**
	 * 类型名称
	 */
	@TableField("type_name")
	private java.lang.String typeName;

	/**
	 * 是否推荐首页
	 */
	@TableField("is_recommond")
	private java.lang.Integer isRecommond;

	/**
	 * 父类ID
	 */
	@TableField("parent_id")
	private java.lang.Long parentId;

	/**
	 * 类别ID
	 */
	@TableField("class_id")
	private java.lang.Long classId;

	/**
	 * 类别名称
	 */
	@TableField("class_name")
	private java.lang.String className;

	public java.lang.Long getClassId() {
		return classId;
	}

	public void setClassId(java.lang.Long classId) {
		this.classId = classId;
	}

	public java.lang.String getClassName() {
		return className;
	}

	public void setClassName(java.lang.String className) {
		this.className = className;
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
