package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.List;

//import javax.persistence.Transient;

import com.eims.cto.framework.module.base.model.BaseView;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleResourcesModel;

/**
 * 鉴权资源服务视图
 * @author yangxuan
 * @date 2018年11月6日 下午11:11:46
 */
public class AuthRoleResourcesView extends BaseView{
	
	private static final long serialVersionUID = -1295346763636593687L;
	
	public AuthRoleResourcesView(){
		
		
	}
	
	public AuthRoleResourcesView(AuthRoleResourcesModel model){
		this.id = model.getId();
		this.time = model.getTime();
		this.lastupdate = model.getTime();
		this.status = model.getStatus();
		this.roleId = model.getRoleId();
		this.resourcesId = model.getResourcesId();
	}

	private long roleId;
	
	private String roleName;
	
	private long resourcesId;
	
	private String resourcesName;
	private String resourcesTarget;
	private String resourcesCls;
	private String resourcesDomId;
	private String resourcesDomName;
	
	private String resUrl;
	
	private long parentId;
	
	private int type;
	
	private int status;
	
	
	
	
	public String getResourcesDomId() {
		return resourcesDomId;
	}

	
	public void setResourcesDomId(String resourcesDomId) {
		this.resourcesDomId = resourcesDomId;
	}

	
	public String getResourcesDomName() {
		return resourcesDomName;
	}

	
	public void setResourcesDomName(String resourcesDomName) {
		this.resourcesDomName = resourcesDomName;
	}

	public String getResourcesTarget() {
		return resourcesTarget;
	}

	public void setResourcesTarget(String resourcesTarget) {
		this.resourcesTarget = resourcesTarget;
	}

	public String getResourcesCls() {
		return resourcesCls;
	}

	public void setResourcesCls(String resourcesCls) {
		this.resourcesCls = resourcesCls;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	/**
	 * 子菜单
	 */
//	@Transient
	List<AuthRoleResourcesView> cMenus;
	

	public List<AuthRoleResourcesView> getcMenus() {
		return cMenus;
	}

	public void setcMenus(List<AuthRoleResourcesView> cMenus) {
		this.cMenus = cMenus;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getResourcesName() {
		return resourcesName;
	}

	public void setResourcesName(String resourcesName) {
		this.resourcesName = resourcesName;
	}

	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getResourcesId() {
		return resourcesId;
	}

	public void setResourcesId(long resourcesId) {
		this.resourcesId = resourcesId;
	}

}
