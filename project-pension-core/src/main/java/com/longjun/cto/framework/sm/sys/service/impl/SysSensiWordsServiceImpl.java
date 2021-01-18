package com.longjun.cto.framework.sm.sys.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsDto;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.SysSensiWordsModel;
import com.longjun.cto.framework.sm.sys.entity.view.SysSensiWordsView;
import com.longjun.cto.framework.sm.sys.mapper.SysSensiWordsMapper;
import com.longjun.cto.framework.sm.sys.service.ISysSensiWordsService;

import java.util.List;

import cn.hutool.core.util.StrUtil;

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
 * SysSensiWordsServiceImpl
 * @author yangxuan
 * @date 2019-04-03 08:38:00
 */
 @Service
public class SysSensiWordsServiceImpl  extends 
					BaseServiceImpl<SysSensiWordsMapper , SysSensiWordsModel> 
						implements ISysSensiWordsService {

	@Autowired
	SysSensiWordsMapper mapper;
	
	@Override
	public SysSensiWordsView findViewById(long id) throws BusinessException {
		SysSensiWordsView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public SysSensiWordsModel findModelById(long id) throws BusinessException {
		SysSensiWordsModel model = this.selectById(id);
		if(model == null) {
			log.warn("SysSensiWords 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(SysSensiWordsModel model) throws BusinessException {
		if(model == null) {
			return;
		}
		log.info("SysSensiWords 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		String words = model.getWords();
		if(StrUtil.isBlank(words)) {
			log.error("新增敏感词汇失败,敏感词数据为空");
			return;
		}
		String[] arr = words.split(",");
		if(arr == null) {
			return;
		}
		if(arr.length > 0 ) {
			for(String word : arr) {
				model = new SysSensiWordsModel();
				model.setTime(new Date());
				model.setLastupdate(new Date());
				model.setWords(StrUtil.trim(word));
				model.setStatus(USE);
				super.insert(model);	
			}
		}
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		SysSensiWordsModel model = super.selectById(id);
		if(model == null) {
			log.error("SysSensiWords 开启操作,ID[{}]未查询到数据信息" , id);
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
		SysSensiWordsModel model = super.selectById(id);
		if(model == null) {
			log.error("SysSensiWords 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<SysSensiWordsView> getByPage(SysSensiWordsDto dto) throws BusinessException {
		startPage(dto);
		List<SysSensiWordsView> ret = this.mapper.getByPage(dto);
		PageUtils<SysSensiWordsView> pages =  new PageUtils<SysSensiWordsView>(ret);
		return pages;
	}
	
	@Override
	public List<SysSensiWordsModel> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<SysSensiWordsModel> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<SysSensiWordsModel>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<SysSensiWordsModel> listAll() throws BusinessException {
//		List<SysSensiWordsModel> rets = this.mapper.listModelMap(new HashMap<>());
//		if(rets == null) {
//			return new ArrayList<SysSensiWordsModel>();
//		}
//		return rets;
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 1);
		List<SysSensiWordsModel> rets = super.selectList(ew);
		if(rets == null) {
			return new ArrayList<SysSensiWordsModel>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(SysSensiWordsModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("SysSensiWords 修改失败;传入对象为空");
			return false;
		}
		SysSensiWordsModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("SysSensiWords 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		SysSensiWordsModel uModel = new SysSensiWordsModel();
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
