package com.longjun.cto.framework.sm.sys.entity.dto;

import java.io.Serializable;

/**
 * 管理员修改密码DTO
 * @author yangxuan
 * @date 2019年4月7日 上午12:24:53
 */
public class AdminModifyPasswordDto implements Serializable{

	private static final long serialVersionUID = -5546660230964072669L;
	
	/**
	 * 用户ID
	 */
	private long adminId;
	
	/**
	 * 账户
	 */
	private String account;
	
	/**
	 * 原密码
	 */
	private String oldPassword;
	
	/**
	 * 新密码
	 */
	private String newPassword;

	/**
	 * 确认密码
	 */
	private String reNewPassword;
 
	
	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getReNewPassword() {
		return reNewPassword;
	}

	public void setReNewPassword(String reNewPassword) {
		this.reNewPassword = reNewPassword;
	}
	

}
