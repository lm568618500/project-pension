package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonCityDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonCityModifyDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonProvinceDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonCityModel;
import com.longjun.cto.framework.sm.sys.entity.model.CommonProvinceModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonCityView;
import com.longjun.cto.framework.sm.sys.mapper.CommonCityMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonCityService;

/**
 * CommonCityServiceImpl
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
 @Service
public class CommonCityServiceImpl  extends 
					BaseServiceImpl<CommonCityMapper , CommonCityModel> 
						implements ICommonCityService {

	@Autowired
	CommonCityMapper mapper;
	
	@Override
	public CommonCityView findViewById(long id) throws BusinessException {
		CommonCityView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CommonCityModel findModelById(long id) throws BusinessException {
		CommonCityModel model = this.selectById(id);
		if(model == null) {
			log.warn("CommonCity 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CommonCityModel model) throws BusinessException {
		log.info("CommonCity 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		CommonCityModel model = super.selectById(id);
		if(model == null) {
			log.error("CommonCity 开启操作,ID[{}]未查询到数据信息" , id);
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
		CommonCityModel model = super.selectById(id);
		if(model == null) {
			log.error("CommonCity 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<CommonCityView> getByPage(CommonCityDto dto) throws BusinessException {
		startPage(dto);
		List<CommonCityView> ret = this.mapper.getByPage(dto);
		PageUtils<CommonCityView> pages =  new PageUtils<CommonCityView>(ret);
		return pages;
	}
	
	@Override
	public List<CommonCityView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CommonCityView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<CommonCityView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CommonCityView> listAll() throws BusinessException {
		List<CommonCityView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<CommonCityView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(CommonCityModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("CommonCity 修改失败;传入对象为空");
			return false;
		}
		CommonCityModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("CommonCity 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		CommonCityModel uModel = new CommonCityModel();
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
	public List<CommonCityModel> listByUse() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", USE);
		List<CommonCityModel> rets = super.selectList(ew);
		return rets;
	}

	@Override
	public List<CommonCityModel> listByUseProvinceId(long provinceId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", USE).eq("province_id", provinceId);
		List<CommonCityModel> rets = super.selectList(ew);
		return rets;
	}
	
	@Override
	public List<Map<String,Object>> getCityByPId(String proviceId) throws BusinessException {
		List<Map<String,Object>> ret = this.mapper.getCityByPId(proviceId);
		return ret;
	}

	@Override
	public CommonCityModel findByUseId(long useId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", USE).eq("use_id", useId);
		CommonCityModel ret = super.selectOne(ew);
		return ret;
	}
	
}
