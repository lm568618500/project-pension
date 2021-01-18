package com.longjun.cto.framework.sm.pay.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.plugins.pay.ali.api.AliPayHelper;
import com.eims.cto.framework.plugins.pay.wx.api.WechatPayApi;
import com.github.binarywang.wxpay.bean.result.WxPayOrderQueryResult;
import com.github.binarywang.wxpay.bean.result.WxPayRefundQueryResult;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelModel;
import com.longjun.cto.framework.sm.pay.entity.model.PayMchInfoModel;
import com.longjun.cto.framework.sm.pay.service.IPayChannelDictService;
import com.longjun.cto.framework.sm.pay.service.IPayChannelItemDictService;
import com.longjun.cto.framework.sm.pay.service.IPayChannelService;
import com.longjun.cto.framework.sm.pay.service.IPayHelperService;
import com.longjun.cto.framework.sm.pay.service.IPayMchInfoService;
import com.longjun.cto.framework.sm.pay.service.IPayOrderService;

/**
 * 支付帮助业务类实现类
 * 
 * @author yangxuan
 * @date 2019年4月13日 上午10:14:10
 */
@Component
public class PayHelperServiceImpl implements IPayHelperService {

	static Logger log = LoggerFactory.getLogger(PayHelperServiceImpl.class);

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

	@Override
	public WxPayOrderQueryResult wechatOrderQuery(String transactionId, String outTradeNo) throws BusinessException {
		PayMchInfoModel mchInfo = iPayMchInfoService.defaultMchInfo();
		if (mchInfo == null) {
			log.error("微信订单查询失败;未查询到商户配置信息");
			throw new BusinessException("微信订单查询失败;未查询到商户配置信息");
		}
		List<PayChannelModel> channels = this.iPayChannelService.findByChannelId(mchInfo.getMchId(), 20000L);
		if (channels == null) {
			log.error("微信订单查询失败;未查询到商户渠道配置信息");
			throw new BusinessException("微信订单查询失败;未查询到商户渠道配置信息");
		}
		PayChannelModel payChannelModel = channels.get(0);
		if (payChannelModel == null) {
			log.error("微信订单查询失败;未查询到商户渠道信息;商户MCHID[{}]", mchInfo.getMchId());
			throw new BusinessException("微信订单查询失败;未查询到商户渠道信息;");
		}
		if (payChannelModel.getStatus() != 1) {
			log.error("微信订单查询失败;商户渠道信息状态异常;状态[{}]商户MCHID[{}]", payChannelModel.getStatus(), mchInfo.getMchId());
			throw new BusinessException("微信订单查询失败;商户渠道信息状态异常");
		}
		// 配置文件信息
		JSONObject paramsJson = JSONObject.parseObject(payChannelModel.getParam());
		String appId = paramsJson.getString("appId");
		String mchId = paramsJson.getString("mchId");
		String mchKey = paramsJson.getString("mchKey");
		String subAppId = paramsJson.getString("subAppId");
		String subMchId = paramsJson.getString("subMchId");
		String keyPath = paramsJson.getString("keyPath");
		boolean sandBox = false;
		WechatPayApi api = WechatPayApi.getWechatPayApi(appId, mchId, mchKey, subAppId, subMchId, keyPath, sandBox);
		WxPayOrderQueryResult wxPayOrderQueryResult = api.queryOrder(transactionId, outTradeNo);
		log.info("微信订单查询;微信订单号[{}]商户系统内部的订单号[{}]查询结果[{}]", transactionId, outTradeNo,
				JSONObject.toJSONString(wxPayOrderQueryResult));
		return wxPayOrderQueryResult;
	}

