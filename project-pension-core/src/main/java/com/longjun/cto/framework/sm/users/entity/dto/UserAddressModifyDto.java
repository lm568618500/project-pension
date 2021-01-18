package com.longjun.cto.framework.sm.users.entity.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;

/**
 * UserAddressModel
 * @author heqiang
 * @date 2019-07-03 06:22:57
 */
public class UserAddressModifyDto implements Serializable {

	private static final long serialVersionUID = 1562149381650L;
	
	/**
	 * 
	 */
	private java.lang.Long id;
	/**
	 * 登录用户id
	 */
	private java.lang.Long userId;
	/**
	 * 收货人真实姓名
	 */
	private java.lang.String userRealName;
	/**
	 * 收货人手机号
	 */
	private java.lang.String userTelephone;
	/**
	 * 邮编地址
	 */
	private java.lang.String zipCode;
	/**
	 * 省id
	 */
	private java.lang.Integer provinceId;
	/**
	 * 省名称
	 */
	private java.lang.String provinceName;
	/**
	 * 市id
	 */
	private java.lang.Integer cityId;
	/**
	 * 市名称
	 */
	private java.lang.String cityName;
	/**
	 * 区id
	 */
	private java.lang.Integer areaId;
	/**
	 * 区名称
	 */
	private java.lang.String areaName;
	/**
	 * 详细地址
	 */
	private java.lang.String addressDetail;
	/**
	 * 是否是默认收货地址 默认收货地址只能有一个 0不是 1表示是
	 */
	private java.lang.Integer isDefault;
	/**
	 * 是否删除（1是，0否）
	 */
	private java.lang.Integer isDel;
	/**
	 * 最后一次修改的时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date lastupdate;
	/**
	 * 时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date time;
	/**
	 * 状态
	 */
	private java.lang.Integer status;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}
	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}

	public java.lang.Long getUserId() {
		return this.userId;
	}
	public void setUserRealName(java.lang.String userRealName) {
		this.userRealName = userRealName;
	}

	public java.lang.String getUserRealName() {
		return this.userRealName;
	}
	public void setUserTelephone(java.lang.String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public java.lang.String getUserTelephone() {
		return this.userTelephone;
	}
	public void setZipCode(java.lang.String zipCode) {
		this.zipCode = zipCode;
	}

	public java.lang.String getZipCode() {
		return this.zipCode;
	}
	public void setProvinceId(java.lang.Integer provinceId) {
		this.provinceId = provinceId;
	}

	public java.lang.Integer getProvinceId() {
		return this.provinceId;
	}
	public void setProvinceName(java.lang.String provinceName) {
		this.provinceName = provinceName;
	}

	public java.lang.String getProvinceName() {
		return this.provinceName;
	}
	public void setCityId(java.lang.Integer cityId) {
		this.cityId = cityId;
	}

	public java.lang.Integer getCityId() {
		return this.cityId;
	}
	public void setCityName(java.lang.String cityName) {
		this.cityName = cityName;
	}

	public java.lang.String getCityName() {
		return this.cityName;
	}
	public void setAreaId(java.lang.Integer areaId) {
		this.areaId = areaId;
	}

	public java.lang.Integer getAreaId() {
		return this.areaId;
	}
	public void setAreaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	public java.lang.String getAreaName() {
		return this.areaName;
	}
	public void setAddressDetail(java.lang.String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public java.lang.String getAddressDetail() {
		return this.addressDetail;
	}
	public void setIsDefault(java.lang.Integer isDefault) {
		this.isDefault = isDefault;
	}

	public java.lang.Integer getIsDefault() {
		return this.isDefault;
	}
	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	public java.lang.Integer getIsDel() {
		return this.isDel;
	}
	public void setLastupdate(java.util.Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public java.util.Date getLastupdate() {
		return this.lastupdate;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public java.util.Date getTime() {
		return this.time;
	}
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}
}
