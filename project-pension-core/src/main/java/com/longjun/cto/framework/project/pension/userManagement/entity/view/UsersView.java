package com.longjun.cto.framework.project.pension.userManagement.entity.view;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.eims.cto.framework.module.base.model.BaseView;

/**
 * UsersModel
 *
 * @author carson
 * @date 2019-10-19 07:48:34
 */
public class UsersView extends BaseView {

    private static final long serialVersionUID = 1571485718216L;


    /**
     * 头像
     */
    private String photo;

    /**
     * 用户名(公司名称/姓名)
     */
    private String name;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 审核操作人id
     */
    private Long adminId;


    /**
     * 审核状态（0 待审核 1 审核通过 2 审核不通过）
     */
    private Integer auditStatus;

    /**
     * 审核状态
     */
    private String auditStatusStr;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 0正常，-1删除
     */
    private Integer isDel;

    /**
     * 用户等级ID
     */
    private Long userGradeId;


    /**
     * 用户等级
     */
    private String gradeLevel;

    /**
     * 用户类别(0 企业用户 1个人用户)
     */
    private Integer userType;

    /**
     * 用户类别(0 企业用户 1个人用户)
     */
    private String userTypeStr;

    /**
     * 统一信用代码 /身份证号码
     */
    private String userCardId;

    /**
     * 邮箱地址
     */
    private String userEmail;

    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date auditTime;


    /**
     * 审核备注
     */
    private String auditRemarks;

    /**
     * 登录帐号
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 国家
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区域
     */
    private String district;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 公司名称（英文）
     */
    private String companyEnName;

    /**
     * 公司地址（英文）
     */
    private String companyEnAddress;

    /**
     * 法人代表
     */
    private String legalRepresentative;

    /**
     * 企业联系人（中文）
     */
    private String enterpriseCnContact;

    /**
     * 企业联系人（英文）
     */
    private String enterpriseEnContact;

    /**
     * 企业传真
     */
    private String enterpriseFax;

    /**
     * 联系人座机
     */
    private String contactLine;

    /**
     * 邮政编码
     */
    private String postCode;

    /**
     * 营业执照
     */
    private String businessLicense;


    /**
     * 审核人名称
     */
    private String adminName;

    /**
     * 证书数
     *
     * @param photo
     */
    private Long certificatesNumber;

    /**
     * QQ
     */
    private String qq;

    /**
     * 状态描述
     */
    private String statusStr;

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAuditRemarks() {
        return auditRemarks;
    }

    public void setAuditRemarks(String auditRemarks) {
        this.auditRemarks = auditRemarks;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Long getCertificatesNumber() {
        return certificatesNumber;
    }

    public void setCertificatesNumber(Long certificatesNumber) {
        this.certificatesNumber = certificatesNumber;
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

    public String getAuditStatusStr() {

        switch (this.auditStatus) {
            case 0:
                this.auditStatusStr = "待审核";
                break;
            case 1:
                this.auditStatusStr = "审核通过";
                break;
            case 2:
                this.auditStatusStr = "审核未通过";
                break;
        }

        return auditStatusStr;
    }


    public String getStatusStr() {
        switch (this.status) {
            case 0:
                this.statusStr = "正常";
                break;
            case 1:
                this.statusStr = "禁用";
                break;
        }

        return this.statusStr;
    }

    public String getUserTypeStr() {
        switch (this.userType) {
            case 0:
                this.userTypeStr = "企业用户";
                break;
            case 1:
                this.userTypeStr = "个人用户";
                break;
        }

        return this.userTypeStr;
    }
}
