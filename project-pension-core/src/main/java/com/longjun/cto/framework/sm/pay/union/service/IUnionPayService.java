package com.longjun.cto.framework.sm.pay.union.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.conf.UnionPayConfig;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionPayDto;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionPayModifyDto;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionPayModel;
import com.longjun.cto.framework.sm.pay.union.entity.view.UnionPayView;

import java.math.BigDecimal;
import java.util.List;

/**
 * UnionPayModel
 * 
 * @author yangxuan
 * @date 2019-10-30 04:21:52
 */
public interface IUnionPayService extends BaseService<UnionPayModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UnionPayView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UnionPayModel findModelById(long id) throws BusinessException;

	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public PageUtils<UnionPayView> getByPage(UnionPayDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<UnionPayView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<UnionPayView> listAll() throws BusinessException;

	/**
	 * 读取银联配置文件
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public UnionPayConfig getAliPayConfig() throws BusinessException;

	/**
	 * 公众号支付
	 * 
	 * @param orderNo 订单编号
	 * @param cod     支付金额
	 * @return 微信支付请求地址
	 * @throws BusinessException
	 */
	public String gzhPay(String orderNo, BigDecimal cod) throws BusinessException;

	/**
	 * 银联异步通知校验mac参数
	 * 
	 * @param context
	 * @param mac
	 * @return
	 * @throws BusinessException
	 */
	public boolean checkMac(String context, String mac) throws BusinessException;

	/**
	 * 通过订单号查询
	 * 
	 * @param orderNo
	 * @return
	 * @throws BusinessException
	 */
	public UnionPayModel findByOrderNo(String orderNo) throws BusinessException;

}
