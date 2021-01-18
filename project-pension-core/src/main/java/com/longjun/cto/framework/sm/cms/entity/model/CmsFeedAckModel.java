package com.longjun.cto.framework.sm.cms.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CmsFeedAckModel
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
@TableName("t_cms_feed_ack")
public class CmsFeedAckModel extends BaseModel<CmsFeedAckModel> {

	private static final long serialVersionUID = 1561297394872L;
	
	
	
	
	
	/**
	 * 删除状态 0正常 -1删除
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;
	
	/**
	 * 反馈编号
	 */
	@TableField("feed_no")
	private java.lang.Long feedNo;
	
	/**
	 * 管理员ID
	 */
	@TableField("admin_id")
	private java.lang.Long adminId;
	
	/**
	 * 回答时间
	 */
	@TableField("ack_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date ackTime;
	
	/**
	 * 回答内容
	 */
	@TableField("ack_content")
	private java.lang.String ackContent;
	
	




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
