package com.longjun.cto.framework.sm.sys.es;

public enum OssTypeEnums {
	
	LOCAL(0, "LOCAL"),
	FASTDFS(1, "FASTDFS"),
	QINIU(2, "七牛"),
	ALIYUN(3, "阿里云"),
	
	;
	private int type;
	
	private String name;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	OssTypeEnums(int type  , String name){
		this.type = type;
		this.name = name;
	}
	
	public static OssTypeEnums matchEnums(int type){
		OssTypeEnums[] es = OssTypeEnums.values();
		for(OssTypeEnums e : es){
			if(e.getType() == type){
				return e;
			}
		}
		return null;
	}

}
