package com.longjun.cto.framework.common.utils.yimeiSms.response;

import java.io.Serializable;


/**
 * 余额数据
 * @author Frank
 *
 */
public class BalanceResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long balance;// 余额


	public BalanceResponse() {

	}

	public BalanceResponse(long balance) {
		this.balance = balance;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

}
