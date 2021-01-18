package com.longjun.cto.framework.sm.pay.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelItemDictDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelItemDictModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelItemDictModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayChannelItemDictView;
import com.longjun.cto.framework.sm.pay.mapper.PayChannelItemDictMapper;
import com.longjun.cto.framework.sm.pay.service.IPayChannelItemDictService;

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
 * PayChannelItemDictServiceImpl
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
 @Service
public class PayChannelItemDictServiceImpl  extends 
					BaseServiceImpl<PayChannelItemDictMapper , PayChannelItemDictModel> 
						implements IPayChannelItemDictService {

	@Autowired
	PayChannelItemDictMapper mapper;
	
	@Override
	public PayChannelItemDictView findViewById(long id) throws BusinessException {
		PayChannelItemDictView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayChannelItemDictModel findModelById(long id) throws BusinessException {
		PayChannelItemDictModel model = this.selectById(id);
		if(model == null) {
			log.warn("PayChannelItemDict 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayChannelItemDictModel model) throws BusinessException {
		log.info("PayChannelItemDict 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		PayChannelItemDictModel model = super.selectById(id);
		if(model == null) {
			log.error("PayChannelItemDict 开启操作,ID[{}]未查询到数据信息" , id);
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
		PayChannelItemDictModel model = super.selectById(id);
		if(model == null) {
			log.error("PayChannelItemDict 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<PayChannelItemDictView> getByPage(PayChannelItemDictDto dto) throws BusinessException {
		startPage(dto);
		List<PayChannelItemDictView> ret = this.mapper.getByPage(dto);
		PageUtils<PayChannelItemDictView> pages =  new PageUtils<PayChannelItemDictView>(ret);
		return pages;
	}
	
	@Override
	public List<PayChannelItemDictView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayChannelItemDictView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<PayChannelItemDictView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayChannelItemDictView> listAll() throws BusinessException {
		List<PayChannelItemDictView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<PayChannelItemDictView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(PayChannelItemDictModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("PayChannelItemDict 修改失败;传入对象为空");
			return false;
		}
		PayChannelItemDictModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("PayChannelItemDict 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayChannelItemDictModel uModel = new PayChannelItemDictModel();
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
	public List<PayChannelItemDictModel> listByChannelId(long channelId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("channel_id", channelId).eq("status", 1);
		List<PayChannelItemDictModel> rets = super.selectList(ew);
		if(rets == null) {
			rets = new ArrayList<PayChannelItemDictModel>();
		}
		return rets;
	}
	
}
