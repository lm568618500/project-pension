package com.longjun.cto.framework.sm.pay.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelDictModel;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelItemDictModel;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelModel;
import com.longjun.cto.framework.sm.pay.entity.model.PayMchInfoModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayChannelView;
import com.longjun.cto.framework.sm.pay.mapper.PayChannelMapper;
import com.longjun.cto.framework.sm.pay.service.IPayChannelDictService;
import com.longjun.cto.framework.sm.pay.service.IPayChannelItemDictService;
import com.longjun.cto.framework.sm.pay.service.IPayChannelService;
import com.longjun.cto.framework.sm.pay.service.IPayMchInfoService;

import cn.hutool.core.util.StrUtil;

/**
 * PayChannelServiceImpl
 * 
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
@Service
public class PayChannelServiceImpl extends BaseServiceImpl<PayChannelMapper, PayChannelModel>
		implements IPayChannelService {

	@Autowired
	PayChannelMapper mapper;

	@Autowired
	IPayChannelDictService iPayChannelDictService;

	@Autowired
	IPayChannelItemDictService iPayChannelItemDictService;

	@Autowired
	IPayMchInfoService iPayMchInfoService;

	@Override
	public PayChannelView findViewById(long id) throws BusinessException {
		PayChannelView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayChannelModel findModelById(long id) throws BusinessException {
		PayChannelModel model = this.selectById(id);
		if (model == null) {
			log.warn("PayChannel 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayChannelModel model) throws BusinessException {
		if (model == null) {
			throw new BusinessException("添加商户渠道失败;传入参数为空");
		}

		if (model.getChannelId() < 1) {
			throw new BusinessException("添加商户渠道失败;渠道ID非法");
		}
		if (model.getChannelItemsId() < 1) {
			throw new BusinessException("添加商户渠道失败;支付方式非法");
		}
		if (model.getMchId() < 1) {
			throw new BusinessException("添加商户渠道失败;商户ID非法");
		}
		PayMchInfoModel mchInfoRet = this.iPayMchInfoService.getByMchId(model.getMchId());
		if (mchInfoRet == null) {
			log.error("添加商户渠道失败;商户MchId[{}]不存在", model.getMchId());
			throw new BusinessException("添加商户渠道失败;商户不存在");
		}
		PayChannelDictModel payChannelDict = this.iPayChannelDictService.selectById(model.getChannelId());
		if (payChannelDict == null) {
			log.error("添加商户渠道失败;渠道ChannelId[{}]不存在", model.getChannelId());
			throw new BusinessException("添加商户渠道失败;渠道不存在");
		}
		PayChannelItemDictModel payChannelItemDictModel = this.iPayChannelItemDictService
				.selectById(model.getChannelItemsId());
		if (payChannelItemDictModel == null) {
			log.error("添加商户渠道失败;支付方式ChannelItemsId[{}]不存在", model.getChannelItemsId());
			throw new BusinessException("添加商户渠道失败;支付方式不存在");
		}
		log.info("PayChannel 数据新增 -> [{}]", JSONObject.toJSONString(model));
		// 初始化基础数据
		model.setLastupdate(new Date());
		model.setTime(new Date());
		model.setStatus(1);
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		PayChannelModel model = super.selectById(id);
		if (model == null) {
			log.error("PayChannel 开启操作,ID[{}]未查询到数据信息", id);
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
	public boolean stop(long id) throws BusinessException {
		PayChannelModel model = super.selectById(id);
		if (model == null) {
			log.error("PayChannel 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<PayChannelView> getByPage(PayChannelDto dto) throws BusinessException {
		startPage(dto);
		List<PayChannelView> ret = this.mapper.getByPage(dto);
		PageUtils<PayChannelView> pages = new PageUtils<PayChannelView>(ret);
		return pages;
	}

	@Override
	public List<PayChannelModel> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayChannelModel> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<PayChannelModel>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayChannelModel> listAll() throws BusinessException {
		List<PayChannelModel> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<PayChannelModel>();
		}
		return rets;
	}

	@Override
	public boolean modify(PayChannelModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("PayChannel 修改失败;传入对象为空");
			return false;
		}
		PayChannelModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("PayChannel 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
//		PayChannelModel uModel = new PayChannelModel();
		try {
//			BeanUtils.copyProperties(uModel, dto);
			model.setParam(dto.getParam());
			model.setRemark(dto.getRemark());
			boolean ret = super.updateById(model);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<PayChannelModel> findByChannelId(long mchId, long channelId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("channel_id", channelId).eq("mch_id", mchId).eq("is_del", 0);
		List<PayChannelModel> rets = super.selectList(ew);
		return rets;
	}

	@Override
	public PayChannelModel findByChannelId2ItemId2MchId(long channelId, long channelItemsId, long mchId)
			throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("channel_id", channelId).eq("channel_items_id", channelItemsId).eq("mch_id", mchId);
		PayChannelModel ret = super.selectOne(ew);
		return ret;
	}

	@Override
	public JSONObject checkAliPayProfile(PayChannelModel model) throws BusinessException {
		if (model == null) {
			log.error("支付宝支付配置文件校验失败;渠道配置为空");
			return null;
		}
		if (StrUtil.isBlank(model.getParam())) {
			log.error("支付宝支付配置文件校验失败;渠道接口配置为空");
			return null;
		}
		// 配置文件信息
		JSONObject paramsJson = null;
		try {
			paramsJson = JSONObject.parseObject(model.getParam());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("支付宝配置文件校验失败;配置信息格式异常; -> {}", JSONObject.toJSONString(model));
			return null;
		}
		String appId = paramsJson.getString("appId");
		if (StrUtil.isBlank(appId)) {
			log.error("支付宝配置信息校验失败;appId为空");
			return null;
		}
		String publicKey = paramsJson.getString("publicKey");
		if (StrUtil.isBlank(publicKey)) {
			log.error("支付宝配置信息校验失败;publicKey为空");
			return null;
		}
		String privateKey = paramsJson.getString("privateKey");
		if (StrUtil.isBlank(privateKey)) {
			log.error("支付宝配置信息校验失败;privateKey为空");
			return null;
		}
		String gateway = paramsJson.getString("gateway");
		if (StrUtil.isBlank(gateway)) {
			log.error("支付宝配置信息校验失败;gateway为空");
			return null;
		}
		String notifyUrl = paramsJson.getString("notifyUrl");
		if (StrUtil.isBlank(notifyUrl)) {
			log.error("支付宝配置信息校验失败;notifyUrl为空");
			return null;
		}
		String returnUrl = paramsJson.getString("returnUrl");
		if (StrUtil.isBlank(returnUrl)) {
			log.error("支付宝配置信息校验失败;returnUrl为空");
			return null;
		}
		String productCode = paramsJson.getString("productCode");
		if (StrUtil.isBlank(productCode)) {
			log.error("支付宝配置信息校验失败;productCode为空");
			return null;
		}
		return paramsJson;
	}

	@Override
	public JSONObject checkWechatPayProfile(PayChannelModel model) throws BusinessException {
		if (model == null) {
			log.error("微信支付配置文件校验失败;渠道配置为空");
			return null;
		}
		if (StrUtil.isBlank(model.getParam())) {
			log.error("微信支付配置文件校验失败;渠道接口配置为空");
			return null;
		}
		// 配置文件信息
		JSONObject paramsJson = null;
		try {
			paramsJson = JSONObject.parseObject(model.getParam());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("微信配置文件校验失败;配置信息格式异常; -> {}", JSONObject.toJSONString(model));
			return null;
		}
		String appId = paramsJson.getString("appId");
		if (StrUtil.isBlank(appId)) {
			log.error("微信支付配置信息校验失败;appId为空");
			return null;
		}
		String mchId = paramsJson.getString("mchId");
		if (StrUtil.isBlank(mchId)) {
			log.error("微信支付配置信息校验失败;mchId为空");
			return null;
		}
		String mchKey = paramsJson.getString("mchKey");
		if (StrUtil.isBlank(mchKey)) {
			log.error("微信支付配置信息校验失败;mchKey为空");
			return null;
		}
//		String subAppId = paramsJson.getString("subAppId");
//		if (StrUtil.isBlank(subAppId)) {
//			log.error("微信支付配置信息校验失败;subAppId为空");
//			return null;
//		}
//		String subMchId = paramsJson.getString("subMchId");
//		if (StrUtil.isBlank(subMchId)) {
//			log.error("微信支付配置信息校验失败;subMchId为空");
//			return null;
//		}
		String keyPath = paramsJson.getString("keyPath");
		if (StrUtil.isBlank(keyPath)) {
			log.error("微信支付配置信息校验失败;keyPath为空");
			return null;
		}
		String notifyUrl = paramsJson.getString("notifyUrl");
		if (StrUtil.isBlank(notifyUrl)) {
			log.error("微信支付配置信息校验失败;notifyUrl为空");
			return null;
		}
		String native_spbillCreateIp = paramsJson.getString("native_spbillCreateIp");
		if (StrUtil.isBlank(native_spbillCreateIp)) {
			log.error("微信支付配置信息校验失败;native_spbillCreateIp为空");
			return null;
		}
		return paramsJson;
	}

}
