package com.longjun.cto.framework.sm.sys.entity.view;

import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 广告条信息表View
 * @author heqiang
 * @date 2018-12-08 08:44:03
 */
public class NewBannerView {

	private static final long serialVersionUID = 1544229843801L;

	public NewBannerView() {
		
	}

	/**
	 * 类型（1、首页banner 2、弹窗广告 3、模块广告图，4、文章分类广告5、商品分类广告 6、启动页广告）
	 */
	@TableField("type")
	private int type;


	/**
	 * 所在位置
	 */
	@TableField("location")
	private String location;

	/**
	 * 图片名称
	 */
	@TableField("name")
	private String name;
	/**
	 * 图片名称
	 */
	@TableField("description")
	private String description;

	/**
	 * 所属板块id
	 */
	@TableField("parent_id")
	private long parentId;
	

	/**
	 * 广告链接
	 */
	@TableField("img_url")
	private String imgUrl;

	/**
	 * 是否启用超链接(0为不启用 ，1为启用
)
	 */
	@TableField("is_link_enabled")
	private int isLinkEnabled;

	/**
	 * 0  轮播 1单播
	 */
	@TableField("target")
	private int target;


	/**
	 * 跳转id
	 */
	@TableField("jump_id")
	private long jumpId;
	

	/**
	 * 跳转id
	 */
	@TableField("jump_name")
	private String jumpName;

	/**
	 * 跳转类型
	 */
	@TableField("jump_type")
	private int jumpType;

	/**
	 * 跳转链接
	 */
	@TableField("jump_url")
	private String jumpUrl;

	/**
	 * 开始时间
	 */
	@TableField("start_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date startTime;

	/**
	 * 结束时间
	 */
	@TableField("end_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private java.util.Date endTime;

	/**
	 * 活动详情
	 */
	@TableField("content")
	private String content;
	/**
	 * id
	 */
	@TableField("id")
	private long id;


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}


	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return this.location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}


	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public void setIsLinkEnabled(int isLinkEnabled) {
		this.isLinkEnabled = isLinkEnabled;
	}

	public int getIsLinkEnabled() {
		return this.isLinkEnabled;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getTarget() {
		return this.target;
	}



	public void setJumpId(long jumpId) {
		this.jumpId = jumpId;
	}

	public long getJumpId() {
		return this.jumpId;
	}

	public void setJumpType(int jumpType) {
		this.jumpType = jumpType;
	}

	public int getJumpType() {
		return this.jumpType;
	}

	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}

	public java.util.Date getStartTime() {
		return this.startTime;
	}

	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}

	public java.util.Date getEndTime() {
		return this.endTime;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}


	public String getJumpUrl() {
		return jumpUrl;
	}

	public void setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl;
	}

	public String getJumpName() {
		return jumpName;
	}

	public void setJumpName(String jumpName) {
		this.jumpName = jumpName;
	}

}
