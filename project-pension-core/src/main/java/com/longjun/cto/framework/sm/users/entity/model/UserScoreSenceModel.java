package com.longjun.cto.framework.sm.users.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserScoreSenceModel
 * @author yangxuan
 * @date 2019-07-01 05:05:46
 */
@TableName("t_user_score_sence")
public class UserScoreSenceModel extends BaseModel<UserScoreSenceModel> {

	private static final long serialVersionUID = 1561971953554L;
	
	
	
	
	
	/**
	 * 删除状态 0正常 -1删除
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;
	
	/**
	 * 场景名称
	 */
	@TableField("sence_name")
	private java.lang.String senceName;
	
	/**
	 * 场景编号
	 */
	@TableField("sence_no")
	private java.lang.Long senceNo;
	
	/**
	 * 出入账情况 1、积分入账 2、积分出账
	 */
	@TableField("income")
	private java.lang.Integer income;
	
	




	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setSenceName(java.lang.String senceName) {
		this.senceName = senceName;
	}

	public java.lang.String getSenceName() {
		return this.senceName;
	}

	public void setSenceNo(java.lang.Long senceNo) {
		this.senceNo = senceNo;
	}

	public java.lang.Long getSenceNo() {
		return this.senceNo;
	}

	public void setIncome(java.lang.Integer income) {
		this.income = income;
	}

	public java.lang.Integer getIncome() {
		return this.income;
	}

}
