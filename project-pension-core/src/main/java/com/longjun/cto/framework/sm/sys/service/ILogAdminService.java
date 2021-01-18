package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.LogAdminDto;
import com.longjun.cto.framework.sm.sys.entity.model.LogAdminModel;
import com.longjun.cto.framework.sm.sys.entity.view.LogAdminView;

/**
 * 管理员日志
 * @author yangxuan
 * @date 2018年11月8日 下午5:18:57
 */
public interface ILogAdminService extends BaseService<LogAdminModel>{
	
	/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	Long saveModel(LogAdminModel model)throws BusinessException;
	
	/**
	 * 保存日志
	 * @param adminId
	 * @param eventUseId
	 * @param content
	 * @param ip
	 * @return
	 * @throws BusinessException
	 */
	Long saveLog(long adminId , long eventUseId , String content , String ip)throws BusinessException;
	
	/**
	 * 通过ID查询数据
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	LogAdminView getById(long id)throws BusinessException;
	
	/**
	 * 分页查看
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<LogAdminView> getByPage(LogAdminDto dto)throws BusinessException;

}
