package com.longjun.cto.framework.sm.sys.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResourceDto;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResourceModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.OssResourceModel;
import com.longjun.cto.framework.sm.sys.entity.view.OssResourceView;
import com.longjun.cto.framework.sm.sys.mapper.OssResourceMapper;
import com.longjun.cto.framework.sm.sys.service.IOssResourceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * OssResourceServiceImpl
 * @author yangxuan
 * @date 2019-04-01 07:19:42
 */
 @Service
public class OssResourceServiceImpl  extends 
					BaseServiceImpl<OssResourceMapper , OssResourceModel> 
						implements IOssResourceService {

	@Autowired
	OssResourceMapper mapper;
	
	@Override
	public OssResourceView findViewById(long id) throws BusinessException {
		OssResourceView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public OssResourceModel findModelById(long id) throws BusinessException {
		OssResourceModel model = this.selectById(id);
		if(model == null) {
			log.warn("OssResource 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(OssResourceModel model) throws BusinessException {
		log.info("OssResource 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		OssResourceModel model = super.selectById(id);
		if(model == null) {
			log.error("OssResource 开启操作,ID[{}]未查询到数据信息" , id);
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
		OssResourceModel model = super.selectById(id);
		if(model == null) {
			log.error("OssResource 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<OssResourceView> getByPage(OssResourceDto dto) throws BusinessException {
		startPage(dto);
		List<OssResourceView> ret = this.mapper.getByPage(dto);
		PageUtils<OssResourceView> pages =  new PageUtils<OssResourceView>(ret);
		return pages;
	}
	
	@Override
	public List<OssResourceModel> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<OssResourceModel> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<OssResourceModel>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<OssResourceModel> listAll() throws BusinessException {
		List<OssResourceModel> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<OssResourceModel>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(OssResourceModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("OssResource 修改失败;传入对象为空");
			return false;
		}
		OssResourceModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("OssResource 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		OssResourceModel uModel = new OssResourceModel();
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
