package com.longjun.cto.framework.sm.pay.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.eims.cto.framework.plugins.pay.wx.api.WechatPayApi;
import com.github.binarywang.wxpay.bean.result.WxPayOrderQueryResult;
import com.longjun.cto.framework.sm.pay.entity.dto.PayWxQueryDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayWxQueryModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayWxQueryView;
import com.longjun.cto.framework.sm.pay.mapper.PayWxQueryMapper;
import com.longjun.cto.framework.sm.pay.service.IPayWxQueryService;

/**
 * 微信支付-查询Service Impl
 * @author yangxuan
 * @date 2019-02-23 09:05:59
 */
 @Service
public class PayWxQueryServiceImpl extends BaseServiceImpl<PayWxQueryMapper,PayWxQueryModel> 
	implements IPayWxQueryService {

	@Autowired
	PayWxQueryMapper mapper;
	
	@Override
	public PageUtils<PayWxQueryView> getByPage(PayWxQueryDto dto) throws BusinessException {
		try{
			startPage(dto);
			List<PayWxQueryView> ret = this.mapper.getByPage(dto);
			return new PageUtils<PayWxQueryView>(ret);
		}catch(Exception e){
			throw handleBusinessException(e);
		}
	}

	@Override
	public WxPayOrderQueryResult queryOrder(String outTradeNo) throws BusinessException {
		return queryOrder(null, outTradeNo);
	}

	@Override
	public WxPayOrderQueryResult queryOrder(String appId, String outTradeNo) throws BusinessException {
		WxPayOrderQueryResult ret = WechatPayApi.getWechatPayApi(appId).queryOrder(null, outTradeNo);
		PayWxQueryModel model = new PayWxQueryModel();
		model.setTime(new Date());
		model.setOutTradeNo(outTradeNo);
		model.setTransactionId(ret.getTransactionId());
		model.setReturnCode(ret.getReturnCode());
		model.setResultCode(ret.getResultCode());
		model.setReturnMsg(ret.getReturnMsg());
		model.setErrCode(ret.getErrCode());
		model.setErrCodeDes(ret.getErrCodeDes());
		model.setAppid(ret.getAppid());
		model.setMchId(ret.getMchId());
		model.setSubAppId(ret.getSubAppId());
		model.setSubMchId(ret.getSubMchId());
		model.setNonceStr(ret.getNonceStr());
		model.setSign(ret.getSign());
		model.setXmlString(ret.getXmlString());
		model.setPromotionDetail(ret.getPromotionDetail());
		model.setDeviceInfo(ret.getDeviceInfo());
		model.setOpenid(ret.getOpenid());
		model.setIsSubscribe(ret.getIsSubscribe());
		model.setTradeType(ret.getTradeType());
		model.setTradeState(ret.getTradeState());
		model.setBankType(ret.getBankType());
		model.setTotalFee(ret.getTotalFee() == null ? 0 :ret.getTotalFee());
		model.setSettlementTotalFee(ret.getSettlementTotalFee() == null ? 0 : ret.getSettlementTotalFee());
		model.setFeeType(ret.getFeeType());
		model.setCashFee(ret.getCashFee());
		model.setCashFeeType(ret.getCashFeeType());
		model.setCouponFee(ret.getCouponFee() == null ? 0 : ret.getSettlementTotalFee());
		model.setCouponCount(ret.getCouponCount() == null ?0 : ret.getCouponCount());
		model.setCoupons(JSONObject.toJSONString(ret.getCoupons()));
		model.setAttach(ret.getAttach());
		model.setTimeEnd(ret.getTimeEnd());
		model.setTradeStateDesc(ret.getTradeStateDesc());
		model.setStatus(this.USE);
		this.insert(model);
		return ret;
	}
 

}
