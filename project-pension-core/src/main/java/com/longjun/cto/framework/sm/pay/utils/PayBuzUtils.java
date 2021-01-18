package com.longjun.cto.framework.sm.pay.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;

/**
 * 支付业务本地工具类-指第三方回调回来后;本地业务逻辑处理
 * 
 * @author yangxuan
 * @date May 28, 2019 - 1:38:12 PM
 */
public class PayBuzUtils {

	private static Logger LOG = LoggerFactory.getLogger(PayBuzUtils.class);

	// 支付状态
	public static String KEY_PAYSTATUS = "payStatus";
	// 同步支付回调地址
	public static String KEY_CALLBACKURL = "callBackUrl";
	// 创建订单提交的参数1
	public static String KEY_PARAM1 = "param1";
	// 创建订单提交的参数2
	public static String KEY_PARAM2 = "param2";
	// 随机码
	public static String KEY_RANDOMKEY = "randomKey";
	// 时间戳
	public static String KEY_TIMESTAMP = "timestamp";
	// 摘要
	public static String KEY_SIGN = "sign";

	// 包装同步信息
	public static void wapperCallBack(int payStatus, String callBackUrl, String param1, String param2,
			ModelAndView model) {
		String randomKey = IdUtil.randomUUID();
		long timestamp = System.currentTimeMillis();
		model.addObject(KEY_PAYSTATUS, payStatus);
		model.addObject(KEY_CALLBACKURL, callBackUrl);
		model.addObject(KEY_PARAM1, param1);
		model.addObject(KEY_PARAM2, param2);
		model.addObject(KEY_RANDOMKEY, randomKey);
		model.addObject(KEY_TIMESTAMP, timestamp);
		// 摘要,业务接收端需要进行解密
		String sign = payStatus /* + URLEncoder.encode(callBackUrl) */ + param1 + param2 + randomKey + timestamp;
		String signRet = DigestUtil.md5Hex(sign);
		model.addObject(KEY_SIGN, signRet);
	}
	

	// 包装异步信息
	public static void wapperNotify(int payStatus,  String param1, String param2,
			Map<String,Object> model) {
		String randomKey = IdUtil.randomUUID();
		long timestamp = System.currentTimeMillis();
		model.put(KEY_PAYSTATUS, payStatus);
		model.put(KEY_PARAM1, param1);
		model.put(KEY_PARAM2, param2);
		model.put(KEY_RANDOMKEY, randomKey);
		model.put(KEY_TIMESTAMP, timestamp);
		// 摘要,业务接收端需要进行解密
		String sign = payStatus /* + URLEncoder.encode(callBackUrl) */ + param1 + param2 + randomKey + timestamp;
		String signRet = DigestUtil.md5Hex(sign);
		model.put(KEY_SIGN, signRet);
	}

	// 校验同步信息
	public static boolean checkCallBack(HttpServletRequest request) {
		String payStatus = request.getParameter(KEY_PAYSTATUS);
		String param1 = request.getParameter(KEY_PARAM1);
		String param2 = request.getParameter(KEY_PARAM2);
		String randomKey = request.getParameter(KEY_RANDOMKEY);
		String timestamp = request.getParameter(KEY_TIMESTAMP);
		String requestSign = request.getParameter(KEY_SIGN);
		LOG.info("支付-同步信息参数校验打印开始");
		LOG.info("[{}], [{}]", KEY_PAYSTATUS, payStatus);
		LOG.info("[{}], [{}]", KEY_PARAM1, param1);
		LOG.info("[{}], [{}]", KEY_PARAM2, param2);
		LOG.info("[{}], [{}]", KEY_RANDOMKEY, randomKey);
		LOG.info("[{}], [{}]", KEY_TIMESTAMP, timestamp);
		LOG.info("[{}], [{}]", KEY_SIGN, requestSign);
		LOG.info("支付-同步信息参数校验打印结束");
		if (StrUtil.isBlank(payStatus) || StrUtil.isBlank(param1) || StrUtil.isBlank(param2)
				|| StrUtil.isBlank(randomKey) || StrUtil.isBlank(timestamp) || StrUtil.isBlank(requestSign)) {
			LOG.error("支付-校验同步信息异常;必填参数有为空;请检查");
			return false;
		}
		String sign = payStatus /* + URLEncoder.encode(callBackUrl) */ + param1 + param2 + randomKey + timestamp;
		LOG.info("支付-同步校验Sign摘要前明文[{}]", sign);
		String signRet = DigestUtil.md5Hex(sign);
		LOG.info("支付-同步校验Sign摘要后[{}]", signRet);
		if (requestSign.equalsIgnoreCase(signRet)) {
			return true;
		} else {
			LOG.info("支付-同步校验Sign摘要校验失败;本地摘要[{}]传入sign[{}]", signRet, requestSign);
			return false;
		}
	}

}
