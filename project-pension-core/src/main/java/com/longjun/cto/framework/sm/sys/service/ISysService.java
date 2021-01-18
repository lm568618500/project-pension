package com.longjun.cto.framework.sm.sys.service;

import java.util.Date;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.module.base.service.MircoBaseService;

/**
 * 系统业务接口
 * 
 * @author yangxuan
 * @date Jul 6, 2019 - 3:07:42 PM
 */
public interface ISysService extends MircoBaseService {

	/**
	 * 是否为开发模式
	 * 
	 * @return
	 */
	public boolean isDev() throws BusinessException;

	/**
	 * 服务器时间
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public Date serverTime() throws BusinessException;

	/**
	 * 获取Server Url地址
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public String serverUrl() throws BusinessException;

	/**
	 * 获取Public Static Server Url地址 - 公共文件资源地址
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public String publicStaticUrlSupervisor() throws BusinessException;

	/**
	 * 获取 Static Server Url地址 - 文件资源地址
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public String staticUrlSupervisor() throws BusinessException;

	/**
	 * 获取 Front Static Server Url地址 - 前台文件资源地址
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public String frontStaticUrlSupervisor() throws BusinessException;

	/**
	 * 获取Public Static Server Url地址 - 公共文件资源地址
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public String publicStaticUrlFront() throws BusinessException;

	/**
	 * 获取 Static Server Url地址 - 文件资源地址
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public String staticUrlFront() throws BusinessException;

	/**
	 * 获取 Front Static Server Url地址 - 前台文件资源地址
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public String frontStaticUrlFront() throws BusinessException;

}
