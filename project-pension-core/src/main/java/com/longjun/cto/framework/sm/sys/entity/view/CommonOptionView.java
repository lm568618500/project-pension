package com.longjun.cto.framework.sm.sys.entity.view;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * 通用-设置
 * 
 * @author yangxuan
 * @date 2018年11月7日 下午5:41:31
 */
public class CommonOptionView extends BaseView {

	private static final long serialVersionUID = 5648478519087927040L;

	private long useId;

	private String key;

	private String value;

	/**
	 * 无权限操作。开发人员维护
	 */
	private int isNotAllowed;

	private String mark;

	private String inputType;

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public int getIsNotAllowed() {
		return isNotAllowed;
	}

	public void setIsNotAllowed(int isNotAllowed) {
		this.isNotAllowed = isNotAllowed;
	}

	public long getUseId() {
		return useId;
	}

	public void setUseId(long useId) {
		this.useId = useId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}