	@Override
	public WxPayRefundQueryResult refundQuery(String transactionId, String outTradeNo, String outRefundNo,
			String refundId) throws BusinessException {
		PayMchInfoModel mchInfo = iPayMchInfoService.defaultMchInfo();
		if (mchInfo == null) {
			log.error("微信退款订单查询失败;未查询到商户配置信息");
			throw new BusinessException("微信退款订单查询失败;未查询到商户配置信息");
		}
		List<PayChannelModel> channels = this.iPayChannelService.findByChannelId(mchInfo.getMchId(), 20000L);
		if (channels == null) {
			log.error("微信退款订单查询失败;未查询到商户渠道配置信息");
			throw new BusinessException("微信退款订单查询失败;未查询到商户渠道配置信息");
		}
		PayChannelModel payChannelModel = channels.get(0);
		if (payChannelModel == null) {
			log.error("微信退款订单查询失败;未查询到商户渠道信息;商户MCHID[{}]", mchInfo.getMchId());
			throw new BusinessException("微信退款订单查询失败;未查询到商户渠道信息;");
		}
		if (payChannelModel.getStatus() != 1) {
			log.error("微信退款订单查询失败;商户渠道信息状态异常;状态[{}]商户MCHID[{}]", payChannelModel.getStatus(), mchInfo.getMchId());
			throw new BusinessException("微信退款订单查询失败;商户渠道信息状态异常");
		}
		// 配置文件信息
		JSONObject paramsJson = JSONObject.parseObject(payChannelModel.getParam());
		String appId = paramsJson.getString("appId");
		String mchId = paramsJson.getString("mchId");
		String mchKey = paramsJson.getString("mchKey");
		String subAppId = paramsJson.getString("subAppId");
		String subMchId = paramsJson.getString("subMchId");
		String keyPath = paramsJson.getString("keyPath");
		boolean sandBox = false;
		WechatPayApi api = WechatPayApi.getWechatPayApi(appId, mchId, mchKey, subAppId, subMchId, keyPath, sandBox);
		WxPayRefundQueryResult wxPayRefundQueryResult = api.refundQuery(transactionId, outTradeNo, outRefundNo,
				refundId);
		log.info("微信退款订单查询;微信订单号[{}]商户订单号[{}]商户退款单号[{}]微信退款单号[{}]查询结果[{}]", transactionId, outTradeNo, outRefundNo,
				refundId, JSONObject.toJSONString(wxPayRefundQueryResult));
		return wxPayRefundQueryResult;
	}

	@Override
	public AlipayTradeQueryResponse aliPayQueryOrder(String orgPid, String outTradeNo, String tradeNo) throws BusinessException {
		PayMchInfoModel mchInfo = iPayMchInfoService.defaultMchInfo();
		if (mchInfo == null) {
			log.error("阿里支付订单查询失败;未查询到商户配置信息");
			throw new BusinessException("阿里支付订单查询失败;未查询到商户配置信息");
		}
		List<PayChannelModel> channels = this.iPayChannelService.findByChannelId(mchInfo.getMchId(), 10000L);
		if (channels == null) {
			log.error("阿里支付订单查询失败;未查询到商户渠道配置信息");
			throw new BusinessException("阿里支付订单查询失败;未查询到商户渠道配置信息");
		}
		PayChannelModel payChannelModel = channels.get(0);
		if (payChannelModel == null) {
			log.error("阿里支付订单查询失败;未查询到商户渠道信息;商户MCHID[{}]", mchInfo.getMchId());
			throw new BusinessException("阿里支付订单查询失败;未查询到商户渠道信息;");
		}
		if (payChannelModel.getStatus() != 1) {
			log.error("阿里支付订单查询失败;商户渠道信息状态异常;状态[{}]商户MCHID[{}]", payChannelModel.getStatus(), mchInfo.getMchId());
			throw new BusinessException("阿里支付订单查询失败;商户渠道信息状态异常");
		}
		// 配置文件信息
		JSONObject paramsJson = JSONObject.parseObject(payChannelModel.getParam());
		String appId = paramsJson.getString("appId");
		String publicKey = paramsJson.getString("publicKey");
		String privateKey = paramsJson.getString("privateKey");
		String gateway = paramsJson.getString("gateway");
		AliPayHelper aliPayHelper = AliPayHelper.getAliPayHelper(appId, publicKey, privateKey, gateway);
		AlipayTradeQueryResponse ret = aliPayHelper.tradeQuery(orgPid, outTradeNo, tradeNo);
		return ret;
	}

}
