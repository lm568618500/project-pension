package com.longjun.cto.framework.sm.pay.web;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.plugins.pay.ali.api.AliPayHelper;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.order.WxPayNativeOrderResult;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelModel;
import com.longjun.cto.framework.sm.pay.entity.model.PayOrderModel;
import com.longjun.cto.framework.sm.pay.service.IPayChannelService;
import com.longjun.cto.framework.sm.pay.service.IPayOrderApi;
import com.longjun.cto.framework.sm.pay.service.IPayOrderService;
import com.longjun.cto.framework.sm.pay.utils.PayBuzUtils;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;

/**
 * 支付开放接口- 主要处理支付宝异步回调
 * 
 * @author yangxuan
 * @date May 28, 2019 - 11:10:16 AM
 */
@RequestMapping("/open/sm/pay")
@Controller
public class SmPayOpenController extends StandardBaseController {

	@Autowired
	private IPayChannelService iPayChannelService;

	@Autowired
	private IPayOrderService iPayOrderService;

	@Autowired
	private IPayOrderApi iPayOrderApi;

	/**
	 * 创建订单
	 * 
	 * @return
	 */
	@GetMapping("/orderCreateTest")
	public ModelAndView orderCreateTest() {
		ModelAndView model = getModelAndView("/sm/pay/open/orderCreateTest");
		long mchOrderNo = System.currentTimeMillis();
		long amount = 1;
		String clientId = "127.0.0.1";
		String subject = "支付下单测试";
		String body = "支付下单测试BODY";
		JSONObject params1JSON = new JSONObject();
		params1JSON.put("orderId", "订单ID");
		params1JSON.put("params1", "JSON对象");
		String params1 = params1JSON.toJSONString();
		String params2 = params1JSON.toJSONString();
		String buzNotifyUrl = "http://127.0.0.1/open/sm/pay/buzNotifyUrlTest";
		String buzCallbackUrl = "http://127.0.0.1/open/sm/pay/buzCallbackUrlTest";
		model.addObject("mchOrderNo", mchOrderNo);
		model.addObject("amount", amount);
		model.addObject("clientId", clientId);
		model.addObject("subject", subject);
		model.addObject("body", body);
		model.addObject("param1", params1);
		model.addObject("param2", params2);
		model.addObject("buzNotifyUrl", buzNotifyUrl);
		model.addObject("buzCallbackUrl", buzCallbackUrl);
		return model;
	}

	/**
	 * 订单创建;返回支付ID
	 * 
	 * @param mchOrderNo
	 * @param amount
	 * @param clientIp
	 * @param subject
	 * @param body
	 * @param param1
	 * @param param2
	 * @param buzNotifyUrl
	 * @param buzCallbackUrl
	 * @return
	 */
	@ResponseBody
	@PostMapping("/submitOrderCreateTest")
	public ApiResult submitOrderCreateTest(long mchOrderNo, long amount, String clientIp, String subject, String body,
			String param1, String param2, String buzNotifyUrl, String buzCallbackUrl) {
		long payOrderId = this.iPayOrderApi.createOrder(mchOrderNo, amount, clientIp, subject, body, param1, param2,
				buzNotifyUrl, buzCallbackUrl);
		return ApiResult.instance().ok("payOrderId", payOrderId);
	}

	/**
	 * 测试-业务异步地址
	 * 
	 * @return
	 */
	@ResponseBody
	@PostMapping("/buzNotifyUrlTest")
	public JSONObject buzNotifyUrlTest(HttpServletRequest request) {
		log.info("异步-业务异步地址回调");
		boolean check = PayBuzUtils.checkCallBack(request);
		log.info("异步-业务异步地址回调-验签结果[{}]", check);
		// 本地业务逻辑处理
		JSONObject ret = new JSONObject();
		ret.put("code", 200);
		return ret;
	}

	/**
	 * 测试-业务同步地址
	 * 
	 * @return
	 */
	@PostMapping("/buzCallbackUrlTest")
	public ModelAndView buzCallbackUrlTest(HttpServletRequest request) {
		log.info("同步-业务同步地址回调");
		boolean check = PayBuzUtils.checkCallBack(request);
		log.info("同步-业务同步地址回调-验签结果[{}]", check);
		ModelAndView model = getModelAndView("/sm/pay/open/buzCallbackUrlTest");
		return model;
	}

	/**
	 * 测试-支付宝PC支付
	 * 
	 * @param payOrderId
	 * @return
	 */
	@ResponseBody
	@PostMapping("/aliPcPayTest")
	public ApiResult aliPcPayTest(long payOrderId) {
		String url = this.iPayOrderApi.alipayPc(payOrderId);
		return ApiResult.instance().ok("payUrl", url);
	}

