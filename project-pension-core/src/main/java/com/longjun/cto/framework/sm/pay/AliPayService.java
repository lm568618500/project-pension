package com.longjun.cto.framework.sm.pay;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.egzosn.pay.ali.api.AliPayConfigStorage;
import com.egzosn.pay.ali.bean.AliTransactionType;
import com.egzosn.pay.common.bean.CertStoreType;
import com.egzosn.pay.common.bean.MethodType;
import com.egzosn.pay.common.bean.PayOrder;
import com.egzosn.pay.common.bean.RefundOrder;
import com.egzosn.pay.common.http.HttpConfigStorage;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.util.MapToJson;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayNotifyModel;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayOrderModel;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayQueryModel;
import com.longjun.cto.framework.sm.pay.alipay.service.IPayAlipayNotifyService;
import com.longjun.cto.framework.sm.pay.alipay.service.IPayAlipayOrderService;
import com.longjun.cto.framework.sm.pay.alipay.service.IPayAlipayQueryService;
import com.longjun.cto.framework.sm.pay.conf.AliPayConfig;
import com.longjun.cto.framework.sm.pay.logs.PayApiCmd;
import com.longjun.cto.framework.sm.pay.logs.service.IPayApiLogsService;
import com.longjun.cto.framework.sm.sys.entity.view.CommonProfileView;
import com.longjun.cto.framework.sm.sys.service.ICommonProfileService;

import cn.hutool.core.util.StrUtil;

/**
 * 支付宝支付业务
 * 
 * @author yangxuan
 * @date Oct 28, 2019 - 4:25:02 PM
 */
@Transactional
@Service
public class AliPayService {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICommonProfileService iCommonProfileService;

	@Autowired
	private IPayAlipayOrderService iPayAlipayOrderService;

	@Autowired
	private IPayApiLogsService iPayApiLogsService;

	@Autowired
	private IPayAlipayQueryService iPayAlipayQueryService;

	@Autowired
	private IPayAlipayNotifyService iPayAlipayNotifyService;

	/**
	 * 读取数据库配置文件
	 * 
	 * @return
	 */
	public AliPayConfig getAliPayConfig() {
		CommonProfileView commonProfileView = this.iCommonProfileService.getByProfileKey("PROFILE_PAY_ALIPAY_CONF");
		if (commonProfileView == null) {
			throw new BusinessException("获取支付宝支付配置失败;未查询到t_common_profile中PROFILE_PAY_ALIPAY_CONF配置数据");
		}
		if (StrUtil.isBlank(commonProfileView.getProfileVal())) {
			throw new BusinessException("获取支付宝支付配置失败;查询到t_common_profile中PROFILE_PAY_ALIPAY_CONF配置数据内容为空");
		}
		try {
			AliPayConfig config = JSONObject.toJavaObject(JSONObject.parseObject(commonProfileView.getProfileVal()),
					AliPayConfig.class);
			return config;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("获取支付宝支付配置失败;查询到t_common_profile中PROFILE_PAY_ALIPAY_CONF配置数据内容非json格式");
		}
	}

	public HttpConfigStorage httpConfig() {
		HttpConfigStorage httpConfigStorage = new HttpConfigStorage();
		/* 网路代理配置 根据需求进行设置 **/
		// http代理地址
		httpConfigStorage.setHttpProxyHost("192.168.1.69");
		// 代理端口
		httpConfigStorage.setHttpProxyPort(3308);
		// 代理用户名
		httpConfigStorage.setAuthUsername("user");
		// 代理密码
		httpConfigStorage.setAuthPassword("password");
		/* /网路代理配置 根据需求进行设置 **/

		/* 网络请求ssl证书 根据需求进行设置 **/
		// 设置ssl证书路径 跟着setCertStoreType 进行对应
		httpConfigStorage.setKeystore("证书文件流，证书字符串信息或证书绝对地址");
		// 设置ssl证书对应的密码
		httpConfigStorage.setStorePassword("证书对应的密码");
		// 设置ssl证书对应的存储方式
		httpConfigStorage.setCertStoreType(CertStoreType.PATH);
		/* /网络请求ssl证书 **/
		/* /网络请求连接池 **/
		// 最大连接数
		httpConfigStorage.setMaxTotal(20);
		// 默认的每个路由的最大连接数
		httpConfigStorage.setDefaultMaxPerRoute(10);
		return httpConfigStorage;

	}

