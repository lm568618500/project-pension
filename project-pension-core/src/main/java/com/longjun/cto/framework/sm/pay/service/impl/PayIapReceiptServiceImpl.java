package com.longjun.cto.framework.sm.pay.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.entity.dto.PayIapReceiptDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayIapReceiptModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayIapReceiptModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayIapReceiptView;
import com.longjun.cto.framework.sm.pay.mapper.PayIapReceiptMapper;
import com.longjun.cto.framework.sm.pay.service.IPayIapReceiptService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * PayIapReceiptServiceImpl
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
 @Service
public class PayIapReceiptServiceImpl  extends 
					BaseServiceImpl<PayIapReceiptMapper , PayIapReceiptModel> 
						implements IPayIapReceiptService {

	@Autowired
	PayIapReceiptMapper mapper;
	
	@Override
	public PayIapReceiptView findViewById(long id) throws BusinessException {
		PayIapReceiptView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayIapReceiptModel findModelById(long id) throws BusinessException {
		PayIapReceiptModel model = this.selectById(id);
		if(model == null) {
			log.warn("PayIapReceipt 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayIapReceiptModel model) throws BusinessException {
		log.info("PayIapReceipt 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		PayIapReceiptModel model = super.selectById(id);
		if(model == null) {
			log.error("PayIapReceipt 开启操作,ID[{}]未查询到数据信息" , id);
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
		PayIapReceiptModel model = super.selectById(id);
		if(model == null) {
			log.error("PayIapReceipt 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<PayIapReceiptView> getByPage(PayIapReceiptDto dto) throws BusinessException {
		startPage(dto);
		List<PayIapReceiptView> ret = this.mapper.getByPage(dto);
		PageUtils<PayIapReceiptView> pages =  new PageUtils<PayIapReceiptView>(ret);
		return pages;
	}
	
	@Override
	public List<PayIapReceiptModel> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayIapReceiptModel> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<PayIapReceiptModel>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayIapReceiptModel> listAll() throws BusinessException {
		List<PayIapReceiptModel> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<PayIapReceiptModel>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(PayIapReceiptModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("PayIapReceipt 修改失败;传入对象为空");
			return false;
		}
		PayIapReceiptModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("PayIapReceipt 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayIapReceiptModel uModel = new PayIapReceiptModel();
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
