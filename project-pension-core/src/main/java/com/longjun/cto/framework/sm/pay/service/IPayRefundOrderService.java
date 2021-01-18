package com.longjun.cto.framework.sm.pay.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.entity.dto.PayRefundOrderDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayRefundOrderModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayRefundOrderModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayRefundOrderView;

import java.util.List;

/**
 * PayRefundOrderModel
 * 
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
public interface IPayRefundOrderService extends BaseService<PayRefundOrderModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayRefundOrderView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayRefundOrderModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(PayRefundOrderModel model) throws BusinessException;

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
	public PageUtils<PayRefundOrderView> getByPage(PayRefundOrderDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<PayRefundOrderView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<PayRefundOrderView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(PayRefundOrderModifyDto dto) throws BusinessException;

	/**
	 * 退款定时任务
	 * 
	 * @throws BusinessException
	 */
	public void refundsJobs() throws BusinessException;

	/**
	 * 退款查询定时任务
	 * 
	 * @throws BusinessException
	 */
	public void refundsQueryJobs() throws BusinessException;

}
