package com.longjun.cto.framework.sm.users.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * UserAttributeModel
 * @author qiujunbo
 * @date 2019-07-05 05:36:06
 */
public class UserAttributeModifyDto implements Serializable {

	private static final long serialVersionUID = 1562319369280L;
	
	/**
	 * ID
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
	 * 业务状态
	 */
	private java.lang.Integer status;
	/**
	 * 删除状态 0正常 -1删除
	 */
	private java.lang.Integer isDel;
	/**
	 * 用户ID
	 */
	private java.lang.Long userId;
	/**
	 * 属性分类(对应common_dict表 7000.兴趣分类)
	 */
	private java.lang.Integer attrType;
	/**
	 * 属性ID
	 */
	private java.lang.Long attrId;
	
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
	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}

	public java.lang.Long getUserId() {
		return this.userId;
	}
	public void setAttrType(java.lang.Integer attrType) {
		this.attrType = attrType;
	}

	public java.lang.Integer getAttrType() {
		return this.attrType;
	}
	public void setAttrId(java.lang.Long attrId) {
		this.attrId = attrId;
	}

	public java.lang.Long getAttrId() {
		return this.attrId;
	}
}
