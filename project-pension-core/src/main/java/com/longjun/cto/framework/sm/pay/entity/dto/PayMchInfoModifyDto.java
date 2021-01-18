package com.longjun.cto.framework.sm.pay.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * PayMchInfoModel
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
public class PayMchInfoModifyDto implements Serializable {

	private static final long serialVersionUID = 1554023841141L;
	
	/**
	 * 
	 */
	private long id;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 商户状态,0-停止使用,1-使用中
	 */
	private int status;
	/**
	 * 
	 */
	private int isDel;
	/**
	 * 商户ID
	 */
	private long mchId;
	/**
	 * 名称
	 */
	private String mchName;
	/**
	 * 类型
	 */
	private String mchType;
	/**
	 * 请求私钥
	 */
	private String reqKey;
	/**
	 * 响应私钥
	 */
	private String resKey;
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
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
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}
	public void setMchId(long mchId) {
		this.mchId = mchId;
	}

	public long getMchId() {
		return this.mchId;
	}
	public void setMchName(String mchName) {
		this.mchName = mchName;
	}

	public String getMchName() {
		return this.mchName;
	}
	public void setMchType(String mchType) {
		this.mchType = mchType;
	}

	public String getMchType() {
		return this.mchType;
	}
	public void setReqKey(String reqKey) {
		this.reqKey = reqKey;
	}

	public String getReqKey() {
		return this.reqKey;
	}
	public void setResKey(String resKey) {
		this.resKey = resKey;
	}

	public String getResKey() {
		return this.resKey;
	}
}