	/**
	 * 初始化
	 * 
	 * @return
	 */
	public AliPayConfigStorage getAliPayConfigStorage() {
		AliPayConfig config = this.getAliPayConfig();
		AliPayConfigStorage aliPayConfigStorage = new AliPayConfigStorage();
		aliPayConfigStorage.setPid(config.getpId());
		aliPayConfigStorage.setAppid(config.getAppId());
		aliPayConfigStorage.setKeyPublic(config.getKeyPublic());
		aliPayConfigStorage.setKeyPrivate(config.getKeyPrivate());
		aliPayConfigStorage.setNotifyUrl(config.getNotifyUrl());
		aliPayConfigStorage.setReturnUrl(config.getReturnUrl());
		aliPayConfigStorage.setSignType(config.getSignType());
		aliPayConfigStorage.setSeller(config.getSeller());
		aliPayConfigStorage.setInputCharset(config.getInputCharset());
		// 是否为测试账号，沙箱环境
		aliPayConfigStorage.setTest(config.isTest());
		return aliPayConfigStorage;
	}

	/**
	 * 获取支付服务
	 * 
	 * @return
	 */
	public com.egzosn.pay.ali.api.AliPayService getAliPayService() {
		// 支付服务
		com.egzosn.pay.ali.api.AliPayService service = new com.egzosn.pay.ali.api.AliPayService(
				getAliPayConfigStorage());
		// 设置网络请求配置根据需求进行设置
		// service.setRequestTemplateConfigStorage(httpConfigStorage)
		return service;
	}

	/**
	 * 二维码支付(扫码付)
	 * 
	 * @param subject
	 * @param body
	 * @param price
	 * @param outTradeNo
	 * @return
	 */
	public BufferedImage sweepPay(String subject, String body, BigDecimal price, String outTradeNo) {
		PayOrder payOrder = new PayOrder(subject, body, price, outTradeNo);
		payOrder.setTransactionType(AliTransactionType.SWEEPPAY);
		BufferedImage img = this.getAliPayService().genQrPay(payOrder);
		this.saveOrder(4, subject, body, price, outTradeNo);
		this.iPayApiLogsService.writeLogs(2, PayApiCmd.ALIPAY_SWEEPPAY_PAY, outTradeNo, null,
				JSONObject.toJSONString(payOrder), null);
		return img;
	}

	/**
	 * 二维码支付(扫码付)
	 * 
	 * @param subject
	 * @param body
	 * @param price
	 * @param outTradeNo
	 * @return
	 */
	public String getQrPay(String subject, String body, BigDecimal price, String outTradeNo) {
		PayOrder payOrder = new PayOrder(subject, body, price, outTradeNo);
		payOrder.setTransactionType(AliTransactionType.SWEEPPAY);
		String ret = this.getAliPayService().getQrPay(payOrder);
		this.saveOrder(4, subject, body, price, outTradeNo);
		this.iPayApiLogsService.writeLogs(2, PayApiCmd.ALIPAY_SWEEPPAY_PAY, outTradeNo, null,
				JSONObject.toJSONString(payOrder), ret);
		return ret;
	}

	/**
	 * APP支付
	 * 
	 * @param subject
	 * @param body
	 * @param price
	 * @param outTradeNo
	 * @return
	 */
	public Map appPay(String subject, String body, BigDecimal price, String outTradeNo) {
		PayOrder payOrder = new PayOrder(subject, body, price, outTradeNo);
		payOrder.setTransactionType(AliTransactionType.APP);
		// 获取APP支付所需的信息组，直接给app端就可使用
		Map appOrderInfo = this.getAliPayService().orderInfo(payOrder);
		this.saveOrder(3, subject, body, price, outTradeNo);
		this.iPayApiLogsService.writeLogs(2, PayApiCmd.ALIPAY_APP_PAY, outTradeNo, null,
				JSONObject.toJSONString(payOrder), JSONObject.toJSONString(appOrderInfo));
		return appOrderInfo;
	}

	/**
	 * 即时到账 pc网页支付
	 * 
	 * @param subject
	 * @param body
	 * @param price
	 * @param outTradeNo
	 */
	public String pcPay(String subject, String body, BigDecimal price, String outTradeNo) {
		PayOrder payOrder = new PayOrder(subject, body, price, outTradeNo);
		payOrder.setTransactionType(AliTransactionType.PAGE); // 即时到帐 PC网页支付
		com.egzosn.pay.ali.api.AliPayService service = this.getAliPayService();
		// 获取支付所需的信息
		Map directOrderInfo = service.orderInfo(payOrder);
		// 获取表单提交对应的字符串，将其序列化到页面即可,
//		String directHtml = service.buildRequest(directOrderInfo, MethodType.POST);
		String directHtml = service.buildRequestUrl(directOrderInfo, MethodType.POST);
		this.saveOrder(1, subject, body, price, outTradeNo);
		this.iPayApiLogsService.writeLogs(2, PayApiCmd.ALIPAY_PC_PAY, outTradeNo, null,
				JSONObject.toJSONString(payOrder), JSONObject.toJSONString(directHtml));
		logger.info("【支付宝支付】网页支付 {}", directHtml);
		return directHtml;
	}

