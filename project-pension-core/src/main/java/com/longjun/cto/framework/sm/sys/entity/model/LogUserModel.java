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
@TableName("t_log_user")
public class LogUserModel extends BaseModel<LogUserModel>{

	private static final long serialVersionUID = -7580863507176057420L;

	@TableField("operater_id")
	private long operaterId;
	
	/**
	 * 操作者名称
	 */
	@TableField("operater_name")
	private String operaterName;
	
	/**
	 *  IP
	 */
	@TableField("ip")
	private String ip;
	
	/**
	 * 事件ID
	 */
	@TableField("event_use_id")
	private long eventUseId;
	
	/**
	 *  操作 模块
	 */
	@TableField("module_name")
	private String moduleName;
	

	/**
	 *  操作 模块
	 */
	@TableField("user_type")
	private String userType;
	
	/**
	 * 事件内容
	 */
	@TableField("event_contet")
	private String eventContet;
	
	
	public String getUserType() {
		return userType;
	}

	
	public void setUserType(String userType) {
		this.userType = userType;
	}

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

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	

}
