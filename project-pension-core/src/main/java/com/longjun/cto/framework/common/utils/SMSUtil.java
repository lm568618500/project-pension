package com.longjun.cto.framework.common.utils;
import com.google.gson.reflect.TypeToken;
import com.longjun.cto.framework.common.utils.yimeiSms.DateUtil;
import com.longjun.cto.framework.common.utils.yimeiSms.JsonHelper;
import com.longjun.cto.framework.common.utils.yimeiSms.Md5;
import com.longjun.cto.framework.common.utils.yimeiSms.http.*;
import com.longjun.cto.framework.common.utils.yimeiSms.response.ResponseData;
import com.longjun.cto.framework.common.utils.yimeiSms.response.SmsResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class SMSUtil {
	
	public static void main(String[] args) {

		sendMsgYM("测试短信","15367519386");

	}
	/**
	 * 发送批次短信
	 */
	private static void setSms(String appId, String sign, String timestamp, String host, String content, String mobiles, String customSmsId, String extendedCode, String timerTime) {
		Map<String, String> params = new HashMap<String, String>();
		try {
			params.put("appId", appId);
			params.put("sign", sign);
			params.put("timestamp", timestamp);
			params.put("mobiles", mobiles);
			params.put("content", URLEncoder.encode(content, "utf-8"));
			if (customSmsId != null) {
				params.put("customSmsId", customSmsId);
			}
			if (timerTime != null) {
				params.put("timerTime", timerTime);
			}
			if (extendedCode != null) {
				params.put("extendedCode", extendedCode);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String json = request1(params, "http://" + host + "/simpleinter/sendSMS");
		if (json != null) {
			ResponseData<SmsResponse[]> data = JsonHelper.fromJson(new TypeToken<ResponseData<SmsResponse[]>>() {
			}, json);
			String code = data.getCode();
			if ("SUCCESS".equals(code)) {
				for (SmsResponse d : data.getData()) {
					System.out.println("data:" + d.getMobile() + "," + d.getSmsId() + "," + d.getCustomSmsId());
				}
			}
		}
		System.out.println("=============end setSms==================");
	}
	/**
	 * 公共请求方法
	 */
	public static String request1(Map<String, String> params, String url) {
		EmayHttpRequestKV request = new EmayHttpRequestKV(url, "UTF-8", "POST", null, null, params);
		EmayHttpClient client = new EmayHttpClient();
		String json = null;
		try {
			String mapst = "";
			for (String key : params.keySet()) {
				String value = params.get(key);
				mapst += key + "=" + value + "&";
			}
			mapst = mapst.substring(0, mapst.length() - 1);
			System.out.println("request params: " + mapst);
			EmayHttpResponseString res = client.service(request, new EmayHttpResponseStringPraser());
			if (res == null) {
				System.err.println("请求接口异常");
				return null;
			}
			if (res.getResultCode().equals(EmayHttpResultCode.SUCCESS)) {
				if (res.getHttpCode() == 200) {
					json = res.getResultString();
					System.out.println("response json: " + json);
				} else {
					System.out.println("请求接口异常,请求码:" + res.getHttpCode());
				}
			} else {
				System.out.println("请求接口网络异常:" + res.getResultCode().getCode());
			}
		} catch (Exception e) {
			System.err.println("解析失败");
			e.printStackTrace();
		}
		return json;
	}
	public static void sendMsgYM(String content, String mobile){
		try {
			// appId
			String appId ="3SDK-GHJ-0130-JKVLP";//请联系销售，或者在页面中 获取
			// 密钥
			String secretKey = "EF2D7BF9BF2742C6";//请联系销售，或者在页面中 获取
			// 接口地址
			String host = "shmtn.b2m.cn";//请联系销售获取
			// 时间戳
			String timestamp = DateUtil.toString(new Date(), "yyyyMMddHHmmss");
			// 签名
			String sign = Md5.md5((appId + secretKey + timestamp).getBytes());
			// 发送批次短信,定时时间格式yyyyMMddHHmmss
			setSms(appId, sign, timestamp, host, "【龙骏报单系统】"+content, mobile, null, null, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
