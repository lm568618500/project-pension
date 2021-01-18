package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CommonProvinceModel
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
@TableName("t_common_province")
public class CommonProvinceModel extends BaseModel<CommonProvinceModel> {

	private static final long serialVersionUID = 1554372822156L;
	
	
	
	
	/**
	 * 使用ID
	 */
	@TableField("use_id")
	private long useId;
	
	/**
	 * 名称
	 */
	@TableField("name")
	private String name;
	
	/**
	 * 邮编
	 */
	@TableField("zipcode")
	private String zipcode;
	
	
	



	public void setUseId(long useId) {
		this.useId = useId;
	}

	public long getUseId() {
		return this.useId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getZipcode() {
		return this.zipcode;
	}


}
