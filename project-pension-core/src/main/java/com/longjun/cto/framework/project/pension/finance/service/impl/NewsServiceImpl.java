package com.longjun.cto.framework.project.pension.finance.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewsDto;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewsModifyDto;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewsModel;
import com.longjun.cto.framework.project.pension.finance.entity.view.NewsView;
import com.longjun.cto.framework.project.pension.finance.mapper.NewsMapper;
import com.longjun.cto.framework.project.pension.finance.service.INewsService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * NewsServiceImpl
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
 @Service
public class NewsServiceImpl  extends 
					BaseServiceImpl<NewsMapper , NewsModel> 
						implements INewsService {

	@Autowired
	NewsMapper mapper;
	
	@Override
	public NewsView findViewById(long id) throws BusinessException {
		NewsView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public NewsModel findModelById(long id) throws BusinessException {
		NewsModel model = this.selectById(id);
		if(model == null) {
			log.warn("News 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(NewsModel model) throws BusinessException {
		log.info("News 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		NewsModel model = super.selectById(id);
		if(model == null) {
			log.error("News 开启操作,ID[{}]未查询到数据信息" , id);
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
		NewsModel model = super.selectById(id);
		if(model == null) {
			log.error("News 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<NewsView> getByPage(NewsDto dto) throws BusinessException {
		startPage(dto);
		List<NewsView> ret = this.mapper.getByPage(dto);
		PageUtils<NewsView> pages =  new PageUtils<NewsView>(ret);
		return pages;
	}
	
	@Override
	public List<NewsView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<NewsView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<NewsView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<NewsView> listAll() throws BusinessException {
		List<NewsView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<NewsView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(NewsModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("News 修改失败;传入对象为空");
			return false;
		}
		NewsModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("News 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		NewsModel uModel = new NewsModel();
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
