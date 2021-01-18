package com.longjun.cto.framework.sm.sys.entity.view;

import com.eims.cto.framework.module.base.model.BaseView;

/**
 * Oss资源视图
 * @author yangxuan
 * @date 2018年11月8日 下午1:48:51
 */
public class OssResView extends BaseView{

	private static final long serialVersionUID = -2645177209221983689L;

	/**
	 * 资源名称
	 */
	private String resName;
	
	/**
	 * 资源大小
	 */
	private long resSize;
	
	/**
	 * 文件后缀
	 */
	private String suffix;
	
	/**
	 * 存储类型(1/本地FASTDFS 2/七牛OSS 3/阿里云OSS)
	 */
	private int ossType;
	
	/**
	 * 文件Hash
	 */
	private String fileHash;
	
	/**
	 * IP
	 */
	private String ip;
	
	private String group;
	
	/**
	 * 远程地址
	 */
	private String remoteResPath;
	
	/**
	 * 远程全地址
	 */
	private String remoteResFullPath;

	/**
	 * 预览地址
	 */
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
