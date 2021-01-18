package com.longjun.cto.framework.sm.sys.entity.dto;

import com.eims.cto.framework.module.base.model.BaseDTO;

/**
 * Oss资源Dto
 * @author yangxuan
 * @date 2018年11月8日 下午1:49:51
 */
public class OssResDto extends BaseDTO{

	private static final long serialVersionUID = 2943622417410455410L;

	/**
	 * 文件名称
	 */
	private String c_fileName;
	
	/**
	 * 路径
	 */
	private String c_filePath;
	
	/**
	 * 资源名称
	 */
	private String c_resName;
	
	

	public String getC_fileName() {
		return c_fileName;
	}

	public void setC_fileName(String c_fileName) {
		this.c_fileName = c_fileName;
	}

	public String getC_filePath() {
		return c_filePath;
	}

	public void setC_filePath(String c_filePath) {
		this.c_filePath = c_filePath;
	}
	
	
	
	
}
