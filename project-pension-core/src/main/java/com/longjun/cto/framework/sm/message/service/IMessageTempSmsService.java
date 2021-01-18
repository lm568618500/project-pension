package com.longjun.cto.framework.sm.message.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempSmsDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempSmsModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageTempSmsModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageTempSmsView;

import java.util.List;

/**
 * MessageTempSmsModel
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public interface IMessageTempSmsService extends BaseService<MessageTempSmsModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public MessageTempSmsView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public MessageTempSmsModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(MessageTempSmsModel model)throws BusinessException;
	
	/**
	 * 启动/开始
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	boolean start(long id) throws BusinessException;

	/**
	 * 停止/关闭
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	boolean stop(long id) throws BusinessException;
	
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	boolean del(long id) throws BusinessException;
	
	
	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<MessageTempSmsView> getByPage(MessageTempSmsDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	List<MessageTempSmsModel> listByLimitStatus(int status , int limit)throws BusinessException;
	
	/**
	 * 查询总数
	 * @return
	 * @throws BusinessException
	 */
	int countAll()throws BusinessException;
	
	
	/**
	 * 全部记录
	 * @return
	 * @throws BusinessException
	 */
	List<MessageTempSmsModel> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	boolean modify(MessageTempSmsModifyDto dto)throws BusinessException;
	
	/**
	 * 通过findModelByTempUid查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public MessageTempSmsModel findModelByTempUid(String tempUid)throws BusinessException;
	
}
