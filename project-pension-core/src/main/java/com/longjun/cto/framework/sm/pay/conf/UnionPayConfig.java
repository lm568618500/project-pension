package com.longjun.cto.framework.sm.pay.conf;

/**
 * 银联配置
 * 
 * @author yangxuan
 * @date Oct 30, 2019 - 4:23:05 PM
 */
public class UnionPayConfig {

	String pay_url;
	String query_url;
	String refund_url;
	String checkStr;
	String static_mer_id;
	String notifyUrl;
	String refundQuery;

	/**
	 * 异步通知加密串，需要跟银联保持一致
	 */
	String notifyHashOid;

	public String getRefundQuery() {
		return refundQuery;
	}

	public void setRefundQuery(String refundQuery) {
		this.refundQuery = refundQuery;
	}

	public String getNotifyHashOid() {
		return notifyHashOid;
	}

	public void setNotifyHashOid(String notifyHashOid) {
		this.notifyHashOid = notifyHashOid;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getPay_url() {
		return pay_url;
	}

	public void setPay_url(String pay_url) {
		this.pay_url = pay_url;
	}

	public String getQuery_url() {
		return query_url;
	}

	public void setQuery_url(String query_url) {
		this.query_url = query_url;
	}

	public String getRefund_url() {
		return refund_url;
	}

	public void setRefund_url(String refund_url) {
		this.refund_url = refund_url;
	}

	public String getCheckStr() {
		return checkStr;
	}

	public void setCheckStr(String checkStr) {
		this.checkStr = checkStr;
	}

	public String getStatic_mer_id() {
		return static_mer_id;
	}

	public void setStatic_mer_id(String static_mer_id) {
		this.static_mer_id = static_mer_id;
	}

}
