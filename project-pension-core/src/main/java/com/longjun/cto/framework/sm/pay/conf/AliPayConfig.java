package com.longjun.cto.framework.sm.pay.conf;

/**
 * 支付宝支付配置
 * 
 * @author yangxuan
 * @date Oct 28, 2019 - 4:24:24 PM
 */
public class AliPayConfig {

	/**
	 * 合作者id
	 */
	private String pId;

	/**
	 * 应用id
	 */
	private String appId;

	/**
	 * 支付宝公钥
	 */
	private String keyPublic;

	/**
	 * 应用私钥
	 */
	private String keyPrivate;

	/**
	 * 异步回调地址
	 */
	private String notifyUrl;
	/**
	 * 同步回调地址
	 */
	private String returnUrl;

	/**
	 * 签名方式
	 */
	private String signType;

	/**
	 * 收款账号
	 */
	private String seller;

	private String inputCharset;

	/**
	 * 是否为测试账号，沙箱环境
	 */
	private boolean test;

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getKeyPublic() {
		return keyPublic;
	}

	public void setKeyPublic(String keyPublic) {
		this.keyPublic = keyPublic;
	}

	public String getKeyPrivate() {
		return keyPrivate;
	}

	public void setKeyPrivate(String keyPrivate) {
		this.keyPrivate = keyPrivate;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getInputCharset() {
		return inputCharset;
	}

	public void setInputCharset(String inputCharset) {
		this.inputCharset = inputCharset;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

}
