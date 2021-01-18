package com.longjun.cto.framework.sm.pay.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelItemDictDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelItemDictModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelItemDictModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayChannelItemDictView;

import java.util.List;

/**
 * PayChannelItemDictModel
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
public interface IPayChannelItemDictService extends BaseService<PayChannelItemDictModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayChannelItemDictView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayChannelItemDictModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(PayChannelItemDictModel model)throws BusinessException;
	
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
	PageUtils<PayChannelItemDictView> getByPage(PayChannelItemDictDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	List<PayChannelItemDictView> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	List<PayChannelItemDictView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	boolean modify(PayChannelItemDictModifyDto dto)throws BusinessException;
	
	/**
	 * 通过渠道ID查询支付方式列表
	 * @param channelId
	 * @return
	 * @throws BusinessException
	 */
	List<PayChannelItemDictModel> listByChannelId(long channelId)throws BusinessException;
	
}
