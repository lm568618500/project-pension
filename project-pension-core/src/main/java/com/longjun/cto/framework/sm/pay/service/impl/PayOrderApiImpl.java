package com.longjun.cto.framework.sm.pay.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.plugins.pay.ali.api.AliPayHelper;
import com.eims.cto.framework.plugins.pay.wx.api.WechatPayApi;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayNativeOrderResult;
import com.github.binarywang.wxpay.bean.result.WxPayOrderQueryResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.longjun.cto.framework.sm.pay.entity.dto.WechatPayOrderRequestDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelDictModel;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelItemDictModel;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelModel;
import com.longjun.cto.framework.sm.pay.entity.model.PayMchInfoModel;
import com.longjun.cto.framework.sm.pay.entity.model.PayOrderModel;
import com.longjun.cto.framework.sm.pay.service.IPayChannelDictService;
import com.longjun.cto.framework.sm.pay.service.IPayChannelItemDictService;
import com.longjun.cto.framework.sm.pay.service.IPayChannelService;
import com.longjun.cto.framework.sm.pay.service.IPayMchInfoService;
import com.longjun.cto.framework.sm.pay.service.IPayOrderApi;
import com.longjun.cto.framework.sm.pay.service.IPayOrderService;
import com.longjun.cto.framework.sm.pay.utils.PayBuzUtils;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;

/**
 * 订单支付Api实现
 * 
 * @author yangxuan
 * @date 2019年4月11日 下午9:56:29
 */
@Service
public class PayOrderApiImpl implements IPayOrderApi {

	static Logger log = LoggerFactory.getLogger(PayOrderApiImpl.class);

	@Autowired
	IPayOrderService iPayOrderService;

	@Autowired
	IPayChannelDictService iPayChannelDictService;

	@Autowired
	IPayChannelItemDictService iPayChannelItemDictService;

	@Autowired
	IPayMchInfoService iPayMchInfoService;

	@Autowired
	IPayChannelService iPayChannelService;

	// 业务通知最大次数
	private static int BUZ_NOTIFY_COUNTMAX = 50;

	@Override
	public long createOrder(long mchOrderNo, long amount, String clientIp, String subject, String body, String param1,
			String param2, String buzNotifyUrl, String buzCallbackUrl) throws BusinessException {
		log.info("支付订单创建;mchOrderNo[{}]amount[{}]clientIp[{}]subject[{}]body[{}]param1[{}]param2[{}]buzNotifyUrl[{}]",
				mchOrderNo, amount, clientIp, subject, body, param1, param2, buzNotifyUrl);
		if (mchOrderNo < 0) {
			log.error("支付订单创建失败; 商户订单号非法");
			throw new BusinessException("支付订单创建失败; 商户订单号非法");
		}
//		if (amount < 1) {
//			log.error("支付订单创建失败; 订单金额非法");
//			throw new BusinessException("支付订单创建失败; 订单金额非法");
//		}
		if (StrUtil.isBlank(buzNotifyUrl)) {
			log.error("支付订单创建失败; 业务通知地址非法");
			throw new BusinessException("支付订单创建失败; 业务通知地址非法");
		}
		long payOrderId = Long.valueOf(new SimpleDateFormat("yyMMddhhmmssSSS").format(new Date()).toString()) * 10000;
		PayOrderModel model = new PayOrderModel();
		model.setTime(new Date());
		model.setPayOrderId(payOrderId);
		model.setLastupdate(new Date());
		model.setMchOrderNo(mchOrderNo);
		model.setAmount(amount);
		model.setCurrency("cny");
		model.setStatus(0);
		model.setClientIp(clientIp);
		model.setSubject(subject);
		model.setBody(body);
		model.setParam1(param1);
		model.setParam2(param2);
		model.setBuzNotifyUrl(buzNotifyUrl);
		model.setBuzCallbackUrl(buzCallbackUrl);
		this.iPayOrderService.insert(model);
		log.info("支付订单[{}]创建成功", mchOrderNo);
		return payOrderId;
	}

	JSONObject formatJson(String params) {
		JSONObject json = JSONObject.parseObject(params);
		return json;
	}

