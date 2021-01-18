package com.longjun.cto.framework.sm.pay.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.github.binarywang.wxpay.bean.result.WxPayOrderQueryResult;
import com.longjun.cto.framework.sm.pay.entity.dto.PayWxQueryDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayWxQueryModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayWxQueryView;

/**
 * 微信支付-查询Service
 * @author yangxuan
 * @date 2019-02-23 09:05:59
 */
public interface IPayWxQueryService extends BaseService<PayWxQueryModel> {
 
	/**
	 * 分页查询
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<PayWxQueryView> getByPage(PayWxQueryDto dto)throws BusinessException;
	
	/**
	 * 查询订单信息
	 * @param outTradeNo
	 * @return
	 * @throws BusinessException
	 */
	WxPayOrderQueryResult queryOrder(String outTradeNo)throws BusinessException;
	
	

	/**
	 * 查询订单信息
	 * @param outTradeNo
	 * @return
	 * @throws BusinessException
	 */
	WxPayOrderQueryResult queryOrder(String appId,String outTradeNo)throws BusinessException;
	 

}
