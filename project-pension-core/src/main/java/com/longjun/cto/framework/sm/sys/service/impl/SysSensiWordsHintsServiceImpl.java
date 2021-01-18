package com.longjun.cto.framework.sm.sys.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.eims.cto.framework.plugins.sensiwords.BannerFilter;
import com.eims.cto.framework.plugins.sensiwords.BannerResp;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsHintsDto;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsHintsModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.SysSensiWordsHintsModel;
import com.longjun.cto.framework.sm.sys.entity.model.SysSensiWordsModel;
import com.longjun.cto.framework.sm.sys.entity.view.SysSensiWordsHintsView;
import com.longjun.cto.framework.sm.sys.mapper.SysSensiWordsHintsMapper;
import com.longjun.cto.framework.sm.sys.service.ISysSensiWordsHintsService;
import com.longjun.cto.framework.sm.sys.service.ISysSensiWordsService;

import java.util.List;

import cn.hutool.core.util.StrUtil;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * SysSensiWordsHintsServiceImpl
 * @author yangxuan
 * @date 2019-04-03 08:38:00
 */
 @Service
public class SysSensiWordsHintsServiceImpl  extends 
					BaseServiceImpl<SysSensiWordsHintsMapper , SysSensiWordsHintsModel> 
						implements ISysSensiWordsHintsService {

	@Autowired
	SysSensiWordsHintsMapper mapper;
	
	@Autowired
	ISysSensiWordsService iSysSensiWordsService;
	
	static BannerFilter filter = BannerFilter.DEFAULT;
	
//	@PostConstruct
	void fullWords() {
		log.info("关键词填充开始...");
		List<SysSensiWordsModel> rets = this.iSysSensiWordsService.listAll();
		if(rets == null) {
			return;
		}
		for(SysSensiWordsModel ret : rets) {
			if(StrUtil.isBlank(ret.getWords())) {
				continue;
			}
			filter.put(ret.getWords());
		}
		log.info("关键词填充结束...");
	}
	
	
	
	@Override
	public SysSensiWordsHintsView findViewById(long id) throws BusinessException {
		SysSensiWordsHintsView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public SysSensiWordsHintsModel findModelById(long id) throws BusinessException {
		SysSensiWordsHintsModel model = this.selectById(id);
		if(model == null) {
			log.warn("SysSensiWordsHints 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(SysSensiWordsHintsModel model) throws BusinessException {
		log.info("SysSensiWordsHints 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		SysSensiWordsHintsModel model = super.selectById(id);
		if(model == null) {
			log.error("SysSensiWordsHints 开启操作,ID[{}]未查询到数据信息" , id);
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
	public boolean stop(long id) throws BusinessException {
		SysSensiWordsHintsModel model = super.selectById(id);
		if(model == null) {
			log.error("SysSensiWordsHints 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<SysSensiWordsHintsView> getByPage(SysSensiWordsHintsDto dto) throws BusinessException {
		startPage(dto);
		List<SysSensiWordsHintsView> ret = this.mapper.getByPage(dto);
		PageUtils<SysSensiWordsHintsView> pages =  new PageUtils<SysSensiWordsHintsView>(ret);
		return pages;
	}
	
	@Override
	public List<SysSensiWordsHintsModel> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<SysSensiWordsHintsModel> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<SysSensiWordsHintsModel>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<SysSensiWordsHintsModel> listAll() throws BusinessException {
		List<SysSensiWordsHintsModel> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<SysSensiWordsHintsModel>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(SysSensiWordsHintsModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("SysSensiWordsHints 修改失败;传入对象为空");
			return false;
		}
		SysSensiWordsHintsModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("SysSensiWordsHints 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		SysSensiWordsHintsModel uModel = new SysSensiWordsHintsModel();
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
	public BannerResp hints(String words) throws BusinessException {
    	BannerResp resp = filter.process(words);
    	return resp;
	}
	
}
