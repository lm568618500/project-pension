package com.longjun.cto.framework.sm.pay.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.entity.dto.PayMchNotifyDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayMchNotifyModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayMchNotifyModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayMchNotifyView;
import com.longjun.cto.framework.sm.pay.mapper.PayMchNotifyMapper;
import com.longjun.cto.framework.sm.pay.service.IPayMchNotifyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * PayMchNotifyServiceImpl
 * @author yangxuan
 * @date 2019-03-31 05:17:13
 */
 @Service
public class PayMchNotifyServiceImpl  extends 
					BaseServiceImpl<PayMchNotifyMapper , PayMchNotifyModel> 
						implements IPayMchNotifyService {

	@Autowired
	PayMchNotifyMapper mapper;
	
	@Override
	public PayMchNotifyView findViewById(long id) throws BusinessException {
		PayMchNotifyView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayMchNotifyModel findModelById(long id) throws BusinessException {
		PayMchNotifyModel model = this.selectById(id);
		if(model == null) {
			log.warn("PayMchNotify 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayMchNotifyModel model) throws BusinessException {
		log.info("PayMchNotify 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		PayMchNotifyModel model = super.selectById(id);
		if(model == null) {
			log.error("PayMchNotify 开启操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == USE){
			return true;
		}
		model.setStatus(USE);
		boolean ret = super.updateById(model);
		return ret;
	}

	@Override
	public boolean stop(long id) throws BusinessException {
		PayMchNotifyModel model = super.selectById(id);
		if(model == null) {
			log.error("PayMchNotify 停止操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == UNUSE){
			return true;
		}
		model.setStatus(UNUSE);
		boolean ret = super.updateById(model);
		return ret;
	}
	
	@Override
	public PageUtils<PayMchNotifyView> getByPage(PayMchNotifyDto dto) throws BusinessException {
		startPage(dto);
		List<PayMchNotifyView> ret = this.mapper.getByPage(dto);
		PageUtils<PayMchNotifyView> pages =  new PageUtils<PayMchNotifyView>(ret);
		return pages;
	}
	
	@Override
	public List<PayMchNotifyModel> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayMchNotifyModel> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<PayMchNotifyModel>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayMchNotifyModel> listAll() throws BusinessException {
		List<PayMchNotifyModel> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<PayMchNotifyModel>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(PayMchNotifyModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("PayMchNotify 修改失败;传入对象为空");
			return false;
		}
		PayMchNotifyModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("PayMchNotify 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayMchNotifyModel uModel = new PayMchNotifyModel();
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
