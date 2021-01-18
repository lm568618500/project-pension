package com.longjun.cto.framework.sm.message.service;

import java.util.List;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.message.entity.dto.MessageSettingDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageSettingModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageSettingModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageSettingView;
import com.longjun.cto.framework.sm.message.es.SettingTypeEnums;

/**
 * MessageSettingModel
 * 
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
public interface IMessageSettingService extends BaseService<MessageSettingModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public MessageSettingView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public MessageSettingModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(MessageSettingModel model) throws BusinessException;

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
	public PageUtils<MessageSettingView> getByPage(MessageSettingDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<MessageSettingView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<MessageSettingView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(MessageSettingModifyDto dto) throws BusinessException;

	/**
	 * 通过商户ID、渠道ID查询对象
	 * 
	 * @param mchId
	 * @param gatwayId
	 * @return
	 * @throws BusinessException
	 */
	public MessageSettingModel findByMchId2GatwayId(long mchId, long gatwayId) throws BusinessException;

	/**
	 * 通过商户ID、类型查询单条记录（一般平台只存在单渠道。因此此方法足够满足）
	 * 
	 * @param mchId
	 * @param settingTypeEnums
	 * @return
	 * @throws BusinessException
	 */
	public MessageSettingModel findByMchId2SettingType(long mchId, SettingTypeEnums settingTypeEnums)
			throws BusinessException;

}
