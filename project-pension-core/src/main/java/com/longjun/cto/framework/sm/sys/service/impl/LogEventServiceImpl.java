package com.longjun.cto.framework.sm.sys.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.LogEventDto;
import com.longjun.cto.framework.sm.sys.entity.dto.LogEventModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.LogEventModel;
import com.longjun.cto.framework.sm.sys.entity.view.LogEventView;
import com.longjun.cto.framework.sm.sys.mapper.LogEventMapper;
import com.longjun.cto.framework.sm.sys.service.ILogEventService;

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
 * LogEventServiceImpl
 * @author yangxuan
 * @date 2019-04-09 01:48:27
 */
 @Service
public class LogEventServiceImpl  extends 
					BaseServiceImpl<LogEventMapper , LogEventModel> 
						implements ILogEventService {

	@Autowired
	LogEventMapper mapper;
	
	@Override
	public LogEventView findViewById(long id) throws BusinessException {
		LogEventView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public LogEventModel findModelById(long id) throws BusinessException {
		LogEventModel model = this.selectById(id);
		if(model == null) {
			log.warn("LogEvent 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(LogEventModel model) throws BusinessException {
		log.info("LogEvent 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		LogEventModel model = super.selectById(id);
		if(model == null) {
			log.error("LogEvent 开启操作,ID[{}]未查询到数据信息" , id);
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
		LogEventModel model = super.selectById(id);
		if(model == null) {
			log.error("LogEvent 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<LogEventView> getByPage(LogEventDto dto) throws BusinessException {
		startPage(dto);
		List<LogEventView> ret = this.mapper.getByPage(dto);
		PageUtils<LogEventView> pages =  new PageUtils<LogEventView>(ret);
		return pages;
	}
	
	@Override
	public List<LogEventView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<LogEventView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<LogEventView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<LogEventView> listAll() throws BusinessException {
		List<LogEventView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<LogEventView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(LogEventModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("LogEvent 修改失败;传入对象为空");
			return false;
		}
		LogEventModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("LogEvent 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		LogEventModel uModel = new LogEventModel();
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
	public List<LogEventModel> listModelByEtype(long etype) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("e_type", etype).eq("status", 1);
		List<LogEventModel> rets = super.selectList(ew);
		if(rets == null) {
			rets = new ArrayList<>();
		}
		return rets;
	}
	
}
