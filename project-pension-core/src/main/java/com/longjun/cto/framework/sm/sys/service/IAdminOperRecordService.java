package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminOperRecordDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminOperRecordModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminOperRecordView;

/**
 * 操作日志Service
 * @author lp
 * @date 2018-12-13 15:54:41
 */
public interface IAdminOperRecordService extends BaseService<AdminOperRecordModel> {

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
	Long saveModel(AdminOperRecordModel model)throws BusinessException;
	
	
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
	PageUtils<AdminOperRecordView> getByPage(AdminOperRecordDto dto)throws BusinessException;
	
	/**
	 * 通过ID查询View
	 * @param id 
	 * @return
	 * @throws BusinessException
	 */
	AdminOperRecordView getById(long id)throws BusinessException;
	
	
	/**
	*保存数据
	*  @param adminId 操作人id
	 * @param mainModelName 主模块名称  例如：内容
	 * @param subModelName	子模块名称   例如：文章列表
	 * @param operationDesc	操作内容描述	例如：添加标题为：测试  的文章
	 * @param operType	操作类型 （1、管理员操作日志；2、用户操作日志）
	*/
	boolean saveModel(
			long adminId,  
			String mainModelName,  
			String subModelName,
			String operationDesc,  
			int operType
		)throws BusinessException;
		
		
		/**
	*保存数据
	*/
	boolean modify(
		long id,  
		java.util.Date time,  
		long adminId,  
		java.util.Date operDate,  
		String toRelationStr,  
		long toRelationId,  
		int toRelationType,  
		String operRecord,  
		int operType,  
		String ip,  
		int status,  
		java.util.Date lastupdate 
		)throws BusinessException;

	
	/**
	 * （逻辑）删除/批量删除
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	Integer deletes(long[] id)throws BusinessException;
}
