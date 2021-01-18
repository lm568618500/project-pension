package com.longjun.cto.framework.sm.pay.wechat.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatNotifyDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatNotifyModifyDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatNotifyModel;
import com.longjun.cto.framework.sm.pay.wechat.entity.view.PayWechatNotifyView;
import com.longjun.cto.framework.sm.pay.wechat.mapper.PayWechatNotifyMapper;
import com.longjun.cto.framework.sm.pay.wechat.service.IPayWechatNotifyService;

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
 * PayWechatNotifyServiceImpl
 * @author yangxuan
 * @date 2019-11-07 02:51:58
 */
 @Service
public class PayWechatNotifyServiceImpl  extends 
					BaseServiceImpl<PayWechatNotifyMapper , PayWechatNotifyModel> 
						implements IPayWechatNotifyService {

	@Autowired
	PayWechatNotifyMapper mapper;
	
	@Override
	public PayWechatNotifyView findViewById(long id) throws BusinessException {
		PayWechatNotifyView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayWechatNotifyModel findModelById(long id) throws BusinessException {
		PayWechatNotifyModel model = this.selectById(id);
		if(model == null) {
			log.warn("PayWechatNotify 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayWechatNotifyModel model) throws BusinessException {
		log.info("PayWechatNotify 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		PayWechatNotifyModel model = super.selectById(id);
		if(model == null) {
			log.error("PayWechatNotify 开启操作,ID[{}]未查询到数据信息" , id);
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
		PayWechatNotifyModel model = super.selectById(id);
		if(model == null) {
			log.error("PayWechatNotify 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<PayWechatNotifyView> getByPage(PayWechatNotifyDto dto) throws BusinessException {
		startPage(dto);
		List<PayWechatNotifyView> ret = this.mapper.getByPage(dto);
		PageUtils<PayWechatNotifyView> pages =  new PageUtils<PayWechatNotifyView>(ret);
		return pages;
	}
	
	@Override
	public List<PayWechatNotifyView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayWechatNotifyView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<PayWechatNotifyView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayWechatNotifyView> listAll() throws BusinessException {
		List<PayWechatNotifyView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<PayWechatNotifyView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(PayWechatNotifyModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("PayWechatNotify 修改失败;传入对象为空");
			return false;
		}
		PayWechatNotifyModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("PayWechatNotify 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayWechatNotifyModel uModel = new PayWechatNotifyModel();
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
