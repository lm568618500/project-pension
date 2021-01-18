package com.longjun.cto.framework.sm.pay;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egzosn.pay.common.bean.DefaultCurType;
import com.egzosn.pay.common.bean.MethodType;
import com.egzosn.pay.common.bean.PayOrder;
import com.egzosn.pay.paypal.api.PayPalConfigStorage;
import com.egzosn.pay.paypal.api.PayPalPayService;
import com.egzosn.pay.paypal.bean.PayPalTransactionType;
import com.eims.cto.framework.common.conf.SysSetting;

/**
 * paypal
 * 
 * @author yangxuan
 * @date Nov 2, 2019 - 9:26:38 AM
 */
@Transactional
@Service
public class PayPalService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private  static  final String clientID = "AekwdpegLQHcVHUuXVZ-1CIWqWJHL6kpMMSSEQYxceDyGa7NAb8xUVQB6vuSYC0Wvz5gxx6E-SaMnlXc";
	private  static  final String clientSecret = "EKYTGrljvJe7uOdMQHTvPtg4QAiE0D1yXZsaTH6Q0pz_sHW4HAsMbYI-JuMV90F6lpPHWJO3hPHYNzOZ";


	/**
	 * 即时到账 pc网页支付
	 * 
	 * @param subject
	 * @param body
	 * @param price
	 * @param outTradeNo
	 */
	public Map<String, String> pcPay(String subject, String body, BigDecimal price, String outTradeNo,Integer orderType) {
        PayOrder payOrder = new PayOrder(subject,body, price,outTradeNo, PayPalTransactionType.sale);
		payOrder.setCurType(DefaultCurType.USD);
		PayPalPayService service = this.getAliPayService(orderType);
		Map orderInfo = service.orderInfo(payOrder);
		orderInfo.get("id");
		String directHtml = service.buildRequest(orderInfo, MethodType.POST);
		Map<String, String> data = new HashMap<String, String>();
		data.put("html", directHtml);
		data.put("outTradeNo", payOrder.getOutTradeNo());
		return data;
	}
	/**
	 * 获取支付服务
	 * 
	 * @return
	 */
	public PayPalPayService getAliPayService(Integer orderType) {
		// 支付服务
		PayPalPayService service = new PayPalPayService(getPayPalConfigStorage(orderType));
		// 设置网络请求配置根据需求进行设置
		// service.setRequestTemplateConfigStorage(httpConfigStorage)
		return service;
	}
	/**
	 * 初始化
	 * 
	 * @return
	 */
	public PayPalConfigStorage getPayPalConfigStorage(Integer orderType) {
		PayPalConfigStorage storage = new PayPalConfigStorage();
        storage.setClientID(clientID);
        storage.setClientSecret(clientSecret);
        storage.setTest(true);
        //发起付款后的页面转跳地址
        storage.setReturnUrl(SysSetting.STANDARD_SERVERURL+"/web/pay/payPalNotify");
        //取消按钮转跳地址,这里用异步通知地址的兼容的做法
        if(orderType != null){
        	switch (orderType) {
				case 1:
			        storage.setNotifyUrl(SysSetting.STANDARD_SERVERURL+"/web/certification/acceptance/acceptanceListInit?type=1");
					break;
				case 2:
			        storage.setNotifyUrl(SysSetting.STANDARD_SERVERURL+"/web/certification/acceptance/acceptanceListInit?type=6");
					break;
				case 3:
			        storage.setNotifyUrl(SysSetting.STANDARD_SERVERURL+"/web/certification/logoApply/logoPendingPaymentListInit");
					break;
            }
        }
		return storage;
	}
	
	@Transactional
	public void payPalNotify(HttpServletRequest request) throws IOException {
		PayPalPayService service = this.getAliPayService(null);
		Map<String, Object> params = service.getParameter2Map(request.getParameterMap(), request.getInputStream());
		/*Wrapper<UserPaymentModel> wrapper = new EntityWrapper<UserPaymentModel>();
		wrapper.eq("transaction_number", params.get("paymentId"));
		UserPaymentModel userPayment = SqlHelper.getObject(this.userPaymentMapper.selectList(wrapper));
        if (service.verify(params)){
        	userPayment.setStatus(1);
        	this.userPaymentMapper.updateById(userPayment);
        	if(userPayment.getOrderType().intValue() == 3){//标志申请
        		LogoApplicationModel logoApplication = new LogoApplicationModel();
        		logoApplication.setId(userPayment.getSubId());
        		logoApplication.setStatus(5);//已支付
        		this.logoApplicationMapper.updateById(logoApplication);
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
        		this.authenticationApplicationMapper.updateById(authenticationApplication);
        	}
        }*/
		
	}

	
}
