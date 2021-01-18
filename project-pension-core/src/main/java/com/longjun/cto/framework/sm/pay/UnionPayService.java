package com.longjun.cto.framework.sm.pay;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.plugins.kuaidi100.MD5;
import com.eims.cto.framework.plugins.logs.LogKit;
import com.eims.cto.framework.plugins.logs.LogKitFactory;
import com.longjun.cto.framework.sm.pay.conf.UnionPayConfig;
import com.longjun.cto.framework.sm.pay.union.bean.RefundQueryResponse;
import com.longjun.cto.framework.sm.pay.union.bean.UnionPayNotifyBean;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionPayModel;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionPayNotifyModel;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionQueryModel;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionRefundModel;
import com.longjun.cto.framework.sm.pay.union.es.UnionPayStatus;
import com.longjun.cto.framework.sm.pay.union.service.IUnionPayNotifyService;
import com.longjun.cto.framework.sm.pay.union.service.IUnionPayService;
import com.longjun.cto.framework.sm.pay.union.service.IUnionQueryService;
import com.longjun.cto.framework.sm.pay.union.service.IUnionRefundService;
import com.longjun.cto.framework.sm.pay.union.utils.SM3Util;
import com.longjun.cto.framework.sm.sys.entity.view.CommonProfileView;
import com.longjun.cto.framework.sm.sys.service.ICommonProfileService;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;

/**
 * 银联支付
 * 
 * @author yangxuan
 * @date Nov 2, 2019 - 9:26:38 AM
 */
