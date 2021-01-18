package com.longjun.cto.framework.sm.sys.entity.dto;

import java.util.Date;

//import javax.persistence.Table;

import com.eims.cto.framework.module.base.model.BaseModel;


/**
 * 系统日志
 * @author yangxuan
 * @date 2018年11月2日下午2:48:33
 */
//@Table(name = "t_sys_log")
public class SysLogModel extends BaseModel{

	private static final long serialVersionUID = -2237263290378633656L;
	
	private Date logtime;
	
	private String url;
	
	private String httpMethod;
	
	private String ip;
	
	private String classMethod;
	
	private String params;
	
	private String osName;
	
	private String browser;
	
	private String browserverion;
	
	
	
	

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getBrowserverion() {
		return browserverion;
	}

	public void setBrowserverion(String browserverion) {
		this.browserverion = browserverion;
	}

	public Date getLogtime() {
		return logtime;
	}

	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getClassMethod() {
		return classMethod;
	}

	public void setClassMethod(String classMethod) {
		this.classMethod = classMethod;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
	
	
	
	
	
	
	
	

}
