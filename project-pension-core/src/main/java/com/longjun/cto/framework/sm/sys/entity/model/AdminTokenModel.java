package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * AdminTokenModel
 * @author EIMS-CODE-BUILD
 * @date 2019-04-01 08:42:02
 */
@TableName("t_admin_token")
public class AdminTokenModel extends BaseModel<AdminTokenModel> {

	private static final long serialVersionUID = 1554079327736L;
	
	
	
	
	
	/**
	 * 
	 */
	@TableField("is_del")
	private int isDel;
	
	/**
	 * 
	 */
	@TableField("user_id")
	private long userId;
	
	/**
	 * 
	 */
	@TableField("token")
	private String token;
	
	/**
	 * 
	 */
	@TableField("expire_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date expireTime;
	
	




	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}

	public void setExpireTime(java.util.Date expireTime) {
		this.expireTime = expireTime;
	}

	public java.util.Date getExpireTime() {
		return this.expireTime;
	}

}
