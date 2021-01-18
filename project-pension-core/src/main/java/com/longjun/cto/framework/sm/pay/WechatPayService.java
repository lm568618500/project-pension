package com.longjun.cto.framework.sm.pay;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.egzosn.pay.common.api.PayService;
import com.egzosn.pay.common.bean.CertStoreType;
import com.egzosn.pay.common.bean.MethodType;
import com.egzosn.pay.common.bean.PayOrder;
import com.egzosn.pay.common.bean.RefundOrder;
import com.egzosn.pay.common.http.HttpConfigStorage;
import com.egzosn.pay.wx.api.WxPayConfigStorage;
import com.egzosn.pay.wx.api.WxPayService;
import com.egzosn.pay.wx.bean.WxTransactionType;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.util.MapToJson;
import com.longjun.cto.framework.sm.pay.conf.WechatPayConfig;
import com.longjun.cto.framework.sm.pay.logs.PayApiCmd;
import com.longjun.cto.framework.sm.pay.logs.service.IPayApiLogsService;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatModel;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatNotifyModel;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatQueryModel;
import com.longjun.cto.framework.sm.pay.wechat.service.IPayWechatNotifyService;
import com.longjun.cto.framework.sm.pay.wechat.service.IPayWechatQueryService;
import com.longjun.cto.framework.sm.pay.wechat.service.IPayWechatService;
import com.longjun.cto.framework.sm.sys.entity.view.CommonProfileView;
import com.longjun.cto.framework.sm.sys.service.ICommonProfileService;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 微信支付业务
 * 
 * @author yangxuan
 * @date Oct 28, 2019 - 3:37:18 PM
 */
