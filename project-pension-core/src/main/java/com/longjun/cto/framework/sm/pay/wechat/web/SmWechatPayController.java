package com.longjun.cto.framework.sm.pay.wechat.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eims.cto.framework.common.base.ret.ApiResult;
import com.eims.cto.framework.module.base.web.BaseController;
import com.longjun.cto.framework.sm.pay.WechatPayService;

/**
 * 微信支付控制类
 * 
 * @author yangxuan
 * @date Nov 7, 2019 - 11:46:47 AM
 */
@RequestMapping("/open/pay/wechat")
@Controller
public class SmWechatPayController extends BaseController {

	@Autowired
	WechatPayService wechatPayService;

	/**
	 * 微信支付异步通知
	 */
	@ResponseBody
	@PostMapping("/notify")
	public String notify(HttpServletRequest request) throws Exception {
		// 获取支付方返回的对应参数
		boolean ret = this.wechatPayService.handerNotify(request);
		if (ret) {
			return wechatPayService.getPayService().getPayOutMessage("fail", "失败").toMessage();
		} else {
			return wechatPayService.getPayService().successPayOutMessage(null).toMessage();
		}
	}

	/**
	 * 微信支付查询
	 * 
	 * @param outTradeNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/query")
	public ApiResult query(String outTradeNo) {
		Map<String, Object> ret = this.wechatPayService.query(null, outTradeNo);
		return ApiResult.instance().ok("ret", ret);
	}

}
