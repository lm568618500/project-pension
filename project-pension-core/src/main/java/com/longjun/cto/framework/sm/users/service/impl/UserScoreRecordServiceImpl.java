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
import com.longjun.cto.framework.sm.users.entity.dto.UserScoreRecordDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserScoreRecordModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserScoreRecordModel;
import com.longjun.cto.framework.sm.users.entity.view.UserScoreRecordView;
import com.longjun.cto.framework.sm.users.mapper.UserScoreRecordMapper;
import com.longjun.cto.framework.sm.users.service.IUserScoreRecordService;

/**
 * UserScoreRecordServiceImpl
 * @author yangxuan
 * @date 2019-06-28 04:46:45
 */
 @Service
public class UserScoreRecordServiceImpl  extends 
					BaseServiceImpl<UserScoreRecordMapper , UserScoreRecordModel> 
						implements IUserScoreRecordService {

	@Autowired
	UserScoreRecordMapper mapper;
	
	@Override
	public UserScoreRecordView findViewById(long id) throws BusinessException {
		UserScoreRecordView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public UserScoreRecordModel findModelById(long id) throws BusinessException {
		UserScoreRecordModel model = this.selectById(id);
		if(model == null) {
			log.warn("UserScoreRecord 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(UserScoreRecordModel model) throws BusinessException {
		log.info("UserScoreRecord 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		UserScoreRecordModel model = super.selectById(id);
		if(model == null) {
			log.error("UserScoreRecord 开启操作,ID[{}]未查询到数据信息" , id);
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
		UserScoreRecordModel model = super.selectById(id);
		if(model == null) {
			log.error("UserScoreRecord 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<UserScoreRecordView> getByPage(UserScoreRecordDto dto) throws BusinessException {
		startPage(dto);
		List<UserScoreRecordView> ret = this.mapper.getByPage(dto);
		PageUtils<UserScoreRecordView> pages =  new PageUtils<UserScoreRecordView>(ret);
		return pages;
	}
	
	@Override
	public List<UserScoreRecordView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<UserScoreRecordView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<UserScoreRecordView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<UserScoreRecordView> listAll() throws BusinessException {
		List<UserScoreRecordView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<UserScoreRecordView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(UserScoreRecordModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("UserScoreRecord 修改失败;传入对象为空");
			return false;
		}
		UserScoreRecordModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("UserScoreRecord 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		UserScoreRecordModel uModel = new UserScoreRecordModel();
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
