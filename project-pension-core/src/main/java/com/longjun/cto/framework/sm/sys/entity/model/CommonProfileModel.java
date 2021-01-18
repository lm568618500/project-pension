package com.longjun.cto.framework.sm.sys.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.eims.cto.framework.module.base.model.BaseModel;

/**
 * 通用-profile
 * @author yangxuan
 * @date 2018年11月13日 下午12:00:34
 */
public class CommonProfileModel extends BaseModel{
	
	private static final long serialVersionUID = -5564506776466041179L;

	/**
	 * 键
	 */
	@TableField("profile_key")
	private String profileKey;
	
	/**
	 * 值
	 */
	@TableField("profile_val")
	private String profileVal;
	
	/**
	 * 备注
	 */
	@TableField("mark")
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
