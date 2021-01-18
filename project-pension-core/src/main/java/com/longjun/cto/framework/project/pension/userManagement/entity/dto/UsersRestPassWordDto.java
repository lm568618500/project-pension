package com.longjun.cto.framework.project.pension.userManagement.entity.dto;

import java.io.Serializable;

/**
 * @author carson deng
 * @date 2019/10/20 18:34
 */
public class UsersRestPassWordDto implements Serializable {

    private static final long serialVersionUID = 2110927803335527382L;
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 密码
     */
    private String password;

    /**
     * 确认密码
     */
    private String confirmPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
