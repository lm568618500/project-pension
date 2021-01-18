package com.longjun.cto.framework.project.pension.userManagement.entity.dto;

/**
 * @author carson deng
 * @date 2019/11/9 15:47
 */
public class UserLoginDto {

    /**
     * 用户帐号

     */
    private String userName;

    /**
     * 密码
     */
    private String password;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