	@Override
	public void wechatAppPay() throws BusinessException {
		PayMchInfoModel mchInfo = iPayMchInfoService.defaultMchInfo();
		if (mchInfo == null) {
			log.error("微信App支付失败;未查询到商户配置信息");
			throw new BusinessException("微信App支付失败;未查询到商户配置信息");
		}
		// 参数固定
		PayChannelDictModel payChannelDictModel = this.iPayChannelDictService.selectById(20000L);
		if (payChannelDictModel == null) {
			log.error("微信App支付失败;未查询到渠道信息;id[{}]", 20000L);
			throw new BusinessException("微信App支付失败;未查询到渠道信息");
		}
		if (payChannelDictModel.getStatus() != 1) {
			log.error("微信App支付失败;查询到渠道状态信息异常;状态[{}]商户MCHID[{}]", payChannelDictModel.getStatus(), mchInfo.getMchId());
			throw new BusinessException("微信App支付失败;查询到渠道状态信息异常");
		}
		// 参数固定
		PayChannelItemDictModel payChannelItemDictModel = iPayChannelItemDictService.selectById(2000010L);
		if (payChannelItemDictModel == null) {
			log.error("微信App支付失败;未查询到支付方式信息;id[{}]", 2000010L);
			throw new BusinessException("微信App支付失败;未查询到支付方式信息");
		}
		if (payChannelItemDictModel.getStatus() != 1) {
			log.error("微信App支付失败;查询到支付方式状态信息异常;状态[{}]商户MCHID[{}]", payChannelItemDictModel.getStatus(),
					mchInfo.getMchId());
			throw new BusinessException("微信App支付失败;查询到支付方式状态信息异常");
		}
		PayChannelModel payChannelModel = this.iPayChannelService.findByChannelId2ItemId2MchId(
				payChannelDictModel.getId(), payChannelItemDictModel.getId(), mchInfo.getMchId());
		if (payChannelModel == null) {
			log.error("微信App支付失败;未查询到商户渠道信息;商户MCHID[{}]", mchInfo.getMchId());
			throw new BusinessException("微信App支付失败;未查询到商户渠道信息;");
		}
		if (payChannelModel.getStatus() != 1) {
			log.error("微信App支付失败;商户渠道信息状态异常;状态[{}]商户MCHID[{}]", payChannelModel.getStatus(), mchInfo.getMchId());
			throw new BusinessException("微信App支付失败;商户渠道信息状态异常");
		}
		// 配置文件信息
		JSONObject paramsJson = formatJson(payChannelModel.getParam());

	}

	@Override
	public void wechatH5() throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public WxPayNativeOrderResult wechatScan(long payOrderId) throws BusinessException {
		PayOrderModel payOrderModel = this.iPayOrderService.findByPayOrderId(payOrderId);
		if (payOrderModel == null) {
			log.info("扫码支付失败;未查询到支付订单记录;订单号[{}]", payOrderId);
			throw new BusinessException("扫码支付失败;未查询到支付订单记录;订单号:" + payOrderId);
		}
		WechatPayOrderRequestDto request = new WechatPayOrderRequestDto();
		request.setNative_body(payOrderModel.getBody());
//		request.setNative_attach(payOrderModel.getSubject());
		request.setNative_out_trade_no(payOrderModel.getPayOrderId() + "");
		request.setNative_total_fee(Convert.toInt(payOrderModel.getAmount()));
		request.setNative_productId(payOrderModel.getMchOrderNo() + "");
		WxPayNativeOrderResult ret = this.wechatScan(request);
		return ret;
	}

