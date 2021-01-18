package com.longjun.cto.framework.project.pension.userManagement.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * UsersModel
 * @author carson
 * @date 2019-10-19 07:48:34
 */
public class UsersDto extends BaseDTO {

	private static final long serialVersionUID = 1571485723984L;

	/**
	 * 界面属性
	 */
	private String c_view;

	/**
	 * 名称
	 */
	private String c_name;

	/**
	 * 证件号
	 */
	private String c_user_card_id;

	/**
	 * 类型
	 */
	private String	c_user_type;

	/**
	 * 审核状态（0 待审核 1 审核通过 2 审核不通过）
	 */
	private String c_audit_status;

	public String getC_audit_status() {
		return c_audit_status;
	}

	public void setC_audit_status(String c_audit_status) {
		this.c_audit_status = c_audit_status;
	}


	public String getC_view() {
		return c_view;
	}

	public void setC_view(String c_view) {
		this.c_view = c_view;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_user_card_id() {
		return c_user_card_id;
	}

	public void setC_user_card_id(String c_user_card_id) {
		this.c_user_card_id = c_user_card_id;
	}

	public String getC_user_type() {
		return c_user_type;
	}

	public void setC_user_type(String c_user_type) {
		this.c_user_type = c_user_type;
	}
}
