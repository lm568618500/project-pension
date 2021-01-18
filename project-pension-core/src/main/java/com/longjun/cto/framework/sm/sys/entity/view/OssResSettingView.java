package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * OssResSettingModel
 * @author yangxuan
 * @date 2019-04-16 06:45:48
 */
public class OssResSettingView extends BaseView {

	private static final long serialVersionUID = 1555411551762L;
	
	
	
	
	
	/**
	 * 删除状态 0正常 -1删除
	 */
	private int isDel;
	
	/**
	 * 父ID
	 */
	private long pId;
	
	/**
	 * 设置名称
	 */
	private String setName;
	
	/**
	 * 资源类型1、图片 2音频 3、视频
	 */
	private int resType;
	
	
	/**
	 * 父类名称
	 */
	private String pSetName;




	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public String getpSetName() {
		return pSetName;
	}

	public void setpSetName(String pSetName) {
		this.pSetName = pSetName;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

	public void setPId(long pId) {
		this.pId = pId;
	}

	public long getPId() {
		return this.pId;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	public String getSetName() {
		return this.setName;
	}

	public void setResType(int resType) {
		this.resType = resType;
	}

	public int getResType() {
		return this.resType;
	}

}
