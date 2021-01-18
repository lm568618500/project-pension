package com.longjun.cto.framework.sm.pay.union.entity.model;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UnionPayModel
 * 
 * @author yangxuan
 * @date 2019-10-30 04:21:52
 */
@TableName("t_union_pay")
public class UnionPayModel extends BaseModel<UnionPayModel> {

	private static final long serialVersionUID = 1572423719704L;

	/**
	 * 删除状态 0正常 -1删除
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;

	/**
	 * 银联订单号
	 */
	@TableField("order_no")
	private java.lang.String orderNo;

	/**
	 * 商户业务订单号,选填:业务订单号，支付通知会回传
	 */
	@TableField("busi_order_no")
	private java.lang.String busiOrderNo;

	/**
	 * 商户ID
	 */
	@TableField("mer_id")
	private java.lang.String merId;

	/**
	 * 金额单位元
	 */
	@TableField("cod")
	private BigDecimal cod;

	/**
	 * 使用方式: 1.qrtype=qr 扫码 支付使用; 2.qrtype=h5 手机 网站调起支付宝 微信支付(咨询 大华技术人员进 行使用);3.
	 * qrtype=gzh在 微信公众号内进 行支付; 4.qrtype=app 商 户 app 集成银商app 支付插件， 调用微信支付宝 云闪付支付5.
	 * qrtype=uac银联全渠道,无卡 支付和企业网银 6.qrtype=xcx 微 信小程序支付;
	 */
	@TableField("qrtype")
	private java.lang.String qrtype;

	/**
	 * 支付方式非必填，不填时直接跳转相应支付页面。 当指定支付方式 97，98，94 时一般是程 序已经运行在相应的 app 内的公众号支 付和 h5
	 * 支付时需要唤醒哪种 app 而使用 97:微信, 98:支付宝, 94:云闪付
	 */
	@TableField("payway")
	private java.lang.String payway;

	/**
	 * 备注
	 */
	@TableField("memo")
	private java.lang.String memo;

	/**
	 * 订单信息 非必填，为空时支付完成后展示的商户 名称
	 */
	@TableField("order_desc")
	private java.lang.String orderDesc;

	/**
	 * 微信用户 id 微信小程序必填
	 */
	@TableField("sub_open_id")
	private java.lang.String subOpenId;

	/**
	 * 分账编码 选填，实时分账使用，大华约定该编码 来配置对应分账的商户号，自动计算分 账金额(如果使用该编码进行分账，不 需要传递 subOrders 和
	 * platformAmount)
	 */
	@TableField("dscode")
	private java.lang.String dscode;

	/**
	 * 分账编码 (分账方案二)选填，此电商分账方式与 pos 机的分账 规则一样，只适合 2 方分账(支持全分， 按定比例分，按数量分，按固定金额分)，
	 * 如果商户的分账金额涉及到商户系统的 积分、折扣等，又不能使用平台和子商 户关联分账，可以使用 fee 参数，商户自 行计算分账金额
	 */
	@TableField("biz_code")
	private java.lang.String bizCode;

	/**
	 * 分账金额 (适合电商分账， 银商业务)非必填,单位元，保留 2 位小数，选填 根据 bizCode 配置的商户的分账金额，传 递该参数后,实际支付金额就是
	 * cod 和 fee 之和
	 */
	@TableField("fee")
	private BigDecimal fee;

	/**
	 * 选填，分账使用，不分账不用传递， [{‘mid’:’123456789012345’,’totalAmount
	 * ’:’200’}]，其中totalAmount的单位是分， 所 有 的 totalAmount+
	 * platformAmount=cod*100，中间涉及到的 单位商户可以自行处理一下(如果使用 subOrders 商户自己传递分账商户明细，
	 * platformAmount 必传，dscode 不传递)
	 */
	@TableField("sub_orders")
	private java.lang.String subOrders;

	/**
	 * 平台金额，单位 分
	 */
	@TableField("platform_amount")
	private java.math.BigDecimal platformAmount;

	/**
	 * 签名
	 */
	@TableField("mac")
	private java.lang.String mac;

	/**
	 * 是否需要实名认 证 选填,需要微信支付认证传 T,中保信认证 传Z
	 */
	@TableField("fix_buyer")
	private java.lang.String fixBuyer;

	/**
	 * 实名认证姓名 非必填,Base64 编码
	 */
	@TableField("name")
	private java.lang.String name;

	/**
	 * 实名认证手机号 非必填,Base64 编码
	 */
	@TableField("mobile")
	private java.lang.String mobile;

	/**
	 * 实名认证证件号 非必填,Base64 编码
	 */
	@TableField("cert_no")
	private java.lang.String certNo;

	/**
	 * 非必填,证件类型 微信支持身份证、支付宝支持身份证: IDENTITY_CARD、 护照:PASSPORT、 军官证:OFFICER_CARD、
	 * 士兵证:SOLDIER_CARD、 户口本:HOKOU
	 */
	@TableField("cert_type")
	private java.lang.String certType;

