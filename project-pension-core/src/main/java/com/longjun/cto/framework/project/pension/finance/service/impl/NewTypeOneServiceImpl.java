package com.longjun.cto.framework.project.pension.finance.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import java.util.List;
import java.util.Date;
import  com.longjun.cto.framework.project.pension.finance.service.INewTypeOneService;
import  com.longjun.cto.framework.project.pension.finance.mapper.NewTypeOneMapper;
import  com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeOneModel;
import  com.longjun.cto.framework.project.pension.finance.entity.view.NewTypeOneView;
import  com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeOneDto;
import  com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeOneModifyDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * NewTypeOneServiceImpl
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
 @Service
public class NewTypeOneServiceImpl  extends 
					BaseServiceImpl<NewTypeOneMapper , NewTypeOneModel> 
						implements INewTypeOneService {

	@Autowired
	NewTypeOneMapper mapper;
	
	@Override
	public NewTypeOneView findViewById(long id) throws BusinessException {
		NewTypeOneView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public NewTypeOneModel findModelById(long id) throws BusinessException {
		NewTypeOneModel model = this.selectById(id);
		if(model == null) {
			log.warn("NewTypeOne 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(NewTypeOneModel model) throws BusinessException {
		log.info("NewTypeOne 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		NewTypeOneModel model = super.selectById(id);
		if(model == null) {
			log.error("NewTypeOne 开启操作,ID[{}]未查询到数据信息" , id);
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
		NewTypeOneModel model = super.selectById(id);
		if(model == null) {
			log.error("NewTypeOne 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<NewTypeOneView> getByPage(NewTypeOneDto dto) throws BusinessException {
		startPage(dto);
		List<NewTypeOneView> ret = this.mapper.getByPage(dto);
		PageUtils<NewTypeOneView> pages =  new PageUtils<NewTypeOneView>(ret);
		return pages;
	}
	
	@Override
	public List<NewTypeOneView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<NewTypeOneView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<NewTypeOneView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<NewTypeOneView> listAll() throws BusinessException {
		List<NewTypeOneView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<NewTypeOneView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(NewTypeOneModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("NewTypeOne 修改失败;传入对象为空");
			return false;
		}
		NewTypeOneModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("NewTypeOne 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		NewTypeOneModel uModel = new NewTypeOneModel();
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
