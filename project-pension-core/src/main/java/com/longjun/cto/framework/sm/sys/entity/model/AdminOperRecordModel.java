package com.longjun.cto.framework.sm.sys.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 操作日志Model
 * @author lp
 * @date 2018-12-13 15:54:41
 */
@TableName("t_admin_oper_record")
public class AdminOperRecordModel extends BaseModel<AdminOperRecordModel> {

	private static final long serialVersionUID = 1544687681675L;


	/**
	 * 管理员id
	 */
	@TableField("admin_id")
	private long adminId;

	/**
	 * 操作时间
	 */
	@TableField("oper_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date operDate;

	/**
	 * 被操作对象
	 */
	@TableField("to_relation_str")
	private String toRelationStr;

	/**
	 * 被操作对象ID
	 */
	@TableField("to_relation_id")
	private long toRelationId;

	/**
	 * 被操作对象类型
	 */
	@TableField("to_relation_type")
	private int toRelationType;

	/**
	 * 操作记录
	 */
	@TableField("oper_record")
	private String operRecord;

	/**
	 * 操作日志类型
	 */
	@TableField("oper_type")
	private int operType;

	/**
	 * 
	 */
	@TableField("ip")
	private String ip;



	


	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public long getAdminId() {
		return this.adminId;
	}

	public void setOperDate(java.util.Date operDate) {
		this.operDate = operDate;
	}

	public java.util.Date getOperDate() {
		return this.operDate;
	}

	public void setToRelationStr(String toRelationStr) {
		this.toRelationStr = toRelationStr;
	}

	public String getToRelationStr() {
		return this.toRelationStr;
	}

	public void setToRelationId(long toRelationId) {
		this.toRelationId = toRelationId;
	}

	public long getToRelationId() {
		return this.toRelationId;
	}

	public void setToRelationType(int toRelationType) {
		this.toRelationType = toRelationType;
	}

	public int getToRelationType() {
		return this.toRelationType;
	}

	public void setOperRecord(String operRecord) {
		this.operRecord = operRecord;
	}

	public String getOperRecord() {
		return this.operRecord;
	}

	public void setOperType(int operType) {
		this.operType = operType;
	}

	public int getOperType() {
		return this.operType;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
	}


}
