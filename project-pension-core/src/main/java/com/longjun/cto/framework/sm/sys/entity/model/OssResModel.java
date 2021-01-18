package com.longjun.cto.framework.sm.sys.entity.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.eims.cto.framework.module.base.model.BaseModel;

/**
 * Oss资源模型
 * @author yangxuan
 * @date 2018年11月8日 下午1:42:55
 */
@TableName("t_oss_resource")
public class OssResModel extends BaseModel<OssResModel>{
	
	private static final long serialVersionUID = 5714389888812174825L;

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
	 * 预览地址
	 */
	@TableField("pre_view_path")
	private String preViewPath;
	

	public String getPreViewPath() {
		return preViewPath;
	}

	public void setPreViewPath(String preViewPath) {
		this.preViewPath = preViewPath;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public long getResSize() {
		return resSize;
	}

	public void setResSize(long resSize) {
		this.resSize = resSize;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public int getOssType() {
		return ossType;
	}

	public void setOssType(int ossType) {
		this.ossType = ossType;
	}

	public String getFileHash() {
		return fileHash;
	}

	public void setFileHash(String fileHash) {
		this.fileHash = fileHash;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRemoteResPath() {
		return remoteResPath;
	}

	public void setRemoteResPath(String remoteResPath) {
		this.remoteResPath = remoteResPath;
	}

	public String getRemoteResFullPath() {
		return remoteResFullPath;
	}

	public void setRemoteResFullPath(String remoteResFullPath) {
		this.remoteResFullPath = remoteResFullPath;
	}
	
}
