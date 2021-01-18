package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * CommonVerificationTypeModel
 * 
 * @author yangxuan
 * @date 2019-06-04 05:50:42
 */
public class CommonVerificationTypeView extends BaseView {

	private static final long serialVersionUID = 1559641849804L;

	/**
	 * 是否删除 0 正常 -1删除
	 */
	private java.lang.Integer isDel;

	/**
	 * 类型名称
	 */
	private java.lang.String typeName;

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