	/**
	 * 即时到账 wap网页支付
	 * 
	 * @param subject
	 * @param body
	 * @param price
	 * @param outTradeNo
	 */
	public String wapPay(String subject, String body, BigDecimal price, String outTradeNo) {
		PayOrder payOrder = new PayOrder(subject, body, price, outTradeNo);
		payOrder.setTransactionType(AliTransactionType.WAP); // 即时到帐 PC网页支付
		com.egzosn.pay.ali.api.AliPayService service = this.getAliPayService();
		// 获取支付所需的信息
		Map directOrderInfo = service.orderInfo(payOrder);
		// 获取表单提交对应的字符串，将其序列化到页面即可,
		String directHtml = service.buildRequest(directOrderInfo, MethodType.POST);
		this.saveOrder(2, subject, body, price, outTradeNo);
		this.iPayApiLogsService.writeLogs(2, PayApiCmd.ALIPAY_WAP_PAY, outTradeNo, null,
				JSONObject.toJSONString(payOrder), JSONObject.toJSONString(directHtml));
		return directHtml;
	}

	// 保存订单信息至数据库
	private void saveOrder(int payType, String subject, String body, BigDecimal price, String outTradeNo) {
		PayAlipayOrderModel model = new PayAlipayOrderModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setStatus(0);
		model.setPayType(payType);
		model.setSubject(subject);
		model.setBody(body);
		model.setPrice(price);
		model.setOutTradeNo(outTradeNo);
		model.setPayStatus(0);
		this.iPayAlipayOrderService.insert(model);
	}

	/**
	 * 交易查询
	 * 
	 * @param tradeNo    支付宝返回
	 * @param outTradeNo 我方系统单号
	 */
	public Map<String, Object> query(String tradeNo, String outTradeNo) {
		Map<String, Object> ret = this.getAliPayService().query(tradeNo, outTradeNo);
		logger.info("【支付宝支付】交易查询 tradeNo {}outTradeNo {} 接口返回{} ", tradeNo, outTradeNo, JSONObject.toJSONString(ret));
		String alipay_trade_query_response = ret.get("alipay_trade_query_response") + "";
		PayAlipayQueryModel model = JSONObject.parseObject(alipay_trade_query_response, PayAlipayQueryModel.class);
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setStatus(1);
		this.iPayAlipayQueryService.insert(model);
		return ret;
	}

	/**
	 * 是否支付成功
	 * 
	 * @param tradeNo
	 * @param outTradeNo
	 * @return
	 */
	public boolean paySuccess(String tradeNo, String outTradeNo) {
		Map<String, Object> ret = this.query(tradeNo, outTradeNo);
		Object alipay_trade_query_response = ret.get("alipay_trade_query_response");
		if (alipay_trade_query_response == null) {
			return false;
		}
		JSONObject respJson = JSONObject.parseObject(alipay_trade_query_response + "");
		if ("TRADE_SUCCESS".equalsIgnoreCase(respJson.getString("trade_status"))) {
			return true;
		}
		return false;
	}

	/**
	 * 关闭订单
	 * 
	 * @param tradeNo
	 * @param outTradeNo
	 * @return
	 */
	public Map<String, Object> close(String tradeNo, String outTradeNo) {
		Map<String, Object> ret = this.getAliPayService().close(tradeNo, outTradeNo);
		return ret;
	}

	/**
	 * 交易撤销接口
	 * 
	 * @param tradeNo
	 * @param outTradeNo
	 * @return
	 */
	public Map<String, Object> cancel(String tradeNo, String outTradeNo) {
		Map<String, Object> ret = this.getAliPayService().cancel(tradeNo, outTradeNo);
		return ret;
	}

