package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonTdkDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonTdkModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonTdkView;

/**
 * Service
 * @author yangxuan
 * @date 2018-11-26 10:56:04
 */
public interface ICommonTdkService extends BaseService<CommonTdkModel> {

	/**
	 * 通过ID修改信息状态
	 * @param id
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	boolean setStatusById(long id ,int status)throws BusinessException;
	
	/**
	 * 保存数据
	 * @param model 
	 * @return
	 * @throws BusinessException
	 */
	Long saveModel(CommonTdkModel model)throws BusinessException;
	
	
	/**
	 * 启动/开始
	 * @param id 
	 * @return
	 * @throws BusinessException
	 */
	boolean start(long id)throws BusinessException;
	
	/**
	 * 停止/关闭
	 * @param id 
	 * @return
	 * @throws BusinessException
	 */
	boolean stop(long id)throws BusinessException;
	
	/**
	 * 分页查询
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<CommonTdkView> getByPage(CommonTdkDto dto)throws BusinessException;
	
	/**
	 * 通过ID查询View
	 * @param id 
	 * @return
	 * @throws BusinessException
	 */
	CommonTdkView getById(long id)throws BusinessException;
	
	
	/**
	*保存数据
	*/
	boolean saveModel(
		java.util.Date time,  
		java.util.Date lastupdate,  
		int status,  
		String title,  
		String keyword,  
		String uri,  
		String description,  
		String helptis,  
		String crumbs 
		)throws BusinessException;
		
		
		/**
	*保存数据
	*/
	boolean modify(
		long id,  
		java.util.Date time,  
		java.util.Date lastupdate,  
		int status,  
		String title,  
		String keyword,  
		String uri,  
		String description,  
		String helptis,  
		String crumbs 
		)throws BusinessException;

	/**
	 * 通过URI查询
	 * @param uri
	 * @return
	 * @throws BusinessException
	 */
	CommonTdkView getByUri(String uri)throws BusinessException;
	

}
