package com.longjun.cto.framework.sm.message.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.message.entity.dto.MessageSettingDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageSettingModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageGatwayModel;
import com.longjun.cto.framework.sm.message.entity.model.MessageSettingModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageSettingView;
import com.longjun.cto.framework.sm.message.es.SettingTypeEnums;
import com.longjun.cto.framework.sm.message.mapper.MessageSettingMapper;
import com.longjun.cto.framework.sm.message.service.IMessageGatwayService;
import com.longjun.cto.framework.sm.message.service.IMessageSettingService;

/**
 * MessageSettingServiceImpl
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
 @Service
public class MessageSettingServiceImpl  extends 
					BaseServiceImpl<MessageSettingMapper , MessageSettingModel> 
						implements IMessageSettingService {

	@Autowired
	MessageSettingMapper mapper;
	
	@Autowired
	IMessageGatwayService iMessageGatwayService;
	
	@Override
	public MessageSettingView findViewById(long id) throws BusinessException {
		MessageSettingView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public MessageSettingModel findModelById(long id) throws BusinessException {
		MessageSettingModel model = this.selectById(id);
		if(model == null) {
			log.warn("MessageSetting 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(MessageSettingModel model) throws BusinessException {
		log.info("MessageSetting 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setIsDel(0);
		model.setStatus(1);
		
		MessageGatwayModel gatway = iMessageGatwayService.findModelById(model.getGatwayId());
		if(gatway == null) {
			log.error("MessageSetting 数据新增失败 ,未查询到网关ID[{}]信息" ,model.getGatwayId());
			return ;
		}
		if("SMS".equals(gatway.getGatwayValue())) {
			model.setSettingType(1);
		}else if("EMAIL".equals(gatway.getGatwayValue())) {
			model.setSettingType(2);
		}else if("PUSH".equals(gatway.getGatwayValue())) {
			model.setSettingType(3);
		}
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		MessageSettingModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageSetting 开启操作,ID[{}]未查询到数据信息" , id);
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
		MessageSettingModel model = super.selectById(id);
		if(model == null) {
			log.error("MessageSetting 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<MessageSettingView> getByPage(MessageSettingDto dto) throws BusinessException {
		startPage(dto);
		List<MessageSettingView> ret = this.mapper.getByPage(dto);
		PageUtils<MessageSettingView> pages =  new PageUtils<MessageSettingView>(ret);
		return pages;
	}
	
	@Override
	public List<MessageSettingView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<MessageSettingView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<MessageSettingView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<MessageSettingView> listAll() throws BusinessException {
		List<MessageSettingView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<MessageSettingView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(MessageSettingModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("MessageSetting 修改失败;传入对象为空");
			return false;
		}
		MessageSettingModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("MessageSetting 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		try {
			model.setGatwayId(dto.getGatwayId());
			model.setProfile(dto.getProfile());
			model.setLastupdate(new Date());
			boolean ret = super.updateById(model);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}

	@Override
	public MessageSettingModel findByMchId2GatwayId(long mchId, long gatwayId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("mech_id", mchId).eq("gatway_id", gatwayId).eq("status", 1).eq("is_del", 0);
		MessageSettingModel ret = super.selectOne(ew);
		return ret;
	}

	@Override
	public MessageSettingModel findByMchId2SettingType(long mchId, SettingTypeEnums settingTypeEnums)
			throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("mech_id", mchId).eq("setting_type", settingTypeEnums.getType()).eq("status", 1).eq("is_del", 0);
		MessageSettingModel ret = super.selectOne(ew);
		return ret;
	}
	
}
