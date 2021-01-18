package com.longjun.cto.framework.sm.sys.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * CommonVerificationModel
 * @author yangxuan
 * @date 2019-06-04 05:39:27
 */
public class CommonVerificationModifyDto implements Serializable {

	private static final long serialVersionUID = 1559641174508L;
	
	/**
	 * ID
	 */
	private java.lang.Long id;
	/**
	 * 添加时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 业务状态
	 */
	private java.lang.Integer status;
	/**
	 * 删除状态 0整除 -1删除
	 */
	private java.lang.Integer isDel;
	/**
	 * code类型
	 */
	private java.lang.Integer codeType;
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
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
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
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}
	public void setCodeType(java.lang.Integer codeType) {
		this.codeType = codeType;
	}

	public java.lang.Integer getCodeType() {
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
