package com.longjun.cto.framework.sm.message.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.message.entity.dto.MessageMechDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageMechModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageMechModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageMechView;
import com.longjun.cto.framework.sm.message.mapper.MessageMechMapper;
import com.longjun.cto.framework.sm.message.service.IMessageMechService;

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
 * MessageMechServiceImpl
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
 @Service
public class MessageMechServiceImpl  extends 
					BaseServiceImpl<MessageMechMapper , MessageMechModel> 
						implements IMessageMechService {

	@Autowired
	MessageMechMapper mapper;
	
	@Override
	public MessageMechView findViewById(long id) throws BusinessException {
		MessageMechView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public MessageMechModel findModelById(long id) throws BusinessException {
		MessageMechModel model = this.selectById(id);
		if(model == null) {
			log.warn("MessageMech 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(MessageMechModel model) throws BusinessException {
		log.info("MessageMech 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		MessageMechModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageMech 开启操作,ID[{}]未查询到数据信息" , id);
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
		MessageMechModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageMech 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<MessageMechView> getByPage(MessageMechDto dto) throws BusinessException {
		startPage(dto);
		List<MessageMechView> ret = this.mapper.getByPage(dto);
		PageUtils<MessageMechView> pages =  new PageUtils<MessageMechView>(ret);
		return pages;
	}
	
	@Override
	public List<MessageMechView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<MessageMechView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<MessageMechView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<MessageMechView> listAll() throws BusinessException {
		List<MessageMechView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<MessageMechView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(MessageMechModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("MessageMech 修改失败;传入对象为空");
			return false;
		}
		MessageMechModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("MessageMech 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		MessageMechModel uModel = new MessageMechModel();
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
	public MessageMechModel getByOneUse() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 1).eq("is_del", 0);
		MessageMechModel ret = super.selectOne(ew);
		return ret;
	}
	
}
