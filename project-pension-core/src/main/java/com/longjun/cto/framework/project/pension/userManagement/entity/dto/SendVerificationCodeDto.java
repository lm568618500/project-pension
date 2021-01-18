package com.longjun.cto.framework.project.pension.userManagement.entity.dto;

/**
 * 验证码DTO
 *
 * @author carson deng
 * @date 2019/11/10 0:05
 */
public class SendVerificationCodeDto {

    /**
     * 类型
     */
    private String type;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 图片验证码key
     */
    private String captchaKey;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCaptchaKey() {
        return captchaKey;
    }

    public void setCaptchaKey(String captchaKey) {
        this.captchaKey = captchaKey;
    }
}
