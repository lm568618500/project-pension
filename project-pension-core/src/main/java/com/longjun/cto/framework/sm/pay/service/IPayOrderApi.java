package com.longjun.cto.framework.sm.pay.service;

import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.github.binarywang.wxpay.bean.order.WxPayNativeOrderResult;
import com.longjun.cto.framework.sm.pay.entity.dto.WechatPayOrderRequestDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayOrderModel;

/**
 * 订单支付Api
 * 
 * @author yangxuan
 * @date 2019年4月11日 下午9:50:32
 */
public interface IPayOrderApi {

	/**
	 * * 创建支付订单
	 * @param mchOrderNo 商户订单号
	 * @param amount 订单金额 单位 分
	 * @param clientIp 客户端调用IP
	 * @param subject  商品标题  
	 * @param body 商品描述信息            
	 * @param param1 扩展参数1
	 * @param param2 扩展参数2 
	 * @param buzNotifyUrl 业务通知地址 
	 * @return -支付订单号
	 * @throws BusinessException
	 */
	public long createOrder(long mchOrderNo, long amount, String clientIp, String subject, String body, String param1,
			String param2, String buzNotifyUrl,String buzCallbackUrl) throws BusinessException;

	/**
	 * 微信App支付
	 * 
	 * @throws BusinessException
	 */
	public void wechatAppPay() throws BusinessException;

	/**
	 * 微信H5支付
	 * 
	 * @throws BusinessException
	 */
	public void wechatH5() throws BusinessException;

	/**
	 * 微信扫码支付
	 * 
	 * @param request
	 * @throws BusinessException
	 */
	public WxPayNativeOrderResult wechatScan(long payOrderId) throws BusinessException;
	
	/**
	 * 微信扫码支付
	 * 
	 * @param request
	 * @throws BusinessException
	 */
	public WxPayNativeOrderResult wechatScan(WechatPayOrderRequestDto request) throws BusinessException;
	
	/**
	 * 微信异步通知
	 * @param xml
	 * @throws BusinessException
	 */
	public boolean wechatNotify(String xml) throws BusinessException;

	/**
	 * 阿里-App支付
	 * 
	 * @throws BusinessException
	 */
	public AlipayTradeAppPayResponse alipayApp(long payOrderId) throws BusinessException;

	/**
	 * 阿里-wap支付
	 * 
	 * @throws BusinessException
	 */
	public String alipayWap(long payOrderId) throws BusinessException;

	/**
	 * 阿里-PC支付
	 * 
	 * @throws BusinessException
	 */
	public String alipayPc(long payOrderId) throws BusinessException;

	/**
	 * 处理业务异步通知
	 * @throws BusinessException
	 */
	public void execBuzNotifyJobs()throws BusinessException;
	
	/**
	 * 处理业务异步通知
	 * @throws BusinessException
	 */
	public void execBuzNotify(long payOrderId)throws BusinessException;
	
	/**
	 * 处理业务异步通知
	 * @throws BusinessException
	 */
	public void execBuzNotify(PayOrderModel model)throws BusinessException;
	
	
}
