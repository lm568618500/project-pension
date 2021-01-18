package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * 通用-银行表Dto
 * @author yangxuan
 * @date 2018-11-24 13:39:27
 */
public class CommonBanksDto extends BaseDTO {

	private static final long serialVersionUID = 1543037968147L;

	/**
	 * 银行代码/银行名称
	 */
	private String c_codeOrName;

	/**
	 * 充值状态
	 */
	private int c_cash = -10001;

	/**
	 * 提现状态
	 */
	private int c_withdraw = -10001;

	public String getC_codeOrName() {
		return c_codeOrName;
	}

	public void setC_codeOrName(String c_codeOrName) {
		this.c_codeOrName = c_codeOrName;
	}

	public int getC_cash() {
		return c_cash;
	}

	public void setC_cash(int c_cash) {
		this.c_cash = c_cash;
	}

	public int getC_withdraw() {
		return c_withdraw;
	}

	public void setC_withdraw(int c_withdraw) {
		this.c_withdraw = c_withdraw;
	}

}
