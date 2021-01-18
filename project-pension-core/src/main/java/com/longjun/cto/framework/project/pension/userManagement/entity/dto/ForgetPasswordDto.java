package com.longjun.cto.framework.project.pension.userManagement.entity.dto;

/**
 * 忘记密码
 *
 * @author carson deng
 * @date 2019/11/10 21:24
 */
public class ForgetPasswordDto {

    /**
     * 手机
     */
    private String mobile;



    /**

     * 验证码
     */
    private String verificationCode;

    /**
     * 密码
     */
    private String password;

    /**
     * 确定密码
     */
    private String confirmPassword;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
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
}
