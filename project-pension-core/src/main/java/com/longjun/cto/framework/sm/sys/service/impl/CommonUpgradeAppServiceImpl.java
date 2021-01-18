package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.ArrayList;
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
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeAppDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeAppModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonUpgradeAppModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonUpgradeAppView;
import com.longjun.cto.framework.sm.sys.mapper.CommonUpgradeAppMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonUpgradeAppService;

/**
 * CommonUpgradeAppServiceImpl
 * @author yangxuan
 * @date 2019-04-09 08:42:08
 */
 @Service
public class CommonUpgradeAppServiceImpl  extends 
					BaseServiceImpl<CommonUpgradeAppMapper , CommonUpgradeAppModel> 
						implements ICommonUpgradeAppService {

	@Autowired
	CommonUpgradeAppMapper mapper;
	
	@Override
	public CommonUpgradeAppView findViewById(long id) throws BusinessException {
		CommonUpgradeAppView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CommonUpgradeAppModel findModelById(long id) throws BusinessException {
		CommonUpgradeAppModel model = this.selectById(id);
		if(model == null) {
			log.warn("CommonUpgradeApp 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CommonUpgradeAppModel model) throws BusinessException {
		log.info("CommonUpgradeApp 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		CommonUpgradeAppModel model = super.selectById(id);
		if(model == null) {
			log.error("CommonUpgradeApp 开启操作,ID[{}]未查询到数据信息" , id);
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
		CommonUpgradeAppModel model = super.selectById(id);
		if(model == null) {
			log.error("CommonUpgradeApp 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<CommonUpgradeAppView> getByPage(CommonUpgradeAppDto dto) throws BusinessException {
		startPage(dto);
		List<CommonUpgradeAppView> ret = this.mapper.getByPage(dto);
		PageUtils<CommonUpgradeAppView> pages =  new PageUtils<CommonUpgradeAppView>(ret);
		return pages;
	}
	
	@Override
	public List<CommonUpgradeAppView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CommonUpgradeAppView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<CommonUpgradeAppView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CommonUpgradeAppView> listAll() throws BusinessException {
		List<CommonUpgradeAppView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<CommonUpgradeAppView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(CommonUpgradeAppModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("CommonUpgradeApp 修改失败;传入对象为空");
			return false;
		}
		CommonUpgradeAppModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("CommonUpgradeApp 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		CommonUpgradeAppModel uModel = new CommonUpgradeAppModel();
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
