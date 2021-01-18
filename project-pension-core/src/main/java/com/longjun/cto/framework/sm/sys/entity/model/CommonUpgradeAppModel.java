package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * CommonUpgradeAppModel
 * @author yangxuan
 * @date 2019-04-09 08:42:07
 */
@TableName("t_common_upgrade_app")
public class CommonUpgradeAppModel extends BaseModel<CommonUpgradeAppModel> {

	private static final long serialVersionUID = 1554770535772L;
	
	
	
	
	
	/**
	 * AppID
	 */
	@TableField("app_id")
	private String appId;
	
	/**
	 * App名称
	 */
	@TableField("app_name")
	private String appName;
	
	




	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppId() {
		return this.appId;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppName() {
		return this.appName;
	}

}
