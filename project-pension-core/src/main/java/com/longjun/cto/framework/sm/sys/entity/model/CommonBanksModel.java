package com.longjun.cto.framework.sm.sys.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;

/**
 * 通用-银行表Model
 * @author yangxuan
 * @date 2018-11-24 13:39:27
 */
@TableName("t_common_banks")
public class CommonBanksModel extends BaseModel<CommonBanksModel> {

	private static final long serialVersionUID = 1543037967778L;

	/**
	 * 
	 */
	@TableField("bank_code")
	private String bankCode;

	/**
	 * 
	 */
	@TableField("bank_name")
	private String bankName;

	/**
	 * 
	 */
	@TableField("bank_logo")
	private String bankLogo;

	/**
	 * 
	 */
	@TableField("sort")
	private int sort;

	/**
	 * 1支持充值 0 不支持充值
	 */
	@TableField("cash")
	private int cash;

	/**
	 * 1支持提现 0 不支持提现
	 */
	@TableField("withdraw")
	private int withdraw;

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankLogo(String bankLogo) {
		this.bankLogo = bankLogo;
	}

	public String getBankLogo() {
		return this.bankLogo;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getSort() {
		return this.sort;
	}

}
