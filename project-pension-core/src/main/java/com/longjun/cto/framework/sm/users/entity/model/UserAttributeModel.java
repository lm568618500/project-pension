package com.longjun.cto.framework.sm.users.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserAttributeModel
 * @author qiujunbo
 * @date 2019-07-05 05:36:06
 */
@TableName("t_user_attribute")
public class UserAttributeModel extends BaseModel<UserAttributeModel> {

	private static final long serialVersionUID = 1562319370351L;
	
	
	
	
	
	/**
	 * 删除状态 0正常 -1删除
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;
	
	/**
	 * 用户ID
	 */
	@TableField("user_id")
	private java.lang.Long userId;
	
	/**
	 * 属性分类(对应common_dict表 7000.兴趣分类)
	 */
	@TableField("attr_type")
	private java.lang.Integer attrType;
	
	/**
	 * 属性ID
	 */
	@TableField("attr_id")
	private java.lang.Long attrId;
	
	




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
