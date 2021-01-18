package com.longjun.cto.framework.sm.pay.union.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionQueryDto;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionQueryModifyDto;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionQueryModel;
import com.longjun.cto.framework.sm.pay.union.entity.view.UnionQueryView;
import com.longjun.cto.framework.sm.pay.union.mapper.UnionQueryMapper;
import com.longjun.cto.framework.sm.pay.union.service.IUnionQueryService;

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
 * UnionQueryServiceImpl
 * @author yangxuan
 * @date 2019-11-02 02:52:27
 */
 @Service
public class UnionQueryServiceImpl  extends 
					BaseServiceImpl<UnionQueryMapper , UnionQueryModel> 
						implements IUnionQueryService {

	@Autowired
	UnionQueryMapper mapper;
	
	@Override
	public UnionQueryView findViewById(long id) throws BusinessException {
		UnionQueryView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public UnionQueryModel findModelById(long id) throws BusinessException {
		UnionQueryModel model = this.selectById(id);
		if(model == null) {
			log.warn("UnionQuery 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(UnionQueryModel model) throws BusinessException {
		log.info("UnionQuery 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		UnionQueryModel model = super.selectById(id);
		if(model == null) {
			log.error("UnionQuery 开启操作,ID[{}]未查询到数据信息" , id);
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
		UnionQueryModel model = super.selectById(id);
		if(model == null) {
			log.error("UnionQuery 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<UnionQueryView> getByPage(UnionQueryDto dto) throws BusinessException {
		startPage(dto);
		List<UnionQueryView> ret = this.mapper.getByPage(dto);
		PageUtils<UnionQueryView> pages =  new PageUtils<UnionQueryView>(ret);
		return pages;
	}
	
	@Override
	public List<UnionQueryView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<UnionQueryView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<UnionQueryView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<UnionQueryView> listAll() throws BusinessException {
		List<UnionQueryView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<UnionQueryView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(UnionQueryModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("UnionQuery 修改失败;传入对象为空");
			return false;
		}
		UnionQueryModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("UnionQuery 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		UnionQueryModel uModel = new UnionQueryModel();
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
