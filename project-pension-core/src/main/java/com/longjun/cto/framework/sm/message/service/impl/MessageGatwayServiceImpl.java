package com.longjun.cto.framework.sm.message.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.message.entity.dto.MessageGatwayDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageGatwayModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageGatwayModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageGatwayView;
import com.longjun.cto.framework.sm.message.mapper.MessageGatwayMapper;
import com.longjun.cto.framework.sm.message.service.IMessageGatwayService;

import java.util.List;

import cn.hutool.core.util.StrUtil;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * MessageGatwayServiceImpl
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
 @Service
public class MessageGatwayServiceImpl  extends 
					BaseServiceImpl<MessageGatwayMapper , MessageGatwayModel> 
						implements IMessageGatwayService {

	@Autowired
	MessageGatwayMapper mapper;
	
	@Override
	public MessageGatwayView findViewById(long id) throws BusinessException {
		MessageGatwayView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public MessageGatwayModel findModelById(long id) throws BusinessException {
		MessageGatwayModel model = this.selectById(id);
		if(model == null) {
			log.warn("MessageGatway 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(MessageGatwayModel model) throws BusinessException {
		log.info("MessageGatway 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		MessageGatwayModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageGatway 开启操作,ID[{}]未查询到数据信息" , id);
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
		MessageGatwayModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageGatway 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<MessageGatwayView> getByPage(MessageGatwayDto dto) throws BusinessException {
		startPage(dto);
		List<MessageGatwayView> ret = this.mapper.getByPage(dto);
		PageUtils<MessageGatwayView> pages =  new PageUtils<MessageGatwayView>(ret);
		return pages;
	}
	
	@Override
	public List<MessageGatwayView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<MessageGatwayView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<MessageGatwayView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<MessageGatwayView> listAll() throws BusinessException {
		List<MessageGatwayView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<MessageGatwayView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(MessageGatwayModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("MessageGatway 修改失败;传入对象为空");
			return false;
		}
		MessageGatwayModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("MessageGatway 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		MessageGatwayModel uModel = new MessageGatwayModel();
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
	public List<MessageGatwayModel> listByGatWayValue(String value) throws BusinessException {
		if(StrUtil.isBlank(value)) {
			return new ArrayList<MessageGatwayModel>();
		} 
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 1).eq("is_del", 0).eq("gatway_value", value);
		List<MessageGatwayModel> rets = super.selectList(ew);
		return rets;
	}
	
}
