package com.longjun.cto.framework.sm.sys.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;

/**
 * 通用-设置
 * 
 * @author yangxuan
 * @date 2018年11月7日 下午5:39:58
 */
@TableName("t_common_option")
public class CommonOptionModel extends BaseModel<CommonOptionModel> {

	private static final long serialVersionUID = -8039277861174143793L;

	@TableField("use_id")
	private long useId;

	@TableField("key")
	private String key;

	@TableField("value")
	private String value;

	/**
	 * 无权限操作。开发人员维护
	 */
	@TableField("is_not_allowed")
	private int isNotAllowed;

	@TableField("mark")
	private String mark;

	@TableField("input_type")
	private String inputType;

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
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

	public int getIsNotAllowed() {
		return isNotAllowed;
	}

	public void setIsNotAllowed(int isNotAllowed) {
		this.isNotAllowed = isNotAllowed;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}
