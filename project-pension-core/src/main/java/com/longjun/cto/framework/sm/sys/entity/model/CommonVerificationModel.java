package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CommonVerificationModel
 * 
 * @author yangxuan
 * @date 2019-06-04 05:39:27
 */
@TableName("t_common_verification")
public class CommonVerificationModel extends BaseModel<CommonVerificationModel> {

	private static final long serialVersionUID = 1559641170387L;

	/**
	 * 删除状态 0整除 -1删除
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;

	/**
	 * code类型
	 */
	@TableField("code_type")
	private java.lang.Long codeType;

	/**
	 * code键
	 */
	@TableField("code_key")
	private java.lang.String codeKey;

	/**
	 * code值
	 */
	@TableField("code_val")
	private java.lang.String codeVal;

	/**
	 * 备注
	 */
	@TableField("mark")
	private java.lang.String mark;

	/**
	 * 到期时间
	 */
	@TableField("expire_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date expireTime;

	/**
	 * 到期时间戳
	 */
	@TableField("expire_timestamp")
	private java.lang.Long expireTimestamp;

	/**
	 * IP
	 */
	@TableField("ip")
	private String ip;

	/**
	 * 备注
	 */
	@TableField("memo")
	private String memo;

	/**
	 * 手机号码
	 */
	@TableField("mobile")
	private String mobile;

	/**
	 * 0图片验证码 1短信验证码
	 */
	@TableField("code_es")
	private Integer codeEs;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getCodeEs() {
		return codeEs;
	}

	public void setCodeEs(Integer codeEs) {
		this.codeEs = codeEs;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setCodeType(java.lang.Long codeType) {
		this.codeType = codeType;
	}

	public java.lang.Long getCodeType() {
		return this.codeType;
	}

	public void setCodeKey(java.lang.String codeKey) {
		this.codeKey = codeKey;
	}

	public java.lang.String getCodeKey() {
		return this.codeKey;
	}

	public void setCodeVal(java.lang.String codeVal) {
		this.codeVal = codeVal;
	}

	public java.lang.String getCodeVal() {
		return this.codeVal;
	}

	public void setMark(java.lang.String mark) {
		this.mark = mark;
	}

	public java.lang.String getMark() {
		return this.mark;
	}

	public void setExpireTime(java.util.Date expireTime) {
		this.expireTime = expireTime;
	}

	public java.util.Date getExpireTime() {
		return this.expireTime;
	}

	public void setExpireTimestamp(java.lang.Long expireTimestamp) {
		this.expireTimestamp = expireTimestamp;
	}

	public java.lang.Long getExpireTimestamp() {
		return this.expireTimestamp;
	}

}