	@Override
	public WxPayNativeOrderResult wechatScan(WechatPayOrderRequestDto request) throws BusinessException {
		PayMchInfoModel mchInfo = iPayMchInfoService.defaultMchInfo();
		if (mchInfo == null) {
			log.error("微信扫码支付失败;未查询到商户配置信息");
			throw new BusinessException("微信扫码支付失败;未查询到商户配置信息");
		}
		// 参数固定
		PayChannelDictModel payChannelDictModel = this.iPayChannelDictService.selectById(20000L);
		if (payChannelDictModel == null) {
			log.error("微信扫码支付失败;未查询到渠道信息;id[{}]", 20000L);
			throw new BusinessException("微信扫码支付失败;未查询到渠道信息");
		}
		if (payChannelDictModel.getStatus() != 1) {
			log.error("微信扫码支付失败;查询到渠道状态信息异常;状态[{}]商户MCHID[{}]", payChannelDictModel.getStatus(), mchInfo.getMchId());
			throw new BusinessException("微信扫码支付失败;查询到渠道状态信息异常");
		}
		// 参数固定 2000012-WX_NATIVE 2000011-WX_JSAPI 2000010-WX_APP
		PayChannelItemDictModel payChannelItemDictModel = iPayChannelItemDictService.selectById(2000012L);
		if (payChannelItemDictModel == null) {
			log.error("微信扫码支付失败;未查询到支付方式信息;id[{}]", 2000012L);
			throw new BusinessException("微信扫码支付失败;未查询到支付方式信息");
		}
		if (payChannelItemDictModel.getStatus() != 1) {
			log.error("微信扫码支付失败;查询到支付方式状态信息异常;状态[{}]商户MCHID[{}]", payChannelItemDictModel.getStatus(),
					mchInfo.getMchId());
			throw new BusinessException("微信扫码支付失败;查询到支付方式状态信息异常");
		}
		PayChannelModel payChannelModel = this.iPayChannelService.findByChannelId2ItemId2MchId(
				payChannelDictModel.getId(), payChannelItemDictModel.getId(), mchInfo.getMchId());
		if (payChannelModel == null) {
			log.error("微信扫码支付失败;未查询到商户渠道信息;商户MCHID[{}]", mchInfo.getMchId());
			throw new BusinessException("微信扫码支付失败;未查询到商户渠道信息;");
		}
		if (payChannelModel.getStatus() != 1) {
			log.error("微信扫码支付失败;商户渠道信息状态异常;状态[{}]商户MCHID[{}]", payChannelModel.getStatus(), mchInfo.getMchId());
			throw new BusinessException("微信扫码支付失败;商户渠道信息状态异常");
		}
		// 配置文件信息
//		JSONObject paramsJson = formatJson(payChannelModel.getParam());
		JSONObject paramsJson = this.iPayChannelService.checkWechatPayProfile(payChannelModel);
		if(paramsJson == null) {
			throw new BusinessException("微信扫码支付失败;支付配置信息校验失败");
		}
		String appId = paramsJson.getString("appId");
		String mchId = paramsJson.getString("mchId");
		String mchKey = paramsJson.getString("mchKey");
		String subAppId = paramsJson.getString("subAppId");
		String subMchId = paramsJson.getString("subMchId");
		String keyPath = paramsJson.getString("keyPath");
		String notifyUrl = paramsJson.getString("notifyUrl");
		String native_spbillCreateIp = paramsJson.getString("native_spbillCreateIp");
		request.setNative_spbillCreateIp(native_spbillCreateIp);
		boolean sandBox = false;
		WechatPayApi api = WechatPayApi.getWechatPayApi(appId, mchId, mchKey, subAppId, subMchId, keyPath, sandBox);
		request.setNative_notify_url(notifyUrl);
		// 附加参数;主要为异步通知扩展使用;长度最大127位
		JSONObject attach = new JSONObject();
		attach.put("mchId", mchInfo.getMchId());
		attach.put("channelId", 20000L);
		attach.put("channelItemsId", 2000012L);
		request.setNative_attach(attach.toJSONString());

		// 参数日志打印
		log.info(
				"微信支付-扫码支付;请求参数body[{}] attach[{}] outTradeNo[{}]totalFee[{}]notifyUrl[{}]spbillCreateIp[{}]"
						+ "productId[{}]",
				request.getNative_body(), request.getNative_attach(), request.getNative_out_trade_no(),
				request.getNative_total_fee(), request.getNative_notify_url(), request.getNative_spbillCreateIp(),
				request.getNative_productId());
		WxPayNativeOrderResult wxPayNativeOrderResult = api.nativePay(request.getNative_body(),
				request.getNative_attach(), request.getNative_out_trade_no(), request.getNative_total_fee(),
				request.getNative_notify_url(), request.getNative_spbillCreateIp(), request.getNative_productId());
		log.info("微信支付-扫码支付;订单号[{}]响应[{}]", request.getNative_out_trade_no(),
				JSONObject.toJSONString(wxPayNativeOrderResult));

		PayOrderModel payOrderModel = this.iPayOrderService
				.findByPayOrderId(Convert.toLong(request.getNative_out_trade_no()));
		if (payOrderModel == null) {
			log.info("扫码支付失败;未查询到支付订单记录;订单号[{}]", Convert.toLong(request.getNative_out_trade_no()));
			throw new BusinessException("扫码支付失败;未查询到支付订单记录;订单号:" + Convert.toLong(request.getNative_out_trade_no()));
		}
		// 修改订单信息。将待支付修改为支付中。之后等待异步通知。
		payOrderModel.setNotifyUrl(notifyUrl);
		payOrderModel.setNotifyCount(0);
		payOrderModel.setGoPayTime(new Date());
		payOrderModel.setApiResp(JSONObject.toJSONString(wxPayNativeOrderResult));
		payOrderModel.setMchId(mchInfo.getMchId());
		payOrderModel.setChannelId(payChannelDictModel.getId());
		payOrderModel.setChannelItemsId(payChannelItemDictModel.getId());
		payOrderModel.setStatus(1);
		this.iPayOrderService.updateById(payOrderModel);
		return wxPayNativeOrderResult;
	}

