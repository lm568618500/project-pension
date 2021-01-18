package com.longjun.cto.framework.sm.sys.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonProvinceDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonProvinceModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonProvinceModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonProvinceView;
import com.longjun.cto.framework.sm.sys.mapper.CommonProvinceMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonProvinceService;

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
 * CommonProvinceServiceImpl
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
 @Service
public class CommonProvinceServiceImpl  extends 
					BaseServiceImpl<CommonProvinceMapper , CommonProvinceModel> 
						implements ICommonProvinceService {

	@Autowired
	CommonProvinceMapper mapper;
	
	@Override
	public CommonProvinceView findViewById(long id) throws BusinessException {
		CommonProvinceView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CommonProvinceModel findModelById(long id) throws BusinessException {
		CommonProvinceModel model = this.selectById(id);
		if(model == null) {
			log.warn("CommonProvince 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CommonProvinceModel model) throws BusinessException {
		log.info("CommonProvince 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		CommonProvinceModel model = super.selectById(id);
		if(model == null) {
			log.error("CommonProvince 开启操作,ID[{}]未查询到数据信息" , id);
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
		CommonProvinceModel model = super.selectById(id);
		if(model == null) {
			log.error("CommonProvince 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<CommonProvinceView> getByPage(CommonProvinceDto dto) throws BusinessException {
		startPage(dto);
		List<CommonProvinceView> ret = this.mapper.getByPage(dto);
		PageUtils<CommonProvinceView> pages =  new PageUtils<CommonProvinceView>(ret);
		return pages;
	}
	
	@Override
	public List<CommonProvinceView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CommonProvinceView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<CommonProvinceView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CommonProvinceView> listAll() throws BusinessException {
		List<CommonProvinceView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<CommonProvinceView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(CommonProvinceModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("CommonProvince 修改失败;传入对象为空");
			return false;
		}
		CommonProvinceModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("CommonProvince 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		CommonProvinceModel uModel = new CommonProvinceModel();
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
	public List<CommonProvinceModel> listByUse() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", USE);
		List<CommonProvinceModel> rets = super.selectList(ew);
		return rets;
	}
	
	@Override
	public List<Map<String,Object>> getProvice(CommonProvinceDto dto) throws BusinessException {
		List<Map<String,Object>> ret = this.mapper.getProvice(dto);
		return ret;
	}

	@Override
	public CommonProvinceModel findByUseId(long useId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", USE).eq("use_id", useId);
		CommonProvinceModel ret = super.selectOne(ew);
		return ret;
	}
	
}
