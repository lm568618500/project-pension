package com.longjun.cto.framework.sm.pay.alipay.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayQueryDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayQueryModifyDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayQueryModel;
import com.longjun.cto.framework.sm.pay.alipay.entity.view.PayAlipayQueryView;
import com.longjun.cto.framework.sm.pay.alipay.mapper.PayAlipayQueryMapper;
import com.longjun.cto.framework.sm.pay.alipay.service.IPayAlipayQueryService;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatQueryModel;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * PayAlipayQueryServiceImpl
 * @author yangxuan
 * @date 2019-11-07 06:58:15
 */
 @Service
public class PayAlipayQueryServiceImpl  extends 
					BaseServiceImpl<PayAlipayQueryMapper , PayAlipayQueryModel> 
						implements IPayAlipayQueryService {

	@Autowired
	PayAlipayQueryMapper mapper;
	
	@Override
	public PayAlipayQueryView findViewById(long id) throws BusinessException {
		PayAlipayQueryView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayAlipayQueryModel findModelById(long id) throws BusinessException {
		PayAlipayQueryModel model = this.selectById(id);
		if(model == null) {
			log.warn("PayAlipayQuery 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayAlipayQueryModel model) throws BusinessException {
		log.info("PayAlipayQuery 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		PayAlipayQueryModel model = super.selectById(id);
		if(model == null) {
			log.error("PayAlipayQuery 开启操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == USE){
			return true;
		}
		model.setStatus(USE);
		model.setLastupdate(new Date());
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
		PayAlipayQueryModel model = super.selectById(id);
		if(model == null) {
			log.error("PayAlipayQuery 停止操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == UNUSE){
			return true;
		}
		model.setStatus(UNUSE);
		model.setLastupdate(new Date());
		boolean ret = super.updateById(model);
		return ret;
	}
	
	@Override
	public PageUtils<PayAlipayQueryView> getByPage(PayAlipayQueryDto dto) throws BusinessException {
		startPage(dto);
		List<PayAlipayQueryView> ret = this.mapper.getByPage(dto);
		PageUtils<PayAlipayQueryView> pages =  new PageUtils<PayAlipayQueryView>(ret);
		return pages;
	}
	
	@Override
	public List<PayAlipayQueryView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayAlipayQueryView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<PayAlipayQueryView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayAlipayQueryView> listAll() throws BusinessException {
		List<PayAlipayQueryView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<PayAlipayQueryView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(PayAlipayQueryModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("PayAlipayQuery 修改失败;传入对象为空");
			return false;
		}
		PayAlipayQueryModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("PayAlipayQuery 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayAlipayQueryModel uModel = new PayAlipayQueryModel();
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
	public PayAlipayQueryModel findBySuccessOutTradeNo(String outTradeNo) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("out_trade_no", outTradeNo).eq("trade_status", "TRADE_SUCCESS");
		PayAlipayQueryModel ret = super.selectOne(ew);
		return ret;
	}
	
}
