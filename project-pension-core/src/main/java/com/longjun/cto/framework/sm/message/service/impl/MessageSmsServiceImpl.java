package com.longjun.cto.framework.sm.message.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.message.entity.dto.MessageSmsDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageSmsModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageSmsModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageSmsView;
import com.longjun.cto.framework.sm.message.mapper.MessageSmsMapper;
import com.longjun.cto.framework.sm.message.service.IMessageApiService;
import com.longjun.cto.framework.sm.message.service.IMessageSmsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * MessageSmsServiceImpl
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
 @Service
public class MessageSmsServiceImpl  extends 
					BaseServiceImpl<MessageSmsMapper , MessageSmsModel> 
						implements IMessageSmsService {

	@Autowired
	MessageSmsMapper mapper;
	
	@Autowired
	IMessageApiService iMessageApiService;
	
	@Override
	public MessageSmsView findViewById(long id) throws BusinessException {
		MessageSmsView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public MessageSmsModel findModelById(long id) throws BusinessException {
		MessageSmsModel model = this.selectById(id);
		if(model == null) {
			log.warn("MessageSms 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(MessageSmsModel model) throws BusinessException {
		log.info("MessageSms 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		MessageSmsModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageSms 开启操作,ID[{}]未查询到数据信息" , id);
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
		MessageSmsModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageSms 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<MessageSmsView> getByPage(MessageSmsDto dto) throws BusinessException {
		startPage(dto);
		List<MessageSmsView> ret = this.mapper.getByPage(dto);
		PageUtils<MessageSmsView> pages =  new PageUtils<MessageSmsView>(ret);
		return pages;
	}
	
	@Override
	public List<MessageSmsModel> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<MessageSmsModel> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<MessageSmsModel>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<MessageSmsModel> listAll() throws BusinessException {
		List<MessageSmsModel> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<MessageSmsModel>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(MessageSmsModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("MessageSms 修改失败;传入对象为空");
			return false;
		}
		MessageSmsModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("MessageSms 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		MessageSmsModel uModel = new MessageSmsModel();
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
	public void sendJobs() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 0).eq("is_del", 0);
		Page<MessageSmsModel> pages = super.selectPage(new Page<>(0, 50), ew);
		if(pages == null) {
			return;
		}
		List<MessageSmsModel> records = pages.getRecords();
		if(records == null) {
			return;
		}
		for(MessageSmsModel record : records) {
			boolean ret = this.iMessageApiService.sendSms(record);
			if(!ret) {
				record.setLastupdate(new Date());
				record.setStatus(-1);
				super.updateById(record);
			}
		}
	}
	
}
