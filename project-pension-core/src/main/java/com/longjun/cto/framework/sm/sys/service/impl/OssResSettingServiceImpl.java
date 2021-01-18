package com.longjun.cto.framework.sm.sys.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResSettingDto;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResSettingModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.OssResSettingModel;
import com.longjun.cto.framework.sm.sys.entity.view.OssResSettingView;
import com.longjun.cto.framework.sm.sys.mapper.OssResSettingMapper;
import com.longjun.cto.framework.sm.sys.service.IOssResSettingService;

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
 * OssResSettingServiceImpl
 * @author yangxuan
 * @date 2019-04-16 06:45:48
 */
 @Service
public class OssResSettingServiceImpl  extends 
					BaseServiceImpl<OssResSettingMapper , OssResSettingModel> 
						implements IOssResSettingService {

	@Autowired
	OssResSettingMapper mapper;
	
	@Override
	public OssResSettingView findViewById(long id) throws BusinessException {
		OssResSettingView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public OssResSettingModel findModelById(long id) throws BusinessException {
		OssResSettingModel model = this.selectById(id);
		if(model == null) {
			log.warn("OssResSetting 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(OssResSettingModel model) throws BusinessException {
		log.info("OssResSetting 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setStatus(1);
		model.setIsDel(0);
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		OssResSettingModel model = super.selectById(id);
		if(model == null) {
			log.error("OssResSetting 开启操作,ID[{}]未查询到数据信息" , id);
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
		OssResSettingModel model = super.selectById(id);
		if(model == null) {
			log.error("OssResSetting 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<OssResSettingView> getByPage(OssResSettingDto dto) throws BusinessException {
		startPage(dto);
		List<OssResSettingView> ret = this.mapper.getByPage(dto);
		PageUtils<OssResSettingView> pages =  new PageUtils<OssResSettingView>(ret);
		return pages;
	}
	
	@Override
	public List<OssResSettingView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<OssResSettingView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<OssResSettingView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<OssResSettingView> listAll() throws BusinessException {
		List<OssResSettingView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<OssResSettingView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(OssResSettingModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("OssResSetting 修改失败;传入对象为空");
			return false;
		}
		OssResSettingModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("OssResSetting 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		OssResSettingModel uModel = new OssResSettingModel();
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
	public List<OssResSettingModel> listByPid(long pId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("p_id", pId).eq("status", 1).eq("is_del", 0);
		List<OssResSettingModel> rets = super.selectList(ew);
		return rets;
	}
	
}
