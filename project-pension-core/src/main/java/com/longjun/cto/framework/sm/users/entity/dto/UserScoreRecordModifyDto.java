package com.longjun.cto.framework.sm.users.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * UserScoreRecordModel
 * @author yangxuan
 * @date 2019-06-28 04:46:45
 */
public class UserScoreRecordModifyDto implements Serializable {

	private static final long serialVersionUID = 1561711615589L;
	
	/**
	 * ID
	 */
	private java.lang.Long id;
	/**
	 * 添加时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 业务状态
	 */
	private java.lang.Integer status;
	/**
	 * 删除状态 0正常 -1删除
	 */
	private java.lang.Integer isDel;
	/**
	 * 用户ID
	 */
	private java.lang.Long userId;
	/**
	 * 是否增加 1增加 0减少
	 */
	private java.lang.Integer isAdd;
	/**
	 * 积分
	 */
	private java.lang.Long score;
	/**
	 * 操作之前积分
	 */
	private java.lang.Long beforeScore;
	/**
	 * 操作之后积分
	 */
	private java.lang.Long afterScore;
	/**
	 * 积分摘要
	 */
	private java.lang.String scoreSign;
	/**
	 * 备注
	 */
	private java.lang.String mark;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
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
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}
	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}

	public java.lang.Long getUserId() {
		return this.userId;
	}
	public void setIsAdd(java.lang.Integer isAdd) {
		this.isAdd = isAdd;
	}

	public java.lang.Integer getIsAdd() {
		return this.isAdd;
	}
	public void setScore(java.lang.Long score) {
		this.score = score;
	}

	public java.lang.Long getScore() {
		return this.score;
	}
	public void setBeforeScore(java.lang.Long beforeScore) {
		this.beforeScore = beforeScore;
	}

	public java.lang.Long getBeforeScore() {
		return this.beforeScore;
	}
	public void setAfterScore(java.lang.Long afterScore) {
		this.afterScore = afterScore;
	}

	public java.lang.Long getAfterScore() {
		return this.afterScore;
	}
	public void setScoreSign(java.lang.String scoreSign) {
		this.scoreSign = scoreSign;
	}

	public java.lang.String getScoreSign() {
		return this.scoreSign;
	}
	public void setMark(java.lang.String mark) {
		this.mark = mark;
	}

	public java.lang.String getMark() {
		return this.mark;
	}
}
