package com.longjun.cto.framework.sm.pay.entity.dto;

import java.io.Serializable;

/**
 * 微信支付请求参数
 * @author yangxuan
 * @date 2019年4月12日 上午9:28:02
 */
public class WechatPayOrderRequestDto implements Serializable{

	private static final long serialVersionUID = 5894628861458647780L;
	
	
	
	/**
	 * 商品描述 	String(128)
	 */
	String native_body; 
	
	/**
	 * 附加数据 String(127)
	 */
	String native_attach; 
	
	/**
	 * 商户订单号 String(32)
	 */
	String native_out_trade_no;
	
	/**
	 * 标价金额 订单总金额，单位为分
	 */
	int native_total_fee;
	
	/**
	 * 通知地址 notify_url String(256)
	 */
	String native_notify_url;
	
	/**
	 * 终端IP spbill_create_ip String(64)
	 */
	String native_spbillCreateIp;
	
	/**
	 * 商品ID String(32) trade_type=NATIVE时，此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
	 */
	String native_productId;

	public String getNative_body() {
		return native_body;
	}

	public void setNative_body(String native_body) {
		this.native_body = native_body;
	}

	public String getNative_attach() {
		return native_attach;
	}

	public void setNative_attach(String native_attach) {
		this.native_attach = native_attach;
	}

	public String getNative_out_trade_no() {
		return native_out_trade_no;
	}

	public void setNative_out_trade_no(String native_out_trade_no) {
		this.native_out_trade_no = native_out_trade_no;
	}

	public int getNative_total_fee() {
		return native_total_fee;
	}

	public void setNative_total_fee(int native_total_fee) {
		this.native_total_fee = native_total_fee;
	}

	public String getNative_notify_url() {
		return native_notify_url;
	}

	public void setNative_notify_url(String native_notify_url) {
		this.native_notify_url = native_notify_url;
	}

	public String getNative_spbillCreateIp() {
		return native_spbillCreateIp;
	}

	public void setNative_spbillCreateIp(String native_spbillCreateIp) {
		this.native_spbillCreateIp = native_spbillCreateIp;
	}

	public String getNative_productId() {
		return native_productId;
	}

	public void setNative_productId(String native_productId) {
		this.native_productId = native_productId;
	}
	

}
