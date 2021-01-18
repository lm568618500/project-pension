package com.longjun.cto.framework.sm.users.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UserAddressModel
 * @author heqiang
 * @date 2019-07-03 06:22:57
 */
@TableName("t_user_address")
public class UserAddressModel extends BaseModel<UserAddressModel> {

	private static final long serialVersionUID = 1562149386789L;
	
	
	/**
	 * 登录用户id
	 */
	@TableField("user_id")
	private java.lang.Long userId;
	
	/**
	 * 收货人真实姓名
	 */
	@TableField("user_real_name")
	private java.lang.String userRealName;
	
	/**
	 * 收货人手机号
	 */
	@TableField("user_telephone")
	private java.lang.String userTelephone;
	
	/**
	 * 邮编地址
	 */
	@TableField("zip_code")
	private java.lang.String zipCode;
	
	/**
	 * 省id
	 */
	@TableField("province_id")
	private java.lang.Integer provinceId;
	
	/**
	 * 省名称
	 */
	@TableField("province_name")
	private java.lang.String provinceName;
	
	/**
	 * 市id
	 */
	@TableField("city_id")
	private java.lang.Integer cityId;
	
	/**
	 * 市名称
	 */
	@TableField("city_name")
	private java.lang.String cityName;
	
	/**
	 * 区id
	 */
	@TableField("area_id")
	private java.lang.Integer areaId;
	
	/**
	 * 区名称
	 */
	@TableField("area_name")
	private java.lang.String areaName;
	
	/**
	 * 详细地址
	 */
	@TableField("address_detail")
	private java.lang.String addressDetail;
	
	/**
	 * 是否是默认收货地址 默认收货地址只能有一个 0不是 1表示是
	 */
	@TableField("is_default")
	private java.lang.Integer isDefault;
	
	/**
	 * 是否删除（1是，0否）
	 */
	@TableField("is_del")
	private java.lang.Integer isDel;
	
	
	
	
	

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




}
