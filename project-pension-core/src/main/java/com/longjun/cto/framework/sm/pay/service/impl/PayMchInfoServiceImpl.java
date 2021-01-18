package com.longjun.cto.framework.sm.pay.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.entity.dto.PayMchInfoDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayMchInfoModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayMchInfoModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayMchInfoView;
import com.longjun.cto.framework.sm.pay.mapper.PayMchInfoMapper;
import com.longjun.cto.framework.sm.pay.service.IPayMchInfoService;

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
 * PayMchInfoServiceImpl
 * @author yangxuan
 * @date 2019-03-31 05:17:13
 */
 @Service
public class PayMchInfoServiceImpl  extends 
					BaseServiceImpl<PayMchInfoMapper , PayMchInfoModel> 
						implements IPayMchInfoService {

	@Autowired
	PayMchInfoMapper mapper;
	
	@Override
	public PayMchInfoView findViewById(long id) throws BusinessException {
		PayMchInfoView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayMchInfoModel findModelById(long id) throws BusinessException {
		PayMchInfoModel model = this.selectById(id);
		if(model == null) {
			log.warn("PayMchInfo 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayMchInfoModel model) throws BusinessException {
		log.info("PayMchInfo 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		PayMchInfoModel model = super.selectById(id);
		if(model == null) {
			log.error("PayMchInfo 开启操作,ID[{}]未查询到数据信息" , id);
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
		PayMchInfoModel model = super.selectById(id);
		if(model == null) {
			log.error("PayMchInfo 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<PayMchInfoView> getByPage(PayMchInfoDto dto) throws BusinessException {
		startPage(dto);
		List<PayMchInfoView> ret = this.mapper.getByPage(dto);
		PageUtils<PayMchInfoView> pages =  new PageUtils<PayMchInfoView>(ret);
		return pages;
	}
	
	@Override
	public List<PayMchInfoModel> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayMchInfoModel> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<PayMchInfoModel>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayMchInfoModel> listAll() throws BusinessException {
		List<PayMchInfoModel> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<PayMchInfoModel>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(PayMchInfoModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("PayMchInfo 修改失败;传入对象为空");
			return false;
		}
		PayMchInfoModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("PayMchInfo 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayMchInfoModel uModel = new PayMchInfoModel();
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
	public PayMchInfoModel getByMchId(long mchId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("mch_id", mchId);
		PayMchInfoModel ret =super.selectOne(ew);
		return ret;
	}

	@Override
	public PayMchInfoModel defaultMchInfo() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 1).eq("is_del", 0);
		PayMchInfoModel ret = super.selectOne(ew);
		if(ret == null) {
			log.error("未查询到可用默认商户配置");
		}
		return ret;
	}
	
}
