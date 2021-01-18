package com.longjun.cto.framework.sm.pay.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.entity.dto.PayOrderDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayOrderModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayOrderModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayOrderView;

import java.util.List;

/**
 * 支付订单业务接口
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
public interface IPayOrderService extends BaseService<PayOrderModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayOrderView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayOrderModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(PayOrderModel model)throws BusinessException;
	
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
	public PageUtils<PayOrderView> getByPage(PayOrderDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<PayOrderView> listByLimitStatus(int status , int limit)throws BusinessException;
	
	/**
	 * 查询总数
	 * @return
	 * @throws BusinessException
	 */
	public int countAll()throws BusinessException;
	
	
	/**
	 * 全部记录
	 * @return
	 * @throws BusinessException
	 */
	public List<PayOrderView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(PayOrderModifyDto dto)throws BusinessException;
	
	/**
	 *  订单通知
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean orderNotify(long id)throws BusinessException;
	
	/**
	 * 通过商户订单号查询
	 * @param mchOrderNo
	 * @return
	 * @throws BusinessException
	 */
	public PayOrderModel findByMchOrderNo(long mchOrderNo)throws BusinessException;
	
	/**
	 * 作废订单。主要针对同一个商户订单进来,对之前订单进行作废
	 * @param orderNo
	 * @throws BusinessException
	 */
//	public void failOrderByMchOrderNo(long orderNo)throws BusinessException;
	
	
	/**
	 * 通过支付订单号查询
	 * @param payOrderId 支付订单号
	 * @return
	 * @throws BusinessException
	 */
	public PayOrderModel findByPayOrderId(long payOrderId)throws BusinessException;
	
	/**
	 * 订单支付成功
	 * @param outTradeNo
	 * @param body 第三方数据 - 查询结果
	 * @return
	 * @throws BusinessException
	 */
	public boolean orderPaySuccess(long outTradeNo, String body)throws BusinessException;
	
	
	
	
}