	@Override
	public synchronized boolean wechatNotify(String xml) throws BusinessException {
		log.info("微信支付-异步通知响应[{}]", xml);
		if (StrUtil.isBlank(xml)) {
			log.error("微信支付,异步通知参数为空");
			throw new BusinessException("微信支付,异步通知参数为空");
		}
		Map<String, String> dataMap = null;
		try {
			dataMap = this.xmlToMap(xml);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("微信支付,异步通知格式解析错误");
		}

		/**
		 * PayMchInfoModel mchInfo = iPayMchInfoService.defaultMchInfo(); if (mchInfo ==
		 * null) { log.error("微信异步通知失败;未查询到商户配置信息"); throw new
		 * BusinessException("微信扫码支付失败;未查询到商户配置信息"); } // 参数固定 PayChannelDictModel
		 * payChannelDictModel = this.iPayChannelDictService.selectById(20000L); if
		 * (payChannelDictModel == null) { log.error("微信异步通知失败;未查询到渠道信息;id[{}]",
		 * 20000L); throw new BusinessException("微信异步通知失败;未查询到渠道信息"); } if
		 * (payChannelDictModel.getStatus() != 1) {
		 * log.error("微信异步通知失败;查询到渠道状态信息异常;状态[{}]商户MCHID[{}]",
		 * payChannelDictModel.getStatus(), mchInfo.getMchId()); throw new
		 * BusinessException("微信异步通知失败;查询到渠道状态信息异常"); } // 参数固定 2000012-WX_NATIVE
		 * 2000011-WX_JSAPI 2000010-WX_APP PayChannelItemDictModel
		 * payChannelItemDictModel = iPayChannelItemDictService.selectById(2000012L); if
		 * (payChannelItemDictModel == null) { log.error("微信异步通知失败;未查询到支付方式信息;id[{}]",
		 * 2000012L); throw new BusinessException("微信异步通知失败;未查询到支付方式信息"); } if
		 * (payChannelItemDictModel.getStatus() != 1) {
		 * log.error("微信异步通知失败;查询到支付方式状态信息异常;状态[{}]商户MCHID[{}]",
		 * payChannelItemDictModel.getStatus(), mchInfo.getMchId()); throw new
		 * BusinessException("微信异步通知失败;查询到支付方式状态信息异常"); } PayChannelModel
		 * payChannelModel = this.iPayChannelService.findByChannelId2ItemId2MchId(
		 * payChannelDictModel.getId(), payChannelItemDictModel.getId(),
		 * mchInfo.getMchId());
		 * 
		 **/
		JSONObject attach = JSONObject.parseObject(dataMap.get("attach"));
		long channelId = attach.getLongValue("channelId");
		long channelItemsId = attach.getLongValue("channelItemsId");
		long mchId = attach.getLongValue("mchId");
		PayChannelModel payChannelModel = this.iPayChannelService.findByChannelId2ItemId2MchId(channelId,
				channelItemsId, mchId);
		if (payChannelModel == null) {
			log.error("微信异步通知失败;未查询到商户渠道信息;商户MCHID[{}]", mchId);
			throw new BusinessException("微信异步通知失败;未查询到商户渠道信息;");
		}
		if (payChannelModel.getStatus() != 1) {
			log.error("微信异步通知失败;商户渠道信息状态异常;状态[{}]商户MCHID[{}]", payChannelModel.getStatus(), mchId);
			throw new BusinessException("微信异步通知失败;商户渠道信息状态异常");
		}
		// 配置文件信息
		JSONObject paramsJson = formatJson(payChannelModel.getParam());
		String appId = paramsJson.getString("appId");
		String wechatMchId = paramsJson.getString("mchId");
		String mchKey = paramsJson.getString("mchKey");
		String subAppId = paramsJson.getString("subAppId");
		String subMchId = paramsJson.getString("subMchId");
		String keyPath = paramsJson.getString("keyPath");
		String notifyUrl = paramsJson.getString("notifyUrl");
		boolean sandBox = false;
		WechatPayApi api = WechatPayApi.getWechatPayApi(appId, wechatMchId, mchKey, subAppId, subMchId, keyPath,
				sandBox);
		WxPayService payService = api.getWxPayService();
		try {
			WxPayOrderNotifyResult notifyResult = payService.parseOrderNotifyResult(xml);
			String outTradeNo = notifyResult.getOutTradeNo();
			// 进行查询
			WxPayOrderQueryResult ret = api.queryOrder(null, outTradeNo);
			String tradeState = ret.getTradeState();
			if ("SUCCESS".equals(tradeState)) { // 成功
				PayOrderModel payOrderModel = this.iPayOrderService.findByPayOrderId(Convert.toLong(outTradeNo));
				if (payOrderModel != null) {
					if (payOrderModel.getStatus() == 1) {
						payOrderModel.setNotifyCount(payOrderModel.getNotifyCount() + 1);
						payOrderModel.setNotifyXml(xml);
						payOrderModel.setLastNotifyTime(new Date());
						payOrderModel.setPaySuccTime(new Date());
						payOrderModel.setStatus(2);
						this.iPayOrderService.updateById(payOrderModel);
						// 业务异步通知
						this.execBuzNotify(payOrderModel);
						return true;
					} else if (payOrderModel.getStatus() == 2) {
						log.warn("微信异步通知;订单号[{}]支付状态已支付status [{}]", outTradeNo, payOrderModel.getStatus());
						return true;
					} else {
						log.warn("微信异步通知;订单号[{}]支付状态异常status [{}]记录", outTradeNo, payOrderModel.getStatus());
						return false;
					}
				} else {
					log.warn("微信异步通知;未查询到订单号[{}]支付记录", outTradeNo);
					return false;
				}
			}
		} catch (WxPayException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public AlipayTradeAppPayResponse alipayApp(long payOrderId) throws BusinessException {
		PayMchInfoModel mchInfo = iPayMchInfoService.defaultMchInfo();
		if (mchInfo == null) {
			log.error("阿里App支付失败;未查询到商户配置信息");
			throw new BusinessException("阿里App支付失败;未查询到商户配置信息");
		}
		// 参数固定
		PayChannelDictModel payChannelDictModel = this.iPayChannelDictService.selectById(10000L);
		if (payChannelDictModel == null) {
			log.error("阿里App支付失败;未查询到渠道信息;id[{}]", 10000L);
			throw new BusinessException("阿里App支付失败;未查询到渠道信息");
		}
		if (payChannelDictModel.getStatus() != 1) {
			log.error("阿里App支付失败;查询到渠道状态信息异常;状态[{}]商户MCHID[{}]", payChannelDictModel.getStatus(), mchInfo.getMchId());
			throw new BusinessException("阿里App支付失败;查询到渠道状态信息异常");
		}
		// 参数固定 1000010-ALIPAY_MOBILE 1000011-ALIPAY_WEB 1000012-ALIPAY_WAP
		PayChannelItemDictModel payChannelItemDictModel = iPayChannelItemDictService.selectById(1000010L);
		if (payChannelItemDictModel == null) {
			log.error("阿里App支付失败;未查询到支付方式信息;id[{}]", 1000010L);
			throw new BusinessException("阿里App支付失败;未查询到支付方式信息");
		}
		if (payChannelItemDictModel.getStatus() != 1) {
			log.error("阿里App支付失败;查询到支付方式状态信息异常;状态[{}]商户MCHID[{}]", payChannelItemDictModel.getStatus(),
					mchInfo.getMchId());
			throw new BusinessException("阿里App支付失败;查询到支付方式状态信息异常");
		}
		PayChannelModel payChannelModel = this.iPayChannelService.findByChannelId2ItemId2MchId(
				payChannelDictModel.getId(), payChannelItemDictModel.getId(), mchInfo.getMchId());
		if (payChannelModel == null) {
			log.error("阿里App支付失败;未查询到商户渠道信息;商户MCHID[{}]", mchInfo.getMchId());
			throw new BusinessException("阿里App支付失败;未查询到商户渠道信息;");
		}
		if (payChannelModel.getStatus() != 1) {
			log.error("阿里App支付失败;商户渠道信息状态异常;状态[{}]商户MCHID[{}]", payChannelModel.getStatus(), mchInfo.getMchId());
			throw new BusinessException("阿里App支付失败;商户渠道信息状态异常");
		}
		// 配置文件信息
		JSONObject paramsJson = formatJson(payChannelModel.getParam());
		String appId = paramsJson.getString("appId");
		String publicKey = paramsJson.getString("publicKey");
		String privateKey = paramsJson.getString("privateKey");
		String gateway = paramsJson.getString("gateway");
		String notifyUrl = paramsJson.getString("notifyUrl");
		String timeoutExpress = paramsJson.getString("timeoutExpress");
		// 参数日志打印
		PayOrderModel payOrderModel = this.iPayOrderService.findByPayOrderId(payOrderId);
		if (payOrderModel == null) {
			log.info("阿里PC支付失败;未查询到支付订单记录;订单号[{}]", payOrderId);
			throw new BusinessException("阿里PC支付失败;未查询到支付订单记录;订单号:" + payOrderId);
		}
		BigDecimal totalAmount = new BigDecimal(payOrderModel.getAmount()).divide(new BigDecimal(100));
		AliPayHelper aliPayHelper = AliPayHelper.getAliPayHelper(appId, publicKey, privateKey, gateway);
		AlipayTradeAppPayResponse alipayTradeAppPayResponse = aliPayHelper.appPay(payOrderId + "",
				payOrderModel.getBody(), timeoutExpress, payOrderModel.getSubject(), totalAmount, null, notifyUrl);
		// 修改订单信息。将待支付修改为支付中。之后等待异步通知。
		payOrderModel.setNotifyUrl(notifyUrl);
		payOrderModel.setNotifyCount(0);
		payOrderModel.setGoPayTime(new Date());
		payOrderModel.setApiResp(JSONObject.toJSONString(alipayTradeAppPayResponse));
		payOrderModel.setMchId(mchInfo.getMchId());
		payOrderModel.setChannelId(payChannelDictModel.getId());
		payOrderModel.setChannelItemsId(payChannelItemDictModel.getId());
		payOrderModel.setStatus(1);
		this.iPayOrderService.updateById(payOrderModel);
		return alipayTradeAppPayResponse;
	}

	@Override
	public String alipayWap(long payOrderId) throws BusinessException {
		PayMchInfoModel mchInfo = iPayMchInfoService.defaultMchInfo();
		if (mchInfo == null) {
			log.error("阿里WAP支付失败;未查询到商户配置信息");
			throw new BusinessException("阿里WAP支付失败;未查询到商户配置信息");
		}
		// 参数固定
		PayChannelDictModel payChannelDictModel = this.iPayChannelDictService.selectById(10000L);
		if (payChannelDictModel == null) {
			log.error("阿里WAP支付失败;未查询到渠道信息;id[{}]", 10000L);
			throw new BusinessException("阿里WAP支付失败;未查询到渠道信息");
		}
		if (payChannelDictModel.getStatus() != 1) {
			log.error("阿里WAP支付失败;查询到渠道状态信息异常;状态[{}]商户MCHID[{}]", payChannelDictModel.getStatus(), mchInfo.getMchId());
			throw new BusinessException("阿里WAP支付失败;查询到渠道状态信息异常");
		}
		// 参数固定 1000010-ALIPAY_MOBILE 1000011-ALIPAY_WEB 1000012-ALIPAY_WAP
		PayChannelItemDictModel payChannelItemDictModel = iPayChannelItemDictService.selectById(1000012L);
		if (payChannelItemDictModel == null) {
			log.error("阿里WAP支付失败;未查询到支付方式信息;id[{}]", 1000012L);
			throw new BusinessException("阿里WAP支付失败;未查询到支付方式信息");
		}
		if (payChannelItemDictModel.getStatus() != 1) {
			log.error("阿里WAP支付失败;查询到支付方式状态信息异常;状态[{}]商户MCHID[{}]", payChannelItemDictModel.getStatus(),
					mchInfo.getMchId());
			throw new BusinessException("阿里WAP支付失败;查询到支付方式状态信息异常");
		}
		PayChannelModel payChannelModel = this.iPayChannelService.findByChannelId2ItemId2MchId(
				payChannelDictModel.getId(), payChannelItemDictModel.getId(), mchInfo.getMchId());
		if (payChannelModel == null) {
			log.error("阿里WAP支付失败;未查询到商户渠道信息;商户MCHID[{}]", mchInfo.getMchId());
			throw new BusinessException("阿里WAP支付失败;未查询到商户渠道信息;");
		}
		if (payChannelModel.getStatus() != 1) {
			log.error("阿里WAP支付失败;商户渠道信息状态异常;状态[{}]商户MCHID[{}]", payChannelModel.getStatus(), mchInfo.getMchId());
			throw new BusinessException("阿里WAP支付失败;商户渠道信息状态异常");
		}
		// 配置文件信息
		JSONObject paramsJson = formatJson(payChannelModel.getParam());
		String appId = paramsJson.getString("appId");
		String publicKey = paramsJson.getString("publicKey");
		String privateKey = paramsJson.getString("privateKey");
		String gateway = paramsJson.getString("gateway");
		String notifyUrl = paramsJson.getString("notifyUrl");
		String returnUrl = paramsJson.getString("returnUrl");
		// 参数日志打印
		PayOrderModel payOrderModel = this.iPayOrderService.findByPayOrderId(payOrderId);
		if (payOrderModel == null) {
			log.info("阿里WAP支付失败;未查询到支付订单记录;订单号[{}]", payOrderId);
			throw new BusinessException("阿里WAP支付失败;未查询到支付订单记录;订单号:" + payOrderId);
		}
		BigDecimal totalAmount = new BigDecimal(payOrderModel.getAmount()).divide(new BigDecimal(100));
		AliPayHelper aliPayHelper = AliPayHelper.getAliPayHelper(appId, publicKey, privateKey, gateway);
		String retHtml = aliPayHelper.wapPay(payOrderId + "", payOrderModel.getBody(), payOrderModel.getSubject(),
				totalAmount, null, returnUrl, notifyUrl);
		// 修改订单信息。将待支付修改为支付中。之后等待异步通知。
		payOrderModel.setNotifyUrl(notifyUrl);
		payOrderModel.setNotifyCount(0);
		payOrderModel.setGoPayTime(new Date());
		payOrderModel.setApiResp(retHtml);
		payOrderModel.setMchId(mchInfo.getMchId());
		payOrderModel.setChannelId(payChannelDictModel.getId());
		payOrderModel.setChannelItemsId(payChannelItemDictModel.getId());
		payOrderModel.setStatus(1);
		this.iPayOrderService.updateById(payOrderModel);
		return retHtml;
	}

	@Override
	public String alipayPc(long payOrderId) throws BusinessException {
		PayMchInfoModel mchInfo = iPayMchInfoService.defaultMchInfo();
		if (mchInfo == null) {
			log.error("阿里PC支付失败;未查询到商户配置信息");
			throw new BusinessException("阿里PC支付失败;未查询到商户配置信息");
		}
		// 参数固定
		PayChannelDictModel payChannelDictModel = this.iPayChannelDictService.selectById(10000L);
		if (payChannelDictModel == null) {
			log.error("阿里PC支付失败;未查询到渠道信息;id[{}]", 10000L);
			throw new BusinessException("阿里PC支付失败;未查询到渠道信息");
		}
		if (payChannelDictModel.getStatus() != 1) {
			log.error("阿里PC支付失败;查询到渠道状态信息异常;状态[{}]商户MCHID[{}]", payChannelDictModel.getStatus(), mchInfo.getMchId());
			throw new BusinessException("阿里PC支付失败;查询到渠道状态信息异常");
		}
		// 参数固定 1000010-ALIPAY_MOBILE 1000011-ALIPAY_WEB 1000012-ALIPAY_WAP
		PayChannelItemDictModel payChannelItemDictModel = iPayChannelItemDictService.selectById(1000011L);
		if (payChannelItemDictModel == null) {
			log.error("阿里PC支付失败;未查询到支付方式信息;id[{}]", 1000011L);
			throw new BusinessException("阿里PC支付失败;未查询到支付方式信息");
		}
		if (payChannelItemDictModel.getStatus() != 1) {
			log.error("阿里PC支付失败;查询到支付方式状态信息异常;状态[{}]商户MCHID[{}]", payChannelItemDictModel.getStatus(),
					mchInfo.getMchId());
			throw new BusinessException("阿里PC支付失败;查询到支付方式状态信息异常");
		}
		PayChannelModel payChannelModel = this.iPayChannelService.findByChannelId2ItemId2MchId(
				payChannelDictModel.getId(), payChannelItemDictModel.getId(), mchInfo.getMchId());
		if (payChannelModel == null) {
			log.error("阿里PC支付失败;未查询到商户渠道信息;商户MCHID[{}]", mchInfo.getMchId());
			throw new BusinessException("阿里PC支付失败;未查询到商户渠道信息;");
		}
		if (payChannelModel.getStatus() != 1) {
			log.error("阿里PC支付失败;商户渠道信息状态异常;状态[{}]商户MCHID[{}]", payChannelModel.getStatus(), mchInfo.getMchId());
			throw new BusinessException("阿里PC支付失败;商户渠道信息状态异常");
		}
		// 配置文件信息
//		JSONObject paramsJson = formatJson(payChannelModel.getParam());
		JSONObject paramsJson = this.iPayChannelService.checkAliPayProfile(payChannelModel);
		if (paramsJson == null) {
			throw new BusinessException("阿里PC支付失败;渠道接口配置信息校验失败;商户MCHID[{}]", mchInfo.getMchId());
		}
		String appId = paramsJson.getString("appId");
		String publicKey = paramsJson.getString("publicKey");
		String privateKey = paramsJson.getString("privateKey");
		String gateway = paramsJson.getString("gateway");
		String notifyUrl = paramsJson.getString("notifyUrl");
		String returnUrl = paramsJson.getString("returnUrl");
		String productCode = paramsJson.getString("productCode");
		// 参数日志打印
		PayOrderModel payOrderModel = this.iPayOrderService.findByPayOrderId(payOrderId);
		if (payOrderModel == null) {
			log.info("阿里PC支付失败;未查询到支付订单记录;订单号[{}]", payOrderId);
			throw new BusinessException("阿里PC支付失败;未查询到支付订单记录;订单号:" + payOrderId);
		}

		JSONObject passbackParamsJson = new JSONObject();
		// 传递到支付宝;主要在支付回调时;我们需要根据租户进行查询相关配置信息;然后用于验签,查询操作;
		/// com.eims.cto.framework.sm.pay-cgi/src/main/java/com/eims/cto/framework/sm/pay/web/SmPayOpenController.java
		passbackParamsJson.put("mchId", mchInfo.getMchId());
		passbackParamsJson.put("channelName", "支付宝");
		passbackParamsJson.put("channelId", 10000L);
		passbackParamsJson.put("channelItemsId", 1000011L);
		BigDecimal totalAmount = new BigDecimal(payOrderModel.getAmount()).divide(new BigDecimal(100));
		AliPayHelper aliPayHelper = AliPayHelper.getAliPayHelper(appId, publicKey, privateKey, gateway);
		String retHtml = aliPayHelper.pcPay(payOrderId + "", payOrderModel.getBody(), productCode,
				payOrderModel.getSubject(), totalAmount, passbackParamsJson.toJSONString(), returnUrl, notifyUrl);
		// 修改订单信息。将待支付修改为支付中。之后等待异步通知。
		payOrderModel.setNotifyUrl(notifyUrl);
		payOrderModel.setNotifyCount(0);
		payOrderModel.setGoPayTime(new Date());
		payOrderModel.setApiResp(retHtml);
		payOrderModel.setMchId(mchInfo.getMchId());
		payOrderModel.setChannelId(payChannelDictModel.getId());
		payOrderModel.setChannelItemsId(payChannelItemDictModel.getId());
		payOrderModel.setStatus(1);
		this.iPayOrderService.updateById(payOrderModel);
		return retHtml;
	}

	@Override
	public void execBuzNotifyJobs() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 2).le("buz_notify_count", BUZ_NOTIFY_COUNTMAX);
		Page<PayOrderModel> pages = this.iPayOrderService.selectPage(new Page<>(0, 10), ew);
		if (pages == null) {
			return;
		}
		List<PayOrderModel> records = pages.getRecords();
		if (records == null) {
			return;
		}
		for (PayOrderModel record : records) {
			this.execBuzNotify(record);
		}
	}

