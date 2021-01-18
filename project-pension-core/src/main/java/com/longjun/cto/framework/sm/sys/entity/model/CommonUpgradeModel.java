package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CommonUpgradeModel
 * @author yangxuan
 * @date 2019-04-04 07:49:24
 */
@TableName("t_common_upgrade")
public class CommonUpgradeModel extends BaseModel<CommonUpgradeModel> {

	private static final long serialVersionUID = 1554378568814L;
	
	
	
	/**
	 * 删除状态
	 */
	@TableField("is_del")
	private int isDel;
	
	/**
	 * 操作者ID
	 */
	@TableField("admin_id")
	private long adminId;
	
	/**
	 * 版本名称
	 */
	@TableField("version")
	private String version;
	
	/**
	 * 更新提示
	 */
	@TableField("tips")
	private String tips;
	
	/**
	 * 发布时间-更新时间
	 */
	@TableField("pub_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date pubTime;
	
	/**
	 * 平台， 1安卓 2IOS
	 */
	@TableField("plat_form")
	private int platForm;
	
	/**
	 * 下载类型， 1、本地 2、第三方
	 */
	@TableField("down_type")
	private int downType;
	
	/**
	 * 文件名
	 */
	@TableField("file_name")
	private String fileName;
	
	/**
	 * 下载地址
	 */
	@TableField("down_url")
	private String downUrl;
	
	/**
	 * 二维码
	 */
	@TableField("qr_code")
	private String qrCode;
	
	/**
	 * 1、强制 2、不强制更新
	 */
	@TableField("is_need")
	private int isNeed;
	
	/**
	 * 是否为默认版本
	 */
	@TableField("is_default")
	private int isDefault;
	
	
	
	/**
	 * 版本号
	 */
	@TableField("version_number")
	private int versionNumber;
	
	
	/**
	 * 版本号
	 */
	@TableField("app_id")
	private long appId;
	

	public long getAppId() {
		return appId;
	}

	public void setAppId(long appId) {
		this.appId = appId;
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



	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public int getVersionNumber() {
		return this.versionNumber;
	}

}
