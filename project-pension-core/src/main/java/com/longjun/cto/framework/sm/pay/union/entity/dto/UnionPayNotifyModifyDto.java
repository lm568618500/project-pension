package com.longjun.cto.framework.sm.pay.union.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * UnionPayNotifyModel
 * @author yangxuan
 * @date 2019-10-30 07:39:43
 */
public class UnionPayNotifyModifyDto implements Serializable {

	private static final long serialVersionUID = 1572435584673L;
	
	/**
	 * 
	 */
	private java.lang.Long id;
	/**
	 * 
	 */
	private java.lang.Integer status;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 最后修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 删除状态 0正常 -1删除
	 */
	private java.lang.Integer isDel;
	/**
	 * 
	 */
	private java.lang.String headerVersion;
	/**
	 * 
	 */
	private java.lang.String headerTranstype;
	/**
	 * 
	 */
	private java.lang.String headerEmployno;
	/**
	 * 
	 */
	private java.lang.String headerTermid;
	/**
	 * 
	 */
	private java.lang.String headerRequestTime;
	/**
	 * 
	 */
	private java.lang.String headerShopid;
	/**
	 * 
	 */
	private java.lang.String headerWlid;
	/**
	 * 运单号
	 */
	private java.lang.String bodyOrderno;
	/**
	 * 代收款金额
	 */
	private java.math.BigDecimal bodyCod;
	/**
	 * 代收款支付方式
97 微信 98 支付宝 94 银联二 维码 CP chinapay 网关支付 
UP unionpay 网关支付 BB unionpay 企业网银支付 
	 */
	private java.lang.String bodyPayway;
	/**
	 * 系统参考号
	 */
	private java.lang.String bodyBanktrace;
	/**
	 * POS 机的流水号
	 */
	private java.lang.String bodyPostrace;
	/**
	 * 交易时间
	 */
	private java.lang.String bodyTracetime;
	/**
	 * 卡号/支付号
	 */
	private java.lang.String bodyCardid;
	/**
	 * 本人签收标记 0:本人签收 1:他人签收 

	 */
	private java.lang.String bodySignflag;
	/**
	 * 
	 */
	private java.lang.String bodyDssn;
	/**
	 * 
	 */
	private java.lang.String bodyDsname;
	/**
	 * 
	 */
	private java.lang.String bodyMemo;
	/**
	 * 
	 */
	private java.lang.String bodyQueryId;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public java.util.Date getTime() {
		return this.time;
	}
	public void setLastupdate(java.util.Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public java.util.Date getLastupdate() {
		return this.lastupdate;
	}
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
