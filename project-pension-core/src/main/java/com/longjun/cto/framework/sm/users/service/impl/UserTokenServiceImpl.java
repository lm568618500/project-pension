package com.longjun.cto.framework.sm.users.service.impl;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.conf.SysSetting;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.users.entity.dto.UserTokenDto;
import com.longjun.cto.framework.sm.users.entity.model.UserTokenModel;
import com.longjun.cto.framework.sm.users.entity.view.UserTokenView;
import com.longjun.cto.framework.sm.users.mapper.UserTokenMapper;
import com.longjun.cto.framework.sm.users.service.IUserTokenService;

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
 * UserTokenServiceImpl
 * @author yangxuan
 * @date 2019-05-31 05:43:41
 */
 @Service
public class UserTokenServiceImpl  extends 
					BaseServiceImpl<UserTokenMapper , UserTokenModel> 
						implements IUserTokenService {

	@Autowired
	UserTokenMapper mapper;
	
	@Override
	public UserTokenView findViewById(long id) throws BusinessException {
		UserTokenView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public UserTokenModel findModelById(long id) throws BusinessException {
		UserTokenModel model = this.selectById(id);
		if(model == null) {
			log.warn("UserToken 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(UserTokenModel model) throws BusinessException {
		log.info("UserToken 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		UserTokenModel model = super.selectById(id);
		if(model == null) {
			log.error("UserToken 开启操作,ID[{}]未查询到数据信息" , id);
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
		UserTokenModel model = super.selectById(id);
		if(model == null) {
			log.error("UserToken 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<UserTokenView> getByPage(UserTokenDto dto) throws BusinessException {
		startPage(dto);
		List<UserTokenView> ret = this.mapper.getByPage(dto);
		PageUtils<UserTokenView> pages =  new PageUtils<UserTokenView>(ret);
		return pages;
	}
	
	@Override
	public List<UserTokenView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<UserTokenView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<UserTokenView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<UserTokenView> listAll() throws BusinessException {
		List<UserTokenView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<UserTokenView>();
		}
		return rets;
	}

	@Override
	public String createToken(long userId, String token) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("token", token).eq("status", 1).eq("is_del", 0);
		UserTokenModel model = super.selectOne(ew);
		Date now = new Date();
		Date expireTime = new Date(now.getTime() + SysSetting.PASSPORT_EXPIRETIME);
		if (model != null) {
			model.setLastupdate(new Date());
			model.setExpireTime(expireTime);
			super.updateById(model);
		} else {
			model = new UserTokenModel();
			model.setTime(now);
			model.setExpireTime(expireTime);
			model.setToken(token);
			model.setStatus(1);
			model.setIsDel(0);
			model.setUserId(userId);
			model.setTokenType(1);
			super.insert(model);
		}
		return token;
	}

	@Override
	public UserTokenModel findByToken(String token) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("token", token).eq("status", 1).eq("is_del", 0);
		UserTokenModel ret = super.selectOne(ew);
		return ret;
	}

	@Override
	public void flushToken(String token) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("token", token).eq("status", 1).eq("is_del", 0);
		UserTokenModel model = super.selectOne(ew);
		Date now = new Date();
		Date expireTime = new Date(now.getTime() + SysSetting.PASSPORT_EXPIRETIME);
		if(model != null) {
			 model.setLastupdate(new Date());
			 model.setExpireTime(expireTime);
			 super.updateById(model);
		}
	}

	@Override
	public void failureToken(String token) throws BusinessException {
		synchronized (token) {
			EntityWrapper ew = new EntityWrapper<>();
			ew.eq("token", token).eq("status", 1).eq("is_del", 0);
			UserTokenModel model = super.selectOne(ew);
			if(model == null) {
				return;
			}
			//作废后
			model.setStatus(0);
			model.setLastupdate(new Date());
			super.updateById(model);
		}
	}

	@Override
	public void failureToken(UserTokenModel userTokenModel) throws BusinessException {
		if(userTokenModel != null) {
			//作废后
			userTokenModel.setStatus(0);
			userTokenModel.setLastupdate(new Date());
			super.updateById(userTokenModel);
		}
	}
	
}
