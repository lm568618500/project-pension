package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CommonVerificationTypeModel
 * 
 * @author yangxuan
 * @date 2019-06-04 05:50:40
 */
@TableName("t_common_verification_type")
public class CommonVerificationTypeModel extends BaseModel<CommonVerificationTypeModel> {

	private static final long serialVersionUID = 1559641849555L;

	/**
	 * 是否删除 0 正常 -1删除
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;

	/**
	 * 类型名称
	 */
	@TableField("type_name")
	private java.lang.String typeName;

	/**
	 * 超时单位(秒) ;
	 */
	@TableField("expire_unit")
	private Long expireUnit;

	public Long getExpireUnit() {
		return expireUnit;
	}

	public void setExpireUnit(Long expireUnit) {
		this.expireUnit = expireUnit;
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

}
