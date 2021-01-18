package com.longjun.cto.framework.sm.message.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * MessageStationModel
 * 
 * @author yangxuan
 * @date 2019-07-04 07:33:46
 */
public class MessageStationView extends BaseView {

	private static final long serialVersionUID = 1562240027324L;

	/**
	 * 删除状态 0 正常 -1删除
	 */
	private java.lang.Integer isDel;

	/**
	 * 用户编号
	 */
	private java.lang.Long userNo;

	/**
	 * 发送时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date sendTime;

	/**
	 * 发送时间戳
	 */
	private java.lang.Long sendTimestamp;

	/**
	 * 内容
	 */
	private java.lang.String content;

	/**
	 * 创建者
	 */
	private java.lang.String creator;

	/**
	 * 标题
	 */
	private java.lang.String title;

	/**
	 * 已读状态 0未读 1已读
	 */
	private java.lang.Integer isRead;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 用户手机号码
	 */
	private String userMobile;

	/**
	 * 用户真实姓名
	 */
	private String userRealName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setUserNo(java.lang.Long userNo) {
		this.userNo = userNo;
	}

	public java.lang.Long getUserNo() {
		return this.userNo;
	}

	public void setSendTime(java.util.Date sendTime) {
		this.sendTime = sendTime;
	}

	public java.util.Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTimestamp(java.lang.Long sendTimestamp) {
		this.sendTimestamp = sendTimestamp;
	}

	public java.lang.Long getSendTimestamp() {
		return this.sendTimestamp;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
	}

	public void setCreator(java.lang.String creator) {
		this.creator = creator;
	}

	public java.lang.String getCreator() {
		return this.creator;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.lang.String getTitle() {
		return this.title;
	}

	public void setIsRead(java.lang.Integer isRead) {
		this.isRead = isRead;
	}

	public java.lang.Integer getIsRead() {
		return this.isRead;
	}

}
