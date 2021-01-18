package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * CommonWorldMapModel
 * @author liuming
 * @date 2019-11-08 03:56:49
 */
public class CommonWorldMapView extends BaseView {

	private static final long serialVersionUID = 1573199812105L;
	
	
	/**
	 * 国家名称
	 */
	private java.lang.String name;
	
	/**
	 * 国家代码
	 */
	private java.lang.String code;
	
	/**
	 * 父id
	 */
	private java.lang.Long pid;
	
	/**
	 * 
	 */
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
