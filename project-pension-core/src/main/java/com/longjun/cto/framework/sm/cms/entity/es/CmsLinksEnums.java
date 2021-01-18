package com.longjun.cto.framework.sm.cms.entity.es;

/**
 * 枚举.
 * 
 * @author yangxuan
 * @date Jun 18, 2019 - 4:32:52 PM
 */
public enum CmsLinksEnums {

	FRIENDSHIPLINKS(1, "友情链接"),
	
	PARTNER(2, "合作伙伴"),


	;

	private int linkType;

	private String typeName;

	public int getLinkType() {
		return linkType;
	}

	public void setLinkType(int linkType) {
		this.linkType = linkType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	CmsLinksEnums(int linkType, String typeName) {
		this.linkType = linkType;
		this.typeName = typeName;
	}

}
