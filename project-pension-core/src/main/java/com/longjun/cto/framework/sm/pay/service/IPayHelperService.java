package com.longjun.cto.framework.sm.pay.service;

import com.alipay.api.response.AlipayTradeQueryResponse;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.github.binarywang.wxpay.bean.result.WxPayOrderQueryResult;
import com.github.binarywang.wxpay.bean.result.WxPayRefundQueryResult;

/**
 * 支付帮助业务类
 * @author yangxuan
 * @date 2019年4月13日 上午10:13:34
 */
public interface IPayHelperService {

	
	/**
	 * 微信订单查询
	 * @param transactionId 微信订单号
	 * @param outTradeNo 商户系统内部的订单号，当没提供transactionId时需要传这个。
	 * @throws BusinessException
	 */
	public WxPayOrderQueryResult wechatOrderQuery(String transactionId, String outTradeNo)throws BusinessException;
	
	
	/**
	 * 微信退款查询
	 * @param transactionId 微信订单号
	 * @param outTradeNo 商户订单号
	 * @param outRefundNo 商户退款单号
	 * @param refundId 微信退款单号
	 * @return
	 * @throws BusinessException
	 */
	public WxPayRefundQueryResult refundQuery(String transactionId, String outTradeNo, String outRefundNo,
			String refundId)throws BusinessException;
	
	
	/**
	 * 阿里订单查询
	 * @param orgPid 银行间联模式下有用，其它场景请不要使用； 双联通过该参数指定需要查询的交易所属收单机构的pid;
	 * @param outTradeNo 订单支付时传入的商户订单号,和支付宝交易号不能同时为空。trade_no,out_trade_no如果同时存在优先取trade_no
	 * @param tradeNo 支付宝交易号，和商户订单号不能同时为空
	 * @throws BusinessException
	 */
	public AlipayTradeQueryResponse aliPayQueryOrder(String orgPid, String outTradeNo, String tradeNo)throws BusinessException;
}
