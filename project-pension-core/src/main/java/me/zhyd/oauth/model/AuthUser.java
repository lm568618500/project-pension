package me.zhyd.oauth.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import me.zhyd.oauth.config.AuthSource;

/**
 * 授权成功后的用户信息，根据授权平台的不同，获取的数据完整性也不同
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @since 1.8
 */
public class AuthUser {
	/**
	 * 用户第三方系统的唯一id。在调用方集成改组件时，可以用uuid + source唯一确定一个用户
	 */
	private String uuid;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户昵称
	 */
	private String nickname;
	/**
	 * 用户头像
	 */
	private String avatar;
	/**
	 * 用户网址
	 */
	private String blog;
	/**
	 * 所在公司
	 */
	private String company;
	/**
	 * 位置
	 */
	private String location;
	/**
	 * 用户邮箱
	 */
	private String email;
	/**
	 * 用户备注（各平台中的用户个人介绍）
	 */
	private String remark;
	/**
	 * 性别
	 */
	private AuthUserGender gender;
	/**
	 * 用户来源
	 */
	private AuthSource source;
	/**
	 * 用户授权的token信息
	 */
	private AuthToken token;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public AuthUserGender getGender() {
		return gender;
	}

	public void setGender(AuthUserGender gender) {
		this.gender = gender;
	}

	public AuthSource getSource() {
		return source;
	}

	public void setSource(AuthSource source) {
		this.source = source;
	}

	public AuthToken getToken() {
		return token;
	}

	public void setToken(AuthToken token) {
		this.token = token;
	}

}
