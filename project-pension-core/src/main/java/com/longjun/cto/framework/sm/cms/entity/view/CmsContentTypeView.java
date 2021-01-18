package com.longjun.cto.framework.sm.cms.entity.view;

import java.util.List;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * CmsContentTypeModel
 * 
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
public class CmsContentTypeView extends BaseView {

	private static final long serialVersionUID = 1560848122438L;

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

	/**
	 * 类别ID
	 */
	private java.lang.Long classId;

	/**
	 * 类别名称
	 */
	private java.lang.String className;

	/**
	 * 内容集合
	 */
	private List<CmsContentView> cmsConentList;

	public List<CmsContentView> getCmsConentList() {
		return cmsConentList;
	}

	public void setCmsConentList(List<CmsContentView> cmsConentList) {
		this.cmsConentList = cmsConentList;
	}

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
