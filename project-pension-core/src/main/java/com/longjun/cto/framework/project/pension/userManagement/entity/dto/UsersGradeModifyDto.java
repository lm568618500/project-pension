package com.longjun.cto.framework.project.pension.userManagement.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * UsersGradeModel
 * @author carson
 * @date 2019-10-19 11:55:54
 */
public class UsersGradeModifyDto implements Serializable {

	private static final long serialVersionUID = 1571500563882L;
	
	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 等级名称
	 */
	private String gradeName;
	/**
	 * 等级级别
	 */
	private String gradeLevel;
	/**
	 * 备注
	 */
	private String gradeRemarks;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date time;
	/**
	 * 操作人id
	 */
	private Long adminId;
	/**
	 * 
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lastupdate;
	/**
	 * 状态(0 启用 1 禁用)
	 */
	private Integer status;
	/**
	 * 0正常，-1删除
	 */
	private Integer isDel;
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getGradeName() {
		return this.gradeName;
	}
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public String getGradeLevel() {
		return this.gradeLevel;
	}
	public void setGradeRemarks(String gradeRemarks) {
		this.gradeRemarks = gradeRemarks;
	}

	public String getGradeRemarks() {
		return this.gradeRemarks;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return this.time;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Long getAdminId() {
		return this.adminId;
	}
	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public Date getLastupdate() {
		return this.lastupdate;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getIsDel() {
		return this.isDel;
	}
}
