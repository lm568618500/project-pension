package com.longjun.cto.framework.sm.sys.entity.view;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * 通用-profile 视图
 * @author yangxuan
 * @date 2018年11月13日 下午12:02:29
 */
public class CommonProfileView extends BaseView{
	
	private static final long serialVersionUID = 446714654084158004L;

	/**
	 * 键
	 */
	private String profileKey;
	
	/**
	 * 值
	 */
	private String profileVal;
	
	/**
	 * 备注
	 */
	private String mark;

	public String getProfileKey() {
		return profileKey;
	}

	public void setProfileKey(String profileKey) {
		this.profileKey = profileKey;
	}

	public String getProfileVal() {
		return profileVal;
	}

	public void setProfileVal(String profileVal) {
		this.profileVal = profileVal;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
	

}
