package com.longjun.cto.framework.sm.users.entity.view;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * UserLevelDictModel
 * 
 * @author yangxuan
 * @date 2019-06-28 04:46:45
 */
public class UserLevelDictView extends BaseView {

	private static final long serialVersionUID = 1561711610150L;

	/**
	 * 删除状态 0正常 -1删除
	 */
	private java.lang.Integer isDel;

	/**
	 * 等级名称
	 */
	private java.lang.String levelName;

	/**
	 * 积分
	 */
	private java.lang.Long socre;

	/**
	 * 图标
	 */
	private String img;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}

	public void setLevelName(java.lang.String levelName) {
		this.levelName = levelName;
	}

	public java.lang.String getLevelName() {
		return this.levelName;
	}

	public void setSocre(java.lang.Long socre) {
		this.socre = socre;
	}

	public java.lang.Long getSocre() {
		return this.socre;
	}

}
