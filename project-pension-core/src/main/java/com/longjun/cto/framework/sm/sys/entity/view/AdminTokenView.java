package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * AdminTokenModel
 * @author EIMS-CODE-BUILD
 * @date 2019-04-01 08:42:02
 */
public class AdminTokenView extends BaseView {

	private static final long serialVersionUID = 1554079325501L;
	
	
	
	
	
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
