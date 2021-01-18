package com.longjun.cto.framework.sm.sys.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * OssResStoreModel
 * @author yangxuan
 * @date 2019-04-16 06:45:47
 */
public class OssResStoreModifyDto implements Serializable {

	private static final long serialVersionUID = 1555411550091L;
	
	/**
	 * ID
	 */
	private long id;
	/**
	 * 数据添加时间
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
	 * 是否删除 0正常 -1删除
	 */
	private int isDel;
	/**
	 * 资源链接
	 */
	private String resHref;
	/**
	 * 资源名称
	 */
	private String resName;
	/**
	 * 文件后缀
	 */
	private String resSuf;
	/**
	 * 类型ID  t_oss_res_setting
	 */
	private long setId;
	
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
	public void setResHref(String resHref) {
		this.resHref = resHref;
	}

	public String getResHref() {
		return this.resHref;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResName() {
		return this.resName;
	}
	public void setResSuf(String resSuf) {
		this.resSuf = resSuf;
	}

	public String getResSuf() {
		return this.resSuf;
	}
	public void setSetId(long setId) {
		this.setId = setId;
	}

	public long getSetId() {
		return this.setId;
	}
}
