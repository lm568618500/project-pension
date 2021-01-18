package com.longjun.cto.framework.project.pension.constant;

/**
 * 认证阶段
 *
 * @author carson deng
 * @date 2019/10/7 21:13
 */
public enum AuthenticationStageEnum {

    /**
     * 认证中止
     */
    CERTIFICATION_SUSPENSION(-1, "认证中止"),

    /**
     * 等待受理
     */
    WAITING_ACCEPT(1, "等待受理"),

    /**
     * 认证方案待填写
     */
    AUTHENTICATION_SCHEME(2, "认证方案待填写"),

    /**
     * 型式试验
     */
    TYPE_TEST(3, "型式试验"),

    /**
     * 工厂检查
     */
    FACTORY_INSPECTION(4, "工厂检查"),

    /**
     * 合格评定
     */
    CONFORMITY_ASSESSMENT(5, "合格评定"),

    /**
     * 证书签发中
     */
    CERTIFICATE_ISSUANCE(6, "证书签发中"),

    /**
     * 认证异常
     */
    AUTHENTICATION_EXCEPTION(7, "认证异常");


    private int code;


    private String desc;


    AuthenticationStageEnum(int code, String desc) {

        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code获取枚举类型
     *
     * @param code
     * @return
     */
    public static AuthenticationStageEnum getValueByCode(String code) {
        for (AuthenticationStageEnum item : AuthenticationStageEnum.values()) {
            if (code.equals(item.getCode())) {
                return item;
            }
        }
        return null;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
