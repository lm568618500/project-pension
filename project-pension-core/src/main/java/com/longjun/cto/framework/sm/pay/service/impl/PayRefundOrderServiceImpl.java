package com.longjun.cto.framework.sm.pay.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.eims.cto.framework.plugins.pay.ali.api.AliPayHelper;
import com.eims.cto.framework.plugins.pay.wx.api.WechatPayApi;
import com.github.binarywang.wxpay.bean.result.WxPayRefundQueryResult;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.longjun.cto.framework.sm.pay.entity.dto.PayRefundOrderDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayRefundOrderModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelModel;
import com.longjun.cto.framework.sm.pay.entity.model.PayOrderModel;
import com.longjun.cto.framework.sm.pay.entity.model.PayRefundOrderModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayRefundOrderView;
import com.longjun.cto.framework.sm.pay.es.PayChannelItemsEnum;
import com.longjun.cto.framework.sm.pay.es.RefundsQueryState;
import com.longjun.cto.framework.sm.pay.mapper.PayRefundOrderMapper;
import com.longjun.cto.framework.sm.pay.service.IPayChannelService;
import com.longjun.cto.framework.sm.pay.service.IPayOrderService;
import com.longjun.cto.framework.sm.pay.service.IPayRefundOrderService;

import cn.hutool.core.convert.Convert;

