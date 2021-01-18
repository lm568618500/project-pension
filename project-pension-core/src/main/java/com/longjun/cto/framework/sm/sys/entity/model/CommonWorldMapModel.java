package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CommonWorldMapModel
 * @author liuming
 * @date 2019-11-08 03:56:49
 */
@TableName("t_common_world_map")
public class CommonWorldMapModel extends BaseModel<CommonWorldMapModel> {

	private static final long serialVersionUID = 1573199812312L;
	
	
	/**
	 * 国家名称
	 */
	@TableField("name")
	private java.lang.String name;
	
	/**
	 * 国家代码
	 */
	@TableField("code")
	private java.lang.String code;
	
	/**
	 * 父id
	 */
	@TableField("pid")
	private java.lang.Long pid;
	
	/**
	 * 
	 */
	@TableField("layer")
	private java.lang.Integer layer;
	
	
	
	
	

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return this.name;
	}

	public void setCode(java.lang.String code) {
		this.code = code;
	}

	public java.lang.String getCode() {
		return this.code;
	}

	public void setPid(java.lang.Long pid) {
		this.pid = pid;
	}

	public java.lang.Long getPid() {
		return this.pid;
	}

	public void setLayer(java.lang.Integer layer) {
		this.layer = layer;
	}

	public java.lang.Integer getLayer() {
		return this.layer;
	}




}
