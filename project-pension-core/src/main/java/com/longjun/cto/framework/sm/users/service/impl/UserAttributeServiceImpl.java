package com.longjun.cto.framework.sm.users.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.users.entity.dto.UserAttributeDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserAttributeModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserAttributeModel;
import com.longjun.cto.framework.sm.users.entity.view.UserAttributeView;
import com.longjun.cto.framework.sm.users.mapper.UserAttributeMapper;
import com.longjun.cto.framework.sm.users.service.IUserAttributeService;

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
 * UserAttributeServiceImpl
 * @author qiujunbo
 * @date 2019-07-05 05:36:06
 */
 @Service
public class UserAttributeServiceImpl  extends 
					BaseServiceImpl<UserAttributeMapper , UserAttributeModel> 
						implements IUserAttributeService {

	@Autowired
	UserAttributeMapper mapper;
	
	@Override
	public UserAttributeView findViewById(long id) throws BusinessException {
		UserAttributeView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public UserAttributeModel findModelById(long id) throws BusinessException {
		UserAttributeModel model = this.selectById(id);
		if(model == null) {
			log.warn("UserAttribute 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(UserAttributeModel model) throws BusinessException {
		log.info("UserAttribute 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		
		model.setStatus(1);
		model.setTime(new Date());
		model.setLastupdate(new Date());
		
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		UserAttributeModel model = super.selectById(id);
		if(model == null) {
			log.error("UserAttribute 开启操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == USE){
			return true;
		}
		model.setStatus(USE);
		model.setLastupdate(new Date());
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
		UserAttributeModel model = super.selectById(id);
		if(model == null) {
			log.error("UserAttribute 停止操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == UNUSE){
			return true;
		}
		model.setStatus(UNUSE);
		model.setLastupdate(new Date());
		boolean ret = super.updateById(model);
		return ret;
	}
	
	@Override
	public PageUtils<UserAttributeView> getByPage(UserAttributeDto dto) throws BusinessException {
		startPage(dto);
		List<UserAttributeView> ret = this.mapper.getByPage(dto);
		PageUtils<UserAttributeView> pages =  new PageUtils<UserAttributeView>(ret);
		return pages;
	}
	
	@Override
	public List<UserAttributeView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<UserAttributeView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<UserAttributeView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<UserAttributeView> listAll() throws BusinessException {
		List<UserAttributeView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<UserAttributeView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(UserAttributeModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("UserAttribute 修改失败;传入对象为空");
			return false;
		}
		UserAttributeModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("UserAttribute 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		UserAttributeModel uModel = new UserAttributeModel();
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
	public List<UserAttributeView> listByUserIdandAttrType(long userId,long attrType) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_userId", userId);
		params.put("c_attrType", attrType);
		List<UserAttributeView> rets = this.mapper.listByUserIdandAttrType(params);
		if(rets == null) {
			return new ArrayList<UserAttributeView>();
		}
		return rets;
	}
	
	@Override
	public boolean delByUserIdandAttrType(long userId,long attrType) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_userId", userId);
		params.put("c_attrType", attrType);
		int ret = this.mapper.delByUserIdandAttrType(params);
		return ret > 0 ? true : false;
	}
}
