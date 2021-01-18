package com.longjun.cto.framework.sm.message.es;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信枚举
 * 
 * @author yangxuan
 * @date May 30, 2019 - 9:30:09 PM
 */
public enum SmsChannelEnums {

	TENCENT(100000, "腾讯云短信"), ALISMS(100001, "阿里云短信"), SMS253(100002, "253短信(创蓝)"), DXT(100003, "短信通短信"),

	;

	private long channelId;

	private String channelName;

	private static Map<Long, SmsChannelEnums> dict = new HashMap<>();

	static {
		SmsChannelEnums[] es = SmsChannelEnums.values();
		for (SmsChannelEnums e : es) {
			dict.put(e.getChannelId(), e);
		}
	}

	public long getChannelId() {
		return channelId;
	}

	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	SmsChannelEnums(long channelId, String channelName) {
		this.channelId = channelId;
		this.channelName = channelName;
	}

	public static SmsChannelEnums match(long channelId) {
		SmsChannelEnums e = dict.get(channelId);
		return e;
	}

}
