package com.longjun.cto.framework.sm.sys.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * OssResStoreModel
 * @author yangxuan
 * @date 2019-04-16 06:45:47
 */
public class OssResStoreView extends BaseView {

	private static final long serialVersionUID = 1555411553917L;
	
	
	
	
	
	/**
	 * 是否删除 0正常 -1删除
	 */
	private int isDel;
	
	/**
	 * 资源链接
	 */
	private String resHref;
	
	/**
	 * 资源名称
	 */
	private String resName;
	
	/**
	 * 文件后缀
	 */
	private String resSuf;
	
	/**
	 * 类型ID  t_oss_res_setting
	 */
	private long setId;
	
	

    //非持久字段
	private String setName;//归类名称


	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

	public void setResHref(String resHref) {
		this.resHref = resHref;
	}

	public String getResHref() {
		return this.resHref;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResName() {
		return this.resName;
	}

	public void setResSuf(String resSuf) {
		this.resSuf = resSuf;
	}

	public String getResSuf() {
		return this.resSuf;
	}

	public void setSetId(long setId) {
		this.setId = setId;
	}

	public long getSetId() {
		return this.setId;
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

}
