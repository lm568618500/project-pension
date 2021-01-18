package com.longjun.cto.framework.sm.sys.entity.view;

import com.baomidou.mybatisplus.annotations.TableField;
import com.eims.cto.framework.module.base.model.BaseView;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.longjun.cto.framework.sm.sys.entity.model.AdminOperRecordModel;

/**
 * 操作日志View
 * @author lp
 * @date 2018-12-13 15:54:41
 */
public class AdminOperRecordView extends BaseView {

	private static final long serialVersionUID = 1544687681921L;

	public AdminOperRecordView(AdminOperRecordModel model) {
		//this.model = model;
		this.id = model.getId();
		this.time = model.getTime();
		this.adminId = model.getAdminId();
		this.operDate = model.getOperDate();
		this.toRelationStr = model.getToRelationStr();
		this.toRelationId = model.getToRelationId();
		this.toRelationType = model.getToRelationType();
		this.operRecord = model.getOperRecord();
		this.operType = model.getOperType();
		this.ip = model.getIp();
		this.status = model.getStatus();
		this.lastupdate = model.getLastupdate();
	}

	public AdminOperRecordView() {
		
	}
	

	@TableField("account")
	private String account;
	
	@TableField("rolename")
	private String rolename;


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

	/**
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * @param rolename the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}


}
