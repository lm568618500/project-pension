package com.longjun.cto.framework.project.pension.userManagement.entity.dto;


import com.eims.cto.framework.module.base.model.BaseDTO;




/**
 * 个人
 * @author carson deng
 * @date 2019/11/10 0:17
 */
public class PersonalRegistrationDto extends BaseDTO {



    /**
     * 用户名(公司名称/姓名)
     */

    private String name;


    /**
     * 手机号
     */
    private String mobile;



    /**
     * 统一信用代码 /身份证号码
     */
    private String userCardId;

    /**
     * 邮箱地址
     */

    private String userEmail;


    /**
     * 登录帐号
     */
    private String loginName;

    /**
     * 登录密码
     */

    private String password;
    /**
     * 确定密码
     */
    private String confirmPassword;


    /**
     * 联系地址
     */

    private String address;


    /**
     * 手机验证码
     */
    private String verificationCode;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(String userCardId) {
        this.userCardId = userCardId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
