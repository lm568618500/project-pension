package com.longjun.cto.framework.sm.sys.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * CommonUpgradeAppModel
 * @author yangxuan
 * @date 2019-04-09 08:42:07
 */
public class CommonUpgradeAppModifyDto implements Serializable {

	private static final long serialVersionUID = 1554770533530L;
	
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
	 * 状态
	 */
	private int status;
	/**
	 * AppID
	 */
	private String appId;
	/**
	 * App名称
	 */
	private String appName;
	
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
	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppId() {
		return this.appId;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppName() {
		return this.appName;
	}
}
