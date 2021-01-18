package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Calendar;
import java.util.Date;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * 验证码View
 * @author yangxuan
 * @date 2018年11月13日 下午6:27:05
 */
public class CommonValidCodeView extends BaseView{
	
	private static final long serialVersionUID = 2135639293253724984L;

	/**
	 * 场景使用ID
	 */
	private long senceId;
	
	/**
	 * 场景-子场景
	 */
	private String sceneName;
	
	/**
	 * 账户
	 */
	private String account;
	
	/**
	 * token
	 */
	private String token;
	
	/**
	 * Code值
	 */
	private String codeVal;
	
	/**
	 * 到期时间
	 */
	private Date expireDate;
	
	/**
	 * 到期时间时间戳
	 */
	private long expireTimeStamp;

	public long getSenceId() {
		return senceId;
	}

	public void setSenceId(long senceId) {
		this.senceId = senceId;
	}

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCodeVal() {
		return codeVal;
	}

	public void setCodeVal(String codeVal) {
		this.codeVal = codeVal;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public long getExpireTimeStamp() {
		return expireTimeStamp;
	}

	public void setExpireTimeStamp(long expireTimeStamp) {
		this.expireTimeStamp = expireTimeStamp;
	}
	
	public boolean isExpire(){
		return this.getExpireTimeStamp() < Calendar.getInstance().getTimeInMillis();
	}

}
