package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * CommonUpgradeAppModel
 * @author yangxuan
 * @date 2019-04-09 08:42:07
 */
public class CommonUpgradeAppView extends BaseView {

	private static final long serialVersionUID = 1554770537328L;
	
	
	
	
	
	/**
	 * AppID
	 */
	private String appId;
	
	/**
	 * App名称
	 */
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
