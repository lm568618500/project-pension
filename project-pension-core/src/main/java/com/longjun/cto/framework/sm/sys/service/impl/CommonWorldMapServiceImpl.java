package com.longjun.cto.framework.sm.sys.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonWorldMapDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonWorldMapModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonWorldMapModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonWorldMapView;
import com.longjun.cto.framework.sm.sys.mapper.CommonWorldMapMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonWorldMapService;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * CommonWorldMapServiceImpl
 * @author liuming
 * @date 2019-11-08 03:56:49
 */
 @Service
public class CommonWorldMapServiceImpl  extends 
					BaseServiceImpl<CommonWorldMapMapper , CommonWorldMapModel> 
						implements ICommonWorldMapService {

	@Autowired
	CommonWorldMapMapper mapper;
	
	@Override
	public CommonWorldMapView findViewById(long id) throws BusinessException {
		CommonWorldMapView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CommonWorldMapModel findModelById(long id) throws BusinessException {
		CommonWorldMapModel model = this.selectById(id);
		if(model == null) {
			log.warn("CommonWorldMap 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CommonWorldMapModel model) throws BusinessException {
		log.info("CommonWorldMap 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		CommonWorldMapModel model = super.selectById(id);
		if(model == null) {
			log.error("CommonWorldMap 开启操作,ID[{}]未查询到数据信息" , id);
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
		CommonWorldMapModel model = super.selectById(id);
		if(model == null) {
			log.error("CommonWorldMap 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<CommonWorldMapView> getByPage(CommonWorldMapDto dto) throws BusinessException {
		startPage(dto);
		List<CommonWorldMapView> ret = this.mapper.getByPage(dto);
		PageUtils<CommonWorldMapView> pages =  new PageUtils<CommonWorldMapView>(ret);
		return pages;
	}
	
	@Override
	public List<CommonWorldMapView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CommonWorldMapView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<CommonWorldMapView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CommonWorldMapView> listAll() throws BusinessException {
		List<CommonWorldMapView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<CommonWorldMapView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(CommonWorldMapModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("CommonWorldMap 修改失败;传入对象为空");
			return false;
		}
		CommonWorldMapModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("CommonWorldMap 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		CommonWorldMapModel uModel = new CommonWorldMapModel();
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