@Transactional
@Service
public class WechatPayService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICommonProfileService iCommonProfileService;

	@Autowired
	private IPayWechatService iPayWechatService;

	@Autowired
	private IPayWechatNotifyService iPayWechatNotifyService;

	@Autowired
	private IPayWechatQueryService iPayWechatQueryService;

	@Autowired
	private IPayApiLogsService iPayApiLogsService;
	/**
	 * 读取微信配置
	 * 
	 * @return
	 */
	public WechatPayConfig getWechatPayConfig() throws BusinessException {
		CommonProfileView commonProfileView = this.iCommonProfileService.getByProfileKey("PROFILE_PAY_WECHAT_CONF");
		if (commonProfileView == null) {
			throw new BusinessException("获取微信支付配置失败;未查询到t_common_profile中PROFILE_PAY_WECHAT_CONF配置数据");
		}
		if (StrUtil.isBlank(commonProfileView.getProfileVal())) {
			throw new BusinessException("获取微信支付配置失败;查询到t_common_profile中PROFILE_PAY_WECHAT_CONF配置数据内容为空");
		}
		try {
			WechatPayConfig config = JSONObject.toJavaObject(JSONObject.parseObject(commonProfileView.getProfileVal()),
					WechatPayConfig.class);
			return config;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("获取微信支付配置失败;查询到t_common_profile中PROFILE_PAY_WECHAT_CONF配置数据内容非json格式");
		}
	}

	private HttpConfigStorage httpConfig() {
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

		// 退款使用
		/* 网络请求ssl证书 根据需求进行设置 **/
		// 设置ssl证书路径
		// TODO 这里也支持输入流的入参。
		// httpConfigStorage.setKeystore(this.getClass()..getResourceAsStream("/证书文件"));
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
	 * 创建支付服务
	 * 
	 * @return
	 */
	public PayService getPayService() {
		WechatPayConfig conf = this.getWechatPayConfig();
		WxPayConfigStorage wxPayConfigStorage = new WxPayConfigStorage();
		wxPayConfigStorage.setMchId(conf.getMchId());
		wxPayConfigStorage.setAppid(conf.getAppId());
		wxPayConfigStorage.setKeyPublic(conf.getKeyPublic());
		wxPayConfigStorage.setSecretKey(conf.getSecretKey());
		wxPayConfigStorage.setNotifyUrl(conf.getNotifyUrl());
		wxPayConfigStorage.setReturnUrl(conf.getReturnUrl());
		wxPayConfigStorage.setSignType(conf.getSignType());
		wxPayConfigStorage.setInputCharset("utf-8");
		// 支付服务
		PayService service = new WxPayService(wxPayConfigStorage);
		// 设置网络请求配置根据需求进行设置
		// service.setRequestTemplateConfigStorage(httpConfig());
		return service;
	}

	/**
	 * 扫码支付(获取输出二维码信息)
	 * 
	 * @param subject
	 * @param body
	 * @param price
	 * @param outTradeNo
	 * @return
	 */
	public String getQrPay(String subject, String body, BigDecimal price, String outTradeNo) {
		logger.info("【微信支付】扫码支付 subject {} body {} price {} outTradeNo {}", subject, body, price, outTradeNo);
		PayOrder payOrder = new PayOrder(subject, body, price, outTradeNo);
		payOrder.setTransactionType(WxTransactionType.NATIVE);
		String url = this.getPayService().getQrPay(payOrder);
		logger.info("【微信支付】扫码支付 subject {} body {} price {} outTradeNo {} 接口返回 {}", subject, body, price, outTradeNo,
				url);
		// 作废原始数据,
		this.iPayWechatService.failOutTradeNo(outTradeNo);
		PayWechatModel model = new PayWechatModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setStatus(1);
		model.setPayType(2);
		model.setBody(body);
		model.setSubject(subject);
		model.setPrice(price);
		model.setOutTradeNo(outTradeNo);
		model.setPayStatus(0);
		model.setMemo("微信扫码（NATIVE）支付");
		this.iPayWechatService.insert(model);
		this.iPayApiLogsService.writeLogs(1, PayApiCmd.WECHAT_NATIVE_PAY, outTradeNo, null,
				JSONObject.toJSONString(payOrder), JSONObject.toJSONString(url));
		return url;
	}

	/**
	 * 扫码支付(返回图片文件)
	 * 
	 * @param subject
	 * @param body
	 * @param price
	 * @param outTradeNo
	 * @return
	 */
	public BufferedImage genQrPay(String subject, String body, BigDecimal price, String outTradeNo) {
		logger.info("【微信支付】扫码支付,返回图片文件 subject {} body {} price {} outTradeNo {}", subject, body, price, outTradeNo);
		PayOrder payOrder = new PayOrder(subject, body, price, outTradeNo);
		payOrder.setTransactionType(WxTransactionType.NATIVE);
		BufferedImage ret = this.getPayService().genQrPay(payOrder);
		// 作废原始数据,
		this.iPayWechatService.failOutTradeNo(outTradeNo);
		PayWechatModel model = new PayWechatModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setStatus(1);
		model.setPayType(2);
		model.setBody(body);
		model.setSubject(subject);
		model.setPrice(price);
		model.setOutTradeNo(outTradeNo);
		model.setPayStatus(0);
		model.setMemo("微信扫码（NATIVE）支付");
		this.iPayWechatService.insert(model);
		this.iPayApiLogsService.writeLogs(1, PayApiCmd.WECHAT_NATIVE_PAY, outTradeNo, null,
				JSONObject.toJSONString(payOrder), null);
		return ret;
	}

	/**
	 * App支付
	 * 
	 * @param subject
	 * @param body
	 * @param price
	 * @param outTradeNo
	 * @return
	 */
	public Map appPay(String subject, String body, BigDecimal price, String outTradeNo) {
		logger.info("【微信支付】App支付 subject {} body {} price {} outTradeNo {}", subject, body, price, outTradeNo);
		PayOrder payOrder = new PayOrder(subject, body, price, outTradeNo);
		payOrder.setTransactionType(WxTransactionType.APP);
		Map appOrderInfo = this.getPayService().orderInfo(payOrder);
		logger.info("【微信支付】App支付 subject {} body {} price {} outTradeNo {} 接口返回 {}", subject, body, price, outTradeNo,
				JSONObject.toJSONString(appOrderInfo));
		// 作废原始数据,
		this.iPayWechatService.failOutTradeNo(outTradeNo);
		PayWechatModel model = new PayWechatModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setStatus(1);
		model.setPayType(3);
		model.setBody(body);
		model.setSubject(subject);
		model.setPrice(price);
		model.setOutTradeNo(outTradeNo);
		model.setPayStatus(0);
		model.setMemo("微信App支付");
		this.iPayWechatService.insert(model);
		this.iPayApiLogsService.writeLogs(1, PayApiCmd.WECHAT_APP_PAY, outTradeNo, null,
				JSONObject.toJSONString(payOrder), JSONObject.toJSONString(appOrderInfo));
		return appOrderInfo;
	}

	/**
	 * 网页（H5）支付
	 * 
	 * @param subject
	 * @param body
	 * @param price
	 * @param outTradeNo
	 * @return
	 */
	public String mWeb(String subject, String body, BigDecimal price, String outTradeNo) {
		logger.info("【微信支付】 网页支付 subject {} body {} price {} outTradeNo {}", subject, body, price, outTradeNo);
		PayOrder payOrder = new PayOrder(subject, body, price, outTradeNo);
		payOrder.setTransactionType(WxTransactionType.MWEB);
		Map directOrderInfo = this.getPayService().orderInfo(payOrder);
		String directHtml = this.getPayService().buildRequest(directOrderInfo, MethodType.POST);
		logger.info("【微信支付】 网页支付 subject {} body {} price {} outTradeNo {} 接口返回 {}", subject, body, price, outTradeNo,
				directHtml);
		// 作废原始数据,
		this.iPayWechatService.failOutTradeNo(outTradeNo);
		PayWechatModel model = new PayWechatModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setStatus(1);
		model.setPayType(5);
		model.setBody(body);
		model.setSubject(subject);
		model.setPrice(price);
		model.setOutTradeNo(outTradeNo);
		model.setPayStatus(0);
		model.setMemo("微信网页（MWEB）支付");
		this.iPayWechatService.insert(model);
		this.iPayApiLogsService.writeLogs(1, PayApiCmd.WECHAT_MWEB_PAY, outTradeNo, null,
				JSONObject.toJSONString(payOrder), JSONObject.toJSONString(directHtml));
		return directHtml;
	}

	/**
	 * 条码支付
	 * 
	 * @param subject
	 * @param body
	 * @param price
	 * @param outTradeNo
	 * @param authCode   条码信息
	 * @return
	 */
	public Map microPay(String subject, String body, BigDecimal price, String outTradeNo, String authCode) {
		logger.info("【微信支付】 条码支付 subject {} body {} price {} outTradeNo {} authCode {}", subject, body, price,
				outTradeNo, authCode);
		PayOrder payOrder = new PayOrder(subject, body, price, outTradeNo);
		payOrder.setTransactionType(WxTransactionType.MICROPAY);
		payOrder.setAuthCode(authCode);
		Map params = this.getPayService().microPay(payOrder);
		logger.info("【微信支付】 条码支付 subject {} body {} price {} outTradeNo {} authCode {} 接口返回 {}", subject, body, price,
				outTradeNo, authCode, JSONObject.toJSONString(params));
		// 作废原始数据,
		this.iPayWechatService.failOutTradeNo(outTradeNo);
		PayWechatModel model = new PayWechatModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setStatus(1);
		model.setPayType(6);
		model.setBody(body);
		model.setSubject(subject);
		model.setPrice(price);
		model.setOutTradeNo(outTradeNo);
		model.setPayStatus(0);
		model.setMemo("微信网页条码支付（MICROPAY）支付");
		this.iPayWechatService.insert(model);
		this.iPayApiLogsService.writeLogs(1, PayApiCmd.WECHAT_MICROPAY_PAY, outTradeNo, null,
				JSONObject.toJSONString(payOrder), JSONObject.toJSONString(params));
		return params;
	}

	/**
	 * 订单支付查询
	 * 
	 * @param tradeNo
	 * @param outTradeNo
	 * @return
	 */
	public Map<String, Object> query(String tradeNo, String outTradeNo) {
		logger.info("【微信支付】 订单支付查询 tradeNo {} outTradeNo {} ", tradeNo, outTradeNo);
		Map<String, Object> ret = null;
		if (StrUtil.isNotBlank(tradeNo)) {
			ret = this.getPayService().query(tradeNo, null);
		} else {
			ret = this.getPayService().query(null, outTradeNo);
		}
		logger.info("【微信支付】 订单支付查询 tradeNo {} outTradeNo {} 接口返回 {}", tradeNo, outTradeNo,
				JSONObject.toJSONString(ret));
		this.iPayApiLogsService.writeLogs(1, PayApiCmd.WECHAT_QUERY, outTradeNo, tradeNo, null,
				JSONObject.toJSONString(ret));
		return ret;
	}

	/**
	 * 交易关闭
	 * 
	 * @param tradeNo
	 * @param outTradeNo
	 */
	public Map<String, Object> close(String tradeNo, String outTradeNo) {
		logger.info("【微信支付】 订单关闭 tradeNo {} outTradeNo {} ", tradeNo, outTradeNo);
		Map<String, Object> ret = null;
		if (StrUtil.isBlank(tradeNo)) {
			ret = this.getPayService().close(tradeNo, null);
		} else {
			ret = this.getPayService().close(null, outTradeNo);
		}
		logger.info("【微信支付】 订单关闭 tradeNo {} outTradeNo {} 接口返回 {} ", tradeNo, outTradeNo, JSONObject.toJSONString(ret));
		this.iPayApiLogsService.writeLogs(1, PayApiCmd.WECHAT_CLOSE, outTradeNo, tradeNo, null,
				JSONObject.toJSONString(ret));
		return ret;
	}

	/**
	 * 微信退款
	 * 
	 * @param refundNo     退款单号
	 * @param tradeNo      微信单号
	 * @param outTradeNo   我方系统单号
	 * @param refundAmount 退款金额
	 * @param totalAmount  订单总金额
	 */
	public Map refund(String refundNo, String tradeNo, String outTradeNo, BigDecimal refundAmount,
			BigDecimal totalAmount) {
		logger.info("【微信支付】 退款 refundNo {} tradeNo {} outTradeNo {} refundAmount {} totalAmount {}", refundNo, tradeNo,
				outTradeNo, refundAmount, totalAmount);
		RefundOrder order = new RefundOrder(tradeNo, outTradeNo, refundAmount, totalAmount);
		order.setRefundNo(refundNo);
		Map result = this.getPayService().refund(order);
		logger.info("【微信支付】 退款 refundNo {} tradeNo {} outTradeNo {} refundAmount {} totalAmount {} 接口返回 {}", refundNo,
				tradeNo, outTradeNo, refundAmount, totalAmount, JSONObject.toJSONString(result));
		this.iPayApiLogsService.writeLogs(1, PayApiCmd.WECHAT_REFUND, outTradeNo, tradeNo,
				JSONObject.toJSONString(order), JSONObject.toJSONString(result));
		return result;
	}

	/**
	 * 查询退款订单
	 * 
	 * @param tradeNo    支付平台订单号
	 * @param outTradeNo 商户单号
	 */
	public Map<String, Object> refundQuery(String tradeNo, String outTradeNo) {
		logger.info("【微信支付】 查询退款订单 tradeNo {} outTradeNo {} ", tradeNo, outTradeNo);
		RefundOrder refundOrder = new RefundOrder();
		refundOrder.setTradeNo(tradeNo);
		refundOrder.setOutTradeNo(outTradeNo);
		Map<String, Object> map = this.getPayService().refundquery(tradeNo, outTradeNo);
		logger.info("【微信支付】 查询退款订单 tradeNo {} outTradeNo {} 接口返回 {} ", tradeNo, outTradeNo,
				JSONObject.toJSONString(map));
		this.iPayApiLogsService.writeLogs(1, PayApiCmd.WECHAT_REFUNDQUERY, outTradeNo, tradeNo,
				JSONObject.toJSONString(refundOrder), JSONObject.toJSONString(map));
		return map;
	}

	/**
	 * /** 下载对账单
	 *
	 * @param billDate 账单时间：日账单格式为yyyy-MM-dd，月账单格式为yyyy-MM。
	 * @param billType 账单类型，商户通过接口或商户经开放平台授权后其所属服务商通过接口可以获取以下账单类型：trade、signcustomer；trade指商户基于支付宝交易收单的业务账单；signcustomer是指基于商户支付宝余额收入及支出等资金变动的帐务账单；
	 * @return 返回支付方下载对账单的结果
	 */
	public Map<String, Object> downloadBill(Date billDate, String billType) {
		Map<String, Object> ret = this.getPayService().downloadbill(billDate, billType);
		JSONObject request = new JSONObject();
		request.put("billDate", DateUtil.format(billDate, "yyyy-MM-dd"));
		request.put("billType", billType);
		this.iPayApiLogsService.writeLogs(1, PayApiCmd.WECHAT_DOWNLOADBILL, null, billType, request.toJSONString(),
				JSONObject.toJSONString(ret));
		return ret;
	}

	/**
	 * 微信异步通知
	 * 
	 * @param params
	 * @return
	 * @throws IOException 
	 */
	public boolean handerNotify(HttpServletRequest request) throws IOException {
		PayService service = this.getPayService();
		Map<String, Object> params = service.getParameter2Map(request.getParameterMap(), request.getInputStream());
		if (null == params) {
			return false;
		}
		// 校验
		if (this.getPayService().verify(params)) {
			String out_trade_no = params.get("out_trade_no") + "";
			synchronized (out_trade_no) {
				logger.info("【微信支付】异步通知验签成功");
				logger.info("【微信支付】异步通知参数 -> {}", JSONObject.toJSONString(params));
				this.saveNotify(params);
				Map<String, Object> queryRet = this.query(null, params.get("out_trade_no") + "");
				// 支付成功
				if ("SUCCESS".equalsIgnoreCase(queryRet.get("trade_state") + "")) {
					logger.info("【微信支付】订单号 {} 支付成功", out_trade_no);
					PayWechatModel order = this.iPayWechatService.findByOutTradeNo(out_trade_no);
					//第一次进来，为修改状态值，可以进行业务处理，修改之后，不做处理，防止重单
					if (order.getPayStatus().intValue() == 0) {
						/*// 修改微信请求记录为已成功
						this.iPayWechatService.updatePaySuccessInfo(out_trade_no, params.get("transaction_id") + "");
						// TODO......业务逻辑处理块.......
						Wrapper<UserPaymentModel> wrapper = new EntityWrapper<UserPaymentModel>();
						wrapper.eq("pay_no", out_trade_no);
						UserPaymentModel userPayment = this.iUserPaymentService.selectOne(wrapper);
						userPayment.setTransactionNumber(params.get("transaction_id")+"");
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

					JSONObject retJson = MapToJson.mapToJson(queryRet);
					PayWechatQueryModel payWechatQueryModel = JSONObject.parseObject(retJson.toJSONString(),
							PayWechatQueryModel.class);
					payWechatQueryModel.setTime(new Date());
					payWechatQueryModel.setLastupdate(new Date());
					payWechatQueryModel.setIsDel(0);
					payWechatQueryModel.setStatus(1);
					this.iPayWechatQueryService.insert(payWechatQueryModel);
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * 保存异步通知地址
	 * 
	 * @param params
	 */
	private void saveNotify(Map<String, Object> params) {
		PayWechatNotifyModel model = new PayWechatNotifyModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setStatus(1);
		model.setAppid(params.get("appid") + "");
		model.setBankType(params.get("bank_type") + "");
		model.setCashFee(Convert.toLong(params.get("cash_fee")));
		model.setFeeType(params.get("fee_type") + "");
		model.setIsSubscribe(params.get("is_subscribe") + "");
		model.setMchId(params.get("mch_id") + "");
		model.setNonceStr(params.get("nonce_str") + "");
		model.setOpenid(params.get("openid") + "");
		model.setOutTradeNo(params.get("out_trade_no") + "");
		model.setResultCode(params.get("result_code") + "");
		model.setReturnCode(params.get("return_code") + "");
		model.setSign(params.get("sign") + "");
		model.setTimeEnd(params.get("time_end") + "");
		model.setTotalFee(Convert.toLong(params.get("total_fee")));
		model.setTradeType(params.get("trade_type") + "");
		model.setTransactionId(params.get("transaction_id") + "");
		iPayWechatNotifyService.insert(model);
	}
}
