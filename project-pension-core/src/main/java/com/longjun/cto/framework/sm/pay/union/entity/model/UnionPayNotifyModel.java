package com.longjun.cto.framework.sm.pay.union.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UnionPayNotifyModel
 * @author yangxuan
 * @date 2019-10-30 07:39:42
 */
@TableName("t_union_pay_notify")
public class UnionPayNotifyModel extends BaseModel<UnionPayNotifyModel> {

	private static final long serialVersionUID = 1572435591335L;
	
	
	
	
	
	/**
	 * 删除状态 0正常 -1删除
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;
	
	/**
	 * 
	 */
	@TableField("header_version")
	private java.lang.String headerVersion;
	
	/**
	 * 
	 */
	@TableField("header_transtype")
	private java.lang.String headerTranstype;
	
	/**
	 * 
	 */
	@TableField("header_employno")
	private java.lang.String headerEmployno;
	
	/**
	 * 
	 */
	@TableField("header_termid")
	private java.lang.String headerTermid;
	
	/**
	 * 
	 */
	@TableField("header_request_time")
	private java.lang.String headerRequestTime;
	
	/**
	 * 
	 */
	@TableField("header_shopid")
	private java.lang.String headerShopid;
	
	/**
	 * 
	 */
	@TableField("header_wlid")
	private java.lang.String headerWlid;
	
	/**
	 * 运单号
	 */
	@TableField("body_orderno")
	private java.lang.String bodyOrderno;
	
	/**
	 * 代收款金额
	 */
	@TableField("body_cod")
	private java.math.BigDecimal bodyCod;
	
	/**
	 * 代收款支付方式
97 微信 98 支付宝 94 银联二 维码 CP chinapay 网关支付 
UP unionpay 网关支付 BB unionpay 企业网银支付 
	 */
	@TableField("body_payway")
	private java.lang.String bodyPayway;
	
	/**
	 * 系统参考号
	 */
	@TableField("body_banktrace")
	private java.lang.String bodyBanktrace;
	
	/**
	 * POS 机的流水号
	 */
	@TableField("body_postrace")
	private java.lang.String bodyPostrace;
	
	/**
	 * 交易时间
	 */
	@TableField("body_tracetime")
	private java.lang.String bodyTracetime;
	
	/**
	 * 卡号/支付号
	 */
	@TableField("body_cardid")
	private java.lang.String bodyCardid;
	
	/**
	 * 本人签收标记 0:本人签收 1:他人签收 

	 */
	@TableField("body_signflag")
	private java.lang.String bodySignflag;
	
	/**
	 * 
	 */
	@TableField("body_dssn")
	private java.lang.String bodyDssn;
	
	/**
	 * 
	 */
	@TableField("body_dsname")
	private java.lang.String bodyDsname;
	
	/**
	 * 
	 */
	@TableField("body_memo")
	private java.lang.String bodyMemo;
	
	/**
	 * 
	 */
	@TableField("body_query_id")
	private java.lang.String bodyQueryId;
	
	




	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setHeaderVersion(java.lang.String headerVersion) {
		this.headerVersion = headerVersion;
	}

	public java.lang.String getHeaderVersion() {
		return this.headerVersion;
	}

	public void setHeaderTranstype(java.lang.String headerTranstype) {
		this.headerTranstype = headerTranstype;
	}

	public java.lang.String getHeaderTranstype() {
		return this.headerTranstype;
	}

	public void setHeaderEmployno(java.lang.String headerEmployno) {
		this.headerEmployno = headerEmployno;
	}

	public java.lang.String getHeaderEmployno() {
		return this.headerEmployno;
	}

	public void setHeaderTermid(java.lang.String headerTermid) {
		this.headerTermid = headerTermid;
	}

	public java.lang.String getHeaderTermid() {
		return this.headerTermid;
	}

	public void setHeaderRequestTime(java.lang.String headerRequestTime) {
		this.headerRequestTime = headerRequestTime;
	}

	public java.lang.String getHeaderRequestTime() {
		return this.headerRequestTime;
	}

	public void setHeaderShopid(java.lang.String headerShopid) {
		this.headerShopid = headerShopid;
	}

	public java.lang.String getHeaderShopid() {
		return this.headerShopid;
	}

	public void setHeaderWlid(java.lang.String headerWlid) {
		this.headerWlid = headerWlid;
	}

	public java.lang.String getHeaderWlid() {
		return this.headerWlid;
	}

	public void setBodyOrderno(java.lang.String bodyOrderno) {
		this.bodyOrderno = bodyOrderno;
	}

	public java.lang.String getBodyOrderno() {
		return this.bodyOrderno;
	}

	public void setBodyCod(java.math.BigDecimal bodyCod) {
		this.bodyCod = bodyCod;
	}

	public java.math.BigDecimal getBodyCod() {
		return this.bodyCod;
	}

	public void setBodyPayway(java.lang.String bodyPayway) {
		this.bodyPayway = bodyPayway;
	}

	public java.lang.String getBodyPayway() {
		return this.bodyPayway;
	}

	public void setBodyBanktrace(java.lang.String bodyBanktrace) {
		this.bodyBanktrace = bodyBanktrace;
	}

	public java.lang.String getBodyBanktrace() {
		return this.bodyBanktrace;
	}

	public void setBodyPostrace(java.lang.String bodyPostrace) {
		this.bodyPostrace = bodyPostrace;
	}

	public java.lang.String getBodyPostrace() {
		return this.bodyPostrace;
	}

	public void setBodyTracetime(java.lang.String bodyTracetime) {
		this.bodyTracetime = bodyTracetime;
	}

	public java.lang.String getBodyTracetime() {
		return this.bodyTracetime;
	}

	public void setBodyCardid(java.lang.String bodyCardid) {
		this.bodyCardid = bodyCardid;
	}

	public java.lang.String getBodyCardid() {
		return this.bodyCardid;
	}

	public void setBodySignflag(java.lang.String bodySignflag) {
		this.bodySignflag = bodySignflag;
	}

	public java.lang.String getBodySignflag() {
		return this.bodySignflag;
	}

	public void setBodyDssn(java.lang.String bodyDssn) {
		this.bodyDssn = bodyDssn;
	}

	public java.lang.String getBodyDssn() {
		return this.bodyDssn;
	}

	public void setBodyDsname(java.lang.String bodyDsname) {
		this.bodyDsname = bodyDsname;
	}

	public java.lang.String getBodyDsname() {
		return this.bodyDsname;
	}

	public void setBodyMemo(java.lang.String bodyMemo) {
		this.bodyMemo = bodyMemo;
	}

	public java.lang.String getBodyMemo() {
		return this.bodyMemo;
	}

	public void setBodyQueryId(java.lang.String bodyQueryId) {
		this.bodyQueryId = bodyQueryId;
	}

	public java.lang.String getBodyQueryId() {
		return this.bodyQueryId;
	}

}