	/**
	 * 实际交易商户号 mer_id 下存在多个商户号时使用
	 */
	@TableField("trans_mid")
	private java.lang.String transMid;

	/**
	 * 实际交易终端号 mer_id 下存在多个终端号时使用
	 */
	@TableField("trans_tid")
	private java.lang.String transTid;

	/**
	 * 交易类型 非必填,取值包含:P004,P034,P074，具 体使用，联调时与对接人员沟通
	 */
	@TableField("trans_type")
	private java.lang.String transType;

	/**
	 * 异步通知 如果商户只存在一个 erp 系统，异步通知 地址可以提供给大华运营人员配置在大 华后台，无需每笔交易都传递;如果商
	 * 户根据不同的订单通知的接口地址不一 样，需要传递 notifyUrl 参数。如果在大 华后台配置了通知地址，下单也传递了 notifyUrl
	 * 参数后，该笔订单支付成功后， 只会通知到 notifyUrl 参数中的接口地址 上
	 */
	@TableField("notify_url")
	private java.lang.String notifyUrl;

	/**
	 * 申请微信支付 商户 App，调用微信小程序支付必传 appid
	 */
	@TableField("sub_app_id")
	private java.lang.String subAppId;

	/**
	 * 操作员工号 不传默认是 01
	 */
	@TableField("employee_no")
	private java.lang.String employeeNo;

	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setOrderNo(java.lang.String orderNo) {
		this.orderNo = orderNo;
	}

	public java.lang.String getOrderNo() {
		return this.orderNo;
	}

	public void setBusiOrderNo(java.lang.String busiOrderNo) {
		this.busiOrderNo = busiOrderNo;
	}

	public java.lang.String getBusiOrderNo() {
		return this.busiOrderNo;
	}

	public void setMerId(java.lang.String merId) {
		this.merId = merId;
	}

	public java.lang.String getMerId() {
		return this.merId;
	}

	public void setQrtype(java.lang.String qrtype) {
		this.qrtype = qrtype;
	}

	public java.lang.String getQrtype() {
		return this.qrtype;
	}

	public void setPayway(java.lang.String payway) {
		this.payway = payway;
	}

	public java.lang.String getPayway() {
		return this.payway;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	public java.lang.String getMemo() {
		return this.memo;
	}

	public void setOrderDesc(java.lang.String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public java.lang.String getOrderDesc() {
		return this.orderDesc;
	}

	public void setSubOpenId(java.lang.String subOpenId) {
		this.subOpenId = subOpenId;
	}

	public java.lang.String getSubOpenId() {
		return this.subOpenId;
	}

	public void setDscode(java.lang.String dscode) {
		this.dscode = dscode;
	}

	public java.lang.String getDscode() {
		return this.dscode;
	}

	public void setBizCode(java.lang.String bizCode) {
		this.bizCode = bizCode;
	}

	public java.lang.String getBizCode() {
		return this.bizCode;
	}

	public void setSubOrders(java.lang.String subOrders) {
		this.subOrders = subOrders;
	}

	public java.lang.String getSubOrders() {
		return this.subOrders;
	}

	public void setPlatformAmount(java.math.BigDecimal platformAmount) {
		this.platformAmount = platformAmount;
	}

	public java.math.BigDecimal getPlatformAmount() {
		return this.platformAmount;
	}

	public void setMac(java.lang.String mac) {
		this.mac = mac;
	}

	public java.lang.String getMac() {
		return this.mac;
	}

	public void setFixBuyer(java.lang.String fixBuyer) {
		this.fixBuyer = fixBuyer;
	}

	public java.lang.String getFixBuyer() {
		return this.fixBuyer;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return this.name;
	}

	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}

	public java.lang.String getMobile() {
		return this.mobile;
	}

	public void setCertNo(java.lang.String certNo) {
		this.certNo = certNo;
	}

	public java.lang.String getCertNo() {
		return this.certNo;
	}

	public void setCertType(java.lang.String certType) {
		this.certType = certType;
	}

	public java.lang.String getCertType() {
		return this.certType;
	}

	public void setTransMid(java.lang.String transMid) {
		this.transMid = transMid;
	}

	public java.lang.String getTransMid() {
		return this.transMid;
	}

	public void setTransTid(java.lang.String transTid) {
		this.transTid = transTid;
	}

	public java.lang.String getTransTid() {
		return this.transTid;
	}

	public void setTransType(java.lang.String transType) {
		this.transType = transType;
	}

	public java.lang.String getTransType() {
		return this.transType;
	}

	public void setNotifyUrl(java.lang.String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public java.lang.String getNotifyUrl() {
		return this.notifyUrl;
	}

	public BigDecimal getCod() {
		return cod;
	}

	public void setCod(BigDecimal cod) {
		this.cod = cod;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public void setSubAppId(java.lang.String subAppId) {
		this.subAppId = subAppId;
	}

	public java.lang.String getSubAppId() {
		return this.subAppId;
	}

	public void setEmployeeNo(java.lang.String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public java.lang.String getEmployeeNo() {
		return this.employeeNo;
	}

}
