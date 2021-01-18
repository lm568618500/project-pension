package com.longjun.cto.framework.sm.pay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.api.response.AlipayTradeQueryResponse;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.github.binarywang.wxpay.bean.result.WxPayOrderQueryResult;
import com.github.binarywang.wxpay.bean.result.WxPayRefundQueryResult;
import com.longjun.cto.framework.sm.pay.service.IPayHelperService;

/**
 * 支付帮助控制类
 * 
 * @author yangxuan
 * @date 2019年4月13日 上午10:10:25
 */
@RequestMapping("/mgn/sm/pay/payHelper")
@Controller
public class PayHelperController extends StandardBaseController {

	@Autowired
	IPayHelperService iPayHelperService;

	/**
	 * 支付帮助中心页面
	 * 
	 * @return
	 */
	@GetMapping("/payHelperInit")
	public ModelAndView payHelperInit() {
		ModelAndView model = getModelAndView("/mgn/sm/pay/payHelper/payHelperInit");
		return model;
	}

	/**
	 * 微信查询
	 * 
	 * @param queryType
	 * @param orderId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/wechatOrderQuery", method = { RequestMethod.GET, RequestMethod.POST })
	public ApiResult wechatOrderQuery(String transactionId, String outTradeNo) {
		WxPayOrderQueryResult ret = this.iPayHelperService.wechatOrderQuery(transactionId, outTradeNo);
		return ApiResult.instance().ok("WxPayOrderQueryResult", ret);
	}

	/**
	 * 微信退款查询
	 * 
	 * @param transactionId 微信订单号
	 * @param outTradeNo    商户订单号
	 * @param outRefundNo   商户退款单号
	 * @param refundId      微信退款单号
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/wechatRefundQuery", method = { RequestMethod.GET, RequestMethod.POST })
	public ApiResult wechatRefundQuery(String transactionId, String outTradeNo, String outRefundNo, String refundId) {
		WxPayRefundQueryResult wxPayRefundQueryResult = this.iPayHelperService.refundQuery(transactionId, outTradeNo,
				outRefundNo, refundId);
		return ApiResult.instance().ok("wxPayRefundQueryResult", wxPayRefundQueryResult);
	}

	/**
	 * 阿里支付订单查询
	 * @param outTradeNo
	 * @param tradeNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/aliPayQueryOrder", method = { RequestMethod.GET, RequestMethod.POST })
	public ApiResult aliPayQueryOrder(String outTradeNo, String tradeNo) {
		AlipayTradeQueryResponse ret = this.iPayHelperService.aliPayQueryOrder(null, outTradeNo, tradeNo);
		return ApiResult.instance().ok("AlipayTradeQueryResponse",ret);
	}
}
