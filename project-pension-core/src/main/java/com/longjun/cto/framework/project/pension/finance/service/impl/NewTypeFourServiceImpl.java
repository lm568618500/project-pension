package com.longjun.cto.framework.project.pension.finance.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import java.util.List;
import java.util.Date;
import  com.longjun.cto.framework.project.pension.finance.service.INewTypeFourService;
import  com.longjun.cto.framework.project.pension.finance.mapper.NewTypeFourMapper;
import  com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeFourModel;
import  com.longjun.cto.framework.project.pension.finance.entity.view.NewTypeFourView;
import  com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeFourDto;
import  com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeFourModifyDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * NewTypeFourServiceImpl
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
 @Service
public class NewTypeFourServiceImpl  extends 
					BaseServiceImpl<NewTypeFourMapper , NewTypeFourModel> 
						implements INewTypeFourService {

	@Autowired
	NewTypeFourMapper mapper;
	
	@Override
	public NewTypeFourView findViewById(long id) throws BusinessException {
		NewTypeFourView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public NewTypeFourModel findModelById(long id) throws BusinessException {
		NewTypeFourModel model = this.selectById(id);
		if(model == null) {
			log.warn("NewTypeFour 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(NewTypeFourModel model) throws BusinessException {
		log.info("NewTypeFour 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		NewTypeFourModel model = super.selectById(id);
		if(model == null) {
			log.error("NewTypeFour 开启操作,ID[{}]未查询到数据信息" , id);
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
		NewTypeFourModel model = super.selectById(id);
		if(model == null) {
			log.error("NewTypeFour 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<NewTypeFourView> getByPage(NewTypeFourDto dto) throws BusinessException {
		startPage(dto);
		List<NewTypeFourView> ret = this.mapper.getByPage(dto);
		PageUtils<NewTypeFourView> pages =  new PageUtils<NewTypeFourView>(ret);
		return pages;
	}
	
	@Override
	public List<NewTypeFourView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<NewTypeFourView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<NewTypeFourView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<NewTypeFourView> listAll() throws BusinessException {
		List<NewTypeFourView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<NewTypeFourView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(NewTypeFourModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("NewTypeFour 修改失败;传入对象为空");
			return false;
		}
		NewTypeFourModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("NewTypeFour 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		NewTypeFourModel uModel = new NewTypeFourModel();
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
