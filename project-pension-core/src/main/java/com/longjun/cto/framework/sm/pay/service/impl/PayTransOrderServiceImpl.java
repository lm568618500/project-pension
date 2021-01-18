package com.longjun.cto.framework.sm.pay.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.entity.dto.PayTransOrderDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayTransOrderModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayTransOrderModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayTransOrderView;
import com.longjun.cto.framework.sm.pay.mapper.PayTransOrderMapper;
import com.longjun.cto.framework.sm.pay.service.IPayTransOrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * PayTransOrderServiceImpl
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
 @Service
public class PayTransOrderServiceImpl  extends 
					BaseServiceImpl<PayTransOrderMapper , PayTransOrderModel> 
						implements IPayTransOrderService {

	@Autowired
	PayTransOrderMapper mapper;
	
	@Override
	public PayTransOrderView findViewById(long id) throws BusinessException {
		PayTransOrderView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayTransOrderModel findModelById(long id) throws BusinessException {
		PayTransOrderModel model = this.selectById(id);
		if(model == null) {
			log.warn("PayTransOrder 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayTransOrderModel model) throws BusinessException {
		log.info("PayTransOrder 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		PayTransOrderModel model = super.selectById(id);
		if(model == null) {
			log.error("PayTransOrder 开启操作,ID[{}]未查询到数据信息" , id);
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
	public boolean del(long id) throws BusinessException {
		int ret = this.mapper.del(id);
		return ret > 0 ? true : false;
	}

	@Override
	public boolean stop(long id) throws BusinessException {
		PayTransOrderModel model = super.selectById(id);
		if(model == null) {
			log.error("PayTransOrder 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<PayTransOrderView> getByPage(PayTransOrderDto dto) throws BusinessException {
		startPage(dto);
		List<PayTransOrderView> ret = this.mapper.getByPage(dto);
		PageUtils<PayTransOrderView> pages =  new PageUtils<PayTransOrderView>(ret);
		return pages;
	}
	
	@Override
	public List<PayTransOrderView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayTransOrderView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<PayTransOrderView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayTransOrderView> listAll() throws BusinessException {
		List<PayTransOrderView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<PayTransOrderView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(PayTransOrderModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("PayTransOrder 修改失败;传入对象为空");
			return false;
		}
		PayTransOrderModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("PayTransOrder 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayTransOrderModel uModel = new PayTransOrderModel();
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
