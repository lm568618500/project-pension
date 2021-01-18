package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * 管理员Dto
 * 
 * @author lp
 * @date 2018-12-20 20:10:49
 */
public class AdminDto extends BaseDTO {

	private static final long serialVersionUID = 1545307849401L;

	// 在这里定义分页查询额外的条件
	private Object param;

	// 账号
	private String c_account;

	// 姓名
	private String c_realName;
	// 手机
	private String c_mobile;
	// 邮箱
	private String c_email;
	//领域
	private String c_admin_other;
	//'类型：1技术专家',
	private int[] c_types;

	public int[] getC_types() {
		return c_types;
	}

	public void setC_types(int[] c_types) {
		this.c_types = c_types;
	}

	public String getC_account() {
		return c_account;
	}

	public void setC_account(String c_account) {
		this.c_account = c_account;
	}

	public String getC_realName() {
		return c_realName;
	}

	public void setC_realName(String c_realName) {
		this.c_realName = c_realName;
	}

	
	public String getC_admin_other() {
		return c_admin_other;
	}

	public void setC_admin_other(String c_admin_other) {
		this.c_admin_other = c_admin_other;
	}

	public String getC_mobile() {
		return c_mobile;
	}

	public void setC_mobile(String c_mobile) {
		this.c_mobile = c_mobile;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	/**
	 * @return the param
	 */
	public Object getParam() {
		return param;
	}

	/**
	 * @param param the param to set
	 */
	public void setParam(Object param) {
		this.param = param;
	}

}
