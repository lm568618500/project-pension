package com.longjun.cto.framework.sm.sys.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResStoreDto;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResStoreModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.OssResStoreModel;
import com.longjun.cto.framework.sm.sys.entity.view.OssResStoreView;
import com.longjun.cto.framework.sm.sys.mapper.OssResStoreMapper;
import com.longjun.cto.framework.sm.sys.service.IOssResStoreService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * OssResStoreServiceImpl
 * @author yangxuan
 * @date 2019-04-16 06:45:47
 */
 @Service
public class OssResStoreServiceImpl  extends 
					BaseServiceImpl<OssResStoreMapper , OssResStoreModel> 
						implements IOssResStoreService {

	@Autowired
	OssResStoreMapper mapper;
	
	@Override
	public OssResStoreView findViewById(long id) throws BusinessException {
		OssResStoreView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public OssResStoreModel findModelById(long id) throws BusinessException {
		OssResStoreModel model = this.selectById(id);
		if(model == null) {
			log.warn("OssResStore 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(OssResStoreModel model) throws BusinessException {
		log.info("OssResStore 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		OssResStoreModel model = super.selectById(id);
		if(model == null) {
			log.error("OssResStore 开启操作,ID[{}]未查询到数据信息" , id);
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
		OssResStoreModel model = super.selectById(id);
		if(model == null) {
			log.error("OssResStore 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<OssResStoreView> getByPage(OssResStoreDto dto) throws BusinessException {
		startPage(dto);
		List<OssResStoreView> ret = this.mapper.getByPage(dto);
		PageUtils<OssResStoreView> pages =  new PageUtils<OssResStoreView>(ret);
		return pages;
	}
	
	@Override
	public List<OssResStoreView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<OssResStoreView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<OssResStoreView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<OssResStoreView> listAll() throws BusinessException {
		List<OssResStoreView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<OssResStoreView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(OssResStoreModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("OssResStore 修改失败;传入对象为空");
			return false;
		}
		OssResStoreModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("OssResStore 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		OssResStoreModel uModel = new OssResStoreModel();
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
