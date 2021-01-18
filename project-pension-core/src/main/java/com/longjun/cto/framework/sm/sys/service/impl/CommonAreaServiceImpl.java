package com.longjun.cto.framework.sm.sys.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonAreaDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonAreaModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonAreaModel;
import com.longjun.cto.framework.sm.sys.entity.model.CommonProvinceModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonAreaView;
import com.longjun.cto.framework.sm.sys.mapper.CommonAreaMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonAreaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * CommonAreaServiceImpl
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
 @Service
public class CommonAreaServiceImpl  extends 
					BaseServiceImpl<CommonAreaMapper , CommonAreaModel> 
						implements ICommonAreaService {

	@Autowired
	CommonAreaMapper mapper;
	
	@Override
	public CommonAreaView findViewById(long id) throws BusinessException {
		CommonAreaView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CommonAreaModel findModelById(long id) throws BusinessException {
		CommonAreaModel model = this.selectById(id);
		if(model == null) {
			log.warn("CommonArea 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CommonAreaModel model) throws BusinessException {
		log.info("CommonArea 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		CommonAreaModel model = super.selectById(id);
		if(model == null) {
			log.error("CommonArea 开启操作,ID[{}]未查询到数据信息" , id);
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
		CommonAreaModel model = super.selectById(id);
		if(model == null) {
			log.error("CommonArea 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<CommonAreaView> getByPage(CommonAreaDto dto) throws BusinessException {
		startPage(dto);
		List<CommonAreaView> ret = this.mapper.getByPage(dto);
		PageUtils<CommonAreaView> pages =  new PageUtils<CommonAreaView>(ret);
		return pages;
	}
	
	@Override
	public List<CommonAreaView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CommonAreaView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<CommonAreaView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CommonAreaView> listAll() throws BusinessException {
		List<CommonAreaView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<CommonAreaView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(CommonAreaModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("CommonArea 修改失败;传入对象为空");
			return false;
		}
		CommonAreaModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("CommonArea 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		CommonAreaModel uModel = new CommonAreaModel();
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
	public List<CommonAreaModel> listByUse() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", USE);
		List<CommonAreaModel> rets = super.selectList(ew);
		return rets;
	}

	@Override
	public List<CommonAreaModel> listByUseCityId(long cityId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", USE).eq("city_id", cityId);
		List<CommonAreaModel> rets = super.selectList(ew);
		return rets;
	}
	
	@Override
	public List<Map<String,Object>> getAreaByCId(String cityId) throws BusinessException {
		List<Map<String,Object>> ret = this.mapper.getAreaByCId(cityId);
		return ret;
	}

	@Override
	public CommonAreaModel findByUseId(long uesId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", USE).eq("use_id", uesId);
		CommonAreaModel ret = super.selectOne(ew);
		return ret;
	}
	
}
