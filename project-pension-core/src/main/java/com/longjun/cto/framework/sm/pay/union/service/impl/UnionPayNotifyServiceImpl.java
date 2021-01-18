package com.longjun.cto.framework.sm.pay.union.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.union.bean.UnionPayNotifyBean;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionPayNotifyDto;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionPayNotifyModifyDto;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionPayNotifyModel;
import com.longjun.cto.framework.sm.pay.union.entity.view.UnionPayNotifyView;
import com.longjun.cto.framework.sm.pay.union.mapper.UnionPayNotifyMapper;
import com.longjun.cto.framework.sm.pay.union.service.IUnionPayNotifyService;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * UnionPayNotifyServiceImpl
 * 
 * @author yangxuan
 * @date 2019-10-30 07:39:43
 */
@Service
public class UnionPayNotifyServiceImpl extends BaseServiceImpl<UnionPayNotifyMapper, UnionPayNotifyModel>
		implements IUnionPayNotifyService {

	@Autowired
	UnionPayNotifyMapper mapper;

	@Override
	public UnionPayNotifyView findViewById(long id) throws BusinessException {
		UnionPayNotifyView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public UnionPayNotifyModel findModelById(long id) throws BusinessException {
		UnionPayNotifyModel model = this.selectById(id);
		if (model == null) {
			log.warn("UnionPayNotify 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public boolean start(long id) throws BusinessException {
		UnionPayNotifyModel model = super.selectById(id);
		if (model == null) {
			log.error("UnionPayNotify 开启操作,ID[{}]未查询到数据信息", id);
			return false;
		}
		if (model.getStatus() == USE) {
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
		UnionPayNotifyModel model = super.selectById(id);
		if (model == null) {
			log.error("UnionPayNotify 停止操作,ID[{}]未查询到数据信息", id);
			return false;
		}
		if (model.getStatus() == UNUSE) {
			return true;
		}
		model.setStatus(UNUSE);
		model.setLastupdate(new Date());
		boolean ret = super.updateById(model);
		return ret;
	}

	@Override
	public PageUtils<UnionPayNotifyView> getByPage(UnionPayNotifyDto dto) throws BusinessException {
		startPage(dto);
		List<UnionPayNotifyView> ret = this.mapper.getByPage(dto);
		PageUtils<UnionPayNotifyView> pages = new PageUtils<UnionPayNotifyView>(ret);
		return pages;
	}

	@Override
	public List<UnionPayNotifyView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<UnionPayNotifyView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<UnionPayNotifyView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<UnionPayNotifyView> listAll() throws BusinessException {
		List<UnionPayNotifyView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<UnionPayNotifyView>();
		}
		return rets;
	}

	@Override
	public boolean modify(UnionPayNotifyModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("UnionPayNotify 修改失败;传入对象为空");
			return false;
		}
		UnionPayNotifyModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("UnionPayNotify 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		UnionPayNotifyModel uModel = new UnionPayNotifyModel();
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
	public UnionPayNotifyModel findByOrderNo(String orderNo, String transtype) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("body_orderno", orderNo).eq("header_transtype", transtype);
		UnionPayNotifyModel ret = super.selectOne(ew);
		return ret;
	}

}
