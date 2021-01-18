package com.longjun.cto.framework.sm.pay.alipay.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayOrderDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayOrderModifyDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayOrderModel;
import com.longjun.cto.framework.sm.pay.alipay.entity.view.PayAlipayOrderView;

import java.util.List;

/**
 * PayAlipayOrderModel
 * 
 * @author yangxuan
 * @date 2019-11-07 05:39:27
 */
public interface IPayAlipayOrderService extends BaseService<PayAlipayOrderModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayAlipayOrderView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayAlipayOrderModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(PayAlipayOrderModel model) throws BusinessException;

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
	public PageUtils<PayAlipayOrderView> getByPage(PayAlipayOrderDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<PayAlipayOrderView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<PayAlipayOrderView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(PayAlipayOrderModifyDto dto) throws BusinessException;

	/**
	 * 更新支付成功信息
	 * 
	 * @param outTradeNo
	 * @param tradeNo
	 * @return
	 * @throws BusinessException
	 */
	public boolean updateSuccInfo(String outTradeNo, String tradeNo) throws BusinessException;

	/**
	 * 是否交易成功
	 * 
	 * @param outTradeNo
	 * @return
	 * @throws BusinessException
	 */
	public PayAlipayOrderModel findByOutTradeNo(String outTradeNo) throws BusinessException;

}
