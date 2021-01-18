package com.longjun.cto.framework.sm.sys.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 广告条信息表Model
 * @author heqiang
 * @date 2018-12-08 08:44:03
 */
@TableName("t_banner")
public class BannerModel extends BaseModel<BannerModel> {

	private static final long serialVersionUID = 1544229843552L;

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
	 * 客户端类型：0 pc 1 app
	 */
	@TableField("client_type")
	private int clientType;
	/**
	 * 所在位置
	 */
	@TableField("description")
	private String description;
	/**
	 * 图片名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 所属板块id
	 */
	@TableField("plate_id")
	private long plateId;
	
	/**
	 * 图片分辨率
	 */
	@TableField("resolution")
	private String resolution;

	/**
	 * 建议文件大小
	 */
	@TableField("file_size")
	private String fileSize;

	/**
	 * 文件格式
	 */
	@TableField("file_format")
	private String fileFormat;

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
	 * 排序
	 */
	@TableField("sort")
	private int sort;


	/**
	 * 跳转id
	 */
	@TableField("jump_id")
	private long jumpId;

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
	 * 父级id
	 */
	@TableField("parent_id")
	private long parentId;


	/**
	 * 是否删除（0否，1是）
	 */
	@TableField("is_del")
	private int isDel;
	/**
	 * 点击次数
	 */
	@TableField("clicks")
	private int clicks;

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

	public void setPlateId(long plateId) {
		this.plateId = plateId;
	}

	public long getPlateId() {
		return this.plateId;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getResolution() {
		return this.resolution;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileSize() {
		return this.fileSize;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public String getFileFormat() {
		return this.fileFormat;
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

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getSort() {
		return this.sort;
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

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getParentId() {
		return this.parentId;
	}


	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsDel() {
		return this.isDel;
	}

	public String getJumpUrl() {
		return jumpUrl;
	}

	public void setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl;
	}

	public int getClientType() {
		return clientType;
	}

	public void setClientType(int clientType) {
		this.clientType = clientType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	
}
