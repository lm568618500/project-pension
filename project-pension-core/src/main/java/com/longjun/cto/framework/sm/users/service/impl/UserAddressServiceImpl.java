package com.longjun.cto.framework.sm.users.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.users.entity.dto.UserAddressDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserAddressModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserAddressModel;
import com.longjun.cto.framework.sm.users.entity.view.UserAddressView;
import com.longjun.cto.framework.sm.users.mapper.UserAddressMapper;
import com.longjun.cto.framework.sm.users.service.IUserAddressService;

/**
 * UserAddressServiceImpl
 * @author heqiang
 * @date 2019-07-03 06:22:57
 */
 @Service
public class UserAddressServiceImpl  extends 
					BaseServiceImpl<UserAddressMapper , UserAddressModel> 
						implements IUserAddressService {

	@Autowired
	UserAddressMapper mapper;
	
	@Override
	public UserAddressView findViewById(long id) throws BusinessException {
		UserAddressView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public UserAddressModel findModelById(long id) throws BusinessException {
		UserAddressModel model = this.selectById(id);
		if(model == null) {
			log.warn("UserAddress 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(UserAddressModel model) throws BusinessException {
		log.info("UserAddress 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		UserAddressModel model = super.selectById(id);
		if(model == null) {
			log.error("UserAddress 开启操作,ID[{}]未查询到数据信息" , id);
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
		UserAddressModel model = super.selectById(id);
		if(model == null) {
			log.error("UserAddress 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<UserAddressView> getByPage(UserAddressDto dto) throws BusinessException {
		startPage(dto);
		List<UserAddressView> ret = this.mapper.getByPage(dto);
		PageUtils<UserAddressView> pages =  new PageUtils<UserAddressView>(ret);
		return pages;
	}
	
	@Override
	public List<UserAddressView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<UserAddressView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<UserAddressView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<UserAddressView> listAll() throws BusinessException {
		List<UserAddressView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<UserAddressView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(UserAddressModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("UserAddress 修改失败;传入对象为空");
			return false;
		}
		UserAddressModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("UserAddress 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		UserAddressModel uModel = new UserAddressModel();
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
