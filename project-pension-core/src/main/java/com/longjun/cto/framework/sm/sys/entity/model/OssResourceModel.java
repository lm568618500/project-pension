package com.longjun.cto.framework.sm.sys.entity.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * OssResourceModel
 * @author yangxuan
 * @date 2019-04-01 07:19:42
 */
@TableName("t_oss_resource")
public class OssResourceModel extends BaseModel<OssResourceModel> {

	private static final long serialVersionUID = 1554117585479L;
	
	
	
	/**
	 * 资源名称
	 */
	@TableField("res_name")
	private String resName;
	
	/**
	 * 资源大小
	 */
	@TableField("res_size")
	private long resSize;
	
	/**
	 * 文件后缀
	 */
	@TableField("suffix")
	private String suffix;
	
	/**
	 * 存储类型(1/本地FASTDFS 2/七牛OSS 3/阿里云OSS)
	 */
	@TableField("oss_type")
	private int ossType;
	
	/**
	 * 文件Hash
	 */
	@TableField("file_hash")
	private String fileHash;
	
	/**
	 * IP
	 */
	@TableField("ip")
	private String ip;
	
	/**
	 * FASTDFS组
	 */
	@TableField("group")
	private String group;
	
	/**
	 * 远程地址
	 */
	@TableField("remote_res_path")
	private String remoteResPath;
	
	/**
	 * 远程全地址
	 */
	@TableField("remote_res_full_path")
	private String remoteResFullPath;
	
	/**
	 * 
	 */
	@TableField("pre_view_path")
	private String preViewPath;
	
	


	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResName() {
		return this.resName;
	}

	public void setResSize(long resSize) {
		this.resSize = resSize;
	}

	public long getResSize() {
		return this.resSize;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setOssType(int ossType) {
		this.ossType = ossType;
	}

	public int getOssType() {
		return this.ossType;
	}

	public void setFileHash(String fileHash) {
		this.fileHash = fileHash;
	}

	public String getFileHash() {
		return this.fileHash;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getGroup() {
		return this.group;
	}

	public void setRemoteResPath(String remoteResPath) {
		this.remoteResPath = remoteResPath;
	}

	public String getRemoteResPath() {
		return this.remoteResPath;
	}

	public void setRemoteResFullPath(String remoteResFullPath) {
		this.remoteResFullPath = remoteResFullPath;
	}

	public String getRemoteResFullPath() {
		return this.remoteResFullPath;
	}

	public void setPreViewPath(String preViewPath) {
		this.preViewPath = preViewPath;
	}

	public String getPreViewPath() {
		return this.preViewPath;
	}

}
