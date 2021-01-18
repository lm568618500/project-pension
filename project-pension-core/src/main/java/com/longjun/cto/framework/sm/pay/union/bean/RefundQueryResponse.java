package com.longjun.cto.framework.sm.pay.union.bean;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Auto-generated: 2019-11-02 14:5:53
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class RefundQueryResponse {

	private String code;
	private String msg;
	@JsonProperty("refundTime")
	private String refundtime;
	@JsonProperty("refundStatus")
	private String refundstatus;
	@JsonProperty("refundAmount")
	private String refundamount;
	private String mac;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setRefundtime(String refundtime) {
		this.refundtime = refundtime;
	}

	public String getRefundtime() {
		return refundtime;
	}

	public void setRefundstatus(String refundstatus) {
		this.refundstatus = refundstatus;
	}

	public String getRefundstatus() {
		return refundstatus;
	}

	public void setRefundamount(String refundamount) {
		this.refundamount = refundamount;
	}

	public String getRefundamount() {
		return refundamount;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getMac() {
		return mac;
	}

}