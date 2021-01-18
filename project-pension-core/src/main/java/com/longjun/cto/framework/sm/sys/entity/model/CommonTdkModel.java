package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Model
 * @author yangxuan
 * @date 2018-11-26 10:56:04
 */
@TableName("t_common_tdk")
public class CommonTdkModel extends BaseModel<CommonTdkModel> {

	private static final long serialVersionUID = 1543200964290L;




	/**
	 * 标题TDK
	 */
	@TableField("title")
	private String title;

	/**
	 * 关键词TDK
	 */
	@TableField("keyword")
	private String keyword;

	/**
	 * URI地址
	 */
	@TableField("uri")
	private String uri;

	/**
	 * 描述TDK
	 */
	@TableField("description")
	private String description;

	/**
	 * 帮助提示
	 */
	@TableField("helptis")
	private String helptis;

	/**
	 * 面包屑
	 */
	@TableField("crumbs")
	private String crumbs;
	
	/**
	 * 面包屑
	 */
	@TableField("crumbstitle")
	private String crumbstitle;
	
	

	




	public String getCrumbstitle() {
		return crumbstitle;
	}

	public void setCrumbstitle(String crumbstitle) {
		this.crumbstitle = crumbstitle;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		return this.uri;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setHelptis(String helptis) {
		this.helptis = helptis;
	}

	public String getHelptis() {
		return this.helptis;
	}

	public void setCrumbs(String crumbs) {
		this.crumbs = crumbs;
	}

	public String getCrumbs() {
		return this.crumbs;
	}

}
