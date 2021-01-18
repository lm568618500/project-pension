package com.longjun.cto.framework.sm.message.es;

import java.util.HashMap;
import java.util.Map;

/**
 * 操作系统枚举
 * 
 * @author yangxuan
 * @date May 30, 2019 - 9:30:09 PM
 */
public enum OsTypeEnums {

	Android(1, "安卓"),

	iOS(1, "iOS"),

	;

	private int type;

	private String os;

	private static Map<Integer, OsTypeEnums> dict = new HashMap<>();

	static {
		OsTypeEnums[] es = OsTypeEnums.values();
		for (OsTypeEnums e : es) {
			dict.put(e.getType(), e);
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	OsTypeEnums(int type, String os) {
		this.type = type;
		this.os = os;
	}

	public static OsTypeEnums match(int type) {
		OsTypeEnums e = dict.get(type);
		return e;
	}

}
