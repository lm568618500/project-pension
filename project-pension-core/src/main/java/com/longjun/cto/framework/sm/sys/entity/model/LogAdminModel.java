package com.longjun.cto.framework.sm.sys.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

//import javax.persistence.Table;

import com.eims.cto.framework.module.base.model.BaseModel;

/**
 * 管理员日志模型
 * @author yangxuan
 * @date 2018年11月8日 下午5:19:43
 */
@TableName("t_log_admin")
public class LogAdminModel extends BaseModel{

	private static final long serialVersionUID = -7580863507176057420L;
	
	@TableField(value = "operater_id")
	private long operaterId;
	
	/**
	 * 操作者名称
	 */
	@TableField(value = "operater_name")
	private String operaterName;
	
	/**
	 * 组ID
	 */
	@TableField(value = "operater_role_id")
	private long operaterRoleId;
	
	/**
	 * 组名称
	 */
	@TableField(value = "operater_role_name")
	private String operaterRoleName;
	
	
	
	/**
	 *  IP
	 */
	private String ip;
	
	/**
	 * 事件ID
	 */
	@TableField(value = "event_use_id")
	private long eventUseId;
	
	/**
	 *  操作 模块
	 */
	@TableField(value = "module_name")
	private String moduleName;
	
	/**
	 * 事件内容
	 */
	@TableField(value = "event_contet")
	private String eventContet;

	public long getOperaterId() {
		return operaterId;
	}

	public void setOperaterId(long operaterId) {
		this.operaterId = operaterId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public long getEventUseId() {
		return eventUseId;
	}

	public void setEventUseId(long eventUseId) {
		this.eventUseId = eventUseId;
	}

	public String getEventContet() {
		return eventContet;
	}

	public void setEventContet(String eventContet) {
		this.eventContet = eventContet;
	}

	public String getOperaterName() {
		return operaterName;
	}

	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}

	public long getOperaterRoleId() {
		return operaterRoleId;
	}

	public void setOperaterRoleId(long operaterRoleId) {
		this.operaterRoleId = operaterRoleId;
	}

	public String getOperaterRoleName() {
		return operaterRoleName;
	}

	public void setOperaterRoleName(String operaterRoleName) {
		this.operaterRoleName = operaterRoleName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	

}
