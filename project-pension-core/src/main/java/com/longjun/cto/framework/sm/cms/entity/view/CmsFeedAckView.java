package com.longjun.cto.framework.sm.cms.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * CmsFeedAckModel
 * 
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
public class CmsFeedAckView extends BaseView {

	private static final long serialVersionUID = 1561297395314L;

	/**
	 * 删除状态 0正常 -1删除
	 */
	private java.lang.Integer isDel;

	/**
	 * 反馈编号
	 */
	private java.lang.Long feedNo;

	/**
	 * 管理员ID
	 */
	private java.lang.Long adminId;

	/**
	 * 回答时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date ackTime;

	/**
	 * 回答内容
	 */
	private java.lang.String ackContent;

	/**
	 * 处理员账号
	 */
	private String adminAccount;

	/**
	 * 处理员姓名
	 */
	private String adminRealName;

	/**
	 * 处理员手机号
	 */
	private String adminMobile;

	public String getAdminAccount() {
		return adminAccount;
	}

	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}

	public String getAdminRealName() {
		return adminRealName;
	}

	public void setAdminRealName(String adminRealName) {
		this.adminRealName = adminRealName;
	}

	public String getAdminMobile() {
		return adminMobile;
	}

	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}

	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setFeedNo(java.lang.Long feedNo) {
		this.feedNo = feedNo;
	}

	public java.lang.Long getFeedNo() {
		return this.feedNo;
	}

	public void setAdminId(java.lang.Long adminId) {
		this.adminId = adminId;
	}

	public java.lang.Long getAdminId() {
		return this.adminId;
	}

	public void setAckTime(java.util.Date ackTime) {
		this.ackTime = ackTime;
	}

	public java.util.Date getAckTime() {
		return this.ackTime;
	}

	public void setAckContent(java.lang.String ackContent) {
		this.ackContent = ackContent;
	}

	public java.lang.String getAckContent() {
		return this.ackContent;
	}

}
