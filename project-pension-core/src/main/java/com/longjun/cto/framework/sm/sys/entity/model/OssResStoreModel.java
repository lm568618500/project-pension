package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * OssResStoreModel
 * @author yangxuan
 * @date 2019-04-16 06:45:47
 */
@TableName("t_oss_res_store")
public class OssResStoreModel extends BaseModel<OssResStoreModel> {

	private static final long serialVersionUID = 1555411551130L;
	
	
	
	
	
	/**
	 * 是否删除 0正常 -1删除
	 */
	@TableField("is_del")
	private int isDel;
	
	/**
	 * 资源链接
	 */
	@TableField("res_href")
	private String resHref;
	
	/**
	 * 资源名称
	 */
	@TableField("res_name")
	private String resName;
	
	/**
	 * 文件后缀
	 */
	@TableField("res_suf")
	private String resSuf;
	
	/**
	 * 类型ID  t_oss_res_setting
	 */
	@TableField("set_id")
	private long setId;
	
	




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

}
