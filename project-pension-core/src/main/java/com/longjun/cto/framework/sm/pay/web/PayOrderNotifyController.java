package com.longjun.cto.framework.sm.pay.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.eims.cto.framework.plugins.pay.ali.api.AliPayHelper;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.longjun.cto.framework.sm.pay.service.IPayOrderApi;
import com.longjun.cto.framework.sm.pay.service.IPayOrderService;

/**
 * 支付订单表Controller
 * @author yangxuan
 * @date 2019-03-23 22:21:19
 */
@RequestMapping("/open/sm/pay/payOrder")
@Controller
public class PayOrderNotifyController extends StandardBaseController{
	
	@Autowired
	IPayOrderService iPayOrderService;
	
	@Autowired
	IPayOrderApi iPayOrderApi;

	/**
	 * 将异步通知的参数转化为Map
	 * 
	 * @param request
	 *            {HttpServletRequest}
	 * @return {Map<String, String>}
	 */
	public static Map<String, String> toMap(HttpServletRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		return params;
	}
	
	/**
	 * 阿里异步通知
	 */
	@ResponseBody
	@RequestMapping(value = "/aliPayNotify"  , method = {RequestMethod.POST , RequestMethod.GET})
	public String aliPayNotify(HttpServletRequest request){
		log.info("支付宝支付异步通知开始");
		Map<String, String> params = toMap(request);
		for (Map.Entry<String, String> entry : params.entrySet()) {
			log.info(entry.getKey() + " = " + entry.getValue());
		}
//		boolean ret = this.iPayOrderService.aliPayNotify(params);
//		if(ret) {
//			log.info("支付宝支付异步返回成功");
//			return "success";
//		}else {
//			log.info("支付宝支付异步返回失败");
//			return "failure";
//		}
		
		return null;
	}

	/**
	 *  微信异步通知
	 */
	@ResponseBody
	@RequestMapping(value = "/wechatPayNotify"  , method = {RequestMethod.POST , RequestMethod.GET})
	public String wechatPayNotify(@RequestBody String body){
		log.info("wechatPayNotify - > [{}]" , body);
		boolean ret = this.iPayOrderApi.wechatNotify(body);
		if(ret) {
			return WxPayNotifyResponse.success("成功");
		}
		return WxPayNotifyResponse.fail("失败");
	}
}
