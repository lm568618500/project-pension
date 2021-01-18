package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * OssResSettingModel
 * @author yangxuan
 * @date 2019-04-16 06:45:48
 */
@TableName("t_oss_res_setting")
public class OssResSettingModel extends BaseModel<OssResSettingModel> {

	private static final long serialVersionUID = 1555411555966L;
	
	
	
	
	
	/**
	 * 删除状态 0正常 -1删除
	 */
	@TableField("is_del")
	private int isDel;
	
	/**
	 * 父ID
	 */
	@TableField("p_id")
	private long pId;
	
	/**
	 * 设置名称
	 */
	@TableField("set_name")
	private String setName;
	
	/**
	 * 资源类型1、图片 2音频 3、视频
	 */
	@TableField("res_type")
	private int resType;
	
	




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