@Transactional
@Service
public class UnionPayService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICommonProfileService iCommonProfileService;

	@Autowired
	private IUnionPayService iUnionPayService;

	@Autowired
	private IUnionRefundService iUnionRefundService;

	@Autowired
	private IUnionPayNotifyService iUnionPayNotifyService;

	@Autowired
	private IUnionQueryService iUnionQueryService;

	/**
	 * 读取银联配置
	 * 
	 * @return
	 */
	public UnionPayConfig getUnionPayConfig() throws BusinessException {
		CommonProfileView commonProfileView = this.iCommonProfileService.getByProfileKey("PROFILE_PAY_UNIONPAY_CONF");
		if (commonProfileView == null) {
			throw new BusinessException("获取银联支付配置失败;未查询到t_common_profile中PROFILE_PAY_UNIONPAY_CONF配置数据");
		}
		if (StrUtil.isBlank(commonProfileView.getProfileVal())) {
			throw new BusinessException("获取银联支付配置失败;查询到t_common_profile中PROFILE_PAY_UNIONPAY_CONF配置数据内容为空");
		}
		try {
			UnionPayConfig config = JSONObject.toJavaObject(JSONObject.parseObject(commonProfileView.getProfileVal()),
					UnionPayConfig.class);
			return config;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("获取银联支付配置失败;查询到t_common_profile中PROFILE_PAY_UNIONPAY_CONF配置数据内容非json格式");
		}
	}

	/**
	 * 公众号支付,接口将返回一串银联地址,需要重定向到网页,即可调用微信公众号支付
	 * 
	 * @param orderNo 订单编号
	 * @param cod     交易金额
	 * @return
	 * @throws BusinessException
	 */
	public String gzhPay(String orderNo, BigDecimal cod, String merBackUrl) throws BusinessException {
		UnionPayConfig config = getUnionPayConfig();
		TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
		treeMap.put("mer_id", config.getStatic_mer_id());//
		treeMap.put("order_no", orderNo);
		treeMap.put("cod", String.format("%.2f", cod.doubleValue()));
		treeMap.put("qrtype", "gzh");
		treeMap.put("notifyUrl", config.getNotifyUrl());
		treeMap.put("MerBackUrl", merBackUrl);
		StringBuffer sb = new StringBuffer();
		for (String key : treeMap.keySet()) {
			sb.append(treeMap.get(key));
		}
		String macStr = "";
		try {
			macStr = SM3Util.sm3(sb.toString() + config.getCheckStr());
			treeMap.put("mac", macStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer param = new StringBuffer();
		param.append(config.getPay_url());
		for (String key : treeMap.keySet()) {
			param.append(key + "=" + treeMap.get(key) + "&");
		}
		logger.info("银联公众号支付,订单号[{}]订单金额[{}] 请求地址 : {}", orderNo, String.format("%.2f", cod.doubleValue()),
				param.toString());

		UnionPayModel model = new UnionPayModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setStatus(0);
		model.setMerId(config.getStatic_mer_id());
		model.setOrderNo(orderNo);
		model.setCod(cod);
		model.setQrtype("gzh");
		model.setMac(macStr);
		this.iUnionPayService.insert(model);
		return param.toString();
	}

	/**
	 * 交易查询请求接口
	 * 
	 * @param waybillno
	 * @param qrtype
	 * @param transDate
	 * @throws BusinessException
	 */
	public JSONObject queryOrder(String waybillno, String qrtype, String transDate) throws BusinessException {
		UnionPayConfig config = getUnionPayConfig();
		TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
		treeMap.put("mer_id", config.getStatic_mer_id());//
		treeMap.put("waybillno", waybillno);
		treeMap.put("qrtype", qrtype);
		treeMap.put("transDate", transDate);
		StringBuffer sb = new StringBuffer();
		for (String key : treeMap.keySet()) {
			sb.append(treeMap.get(key));
		}
		String macStr = "";
		try {
			macStr = SM3Util.sm3(sb.toString() + config.getCheckStr());
			treeMap.put("mac", macStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer param = new StringBuffer();
		param.append(config.getQuery_url());
		for (String key : treeMap.keySet()) {
			param.append(key + "=" + treeMap.get(key) + "&");
		}
		logger.info("银联支付查询地址 : {}", param.toString());
		try {
			String resp = HttpUtil.get(param.toString());
			logger.info("银联支付查询地址 : {} resp {}", param.toString(), resp);
			JSONObject response = JSONObject.parseObject(resp);
			LogKit logKit = LogKitFactory.getLogKit(this.getClass(), "pay/union", "unionpayquery.txt", true);
			logKit.appendLog(param.toString(), response);
			UnionQueryModel model = new UnionQueryModel();
			model.setTime(new Date());
			model.setLastupdate(new Date());
			model.setIsDel(0);
			model.setStatus(1);
			model.setQueryType(1);
			model.setMerId(config.getStatic_mer_id());
			model.setPayWaybillno(waybillno);
			model.setQrtype(qrtype);
			model.setPayTransDate(transDate);
			model.setPayRespAmount(response.getString("amount"));
			model.setPayRespCode(response.getString("code"));
			model.setPayRespSeqno(response.getString("seqno"));
			model.setPayRespPayTime(response.getString("payTime"));
			model.setPayRespMemo(response.getString("memp"));
			model.setPayRespPayway(response.getString("payway"));
			model.setPayRespMac(response.getString("mac"));
			model.setPayRespTermid(response.getString("termid"));
			model.setPayRespShopid(response.getString("shopid"));
			model.setPayRespCleardate(response.getString("cleardate"));
			model.setPayRespStatus(response.getString("status"));
			iUnionQueryService.insert(model);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 订单交易是否成功
	 * 
	 * @param waybillno
	 * @param qrtype
	 * @param transDate
	 * @return
	 * @throws BusinessException
	 */
	public UnionPayStatus orderTradeSuccess(String waybillno, String qrtype, String transDate)
			throws BusinessException {
		JSONObject ret = this.queryOrder(waybillno, qrtype, transDate);
		return UnionPayStatus.valueOf(ret.getString("status"));
	}

	/**
	 * 退款交易
	 * 
	 * @param orderNo        单号
	 * @param qrtype         使用场景 必填，下单的时候传递什么，查询的时 候也传递什么
	 * @param queryId        查询流水号 选填，app 支付，扫码支付，下单的时候 都会返回 queryId，支付通知和支付完成
	 *                       详情页面都会有查询流水号。与 cleardate ，2 选 1
	 * @param refundAmt      退款金额(单位 是元) 选填，不填时 refund_amt 就是支付的总 金额，如果涉及分账
	 *                       refund_amt 金额必 填，并且 refund_amt= platformAmount+
	 *                       subOrders 里面的子商户金额 totalAmount，请注意单位换算;
	 *                       如果购物车分账希望一次退全部金额， 此处传递的参数值要等于下单传入的金 额
	 * @param refundNo       退款单号 选填，同一笔交易分多次，比如分账交 易退款时必传，只退一次可以不填;
	 *                       如果购物车分账希望一次退全部金额， 此参数不传
	 * @param subOrders      分账退款子商户 信息(单位是分) 选填，分账交易退款必传，一次只能传 递一个子商户进行退款,如果只退平台方
	 *                       的金额，subOrders 里的金额传递 0，如 果子商户和平台方一起退，需要传递平 台方金额
	 *                       platformAmount 和 subOrders 里的 totalAmount，多个子商户，一次只
	 *                       能退一个，分多次退款; 如果购物车分账希望一次退全部金额， 此参数不传
	 * @param platformAmount 平台方退款金额 (单位是分) 选填,分账交易必传,如果多次退款，平台 方已经退完，只需要退子商户，此时传 递
	 *                       0，
	 * @param refundDesc     退款描述 退款通知，会原样返回
	 * @throws BusinessException
	 */
	public void refund(String orderNo, String qrtype, String queryId, BigDecimal refundAmt, String refundNo,
			String subOrders, String platformAmount, String refundDesc) throws BusinessException {
		UnionPayConfig config = getUnionPayConfig();
		TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
		treeMap.put("mer_id", config.getStatic_mer_id());//
		treeMap.put("order_no", orderNo);
		treeMap.put("qrtype", qrtype);
		treeMap.put("queryId", queryId);
		treeMap.put("refundAmt", String.format("%.2f", refundAmt.doubleValue()));
		treeMap.put("refund_no", refundNo);
		if (StrUtil.isNotBlank(subOrders)) {
			treeMap.put("subOrders", subOrders);
		}
		if (platformAmount != null) {
			treeMap.put("platformAmount", platformAmount);
		}
		treeMap.put("refund_desc", refundDesc);
		StringBuffer sb = new StringBuffer();
		for (String key : treeMap.keySet()) {
			sb.append(treeMap.get(key));
		}
		String macStr = "";
		try {
			macStr = SM3Util.sm3(sb.toString() + config.getCheckStr());
			treeMap.put("mac", macStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer param = new StringBuffer();
		param.append(config.getRefund_url());
		for (String key : treeMap.keySet()) {
			param.append(key + "=" + treeMap.get(key) + "&");
		}
		logger.info("银联退款交易地址 : {}", param.toString());
		String resp = HttpUtil.get(param.toString());
		logger.info("银联退款交易地址 : {} resp {} ", param.toString(), resp);
		LogKit logKit = LogKitFactory.getLogKit(this.getClass(), "pay/union", "unionrefunds.txt", true);
		logKit.appendLog(param.toString(), resp);
		UnionRefundModel model = new UnionRefundModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setStatus(1);
		model.setMerId(config.getStatic_mer_id());
		model.setOrderNo(orderNo);
		model.setQrtype(qrtype);
		model.setQueryId(queryId);
		model.setCleardate(null);
		model.setBankTrace(null);
		model.setRefundAmt(refundAmt);
		model.setRefundNo(refundNo);
		model.setSubOrders(subOrders);
		model.setPlatformAmount(Convert.toLong(platformAmount, 0L));
		model.setRefundDesc(refundDesc);
		model.setMac(macStr);
		model.setReqUrl(param.toString());
		model.setResp(resp);
		this.iUnionRefundService.insert(model);
	}

	/**
	 * 退款交易查询
	 * 
	 * @param qrtype   使用场景
	 * @param queryId  查询流水号
	 * @param refundNo 退款单号
	 * @throws BusinessException
	 */
	public RefundQueryResponse refundQuery(String qrtype, String queryId, String refundNo) throws BusinessException {
		UnionPayConfig config = getUnionPayConfig();
		Map<String, Object> treeMap = new TreeMap<String, Object>();
		treeMap.put("mer_id", config.getStatic_mer_id());//
		treeMap.put("queryId", queryId);
		treeMap.put("qrtype", qrtype);
		treeMap.put("queryId", queryId);
		treeMap.put("refund_no", refundNo);
		StringBuffer sb = new StringBuffer();
		for (String key : treeMap.keySet()) {
			sb.append(treeMap.get(key));
		}
		String macStr = "";
		try {
			macStr = SM3Util.sm3(sb.toString() + config.getCheckStr());
			treeMap.put("mac", macStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer param = new StringBuffer();
		param.append(config.getRefundQuery());
		for (String key : treeMap.keySet()) {
			param.append(key + "=" + treeMap.get(key) + "&");
		}
		logger.info("银联退款查询地址 : {} 请求参数 : {}", config.getRefundQuery(), JSONObject.toJSONString(treeMap));
		String resp = HttpUtil.post(config.getRefundQuery(), treeMap);
		logger.info("银联退款交易查询返回 {} ", resp);
		RefundQueryResponse dto = JSONObject.toJavaObject(JSONObject.parseObject(resp), RefundQueryResponse.class);
		LogKit logKit = LogKitFactory.getLogKit(this.getClass(), "pay/union", "unionrefundsquery.txt", true);
		logKit.appendLog(config.getRefundQuery(), dto);
		UnionQueryModel model = new UnionQueryModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setMerId(config.getStatic_mer_id());
		model.setStatus(1);
		model.setQueryType(2);
		model.setQrtype(qrtype);
		model.setRefundQueryId(queryId);
		model.setRefundNo(refundNo);
		model.setRefundRespCode(dto.getCode());
		model.setRefundRespRefundtime(dto.getRefundtime());
		model.setRefundRespMsg(dto.getMsg());
		model.setRefundRespRefundstatus(dto.getRefundstatus());
		model.setRefundRespRefundamount(dto.getRefundamount());
		model.setRefundRespMac(dto.getMac());
		iUnionQueryService.insert(model);
		return dto;
	}

	/**
	 * 校验mac签名
	 * 
	 * @param context
	 * @param mac
	 * @return
	 * @throws BusinessException
	 */
	public boolean checkMac(String context, String mac) throws BusinessException {
		UnionPayConfig config = getUnionPayConfig();
		context = context + config.getNotifyHashOid();
		String encode = MD5.encode(context);
		boolean check = encode.equalsIgnoreCase(mac);
		return check;
	}

	/**
	 * 处理异步通知
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public boolean handlerNotify(UnionPayNotifyBean unionPayNotifyBean) throws BusinessException {
		LogKit logKit = LogKitFactory.getLogKit(this.getClass(), "pay/union", "unionnotify.txt", true);
		logKit.appendLog(unionPayNotifyBean);
		boolean ret = false;
		synchronized (unionPayNotifyBean.getBody().getOrderno() + "-" + unionPayNotifyBean.getHeader().getTranstype()) {
			// 处理支付异步通知
			if ("P033".equals(unionPayNotifyBean.getHeader().getTranstype())) {
				ret = this.P033(unionPayNotifyBean);
			} else if ("P036".equals(unionPayNotifyBean.getHeader().getTranstype())) { // 处理退款异步通知地址
				this.P036(unionPayNotifyBean);
			}
		}
		return ret;
	}

	// 返回值开发自己做扩展
	public void handerReturn(String orderId, String tracetime) throws BusinessException {
		UnionPayModel unionPayModel = this.iUnionPayService.findByOrderNo(orderId);
		try {
			tracetime = DateUtil.format(DateUtil.parse(tracetime), "yyyyMMdd");
		} catch (Exception e) {
			e.printStackTrace();
			tracetime = DateUtil.format(unionPayModel.getTime(), "yyyyMMdd");
		}
		UnionPayStatus unionPayStatus = this.orderTradeSuccess(orderId, unionPayModel.getQrtype(), tracetime);
		if (unionPayStatus != UnionPayStatus.TRADE_SUCCESS) {

			return;
		}
		// TODO 处理业务逻辑
		logger.info("银联支付, 同步回调处理业务逻辑...");
	}

	/**
	 * 支付异步通知, 返回值为是否通知银联值
	 * 
	 * @param unionPayNotifyBean
	 */
	private boolean P033(UnionPayNotifyBean unionPayNotifyBean) throws BusinessException {
		// 如果存在数据,则表示有执行业务逻辑,则在此直接返回,做防重单功能
		UnionPayModel unionPayModel = this.iUnionPayService.findByOrderNo(unionPayNotifyBean.getBody().getOrderno());
		UnionPayStatus unionPayStatus = this.orderTradeSuccess(unionPayNotifyBean.getBody().getOrderno(),
				unionPayModel.getQrtype(), unionPayNotifyBean.getHeader().getRequestTime().substring(0, 8));
		if (unionPayStatus != UnionPayStatus.TRADE_SUCCESS) {
			logger.info("银联支付,订单号{} 订单支付类型 {} 订单创建时间 {} 支付结果 {} 非成功状态, 不进行业务逻辑处理",
					unionPayNotifyBean.getBody().getOrderno(), unionPayModel.getQrtype(),
					unionPayNotifyBean.getHeader().getRequestTime().substring(0, 8), unionPayStatus);
			return false;
		}
		UnionPayNotifyModel exist = this.iUnionPayNotifyService.findByOrderNo(unionPayNotifyBean.getBody().getOrderno(),
				unionPayNotifyBean.getHeader().getTranstype());
		if (exist != null) {
			logger.info("银联支付异步通知执行,订单号[{}]以通知,已执行业务逻辑,直接返回");
			return true;
		}
		UnionPayNotifyModel model = new UnionPayNotifyModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setStatus(1);
		model.setHeaderVersion(unionPayNotifyBean.getHeader().getVersion());
		model.setHeaderTranstype(unionPayNotifyBean.getHeader().getTranstype());
		model.setHeaderEmployno(unionPayNotifyBean.getHeader().getEmployno());
		model.setHeaderTermid(unionPayNotifyBean.getHeader().getTermid());
		model.setHeaderRequestTime(unionPayNotifyBean.getHeader().getRequestTime());
		model.setHeaderShopid(unionPayNotifyBean.getHeader().getShopid());
		model.setHeaderWlid(unionPayNotifyBean.getHeader().getWlid());
		model.setBodyOrderno(unionPayNotifyBean.getBody().getOrderno());
		model.setBodyCod(new BigDecimal(unionPayNotifyBean.getBody().getCod()));
		model.setBodyPayway(unionPayNotifyBean.getBody().getPayway());
		model.setBodyBanktrace(unionPayNotifyBean.getBody().getBanktrace());
		model.setBodyPostrace(unionPayNotifyBean.getBody().getPostrace());
		model.setBodyTracetime(unionPayNotifyBean.getBody().getTracetime());
		model.setBodyCardid(unionPayNotifyBean.getBody().getCardid());
		model.setBodySignflag(unionPayNotifyBean.getBody().getSignflag());
		model.setBodyDssn(unionPayNotifyBean.getBody().getDssn());
		model.setBodyDsname(unionPayNotifyBean.getBody().getDsname());
		model.setBodyMemo(unionPayNotifyBean.getBody().getMemo());
		model.setBodyQueryId(unionPayNotifyBean.getBody().getQueryid());
		this.iUnionPayNotifyService.insert(model);
		// TODO 业务补充

		return true;
	}

	/**
	 * 交易退款异步通知
	 * 
	 * @param unionPayNotifyBean
	 * @throws BusinessException
	 */
	private boolean P036(UnionPayNotifyBean unionPayNotifyBean) throws BusinessException {
		// 如果存在数据,则表示有执行业务逻辑,则在此直接返回,做防重单功能
		UnionRefundModel unionRefundModel = this.iUnionRefundService
				.findByOrderNo(unionPayNotifyBean.getBody().getOrderno());
		RefundQueryResponse refundQueryResponse = this.refundQuery(unionRefundModel.getQrtype(),
				unionRefundModel.getQueryId(), unionRefundModel.getRefundNo());
		if (!"00".equals(refundQueryResponse.getCode())) {

			return false;
		}
		if (!"SUCCESS".equals(refundQueryResponse.getRefundstatus())) {

			return false;
		}
		UnionPayNotifyModel exist = this.iUnionPayNotifyService.findByOrderNo(unionPayNotifyBean.getBody().getOrderno(),
				unionPayNotifyBean.getHeader().getTranstype());
		if (exist != null) {
			logger.info("银联支付异步通知执行,订单号[{}]以通知,已执行业务逻辑,直接返回");
			return true;
		}
		UnionPayNotifyModel model = new UnionPayNotifyModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setStatus(1);
		model.setHeaderVersion(unionPayNotifyBean.getHeader().getVersion());
		model.setHeaderTranstype(unionPayNotifyBean.getHeader().getTranstype());
		model.setHeaderEmployno(unionPayNotifyBean.getHeader().getEmployno());
		model.setHeaderTermid(unionPayNotifyBean.getHeader().getTermid());
		model.setHeaderRequestTime(unionPayNotifyBean.getHeader().getRequestTime());
		model.setHeaderShopid(unionPayNotifyBean.getHeader().getShopid());
		model.setHeaderWlid(unionPayNotifyBean.getHeader().getWlid());
		model.setBodyOrderno(unionPayNotifyBean.getBody().getOrderno());
		model.setBodyCod(new BigDecimal(unionPayNotifyBean.getBody().getCod()));
		model.setBodyPayway(unionPayNotifyBean.getBody().getPayway());
		model.setBodyBanktrace(unionPayNotifyBean.getBody().getBanktrace());
		model.setBodyPostrace(unionPayNotifyBean.getBody().getPostrace());
		model.setBodyTracetime(unionPayNotifyBean.getBody().getTracetime());
		model.setBodyCardid(unionPayNotifyBean.getBody().getCardid());
		model.setBodySignflag(unionPayNotifyBean.getBody().getSignflag());
		model.setBodyDssn(unionPayNotifyBean.getBody().getDssn());
		model.setBodyDsname(unionPayNotifyBean.getBody().getDsname());
		model.setBodyMemo(unionPayNotifyBean.getBody().getMemo());
		model.setBodyQueryId(unionPayNotifyBean.getBody().getQueryid());
		this.iUnionPayNotifyService.insert(model);
		// TODO 业务补充

		return true;
	}

}
