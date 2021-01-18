package com.longjun.cto.framework.sm.pay.es;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付渠道枚举
 * @author yangxuan
 * @date Jun 1, 2019 - 7:15:14 PM
 */
public enum PayChannelItemsEnum {
	
	ALIPAY_MOBILE(1000010, "支付宝-APP支付"),
	ALIPAY_WEB(1000011, "支付宝-网页支付"),
	ALIPAY_WAP(1000012, "支付宝-手机网页支付"),
	WX_APP(2000010, "微信-App支付"),
	WX_JSAPI(2000011, "微信-JSAPI支付"),
	WX_NATIVE(2000012, "微信-NATIVE支付"),
	
	;

	private long code;

	private String chennelName;
	
	private static Map<Long , PayChannelItemsEnum> dict = new HashMap<>();
	
	static {
		PayChannelItemsEnum[] es = PayChannelItemsEnum.values();
		for(PayChannelItemsEnum e : es) {
			dict.put(e.getCode(), e);
		}
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getChennelName() {
		return chennelName;
	}

	public void setChennelName(String chennelName) {
		this.chennelName = chennelName;
	}

	PayChannelItemsEnum(long code, String chennelName) {
		this.code = code;
		this.chennelName = chennelName;
	}
	
	public static PayChannelItemsEnum match(long code) {
		PayChannelItemsEnum e = dict.get(code);
		return e;
	}

}
