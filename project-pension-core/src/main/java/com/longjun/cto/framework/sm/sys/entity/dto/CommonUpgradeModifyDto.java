package com.longjun.cto.framework.sm.sys.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * CommonUpgradeModel
 * @author yangxuan
 * @date 2019-04-04 07:49:24
 */
public class CommonUpgradeModifyDto implements Serializable {

	private static final long serialVersionUID = 1554378571321L;
	
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
	 * 删除状态
	 */
	private int isDel;
	/**
	 * 操作者ID
	 */
	private long adminId;
	/**
	 * 版本名称
	 */
	private String version;
	/**
	 * 更新提示
	 */
	private String tips;
	/**
	 * 发布时间-更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date pubTime;
	/**
	 * 平台， 1安卓 2IOS
	 */
	private int platForm;
	/**
	 * 下载类型， 1、本地 2、第三方
	 */
	private int downType;
	/**
	 * 文件名
	 */
	private String fileName;
	/**
	 * 下载地址
	 */
	private String downUrl;
	/**
	 * 二维码
	 */
	private String qrCode;
	/**
	 * 1、强制 2、不强制更新
	 */
	private int isNeed;
	/**
	 * 是否为默认版本
	 */
	private int isDefault;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 状态
	 */
	private int status;
	/**
	 * 版本号
	 */
	private int versionNumber;
	
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
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public long getAdminId() {
		return this.adminId;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return this.version;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getTips() {
		return this.tips;
	}
	public void setPubTime(java.util.Date pubTime) {
		this.pubTime = pubTime;
	}

	public java.util.Date getPubTime() {
		return this.pubTime;
	}
	public void setPlatForm(int platForm) {
		this.platForm = platForm;
	}

	public int getPlatForm() {
		return this.platForm;
	}
	public void setDownType(int downType) {
		this.downType = downType;
	}

	public int getDownType() {
		return this.downType;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}
	public void setDownUrl(String downUrl) {
		this.downUrl = downUrl;
	}

	public String getDownUrl() {
		return this.downUrl;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getQrCode() {
		return this.qrCode;
	}
	public void setIsNeed(int isNeed) {
		this.isNeed = isNeed;
	}

	public int getIsNeed() {
		return this.isNeed;
	}
	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public int getIsDefault() {
		return this.isDefault;
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
	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public int getVersionNumber() {
		return this.versionNumber;
	}
}