	@Override
	public void execBuzNotify(long payOrderId) throws BusinessException {
		if (payOrderId < 1) {
			log.error("支付订单;处理业务异步通知失败;订单号非法");
			return;
		}
		PayOrderModel payOrderModel = this.iPayOrderService.findByPayOrderId(payOrderId);
		if (payOrderModel != null) {
			this.execBuzNotify(payOrderModel);
		}
	}

	@Override
	public synchronized void execBuzNotify(PayOrderModel payOrderModel) throws BusinessException {
		if (payOrderModel == null) {
			return;
		}
		if (payOrderModel.getStatus() == 2 || payOrderModel.getStatus() == 3) {
//			this.execBuzNotify(payOrderModel);
		} else {
			log.error("支付订单;处理业务异步通知失败;订单号状态异常订单号[{}]状态[{}]", payOrderModel.getPayOrderId(), payOrderModel.getStatus());
			return;
		}

		if (payOrderModel.getBuzNotifyCount() > BUZ_NOTIFY_COUNTMAX) {
			log.error("订单[{}]业务异步通知次数达到上限[{}]次", payOrderModel.getId(), payOrderModel.getBuzNotifyCount());
			return;
		}
		String buzUrl = payOrderModel.getBuzNotifyUrl();
		if (StrUtil.isBlank(buzUrl)) {
			payOrderModel.setBuzNotifyCount(payOrderModel.getBuzNotifyCount() + 1);
			payOrderModel.setBuzNotifyResp("业务异步接口请求地址为空");
			this.iPayOrderService.updateById(payOrderModel);
			return;
		}
		JSONObject bodyJson = new JSONObject();
		bodyJson.put("payOrderId", payOrderModel.getPayOrderId());
		bodyJson.put("mchOrderNo", payOrderModel.getMchOrderNo());
		bodyJson.put("channelId", payOrderModel.getChannelId());
		bodyJson.put("channelItemsId", payOrderModel.getChannelItemsId());
//		bodyJson.put("param1", payOrderModel.getParam1());
//		bodyJson.put("param2", payOrderModel.getParam2());
		bodyJson.put("paySuccTime", DateUtil.format(payOrderModel.getPaySuccTime(), "yyyy-MM-dd HH:mm:ss"));

		Map<String, Object> params = new HashMap<>(bodyJson);
		String param1 = payOrderModel.getParam1();
		String param2 = payOrderModel.getParam2();
		// 摘要处理
		PayBuzUtils.wapperNotify(payOrderModel.getStatus(), param1, param2, params);
		try {
			String ret = HttpUtil.post(buzUrl, params);
			if (StrUtil.isBlank(ret)) {
				payOrderModel.setBuzNotifyCount(payOrderModel.getBuzNotifyCount() + 1);
				payOrderModel.setBuzNotifyResp("业务异步接口异常;返回空对象");
				this.iPayOrderService.updateById(payOrderModel);
			} else {
				JSONObject retJson = JSONObject.parseObject(ret);
				int code = retJson.getIntValue("code");
				if (code == 200) {
					payOrderModel.setBuzNotifyCount(payOrderModel.getBuzNotifyCount() + 1);
					payOrderModel.setBuzNotifyResp(retJson.toJSONString());
					payOrderModel.setStatus(3);
					this.iPayOrderService.updateById(payOrderModel);
				} else {
					payOrderModel.setBuzNotifyCount(payOrderModel.getBuzNotifyCount() + 1);
					payOrderModel.setBuzNotifyResp(retJson.toJSONString());
					this.iPayOrderService.updateById(payOrderModel);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			payOrderModel.setBuzNotifyCount(payOrderModel.getBuzNotifyCount() + 1);
			payOrderModel.setBuzNotifyResp("业务异步接口异常;" + e.getMessage());
			this.iPayOrderService.updateById(payOrderModel);
		}
	}

	/**
	 * XML格式字符串转换为Map
	 *
	 * @param strXML XML字符串
	 * @return XML数据转换后的Map
	 * @throws Exception
	 */
	private Map<String, String> xmlToMap(String strXML) throws Exception {
		try {
			Map<String, String> data = new HashMap<String, String>();
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
			org.w3c.dom.Document doc = documentBuilder.parse(stream);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getDocumentElement().getChildNodes();
			for (int idx = 0; idx < nodeList.getLength(); ++idx) {
				Node node = nodeList.item(idx);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					org.w3c.dom.Element element = (org.w3c.dom.Element) node;
					data.put(element.getNodeName(), element.getTextContent());
				}
			}
			try {
				stream.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return data;
		} catch (Exception ex) {
			throw ex;
		}

	}

}
