package com.longjun.cto.framework.sm.message.es;

import java.util.HashMap;
import java.util.Map;

/**
 * 推送枚举
 * 
 * @author yangxuan
 * @date May 30, 2019 - 9:30:09 PM
 */
public enum PushChannelEnums {

	UMENG(300000, "友盟推送"), JIGUANG(300001, "极光推送"), WANGYIYUNXIN(300002, "网易云信推送"), XINGE(300003, "腾讯-信鸽推送"),

	;

	private long channelId;

	private String channelName;

	private static Map<Long, PushChannelEnums> dict = new HashMap<>();
	
	static {
		PushChannelEnums[] es = PushChannelEnums.values();
		for(PushChannelEnums e : es) {
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

	PushChannelEnums(long channelId, String channelName) {
		this.channelId = channelId;
		this.channelName = channelName;
	}
	
	public static PushChannelEnums match(long channelId) {
		PushChannelEnums e = dict.get(channelId);
		return e;
	}

}
