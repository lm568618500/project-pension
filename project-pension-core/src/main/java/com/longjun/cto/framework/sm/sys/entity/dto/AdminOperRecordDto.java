package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * 操作日志Dto
 * @author lp
 * @date 2018-12-13 15:54:41
 */
public class AdminOperRecordDto extends BaseDTO {

	private static final long serialVersionUID = 1544687681939L;
	
	//在这里定义分页查询额外的条件
	
	private Object param;

	/**
	 * @return the param
	 */
	public Object getParam() {
		return param;
	}

	/**
	 * @param param the param to set
	 */
	public void setParam(Object param) {
		this.param = param;
	}
	
}
