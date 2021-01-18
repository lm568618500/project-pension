package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * CommonProvinceModel
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
public class CommonProvinceView extends BaseView {

	private static final long serialVersionUID = 1554372819033L;
	
	
	
	
	/**
	 * 使用ID
	 */
	private long useId;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 邮编
	 */
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
