package com.longjun.cto.framework.sm.users.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserTokenModel
 * @author yangxuan
 * @date 2019-05-31 05:43:41
 */
@TableName("t_user_token")
public class UserTokenModel extends BaseModel<UserTokenModel> {

	private static final long serialVersionUID = 1559295829014L;
	
	
	
	
	
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
	@TableField("token_type")
	private int tokenType;
	
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

	public void setTokenType(int tokenType) {
		this.tokenType = tokenType;
	}

	public int getTokenType() {
		return this.tokenType;
	}

	public void setExpireTime(java.util.Date expireTime) {
		this.expireTime = expireTime;
	}

	public java.util.Date getExpireTime() {
		return this.expireTime;
	}

}
