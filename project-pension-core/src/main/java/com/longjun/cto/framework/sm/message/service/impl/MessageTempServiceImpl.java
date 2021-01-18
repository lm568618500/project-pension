package com.longjun.cto.framework.sm.message.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageTempModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageTempView;
import com.longjun.cto.framework.sm.message.mapper.MessageTempMapper;
import com.longjun.cto.framework.sm.message.service.IMessageTempService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * MessageTempServiceImpl
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
 @Service
public class MessageTempServiceImpl  extends 
					BaseServiceImpl<MessageTempMapper , MessageTempModel> 
						implements IMessageTempService {

	@Autowired
	MessageTempMapper mapper;
	
	@Override
	public MessageTempView findViewById(long id) throws BusinessException {
		MessageTempView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public MessageTempModel findModelById(long id) throws BusinessException {
		MessageTempModel model = this.selectById(id);
		if(model == null) {
			log.warn("MessageTemp 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(MessageTempModel model) throws BusinessException {
		log.info("MessageTemp 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		MessageTempModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageTemp 开启操作,ID[{}]未查询到数据信息" , id);
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
		MessageTempModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageTemp 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<MessageTempView> getByPage(MessageTempDto dto) throws BusinessException {
		startPage(dto);
		List<MessageTempView> ret = this.mapper.getByPage(dto);
		PageUtils<MessageTempView> pages =  new PageUtils<MessageTempView>(ret);
		return pages;
	}
	
	@Override
	public List<MessageTempView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<MessageTempView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<MessageTempView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<MessageTempView> listAll() throws BusinessException {
		List<MessageTempView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<MessageTempView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(MessageTempModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("MessageTemp 修改失败;传入对象为空");
			return false;
		}
		MessageTempModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("MessageTemp 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		MessageTempModel uModel = new MessageTempModel();
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
