package com.longjun.cto.framework.sm.pay.logs;

/**
 * 支付api指令
 * 
 * @author yangxuan
 * @date Nov 7, 2019 - 5:53:17 PM
 */
public enum PayApiCmd {

	WECHAT_APP_PAY(100, "微信app支付"),
	WECHAT_NATIVE_PAY(101, "微信NATIVE支付"),
	WECHAT_MWEB_PAY(102, "微信MWEB支付"),
	WECHAT_MICROPAY_PAY(103, "微信MICROPAY支付"),
	WECHAT_QUERY(104, "微信QUERY"),
	WECHAT_CLOSE(105, "微信CLOSE交易关闭"),
	WECHAT_REFUND(106, "微信REFUND交易退款"),
	WECHAT_REFUNDQUERY(107, "微信REFUNDQUERY查询退款订单"),
	WECHAT_DOWNLOADBILL(108, "微信DOWNLOADBILL查询对账单"),

	ALIPAY_APP_PAY(200, "支付宝app支付"),
	
	ALIPAY_SWEEPPAY_PAY(201, "支付宝SWEEPPAY支付"),
	ALIPAY_PC_PAY(202, "支付宝PC网页支付"),
	ALIPAY_WAP_PAY(203, "支付宝WAP网页支付"),

	;

	private int cmd;

	private String name;

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	PayApiCmd(int cmd, String name) {
		this.cmd = cmd;
		this.name = name;
	}
}
