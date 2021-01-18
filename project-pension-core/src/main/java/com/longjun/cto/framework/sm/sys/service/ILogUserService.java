package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.LogUserDto;
import com.longjun.cto.framework.sm.sys.entity.model.LogUserModel;
import com.longjun.cto.framework.sm.sys.entity.view.LogUserView;

/**
 * 用户日志
 * @author yangxuan
 * @date 2018年11月8日 下午5:18:57
 */
public interface ILogUserService extends BaseService<LogUserModel>{
	
	/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	Long saveModel(LogUserModel model)throws BusinessException;
	
	/**
	 * 保存日志
	 * @param UserId
	 * @param eventUseId
	 * @param content
	 * @param ip
	 * @return
	 * @throws BusinessException
	 */
	Long saveLog(long UserId , long eventUseId , String content , String ip)throws BusinessException;
	
	/**
	 * 通过ID查询数据
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	LogUserView getById(long id)throws BusinessException;
	
	/**
	 * 分页查看
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<LogUserView> getByPage(LogUserDto dto)throws BusinessException;

}
