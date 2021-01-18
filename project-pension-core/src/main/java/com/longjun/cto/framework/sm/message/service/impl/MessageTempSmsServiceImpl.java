package com.longjun.cto.framework.sm.message.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempSmsDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempSmsModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageTempSmsModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageTempSmsView;
import com.longjun.cto.framework.sm.message.mapper.MessageTempSmsMapper;
import com.longjun.cto.framework.sm.message.service.IMessageTempSmsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * MessageTempSmsServiceImpl
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
 @Service
public class MessageTempSmsServiceImpl  extends 
					BaseServiceImpl<MessageTempSmsMapper , MessageTempSmsModel> 
						implements IMessageTempSmsService {

	@Autowired
	MessageTempSmsMapper mapper;
	
	@Override
	public MessageTempSmsView findViewById(long id) throws BusinessException {
		MessageTempSmsView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public MessageTempSmsModel findModelById(long id) throws BusinessException {
		MessageTempSmsModel model = this.selectById(id);
		if(model == null) {
			log.warn("MessageTempSms 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(MessageTempSmsModel model) throws BusinessException {
		log.info("MessageTempSms 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		MessageTempSmsModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageTempSms 开启操作,ID[{}]未查询到数据信息" , id);
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
		MessageTempSmsModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageTempSms 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<MessageTempSmsView> getByPage(MessageTempSmsDto dto) throws BusinessException {
		startPage(dto);
		List<MessageTempSmsView> ret = this.mapper.getByPage(dto);
		PageUtils<MessageTempSmsView> pages =  new PageUtils<MessageTempSmsView>(ret);
		return pages;
	}
	
	@Override
	public List<MessageTempSmsModel> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<MessageTempSmsModel> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<MessageTempSmsModel>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<MessageTempSmsModel> listAll() throws BusinessException {
		List<MessageTempSmsModel> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<MessageTempSmsModel>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(MessageTempSmsModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("MessageTempSms 修改失败;传入对象为空");
			return false;
		}
		MessageTempSmsModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("MessageTempSms 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		log.info("短信消息模板修改,传入对象参数信息 - > [{}]" , JSONObject.toJSONString(dto));
		try {
			//第三方模板
			model.setOtherTemplateId(dto.getOtherTemplateId());
			//业务状态
			model.setStatus(dto.getStatus());
			//立即发送
			model.setImmediately(dto.getImmediately());
			//短信模板内容
			model.setSmsContent(dto.getSmsContent());
			//tips提示
			model.setTips(dto.getTips());
			//修改时间
			model.setLastupdate(new Date());
			boolean ret = super.updateById(model);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}

	@Override
	public MessageTempSmsModel findModelByTempUid(String tempUid) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 1).eq("temp_uid", tempUid);
		MessageTempSmsModel ret = super.selectOne(ew);
		return ret;
	}
	
}
