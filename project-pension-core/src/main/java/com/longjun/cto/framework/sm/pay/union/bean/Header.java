package com.longjun.cto.framework.sm.pay.union.bean;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Auto-generated: 2019-10-30 18:7:42
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class Header {

	private String version;
	private String transtype;
	private String employno;
	private String termid;
	@JsonProperty("request_time")
	private String requestTime;
	private String shopid;
	private String wlid;

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}

	public String getTranstype() {
		return transtype;
	}

	public void setEmployno(String employno) {
		this.employno = employno;
	}

	public String getEmployno() {
		return employno;
	}

	public void setTermid(String termid) {
		this.termid = termid;
	}

	public String getTermid() {
		return termid;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}

	public String getShopid() {
		return shopid;
	}

	public void setWlid(String wlid) {
		this.wlid = wlid;
	}

	public String getWlid() {
		return wlid;
	}

}