	/**
	 * 退款接口
	 * 
	 * @param refundNo
	 * @param tradeNo
	 * @param outTradeNo
	 * @param refundAmount
	 * @param totalAmount
	 * @return
	 */
	public Map<String, Object> refund(String refundNo, String tradeNo, String outTradeNo, BigDecimal refundAmount,
			BigDecimal totalAmount) {
		// 支付宝单号与我方系统单号二选一
		RefundOrder order = new RefundOrder(tradeNo, outTradeNo, refundAmount, totalAmount);
		// 非必填， 根据业务需求而定，可用于多次退款
		order.setRefundNo(refundNo);
		Map result = this.getAliPayService().refund(order);
		return result;
	}

	/**
	 * 查询退款
	 * 
	 * @param tradeNo
	 * @param outTradeNo
	 * @return
	 */
	public Map<String, Object> refundQuery(String tradeNo, String outTradeNo) {
		Map<String, Object> ret = this.getAliPayService().refundquery(tradeNo, outTradeNo);
		return ret;
	}

	/**
	 * 对账下载
	 * 
	 * @param billDate
	 * @param billType
	 */
	public Map<String, Object> downloadBill(Date billDate, String billType) {
		Map<String, Object> rets = this.getAliPayService().downloadbill(billDate, billType);
		return rets;
	}

	/**
	 * 支付宝异步通知
	 * 
	 * @param params
	 * @return
	 * @throws IOException 
	 */
	public boolean handerNotify(HttpServletRequest request) throws IOException {
		com.egzosn.pay.ali.api.AliPayService service = this.getAliPayService();
		Map<String, Object> params = service.getParameter2Map(request.getParameterMap(), request.getInputStream());
		logger.info("支付宝异步通知 参数 {}", JSONObject.toJSONString(params));
		String outTradeNo = params.get("out_trade_no") + "";
		String tradeNo = params.get("trade_no") + "";
		synchronized (outTradeNo) {
			JSONObject json = MapToJson.mapToJson(params);
			PayAlipayNotifyModel payAlipayNotifyModel = JSONObject.toJavaObject(json, PayAlipayNotifyModel.class);
			payAlipayNotifyModel.setTime(new Date());
			payAlipayNotifyModel.setLastupdate(new Date());
			payAlipayNotifyModel.setStatus(1);
			payAlipayNotifyModel.setIsDel(0);
			this.iPayAlipayNotifyService.insert(payAlipayNotifyModel);
			boolean suc = this.paySuccess(tradeNo, outTradeNo);
			// 支付成功
			if (suc) {
//				PayAlipayQueryModel dbQuery = this.iPayAlipayQueryService.findBySuccessOutTradeNo(outTradeNo);
				PayAlipayOrderModel order = this.iPayAlipayOrderService.findByOutTradeNo(outTradeNo);
				// 第一次进入，成功状态未改变
				if (order.getPayStatus().intValue() == 0) {
					// TODO处理业务逻辑，防重单处理
					logger.info("【支付宝支付】回调处理 平台业务");
					/*Wrapper<UserPaymentModel> wrapper = new EntityWrapper<UserPaymentModel>();
					wrapper.eq("pay_no", outTradeNo);
					UserPaymentModel userPayment = this.iUserPaymentService.selectOne(wrapper);
					userPayment.setTransactionNumber(tradeNo);
					userPayment.setStatus(1);
					this.iUserPaymentService.updateById(userPayment);
					
					if(userPayment.getOrderType().intValue() == 3){//标志申请
		        		LogoApplicationModel logoApplication = new LogoApplicationModel();
		        		logoApplication.setId(userPayment.getSubId());
		        		logoApplication.setStatus(5);//已支付
		        		this.iLogoApplicationService.updateById(logoApplication);
		        	}else{//证书申请
		        		AuthenticationApplicationModel authenticationApplication = new AuthenticationApplicationModel();
		        		authenticationApplication.setId(userPayment.getSubId());
		        		if(userPayment.getOrderType().intValue() == 1){
		        			authenticationApplication.setFirstpayStatus(1);//已支付
		        			authenticationApplication.setLaboratoryStatus(0);//实验室
		        			authenticationApplication.setStage(3);//实验室阶段
		        		}else{
		        			authenticationApplication.setLastpayStatus(1);//已支付
		        			authenticationApplication.setIssuanceStatus(0);//证书签发中状态 0待签发
		        			authenticationApplication.setStage(6);//证书签发中
		        		}
		        		this.iAuthenticationApplicationService.updateById(authenticationApplication);
		        	}*/
				}
				this.iPayAlipayOrderService.updateSuccInfo(outTradeNo, tradeNo);

				return true;
			}
		}
		return false;
	}
}
