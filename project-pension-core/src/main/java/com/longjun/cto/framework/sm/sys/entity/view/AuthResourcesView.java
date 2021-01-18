package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseView;
import com.longjun.cto.framework.sm.sys.entity.model.AuthResourcesModel;

/**
 * 资源视图
 * @author yangxuan
 * @date 2018年11月5日 下午5:02:38
 */
@TableName(value = "t_auth_resources")
public class AuthResourcesView extends BaseView{
	

	private static final long serialVersionUID = -657795586028661016L;
	
	public AuthResourcesView(){
		
	}
	
	public AuthResourcesView(AuthResourcesModel model){
		this.id = model.getId();
		this.time = model.getTime();
		this.lastupdate = model.getLastupdate();
		this.status = model.getStatus();
		this.cls = model.getCls();
		this.target = model.getTarget();
		this.name = model.getName();
		this.url = model.getUrl();
		this.type = model.getType();
		this.parentId = model.getParentId();
		this.permission = model.getPermission();
		this.sort = model.getSort();
		this.topmenuid = model.getTopmenuid();
		this.icon = model.getIcon();
	}
	
	@TableField(value = "cls")
	private String cls;
	
	@TableField(value = "target")
	private String target;

	@TableField(value = "name")
	private String name;
	
	@TableField(value = "url")
	private String url;
	
	@TableField(value = "type")
	private int type;
	
	@TableField(value = "parentId")
	private long parentId;
	
	@TableField(value = "permission")
	private String permission;
	
	@TableField(value = "sort")
	private int sort;
	

	@TableField("topmenuid")
	private long topmenuid;
	
	private String icon;
	
	private boolean spread = true;
	
	private List<AuthResourcesView> children;
	
	
	public boolean isSpread() {
		return spread;
	}

	public void setSpread(boolean spread) {
		this.spread = spread;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
 

	public List<AuthResourcesView> getChildren() {
		return children;
	}

	public void setChildren(List<AuthResourcesView> children) {
		this.children = children;
	}

	public long getTopmenuid() {
		return topmenuid;
	}

	
	public void setTopmenuid(long topmenuid) {
		this.topmenuid = topmenuid;
	}

	/**
	 * 角色编辑试用（标记是否选中）
	 */
	@TableField(exist = false)
	private int checked = 0;
	
	
	
	public int getChecked() {
		return checked;
	}

	
	public void setChecked(int checked) {
		this.checked = checked;
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
