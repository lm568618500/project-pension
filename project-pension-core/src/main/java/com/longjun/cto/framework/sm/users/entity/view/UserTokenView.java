package com.longjun.cto.framework.sm.users.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * UserTokenModel
 * @author yangxuan
 * @date 2019-05-31 05:43:41
 */
public class UserTokenView extends BaseView {

	private static final long serialVersionUID = 1559295828883L;
	
	
	
	
	
	/**
	 * 
	 */
	private int isDel;
	
	/**
	 * 
	 */
	private long userId;
	
	/**
	 * 
	 */
	private String token;
	
	/**
	 * 
	 */
	private int tokenType;
	
	/**
	 * 
	 */
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
