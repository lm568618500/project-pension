package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * AdminOtherModel
 * @author liuming
 * @date 2019-10-05 04:51:18
 */
public class AdminOtherDto extends BaseDTO {

	private static final long serialVersionUID = 1570265485528L;
	
	/**
	 * 姓名
	 */
	private String realName;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * ids
	 */
	private int[] ids;
	/**
	 * 领域状态
	 */
	private String businessStatus;
	/**
	 * 授权领域
	 */
	private String domainName;
	
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public String getBusinessStatus() {
		return businessStatus;
	}
	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	
	
}
