package com.longjun.cto.framework.sm.sys.entity.view;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 *  管理员日志视图
 * @author yangxuan
 * @date 2018年11月8日 下午5:50:06
 */
public class LogUserView extends BaseView{

	private static final long serialVersionUID = 6140191835605519654L;
	

	private long operaterId;
	
	/**
	 * 操作者名称
	 */
	private String operaterName;
	
	/**
	 *  IP
	 */
	private String ip;
	
	/**
	 * 事件ID
	 */
	private long eventUseId;
	
	/**
	 *  操作 模块
	 */
	private String moduleName;
	
	/**
	 * 事件内容
	 */
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

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	
}
