package com.longjun.cto.framework.project.pension.userManagement.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * UsersModel
 * @author carson
 * @date 2019-10-19 07:48:34
 */
@TableName("t_users")
public class UsersModel extends BaseModel<UsersModel> {

	private static final long serialVersionUID = 1571485723396L;
	
	
	/**
	 * 头像
	 */
	@TableField("photo")
	private String photo;
	
	/**
	 * 用户名(公司名称/姓名)
	 */
	@TableField("name")
	private String name;
	
	/**
	 * 真实姓名
	 */
	@TableField("real_name")
	private String realName;
	
	/**
	 * 手机号
	 */
	@TableField("mobile")
	private String mobile;
	
	/**
	 * 审核操作人id
	 */
	@TableField("admin_id")
	private Long adminId;
	
	
	
	
	/**
	 * 审核状态（0 待审核 1 审核通过 2 审核不通过）
	 */
	@TableField("audit_status")
	private Integer auditStatus;
	
	/**
	 * 备注
	 */
	@TableField("remarks")
	private String remarks;
	
	/**
	 * 0正常，-1删除
	 */
	@TableField("is_del")
	private Integer isDel;
	
	/**
	 * 用户等级ID
	 */
	@TableField("user_grade_id")
	private Long userGradeId;
	
	/**
	 * 用户类别(0 企业用户 1个人用户)
	 */
	@TableField("user_type")
	private Integer userType;
	
	/**
	 * 统一信用代码 /身份证号码
	 */
	@TableField("user_card_id")
	private String userCardId;
	
	/**
	 * 邮箱地址
	 */
	@TableField("user_email")
	private String userEmail;
	
	/**
	 * 审核时间
	 */
	@TableField("audit_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date auditTime;



	/**
	 * 审核备注
	 */
	private String auditRemarks;
	
	/**
	 * 登录帐号
	 */
	@TableField("login_name")
	private String loginName;
	
	/**
	 * 登录密码
	 */
	@TableField("password")
	private String password;
	
	/**
	 * 国家
	 */
	@TableField("country")
	private String country;
	
	/**
	 * 省份
	 */
	@TableField("province")
	private String province;
	
	/**
	 * 城市
	 */
	@TableField("city")
	private String city;
	
	/**
	 * 区域
	 */
	@TableField("district")
	private String district;
	
	/**
	 * 联系地址
	 */
	@TableField("address")
	private String address;
	
	/**
	 * 公司名称（英文）
	 */
	@TableField("company_en_name")
	private String companyEnName;
	
	/**
	 * 公司地址（英文）
	 */
	@TableField("company_en_address")
	private String companyEnAddress;
	
	/**
	 * 法人代表
	 */
	@TableField("legal_representative")
	private String legalRepresentative;
	
	/**
	 * 企业联系人（中文）
	 */
	@TableField("enterprise_cn_contact")
	private String enterpriseCnContact;
	
	/**
	 * 企业联系人（英文）
	 */
	@TableField("enterprise_en_contact")
	private String enterpriseEnContact;
	
	/**
	 * 企业传真
	 */
	@TableField("enterprise_fax")
	private String enterpriseFax;
	
	/**
	 * 联系人座机
	 */
	@TableField("contact_line")
	private String contactLine;
	
	/**
	 * 邮政编码
	 */
	@TableField("post_code")
	private String postCode;
	
	/**
	 * 营业执照
	 */
	@TableField("business_license")
	private String businessLicense;


	/**
	 * QQ
	 */
	@TableField("qq")
	private String qq;

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Long getAdminId() {
		return this.adminId;
	}

	public String getAuditRemarks() {
		return auditRemarks;
	}

	public void setAuditRemarks(String auditRemarks) {
		this.auditRemarks = auditRemarks;
	}


	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Integer getAuditStatus() {
		return this.auditStatus;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setUserGradeId(Long userGradeId) {
		this.userGradeId = userGradeId;
	}

	public Long getUserGradeId() {
		return this.userGradeId;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserCardId(String userCardId) {
		this.userCardId = userCardId;
	}

	public String getUserCardId() {
		return this.userCardId;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public Date getAuditTime() {
		return this.auditTime;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {
		return this.province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setCompanyEnName(String companyEnName) {
		this.companyEnName = companyEnName;
	}

	public String getCompanyEnName() {
		return this.companyEnName;
	}

	public void setCompanyEnAddress(String companyEnAddress) {
		this.companyEnAddress = companyEnAddress;
	}

	public String getCompanyEnAddress() {
		return this.companyEnAddress;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public String getLegalRepresentative() {
		return this.legalRepresentative;
	}

	public void setEnterpriseCnContact(String enterpriseCnContact) {
		this.enterpriseCnContact = enterpriseCnContact;
	}

	public String getEnterpriseCnContact() {
		return this.enterpriseCnContact;
	}

	public void setEnterpriseEnContact(String enterpriseEnContact) {
		this.enterpriseEnContact = enterpriseEnContact;
	}

	public String getEnterpriseEnContact() {
		return this.enterpriseEnContact;
	}

	public void setEnterpriseFax(String enterpriseFax) {
		this.enterpriseFax = enterpriseFax;
	}

	public String getEnterpriseFax() {
		return this.enterpriseFax;
	}

	public void setContactLine(String contactLine) {
		this.contactLine = contactLine;
	}

	public String getContactLine() {
		return this.contactLine;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getBusinessLicense() {
		return this.businessLicense;
	}

}
