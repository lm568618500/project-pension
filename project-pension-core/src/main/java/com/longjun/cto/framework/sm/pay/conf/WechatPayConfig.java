package com.longjun.cto.framework.sm.pay.conf;

/**
 * 微信支付配置
 * 
 * @author yangxuan
 * @date Oct 28, 2019 - 3:39:04 PM
 */
public class WechatPayConfig {

	private String appId;
	private String mchId;
	private String mchKey;
	private String subAppId;
	private String subMchId;
	private String keyPath;
	/**
	 * 转账公钥，转账时必填
	 */
	private String keyPublic;
	private String secretKey;
	private String notifyUrl;
	private String returnUrl;
	private String signType;

	private boolean sandBox;

	public String getKeyPublic() {
		return keyPublic;
	}

	public void setKeyPublic(String keyPublic) {
		this.keyPublic = keyPublic;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
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

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getMchKey() {
		return mchKey;
	}

	public void setMchKey(String mchKey) {
		this.mchKey = mchKey;
	}

	public String getSubAppId() {
		return subAppId;
	}

	public void setSubAppId(String subAppId) {
		this.subAppId = subAppId;
	}

	public String getSubMchId() {
		return subMchId;
	}

	public void setSubMchId(String subMchId) {
		this.subMchId = subMchId;
	}

	public String getKeyPath() {
		return keyPath;
	}

	public void setKeyPath(String keyPath) {
		this.keyPath = keyPath;
	}

	public boolean isSandBox() {
		return sandBox;
	}

	public void setSandBox(boolean sandBox) {
		this.sandBox = sandBox;
	}

}
