package com.longjun.cto.framework.sm.pay.union.bean;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Auto-generated: 2019-10-30 18:7:42
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
public class Body {

	private String orderno;
	private String cod;
	private String payway;
	private String banktrace;
	private String postrace;
	private String tracetime;
	private String cardid;
	private String signflag;
	private String dssn;
	private String dsname;
	private String memo;
	@JsonProperty("queryId")
	private String queryid;

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getCod() {
		return cod;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}

	public String getPayway() {
		return payway;
	}

	public void setBanktrace(String banktrace) {
		this.banktrace = banktrace;
	}

	public String getBanktrace() {
		return banktrace;
	}

	public void setPostrace(String postrace) {
		this.postrace = postrace;
	}

	public String getPostrace() {
		return postrace;
	}

	public void setTracetime(String tracetime) {
		this.tracetime = tracetime;
	}

	public String getTracetime() {
		return tracetime;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getCardid() {
		return cardid;
	}

	public void setSignflag(String signflag) {
		this.signflag = signflag;
	}

	public String getSignflag() {
		return signflag;
	}

	public void setDssn(String dssn) {
		this.dssn = dssn;
	}

	public String getDssn() {
		return dssn;
	}

	public void setDsname(String dsname) {
		this.dsname = dsname;
	}

	public String getDsname() {
		return dsname;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMemo() {
		return memo;
	}

	public void setQueryid(String queryid) {
		this.queryid = queryid;
	}

	public String getQueryid() {
		return queryid;
	}

}