	/**
	 * 测试-微信扫码支付
	 * 
	 * @param payOrderId
	 * @return
	 */
	@ResponseBody
	@PostMapping("/wechatScanPayTest")
	public ApiResult wechatScanPayTest(long payOrderId) {
		WxPayNativeOrderResult ret = this.iPayOrderApi.wechatScan(payOrderId);
		return ApiResult.instance().ok("qrcode", ret.getCodeUrl());
	}

	/**
	 * 支付宝异步回调
	 */
	@ResponseBody
	@RequestMapping(value = "/aliPayNotify", method = { RequestMethod.POST, RequestMethod.GET })
	public String aliPayNotify(HttpServletRequest request) {
		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		log.info("支付宝支付-异步通知回调-参数打印开始.");
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
				log.info("参数Key [{}] 参数值[{}]", name, valueStr);
			}
			// 乱码解决，这段代码在出现乱码时使用
//    		valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		log.info("支付宝支付-异步通知回调-参数打印结束.");
		// 获取json参数;主要在订单支付时,传递了商户ID ， 渠道ID等信息
		JSONObject passbackParamsJson = JSONObject.parseObject(params.get("passback_params"));
		long mchId = passbackParamsJson.getLongValue("mchId");
		long channelItemsId = passbackParamsJson.getLongValue("channelItemsId");
		String channelName = passbackParamsJson.getString("channelName");
		long channelId = passbackParamsJson.getLongValue("channelId");
		PayChannelModel payChannelModel = this.iPayChannelService.findByChannelId2ItemId2MchId(channelId,
				channelItemsId, mchId);
		if (payChannelModel == null) {
			log.error("支付宝异步支付失败;商户渠道信息未查询到;商户ID-mchId[{}]渠道ID-channelItemsId[{}]", mchId, channelItemsId);
			return "fail";
		}
		JSONObject paramsJson = JSONObject.parseObject(payChannelModel.getParam());
		String appId = paramsJson.getString("appId");
		String publicKey = paramsJson.getString("publicKey");
		String privateKey = paramsJson.getString("privateKey");
		String gateway = paramsJson.getString("gateway");
		String notifyUrl = paramsJson.getString("notifyUrl");
		String returnUrl = paramsJson.getString("returnUrl");
		String outTradeNo = params.get("out_trade_no").toString();
		try {
			// 进行订单查询;通过数据库配置文件序列化支付宝帮助类;
			AliPayHelper helper = AliPayHelper.getAliPayHelper(appId, publicKey, privateKey, gateway);
			// 支付宝异步验签
			boolean checkSign = helper.rsaCheckV1(params);
			log.error("支付宝异步通知验签状态;支付订单号[{}]验签结果[{}]", outTradeNo, checkSign);
			if (!checkSign) {
				log.error("支付宝异步通知验签失败;支付订单号[{}]", outTradeNo);
				return "fail";
			}
			AlipayTradeQueryResponse ret = helper.tradeQuery(null, outTradeNo, null);
			log.info("支付宝支付;订单号[{}]交易状态[{}]", outTradeNo, ret.getTradeStatus());
			if ("TRADE_SUCCESS".equals(ret.getTradeStatus())) {
				boolean updateRet = this.iPayOrderService.orderPaySuccess(Convert.toLong(outTradeNo, -1L),
						JSONObject.toJSONString(ret));
				// 业务执行状态;处理完后;定时任务将会继续往业务层推送;
				if (updateRet) {
					return "success";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 支付宝同步回调
	 */
	@RequestMapping(value = "/ailPayCallBack", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView ailPayCallBack(HttpServletRequest request) {
		ModelAndView model = getModelAndView("/sm/pay/open/ailPayCallBack");
		// 2支付成功 1支付中 -1支付失败
		int payStatus = 2;
		// 业务同步跳转地址
		String callBackUrl = "#";
		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		log.info("支付宝支付-同步通知回调-参数打印开始.");
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
				log.info("参数Key [{}] 参数值[{}]", name, valueStr);
			}
			// 乱码解决，这段代码在出现乱码时使用
//		    		valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		log.info("支付宝支付-同步通知回调-参数打印结束.");
		// 获取json参数;主要在订单支付时,传递了商户ID ， 渠道ID等信息
		long payOrderId = Convert.toLong(params.get("out_trade_no"), -1L);
		PayOrderModel payOrderModel = this.iPayOrderService.findByPayOrderId(payOrderId);
		long mchId = payOrderModel.getMchId();
		long channelItemsId = payOrderModel.getChannelItemsId();
		String channelName = "支付宝支付";
		long channelId = payOrderModel.getChannelId();
		PayChannelModel payChannelModel = this.iPayChannelService.findByChannelId2ItemId2MchId(channelId,
				channelItemsId, mchId);
		if (payChannelModel == null) {
			log.error("支付宝同步支付失败;商户渠道信息未查询到;商户ID-mchId[{}]渠道ID-channelItemsId[{}]", mchId, channelItemsId);
			payStatus = -1;
		}
		JSONObject paramsJson = JSONObject.parseObject(payChannelModel.getParam());
		String appId = paramsJson.getString("appId");
		String publicKey = paramsJson.getString("publicKey");
		String privateKey = paramsJson.getString("privateKey");
		String gateway = paramsJson.getString("gateway");
		String notifyUrl = paramsJson.getString("notifyUrl");
		String returnUrl = paramsJson.getString("returnUrl");
		String outTradeNo = params.get("out_trade_no").toString();
		PayOrderModel payOrder = this.iPayOrderService.findByPayOrderId(Convert.toLong(outTradeNo, -1L));
		if (payOrder == null) {
			log.error("支付宝支付同步回调；未查询到支付订单号[{}]订单数据", outTradeNo);
			payStatus = -1;
			model.addObject("payStatus", payStatus);
			return model;
		}
		callBackUrl = payOrder.getBuzCallbackUrl();
		
		try {
			// 进行订单查询;通过数据库配置文件序列化支付宝帮助类;
			AliPayHelper helper = AliPayHelper.getAliPayHelper(appId, publicKey, privateKey, gateway);
			// 支付宝验签
			boolean checkSign = helper.rsaCheckV1(params);
			log.error("支付宝同步通知验签状态;支付订单号[{}]验签结果[{}]", outTradeNo, checkSign);
			if (!checkSign) {
				log.error("支付宝同步通知验签失败;支付订单号[{}]", outTradeNo);
				payStatus = -1;
			}
			AlipayTradeQueryResponse ret = helper.tradeQuery(null, outTradeNo, null);
			log.info("支付宝支付;订单号[{}]交易状态[{}]", outTradeNo, ret.getTradeStatus());
			if ("TRADE_SUCCESS".equals(ret.getTradeStatus())) {
				boolean updateRet = this.iPayOrderService.orderPaySuccess(Convert.toLong(outTradeNo, -1L),
						JSONObject.toJSONString(ret));
				// 业务执行状态;处理完后;定时任务将会继续往业务层推送;
				if (updateRet) {
					payStatus = 2;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String param1 = payOrder.getParam1();
		String param2 = payOrder.getParam2();
		PayBuzUtils.wapperCallBack(payStatus, callBackUrl, param1, param2, model);
		model.addObject("payOrderId", payOrderModel.getPayOrderId());
		model.addObject("payOrderPrice", payOrderModel.getAmount());
		model.addObject("mchOrderNo", payOrderModel.getMchOrderNo());
		model.addObject("channelId", payOrderModel.getChannelId());
		model.addObject("channelItemsId", payOrderModel.getChannelItemsId());
		model.addObject("paySuccTime", DateUtil.format(payOrderModel.getPaySuccTime(), "yyyy-MM-dd HH:mm:ss"));
		return model;
	}

	/**
	 * 微信异步回调
	 */
	@ResponseBody
	@RequestMapping(value = "/wechatNotify", method = { RequestMethod.POST, RequestMethod.GET })
	public String wechatNotify(HttpServletRequest request) {
		InputStream ins;
		try {
			ins = request.getInputStream();
			String xmlDate = IOUtils.toString(ins);
			log.info("微信支付-异步通知 - > [{}]", xmlDate);
			boolean ret = this.iPayOrderApi.wechatNotify(xmlDate);
			// 成功情况
			if (ret) {
				// 通知微信处理成功
				return WxPayNotifyResponse.success("OK");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return WxPayNotifyResponse.fail("OK");
	}

	/**
	 * 微信同步回调
	 */
	@RequestMapping(value = "wechatCallBack", method = { RequestMethod.POST, RequestMethod.GET })
	public void wechatCallBack() {

	}

	

	/**
	 * 查询支付成功状态
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/payStateQuery", method = { RequestMethod.POST, RequestMethod.GET })
	public ApiResult payStateQuery(@RequestParam(required = true, defaultValue = "-1") Long payOrderId) {
		if(payOrderId < 0) {
			log.error("支付状态查询失败;传入订单号非法 [{}]", payOrderId);
			//记录不存在;返回失败;
			return ApiResult.instance().ok("state", -1);
		}
		PayOrderModel payOrderModel = this.iPayOrderService.findByPayOrderId(payOrderId);
		if(payOrderModel == null) {
			log.error("支付状态查询失败;未查询到支付订单号记录;传入支付订单号 [{}]", payOrderId);
			//记录不存在;返回失败;
			return ApiResult.instance().ok("state", -1);
		}
		int status = payOrderModel.getStatus().intValue();
		if(status == 2 || status == 3) {
			//2位支付成功;3位业务通知成功,在业务通知成功必然支付也是成功
			return ApiResult.instance().ok("state", 1);
		}
		//支付中
		return ApiResult.instance().ok("state", 0);
	}

	
}
