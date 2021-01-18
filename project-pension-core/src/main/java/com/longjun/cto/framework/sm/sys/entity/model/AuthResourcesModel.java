package com.longjun.cto.framework.sm.sys.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;

/**
 * 资源模型
 * @author yangxuan
 * @date 2018年11月5日 下午5:01:26
 */
@TableName("t_auth_resource")
public class AuthResourcesModel extends BaseModel<AuthResourcesModel>{

	private static final long serialVersionUID = 8248715320799209356L;
	
	@TableField("cls")
	private String cls;
	
	@TableField("dom_id")
	private String domId;
	
	@TableField("dom_name")
	private String domName;
	
	@TableField("target")
	private String target;
	
	@TableField("name")
	private String name;
	
	@TableField("url")
	private String url;
	
	@TableField("type")
	private int type;
	
	@TableField("parent_id")
	private long parentId;
	
	@TableField("permission")
	private String permission;
	
	@TableField("sort")
	private int sort;
	
	@TableField("topmenuid")
	private long topmenuid;
	
	@TableField("icon")
	private String icon;
	
	
	public String getIcon() {
		return icon;
	}



	public void setIcon(String icon) {
		this.icon = icon;
	}



	public long getTopmenuid() {
		return topmenuid;
	}


	
	public void setTopmenuid(long topmenuid) {
		this.topmenuid = topmenuid;
	}


	public String getDomId() {
		return domId;
	}

	
	public void setDomId(String domId) {
		this.domId = domId;
	}

	
	public String getDomName() {
		return domName;
	}

	
	public void setDomName(String domName) {
		this.domName = domName;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	

}
