package com.longjun.cto.framework.sm.message.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempEmailDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempEmailModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageTempEmailModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageTempEmailView;
import com.longjun.cto.framework.sm.message.mapper.MessageTempEmailMapper;
import com.longjun.cto.framework.sm.message.service.IMessageTempEmailService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * MessageTempEmailServiceImpl
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
 @Service
public class MessageTempEmailServiceImpl  extends 
					BaseServiceImpl<MessageTempEmailMapper , MessageTempEmailModel> 
						implements IMessageTempEmailService {

	@Autowired
	MessageTempEmailMapper mapper;
	
	@Override
	public MessageTempEmailView findViewById(long id) throws BusinessException {
		MessageTempEmailView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public MessageTempEmailModel findModelById(long id) throws BusinessException {
		MessageTempEmailModel model = this.selectById(id);
		if(model == null) {
			log.warn("MessageTempEmail 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(MessageTempEmailModel model) throws BusinessException {
		log.info("MessageTempEmail 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		MessageTempEmailModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageTempEmail 开启操作,ID[{}]未查询到数据信息" , id);
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
		MessageTempEmailModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageTempEmail 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<MessageTempEmailView> getByPage(MessageTempEmailDto dto) throws BusinessException {
		startPage(dto);
		List<MessageTempEmailView> ret = this.mapper.getByPage(dto);
		PageUtils<MessageTempEmailView> pages =  new PageUtils<MessageTempEmailView>(ret);
		return pages;
	}
	
	@Override
	public List<MessageTempEmailView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<MessageTempEmailView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<MessageTempEmailView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<MessageTempEmailView> listAll() throws BusinessException {
		List<MessageTempEmailView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<MessageTempEmailView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(MessageTempEmailModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("MessageTempEmail 修改失败;传入对象为空");
			return false;
		}
		MessageTempEmailModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("MessageTempEmail 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		try {
			model.setStatus(dto.getStatus());
			model.setEmailimmediately(dto.getEmailimmediately());
			model.setEmailContent(dto.getEmailContent());
			model.setLastupdate(new Date());
			model.setTips(dto.getTips());
			boolean ret = super.updateById(model);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
	
}
