package com.longjun.cto.framework.sm.sys.entity.view;

import java.io.Serializable;

/**
 * 文件保存返回视图
 * @author yangxuan
 * @date 2018年11月8日 下午4:36:15
 */
public class OssResSaveView implements Serializable{

	private static final long serialVersionUID = 7230422859171763034L;

	private String fileName;
	
	private long fileSize;
	
	private String remoteName;
	
	private String attachment;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getRemoteName() {
		return remoteName;
	}

	public void setRemoteName(String remoteName) {
		this.remoteName = remoteName;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
}
