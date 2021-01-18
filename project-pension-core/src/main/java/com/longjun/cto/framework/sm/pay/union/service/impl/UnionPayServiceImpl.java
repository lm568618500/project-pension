package com.longjun.cto.framework.sm.pay.union.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.eims.cto.framework.plugins.kuaidi100.MD5;
import com.longjun.cto.framework.sm.pay.conf.UnionPayConfig;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionPayDto;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionPayModel;
import com.longjun.cto.framework.sm.pay.union.entity.view.UnionPayView;
import com.longjun.cto.framework.sm.pay.union.mapper.UnionPayMapper;
import com.longjun.cto.framework.sm.pay.union.service.IUnionPayService;
import com.longjun.cto.framework.sm.pay.union.utils.SM3Util;
import com.longjun.cto.framework.sm.sys.entity.view.CommonProfileView;
import com.longjun.cto.framework.sm.sys.service.ICommonProfileService;

import cn.hutool.core.util.StrUtil;

/**
 * UnionPayServiceImpl
 * 
 * @author yangxuan
 * @date 2019-10-30 04:21:52
 */
@Service
public class UnionPayServiceImpl extends BaseServiceImpl<UnionPayMapper, UnionPayModel> implements IUnionPayService {

	@Autowired
	UnionPayMapper mapper;

	@Autowired
	private ICommonProfileService iCommonProfileService;

	@Override
	public UnionPayView findViewById(long id) throws BusinessException {
		UnionPayView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public UnionPayModel findModelById(long id) throws BusinessException {
		UnionPayModel model = this.selectById(id);
		if (model == null) {
			log.warn("UnionPay 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public PageUtils<UnionPayView> getByPage(UnionPayDto dto) throws BusinessException {
		startPage(dto);
		List<UnionPayView> ret = this.mapper.getByPage(dto);
		PageUtils<UnionPayView> pages = new PageUtils<UnionPayView>(ret);
		return pages;
	}

	@Override
	public List<UnionPayView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<UnionPayView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<UnionPayView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<UnionPayView> listAll() throws BusinessException {
		List<UnionPayView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<UnionPayView>();
		}
		return rets;
	}

	/**
	 * 读取支付宝配置
	 * 
	 * @return
	 */
	@Override
	public UnionPayConfig getAliPayConfig() throws BusinessException {
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

	@Override
	public String gzhPay(String orderNo, BigDecimal cod) throws BusinessException {
		UnionPayConfig config = getAliPayConfig();
		TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
		treeMap.put("mer_id", config.getStatic_mer_id());//
		treeMap.put("order_no", orderNo);
		treeMap.put("cod", String.format("%.2f", cod.doubleValue()));
		treeMap.put("qrtype", "gzh");
		treeMap.put("notifyUrl", config.getNotifyUrl());
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
		log.info("银联公众号支付,订单号[{}]订单金额[{}] 请求地址 : {}", orderNo, String.format("%.2f", cod.doubleValue()),
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
		super.insert(model);
		return param.toString();
	}

	@Override
	public boolean checkMac(String context, String mac) throws BusinessException {
		UnionPayConfig config = getAliPayConfig();
		context = context + config.getNotifyHashOid();
		String encode = MD5.encode(context);
		boolean check = encode.equalsIgnoreCase(mac);
		return check;
	}

	@Override
	public UnionPayModel findByOrderNo(String orderNo) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("order_no", orderNo);
		UnionPayModel ret = super.selectOne(ew);
		return ret;
	}

}
