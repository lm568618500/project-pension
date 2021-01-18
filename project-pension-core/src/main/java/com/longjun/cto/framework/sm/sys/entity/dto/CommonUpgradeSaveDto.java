package com.longjun.cto.framework.sm.sys.entity.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.eims.cto.framework.module.base.model.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CommonUpgradeModel
 * 
 * @author yangxuan
 * @date 2019-04-04 07:49:24
 */
public class CommonUpgradeSaveDto extends BaseDTO {

	private static final long serialVersionUID = 1554378573148L;

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
	 * 版本号
	 */
	private int versionNumber;

	/**
	 * 版本号
	 */
	private long appId;
	
	/**
	 * 本地地址。 上传包含第三方，如果第三方有值，则读取第三方。该值为第二读取
	 */
	private String localUrl;
	
	public String getLocalUrl() {
		return localUrl;
	}

	public void setLocalUrl(String localUrl) {
		this.localUrl = localUrl;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public java.util.Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(java.util.Date pubTime) {
		this.pubTime = pubTime;
	}

	public int getPlatForm() {
		return platForm;
	}

	public void setPlatForm(int platForm) {
		this.platForm = platForm;
	}

	public int getDownType() {
		return downType;
	}

	public void setDownType(int downType) {
		this.downType = downType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDownUrl() {
		return downUrl;
	}

	public void setDownUrl(String downUrl) {
		this.downUrl = downUrl;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public int getIsNeed() {
		return isNeed;
	}

	public void setIsNeed(int isNeed) {
		this.isNeed = isNeed;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public long getAppId() {
		return appId;
	}

	public void setAppId(long appId) {
		this.appId = appId;
	}

	
	
}
