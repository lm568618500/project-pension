package com.longjun.cto.framework.sm.message.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.message.entity.dto.MessagePushDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessagePushModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessagePushModel;
import com.longjun.cto.framework.sm.message.entity.view.MessagePushView;

import java.util.List;

/**
 * MessagePushModel
 * @author yangxuan
 * @date 2019-05-30 09:21:36
 */
public interface IMessagePushService extends BaseService<MessagePushModel> {


	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public MessagePushView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public MessagePushModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(MessagePushModel model) throws BusinessException;

	/**
	 * 启动/开始
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean start(long id) throws BusinessException;

	/**
	 * 停止/关闭
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean stop(long id) throws BusinessException;

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean del(long id) throws BusinessException;

	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public PageUtils<MessagePushView> getByPage(MessagePushDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<MessagePushView> listByLimitStatus(int status, int limit) throws BusinessException;

	/**
	 * 查询总数
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public int countAll() throws BusinessException;

	/**
	 * 全部记录
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<MessagePushView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(MessagePushModifyDto dto) throws BusinessException;

	/**
	 * 定时任务发送
	 * 
	 * @throws BusinessException
	 */
	public void sendJobs() throws BusinessException;

	/**
	 * 定时任务-计划发送
	 * 
	 * @throws BusinessException
	 */
	public void sendPushPlainJobs() throws BusinessException;
	
}
