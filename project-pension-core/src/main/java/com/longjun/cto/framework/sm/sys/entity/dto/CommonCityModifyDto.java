package com.longjun.cto.framework.sm.sys.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * CommonCityModel
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
public class CommonCityModifyDto implements Serializable {

	private static final long serialVersionUID = 1554372820765L;
	
	/**
	 * 
	 */
	private long id;
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
	 * 试用ID
	 */
	private long useId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 省份UseId
	 */
	private long provinceId;
	/**
	 * 状态
	 */
	private int status;
	
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
	public void setUseId(long useId) {
		this.useId = useId;
	}

	public long getUseId() {
		return this.useId;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}

	public long getProvinceId() {
		return this.provinceId;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return this.status;
	}
}
