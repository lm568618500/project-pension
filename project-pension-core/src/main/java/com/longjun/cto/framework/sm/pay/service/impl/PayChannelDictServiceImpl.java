package com.longjun.cto.framework.sm.pay.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelDictDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelDictModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelDictModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayChannelDictView;
import com.longjun.cto.framework.sm.pay.mapper.PayChannelDictMapper;
import com.longjun.cto.framework.sm.pay.service.IPayChannelDictService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * PayChannelDictServiceImpl
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
 @Service
public class PayChannelDictServiceImpl  extends 
					BaseServiceImpl<PayChannelDictMapper , PayChannelDictModel> 
						implements IPayChannelDictService {

	@Autowired
	PayChannelDictMapper mapper;
	
	@Override
	public PayChannelDictView findViewById(long id) throws BusinessException {
		PayChannelDictView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayChannelDictModel findModelById(long id) throws BusinessException {
		PayChannelDictModel model = this.selectById(id);
		if(model == null) {
			log.warn("PayChannelDict 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayChannelDictModel model) throws BusinessException {
		log.info("PayChannelDict 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		PayChannelDictModel model = super.selectById(id);
		if(model == null) {
			log.error("PayChannelDict 开启操作,ID[{}]未查询到数据信息" , id);
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
		PayChannelDictModel model = super.selectById(id);
		if(model == null) {
			log.error("PayChannelDict 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<PayChannelDictView> getByPage(PayChannelDictDto dto) throws BusinessException {
		startPage(dto);
		List<PayChannelDictView> ret = this.mapper.getByPage(dto);
		PageUtils<PayChannelDictView> pages =  new PageUtils<PayChannelDictView>(ret);
		return pages;
	}
	
	@Override
	public List<PayChannelDictView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayChannelDictView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<PayChannelDictView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayChannelDictView> listAll() throws BusinessException {
		List<PayChannelDictView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<PayChannelDictView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(PayChannelDictModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("PayChannelDict 修改失败;传入对象为空");
			return false;
		}
		PayChannelDictModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("PayChannelDict 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayChannelDictModel uModel = new PayChannelDictModel();
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
