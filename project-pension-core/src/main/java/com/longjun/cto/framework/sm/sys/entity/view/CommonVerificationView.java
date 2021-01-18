package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * CommonVerificationModel
 * 
 * @author yangxuan
 * @date 2019-06-04 05:39:27
 */
public class CommonVerificationView extends BaseView {

	private static final long serialVersionUID = 1559641172027L;

	/**
	 * 删除状态 0整除 -1删除
	 */
	private java.lang.Integer isDel;

	/**
	 * code类型
	 */
	private java.lang.Long codeType;

	/**
	 * code键
	 */
	private java.lang.String codeKey;

	/**
	 * code值
	 */
	private java.lang.String codeVal;

	/**
	 * 备注
	 */
	private java.lang.String mark;

	/**
	 * 到期时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date expireTime;

	/**
	 * 到期时间戳
	 */
	private java.lang.Long expireTimestamp;

	/**
	 * IP
	 */
	private String ip;

	/**
	 * 备注
	 */
	private String memo;

	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 0图片验证码 1短信验证码
	 */
	private Integer codeEs;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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
