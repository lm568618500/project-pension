package com.longjun.cto.framework.sm.message.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.message.entity.dto.MessageGatwayDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageGatwayModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageGatwayModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageGatwayView;

import java.util.List;

/**
 * MessageGatwayModel
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
public interface IMessageGatwayService extends BaseService<MessageGatwayModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public MessageGatwayView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public MessageGatwayModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(MessageGatwayModel model)throws BusinessException;
	
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
	PageUtils<MessageGatwayView> getByPage(MessageGatwayDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	List<MessageGatwayView> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	List<MessageGatwayView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	boolean modify(MessageGatwayModifyDto dto)throws BusinessException;
	
	/**
	 * 通过网关值查询
	 * @param value SMS EMAIL PUSH
	 * @return
	 * @throws BusinessException
	 */
	List<MessageGatwayModel> listByGatWayValue(String value)throws BusinessException;
	
}
