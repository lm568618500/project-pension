package com.longjun.cto.framework.sm.pay.alipay.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayNotifyDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayNotifyModifyDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayNotifyModel;
import com.longjun.cto.framework.sm.pay.alipay.entity.view.PayAlipayNotifyView;
import com.longjun.cto.framework.sm.pay.alipay.mapper.PayAlipayNotifyMapper;
import com.longjun.cto.framework.sm.pay.alipay.service.IPayAlipayNotifyService;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * PayAlipayNotifyServiceImpl
 * @author yangxuan
 * @date 2019-11-07 06:58:15
 */
 @Service
public class PayAlipayNotifyServiceImpl  extends 
					BaseServiceImpl<PayAlipayNotifyMapper , PayAlipayNotifyModel> 
						implements IPayAlipayNotifyService {

	@Autowired
	PayAlipayNotifyMapper mapper;
	
	@Override
	public PayAlipayNotifyView findViewById(long id) throws BusinessException {
		PayAlipayNotifyView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayAlipayNotifyModel findModelById(long id) throws BusinessException {
		PayAlipayNotifyModel model = this.selectById(id);
		if(model == null) {
			log.warn("PayAlipayNotify 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayAlipayNotifyModel model) throws BusinessException {
		log.info("PayAlipayNotify 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		PayAlipayNotifyModel model = super.selectById(id);
		if(model == null) {
			log.error("PayAlipayNotify 开启操作,ID[{}]未查询到数据信息" , id);
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
		PayAlipayNotifyModel model = super.selectById(id);
		if(model == null) {
			log.error("PayAlipayNotify 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<PayAlipayNotifyView> getByPage(PayAlipayNotifyDto dto) throws BusinessException {
		startPage(dto);
		List<PayAlipayNotifyView> ret = this.mapper.getByPage(dto);
		PageUtils<PayAlipayNotifyView> pages =  new PageUtils<PayAlipayNotifyView>(ret);
		return pages;
	}
	
	@Override
	public List<PayAlipayNotifyView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayAlipayNotifyView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<PayAlipayNotifyView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayAlipayNotifyView> listAll() throws BusinessException {
		List<PayAlipayNotifyView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<PayAlipayNotifyView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(PayAlipayNotifyModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("PayAlipayNotify 修改失败;传入对象为空");
			return false;
		}
		PayAlipayNotifyModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("PayAlipayNotify 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayAlipayNotifyModel uModel = new PayAlipayNotifyModel();
		try {
			BeanUtils.copyProperties(uModel, dto);
			boolean ret = super.updateById(uModel);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
	
}
