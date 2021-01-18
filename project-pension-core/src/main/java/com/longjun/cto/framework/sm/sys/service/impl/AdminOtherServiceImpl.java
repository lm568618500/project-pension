package com.longjun.cto.framework.sm.sys.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminOtherDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminOtherModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminOtherModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminOtherView;
import com.longjun.cto.framework.sm.sys.mapper.AdminOtherMapper;
import com.longjun.cto.framework.sm.sys.service.IAdminOtherService;

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
 * AdminOtherServiceImpl
 * @author liuming
 * @date 2019-10-05 04:51:18
 */
 @Service
public class AdminOtherServiceImpl  extends 
					BaseServiceImpl<AdminOtherMapper , AdminOtherModel> 
						implements IAdminOtherService {

	@Autowired
	AdminOtherMapper mapper;
	
	@Override
	public AdminOtherView findViewById(long id) throws BusinessException {
		AdminOtherView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public AdminOtherModel findModelById(long id) throws BusinessException {
		AdminOtherModel model = this.selectById(id);
		if(model == null) {
			log.warn("AdminOther 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(AdminOtherModel model) throws BusinessException {
		log.info("AdminOther 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		AdminOtherModel model = super.selectById(id);
		if(model == null) {
			log.error("AdminOther 开启操作,ID[{}]未查询到数据信息" , id);
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
		AdminOtherModel model = super.selectById(id);
		if(model == null) {
			log.error("AdminOther 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<AdminOtherView> getByPage(AdminOtherDto dto) throws BusinessException {
		startPage(dto);
		List<AdminOtherView> ret = this.mapper.getByPage(dto);
		PageUtils<AdminOtherView> pages =  new PageUtils<AdminOtherView>(ret);
		return pages;
	}
	
	@Override
	public List<AdminOtherView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<AdminOtherView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<AdminOtherView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<AdminOtherView> listAll() throws BusinessException {
		List<AdminOtherView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<AdminOtherView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(AdminOtherModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("AdminOther 修改失败;传入对象为空");
			return false;
		}
		AdminOtherModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("AdminOther 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		AdminOtherModel uModel = new AdminOtherModel();
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
	public PageUtils<AdminOtherView> getByAdminPage(AdminOtherDto dto) {
		startPage(dto);
		List<AdminOtherView> ret = this.mapper.getByAdminPage(dto);
		PageUtils<AdminOtherView> pages =  new PageUtils<AdminOtherView>(ret);
		return pages;
	}
	
}
