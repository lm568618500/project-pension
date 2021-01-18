package com.longjun.cto.framework.sm.sys.entity.view;

import com.baomidou.mybatisplus.annotations.TableField;
import com.eims.cto.framework.module.base.model.BaseView;
import com.longjun.cto.framework.sm.sys.entity.model.CommonBanksModel;

/**
 * 通用-银行表View
 * @author yangxuan
 * @date 2018-11-24 13:39:27
 */
public class CommonBanksView extends BaseView {

	private static final long serialVersionUID = 1543037968130L;

	public CommonBanksView(CommonBanksModel model) {
		// this.model = model;
		this.id = model.getId();
		this.time = model.getTime();
		this.bankCode = model.getBankCode();
		this.bankName = model.getBankName();
		this.bankLogo = model.getBankLogo();
		this.sort = model.getSort();
		this.lastupdate = model.getLastupdate();
		this.status = model.getStatus();
		this.cash = model.getCash();
		this.withdraw = model.getWithdraw();
	}

	public CommonBanksView() {

	}

	// @TableField(exist = false)
	// private CommonBanksModel model;

	// public CommonBanksModel getModel() {
	// return this.model;
	// }

	// public void setModel(CommonBanksModel model) {
	// this.model = model;
	// }

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
