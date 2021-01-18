package com.longjun.cto.framework.project.pension.finance.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import java.util.List;
import java.util.Date;
import  com.longjun.cto.framework.project.pension.finance.service.INewTypeTwoService;
import  com.longjun.cto.framework.project.pension.finance.mapper.NewTypeTwoMapper;
import  com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeTwoModel;
import  com.longjun.cto.framework.project.pension.finance.entity.view.NewTypeTwoView;
import  com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeTwoDto;
import  com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeTwoModifyDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * NewTypeTwoServiceImpl
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
 @Service
public class NewTypeTwoServiceImpl  extends 
					BaseServiceImpl<NewTypeTwoMapper , NewTypeTwoModel> 
						implements INewTypeTwoService {

	@Autowired
	NewTypeTwoMapper mapper;
	
	@Override
	public NewTypeTwoView findViewById(long id) throws BusinessException {
		NewTypeTwoView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public NewTypeTwoModel findModelById(long id) throws BusinessException {
		NewTypeTwoModel model = this.selectById(id);
		if(model == null) {
			log.warn("NewTypeTwo 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(NewTypeTwoModel model) throws BusinessException {
		log.info("NewTypeTwo 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		NewTypeTwoModel model = super.selectById(id);
		if(model == null) {
			log.error("NewTypeTwo 开启操作,ID[{}]未查询到数据信息" , id);
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
		NewTypeTwoModel model = super.selectById(id);
		if(model == null) {
			log.error("NewTypeTwo 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<NewTypeTwoView> getByPage(NewTypeTwoDto dto) throws BusinessException {
		startPage(dto);
		List<NewTypeTwoView> ret = this.mapper.getByPage(dto);
		PageUtils<NewTypeTwoView> pages =  new PageUtils<NewTypeTwoView>(ret);
		return pages;
	}
	
	@Override
	public List<NewTypeTwoView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<NewTypeTwoView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<NewTypeTwoView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<NewTypeTwoView> listAll() throws BusinessException {
		List<NewTypeTwoView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<NewTypeTwoView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(NewTypeTwoModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("NewTypeTwo 修改失败;传入对象为空");
			return false;
		}
		NewTypeTwoModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("NewTypeTwo 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		NewTypeTwoModel uModel = new NewTypeTwoModel();
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
