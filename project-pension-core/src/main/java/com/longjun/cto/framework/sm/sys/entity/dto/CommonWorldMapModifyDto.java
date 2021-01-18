package com.longjun.cto.framework.sm.sys.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * CommonWorldMapModel
 * @author liuming
 * @date 2019-11-08 03:56:49
 */
public class CommonWorldMapModifyDto implements Serializable {

	private static final long serialVersionUID = 1573199815272L;
	
	/**
	 * 
	 */
	private java.lang.Integer id;
	/**
	 * 国家名称
	 */
	private java.lang.String name;
	/**
	 * 国家代码
	 */
	private java.lang.Integer code;
	/**
	 * 父id
	 */
	private java.lang.Integer pid;
	/**
	 * 
	 */
	private java.lang.Integer layer;
	/**
	 * 数据插入时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 状态
	 */
	private java.lang.Integer status;
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return this.name;
	}
	public void setCode(java.lang.Integer code) {
		this.code = code;
	}

	public java.lang.Integer getCode() {
		return this.code;
	}
	public void setPid(java.lang.Integer pid) {
		this.pid = pid;
	}

	public java.lang.Integer getPid() {
		return this.pid;
	}
	public void setLayer(java.lang.Integer layer) {
		this.layer = layer;
	}

	public java.lang.Integer getLayer() {
		return this.layer;
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
}
