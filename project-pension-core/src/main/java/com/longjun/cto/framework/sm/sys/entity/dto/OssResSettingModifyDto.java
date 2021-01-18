package com.longjun.cto.framework.sm.sys.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * OssResSettingModel
 * @author yangxuan
 * @date 2019-04-16 06:45:48
 */
public class OssResSettingModifyDto implements Serializable {

	private static final long serialVersionUID = 1555411552171L;
	
	/**
	 * ID
	 */
	private long id;
	/**
	 * 数据插入时间
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
	private int status;
	/**
	 * 删除状态 0正常 -1删除
	 */
	private int isDel;
	/**
	 * 父ID
	 */
	private long pId;
	/**
	 * 设置名称
	 */
	private String setName;
	/**
	 * 资源类型1、图片 2音频 3、视频
	 */
	private int resType;
	
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
	public void setPId(long pId) {
		this.pId = pId;
	}

	public long getPId() {
		return this.pId;
	}
	public void setSetName(String setName) {
		this.setName = setName;
	}

	public String getSetName() {
		return this.setName;
	}
	public void setResType(int resType) {
		this.resType = resType;
	}

	public int getResType() {
		return this.resType;
	}
}
