package com.longjun.cto.framework.sm.sys.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.conf.SysSetting;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminTokenDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminTokenModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminTokenModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminTokenView;
import com.longjun.cto.framework.sm.sys.mapper.AdminTokenMapper;
import com.longjun.cto.framework.sm.sys.service.IAdminTokenService;

import java.util.List;

import cn.hutool.core.date.DateUtil;

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
 * AdminTokenServiceImpl
 * @author EIMS-CODE-BUILD
 * @date 2019-04-01 08:42:03
 */
 @Service
public class AdminTokenServiceImpl  extends 
					BaseServiceImpl<AdminTokenMapper , AdminTokenModel> 
						implements IAdminTokenService {
      
	@Autowired
	AdminTokenMapper mapper;
	
	@Override
	public AdminTokenView findViewById(long id) throws BusinessException {
		AdminTokenView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public AdminTokenModel findModelById(long id) throws BusinessException {
		AdminTokenModel model = this.selectById(id);
		if(model == null) {
			log.warn("AdminToken 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(AdminTokenModel model) throws BusinessException {
		log.info("AdminToken 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		AdminTokenModel model = super.selectById(id);
		if(model == null) {
			log.error("AdminToken 开启操作,ID[{}]未查询到数据信息" , id);
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
	public boolean stop(long id) throws BusinessException {
		AdminTokenModel model = super.selectById(id);
		if(model == null) {
			log.error("AdminToken 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<AdminTokenView> getByPage(AdminTokenDto dto) throws BusinessException {
		startPage(dto);
		List<AdminTokenView> ret = this.mapper.getByPage(dto);
		PageUtils<AdminTokenView> pages =  new PageUtils<AdminTokenView>(ret);
		return pages;
	}
	
	@Override
	public List<AdminTokenModel> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<AdminTokenModel> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<AdminTokenModel>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<AdminTokenModel> listAll() throws BusinessException {
		List<AdminTokenModel> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<AdminTokenModel>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(AdminTokenModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("AdminToken 修改失败;传入对象为空");
			return false;
		}
		AdminTokenModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("AdminToken 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		AdminTokenModel uModel = new AdminTokenModel();
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
	public String createToken(long userId, String token) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("token", token).eq("status", 1).eq("is_del", 0);
		AdminTokenModel model = super.selectOne(ew);
		Date now = new Date();
		Date expireTime = new Date(now.getTime() + SysSetting.PASSPORT_EXPIRETIME);
		if(model != null) {
			 model.setLastupdate(new Date());
			 model.setExpireTime(expireTime);
			 model.setUserId(userId);
			 super.updateById(model);
		}else {
			model = new AdminTokenModel();
			model.setTime(now);
			model.setExpireTime(expireTime);
			model.setToken(token);
			model.setStatus(1);
			model.setIsDel(0);
			model.setUserId(userId);
			super.insert(model);
		}
		return null;
	}
	
	@Override
	public void failureToken(String token)throws BusinessException{
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("token", token).eq("status", 1).eq("is_del", 0);
		AdminTokenModel model = super.selectOne(ew);
		if(model == null) {
			return;
		}
		//作废后
		model.setStatus(0);
		super.updateById(model);
	}
	
}