/**
 * PayRefundOrderServiceImpl
 * 
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
@Service
public class PayRefundOrderServiceImpl extends BaseServiceImpl<PayRefundOrderMapper, PayRefundOrderModel>
		implements IPayRefundOrderService {

	@Autowired
	private PayRefundOrderMapper mapper;

	@Autowired
	private IPayOrderService iPayOrderService;

	@Autowired
	private IPayChannelService iPayChannelService;

	@Override
	public PayRefundOrderView findViewById(long id) throws BusinessException {
		PayRefundOrderView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayRefundOrderModel findModelById(long id) throws BusinessException {
		PayRefundOrderModel model = this.selectById(id);
		if (model == null) {
			log.warn("PayRefundOrder 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayRefundOrderModel model) throws BusinessException {
		log.info("PayRefundOrder 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		PayRefundOrderModel model = super.selectById(id);
		if (model == null) {
			log.error("PayRefundOrder 开启操作,ID[{}]未查询到数据信息", id);
			return false;
		}
		if (model.getStatus() == USE) {
			return true;
		}
		model.setStatus(USE);
		boolean ret = super.updateById(model);
		return ret;
	}

	@Override
	public boolean del(long id) throws BusinessException {
		int ret = this.mapper.del(id);
		return ret > 0 ? true : false;
	}

	@Override
	public boolean stop(long id) throws BusinessException {
		PayRefundOrderModel model = super.selectById(id);
		if (model == null) {
			log.error("PayRefundOrder 停止操作,ID[{}]未查询到数据信息", id);
			return false;
		}
		if (model.getStatus() == UNUSE) {
			return true;
		}
		model.setStatus(UNUSE);
		boolean ret = super.updateById(model);
		return ret;
	}

	@Override
	public PageUtils<PayRefundOrderView> getByPage(PayRefundOrderDto dto) throws BusinessException {
		startPage(dto);
		List<PayRefundOrderView> ret = this.mapper.getByPage(dto);
		PageUtils<PayRefundOrderView> pages = new PageUtils<PayRefundOrderView>(ret);
		return pages;
	}

	@Override
	public List<PayRefundOrderView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayRefundOrderView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<PayRefundOrderView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayRefundOrderView> listAll() throws BusinessException {
		List<PayRefundOrderView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<PayRefundOrderView>();
		}
		return rets;
	}

	@Override
	public boolean modify(PayRefundOrderModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("PayRefundOrder 修改失败;传入对象为空");
			return false;
		}
		PayRefundOrderModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("PayRefundOrder 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayRefundOrderModel uModel = new PayRefundOrderModel();
		try {
			BeanUtils.copyProperties(uModel, dto);
			boolean ret = super.updateById(uModel);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void refundsJobs() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 1).eq("is_del", 0).le("expire_time", new Date());
		Page<PayRefundOrderModel> pages = super.selectPage(new Page<>(0, 20), ew);
		if (pages == null) {
			return;
		}
		List<PayRefundOrderModel> lists = pages.getRecords();
		if (lists == null) {
			return;
		}
		for (PayRefundOrderModel ret : lists) {
			log.info("退款订单:ID[{}]退款开始", ret.getId());
			this.execRefunds(ret);
		}
	}

	private boolean execRefunds(PayRefundOrderModel model) throws BusinessException {
		if (model == null) {
			log.error("退款失败;传入对象为空");
			return false;
		}
		PayOrderModel payOrderModel = this.iPayOrderService.findByPayOrderId(model.getPayOrderId());
		if (payOrderModel == null) {
			log.error("退款订单:ID[{}]退款失败,未查询到该支付订单记录;");
			return false;
		}
		long channelId = model.getChannelId();
		long channelItemsId = model.getChannelItemsId();
		long mchId = model.getMchId();
		if (channelId <= 0 || channelItemsId <= 0 || mchId <= 0) {
			log.error("退款失败;ID[{}]商户号、渠道号、支付渠道参数存在空;mchId[{}] channelId[{}] channelItemsId[{}]", model.getId(), mchId,
					channelId, channelItemsId);
			return false;
		}
		PayChannelModel payChannelModel = this.iPayChannelService.findByChannelId2ItemId2MchId(channelId,
				channelItemsId, mchId);
		if (payChannelModel == null) {
			log.error("退款失败;ID[{}] 未查询到商户[{}]可用渠道配置信息", model.getId(), mchId);
			return false;
		}
		PayChannelItemsEnum e = PayChannelItemsEnum.match(model.getChannelItemsId());
		if (e == null) {
			log.error("退款失败;程序未获取到渠道ID枚举;PayChannelItemsEnum - > ID[{}]", model.getChannelItemsId());
			return false;
		}
		boolean refundsRet = false;
		switch (e) {
		case ALIPAY_MOBILE:
			refundsRet = this.refundsAliPay(model, payChannelModel);
			break;
		case ALIPAY_WAP:
			refundsRet = this.refundsAliPay(model, payChannelModel);
			break;
		case ALIPAY_WEB:
			refundsRet = this.refundsAliPay(model, payChannelModel);
			break;
		case WX_APP:
			refundsRet = this.refundsWechatPay(model, payChannelModel);
			break;
		case WX_JSAPI:
			refundsRet = this.refundsWechatPay(model, payChannelModel);
			break;
		case WX_NATIVE:
			refundsRet = this.refundsWechatPay(model, payChannelModel);
			break;
		}
		// 退款成功
		if (refundsRet) {

		} else { // 退款失败

		}
		return true;
	}

	private boolean refundsAliPay(PayRefundOrderModel model, PayChannelModel payChannelModel) throws BusinessException {
		JSONObject paramsJson = this.iPayChannelService.checkAliPayProfile(payChannelModel);
		if (paramsJson == null) {
			return false;
		}
		// 配置文件信息
		String appId = paramsJson.getString("appId");
		String publicKey = paramsJson.getString("publicKey");
		String privateKey = paramsJson.getString("privateKey");
		String gateway = paramsJson.getString("gateway");
		String notifyUrl = paramsJson.getString("notifyUrl");
		String returnUrl = paramsJson.getString("returnUrl");
		String productCode = paramsJson.getString("productCode");
		AliPayHelper helper = AliPayHelper.getAliPayHelper(appId, publicKey, privateKey, gateway);
		long refundAmout = model.getRefundAmount();
		if (refundAmout < 1) {
			log.error("支付宝退款失败;退款金额小于1分");
			return false;
		}
		AlipayTradeRefundResponse ret = helper.tradeRefund(model.getPayOrderId() + "", null,
				new BigDecimal(model.getRefundAmount()));
		if (ret.isSuccess()) {
			return true;
		}
		return false;
	}

	private boolean refundsWechatPay(PayRefundOrderModel model, PayChannelModel payChannelModel)
			throws BusinessException {
		log.info("微信退款;PayRefundOrderModel - > {}", JSONObject.toJSON(model));
		JSONObject paramsJson = this.iPayChannelService.checkWechatPayProfile(payChannelModel);
		if (paramsJson == null) {
			return false;
		}
		String appId = paramsJson.getString("appId");
		String mchId = paramsJson.getString("mchId");
		String mchKey = paramsJson.getString("mchKey");
		String subAppId = paramsJson.getString("subAppId");
		String subMchId = paramsJson.getString("subMchId");
		String keyPath = paramsJson.getString("keyPath");
		String notifyUrl = paramsJson.getString("notifyUrl");
		String native_spbillCreateIp = paramsJson.getString("native_spbillCreateIp");
		boolean sandBox = false;
		WechatPayApi api = WechatPayApi.getWechatPayApi(appId, mchId, mchKey, subAppId, subMchId, keyPath, sandBox);
		WxPayRefundResult ret = api.refund(null, model.getPayOrderId() + "", Convert.toInt(model.getPayAmount()),
				Convert.toInt(model.getRefundAmount() + ""));
		if ("SUCCESS".equals(ret.getReturnCode())) {
			if ("SUCCESS".equals(ret.getResultCode())) {
				WxPayRefundQueryResult queryRet = api.refundQuery(null, model.getPayOrderId() + "", null, null);
				if ("SUCCESS".equals(queryRet)) {
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	@Override
	public void refundsQueryJobs() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 2).eq("is_del", 0).le("expire_time", new Date());
		Page<PayRefundOrderModel> pages = super.selectPage(new Page<>(0, 20), ew);
		if (pages == null) {
			return;
		}
		List<PayRefundOrderModel> lists = pages.getRecords();
		if (lists == null) {
			return;
		}
		for (PayRefundOrderModel ret : lists) {
			log.info("退款查询订单:ID[{}]退款查询开始", ret.getId());
			this.execRefundsQuery(ret);
		}
	}

	private boolean execRefundsQuery(PayRefundOrderModel model) throws BusinessException {
		if (model == null) {
			log.error("退款查询失败;传入对象为空");
			return false;
		}
		PayOrderModel payOrderModel = this.iPayOrderService.findByPayOrderId(model.getPayOrderId());
		if (payOrderModel == null) {
			log.error("退款查询订单:ID[{}]退款查询失败,未查询到该支付订单记录;");
			return false;
		}
		long channelId = model.getChannelId();
		long channelItemsId = model.getChannelItemsId();
		long mchId = model.getMchId();
		if (channelId <= 0 || channelItemsId <= 0 || mchId <= 0) {
			log.error("退款查询失败;ID[{}]商户号、渠道号、支付渠道参数存在空;mchId[{}] channelId[{}] channelItemsId[{}]", model.getId(), mchId,
					channelId, channelItemsId);
			return false;
		}
		PayChannelModel payChannelModel = this.iPayChannelService.findByChannelId2ItemId2MchId(channelId,
				channelItemsId, mchId);
		if (payChannelModel == null) {
			log.error("退款查询失败;ID[{}] 未查询到商户[{}]可用渠道配置信息", model.getId(), mchId);
			return false;
		}
		PayChannelItemsEnum e = PayChannelItemsEnum.match(model.getChannelItemsId());
		if (e == null) {
			log.error("退款查询失败;程序未获取到渠道ID枚举;PayChannelItemsEnum - > ID[{}]", model.getChannelItemsId());
			return false;
		}
		RefundsQueryState refundsQueryState = RefundsQueryState.ING;
		switch (e) {
		case ALIPAY_MOBILE:
			refundsQueryState = this.refundsQueryAliPay(model, payChannelModel);
			break;
		case ALIPAY_WAP:
			refundsQueryState = this.refundsQueryAliPay(model, payChannelModel);
			break;
		case ALIPAY_WEB:
			refundsQueryState = this.refundsQueryAliPay(model, payChannelModel);
			break;
		case WX_APP:
			refundsQueryState = this.refundsQueryWechatPay(model, payChannelModel);
			break;
		case WX_JSAPI:
			refundsQueryState = this.refundsQueryWechatPay(model, payChannelModel);
			break;
		case WX_NATIVE:
			refundsQueryState = this.refundsQueryWechatPay(model, payChannelModel);
			break;
		}
		model.setLastupdate(new Date());
		// 退款查询成功
		switch (refundsQueryState) {
		case ING:

			break;
		case SUCCESS:
			model.setStatus(3);
			break;
		case FAIL:
			model.setStatus(-1);
			break;
		}
		super.updateById(model);
		return true;
	}

	private RefundsQueryState refundsQueryAliPay(PayRefundOrderModel model, PayChannelModel payChannelModel)
			throws BusinessException {
		JSONObject paramsJson = this.iPayChannelService.checkAliPayProfile(payChannelModel);
		if (paramsJson == null) {
			return RefundsQueryState.ING;
		}
		// 配置文件信息
		String appId = paramsJson.getString("appId");
		String publicKey = paramsJson.getString("publicKey");
		String privateKey = paramsJson.getString("privateKey");
		String gateway = paramsJson.getString("gateway");
		String notifyUrl = paramsJson.getString("notifyUrl");
		String returnUrl = paramsJson.getString("returnUrl");
		String productCode = paramsJson.getString("productCode");
		AliPayHelper helper = AliPayHelper.getAliPayHelper(appId, publicKey, privateKey, gateway);
		long refundAmout = model.getRefundAmount();
		if (refundAmout < 1) {
			log.error("支付宝退款失败;退款金额小于1分");
			return RefundsQueryState.FAIL;
		}
		AlipayTradeRefundResponse ret = helper.tradeRefund(model.getPayOrderId() + "", null,
				new BigDecimal(model.getRefundAmount()));
		if (ret.isSuccess()) {
			return RefundsQueryState.SUCCESS;
		}
		return RefundsQueryState.FAIL;
	}

	private RefundsQueryState refundsQueryWechatPay(PayRefundOrderModel model, PayChannelModel payChannelModel)
			throws BusinessException {
		log.info("微信退款查询;PayRefundOrderModel - > {}", JSONObject.toJSON(model));
		JSONObject paramsJson = this.iPayChannelService.checkWechatPayProfile(payChannelModel);
		if (paramsJson == null) {
			return RefundsQueryState.ING;
		}
		String appId = paramsJson.getString("appId");
		String mchId = paramsJson.getString("mchId");
		String mchKey = paramsJson.getString("mchKey");
		String subAppId = paramsJson.getString("subAppId");
		String subMchId = paramsJson.getString("subMchId");
		String keyPath = paramsJson.getString("keyPath");
		String notifyUrl = paramsJson.getString("notifyUrl");
		String native_spbillCreateIp = paramsJson.getString("native_spbillCreateIp");
		boolean sandBox = false;
		WechatPayApi api = WechatPayApi.getWechatPayApi(appId, mchId, mchKey, subAppId, subMchId, keyPath, sandBox);
		WxPayRefundResult ret = api.refund(null, model.getPayOrderId() + "", Convert.toInt(model.getPayAmount()),
				Convert.toInt(model.getRefundAmount() + ""));
		WxPayRefundQueryResult queryRet = api.refundQuery(null, model.getPayOrderId() + "", null, null);
		if ("SUCCESS".equals(queryRet.getReturnCode())) {
			// 需要处理。多比情况遍历
			queryRet.getRefundRecords().get(0).getRefundStatus();
		}
		return RefundsQueryState.FAIL;
	}

}
