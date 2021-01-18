package com.longjun.cto.framework.sm.pay.union.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionRefundDto;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionRefundModifyDto;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionRefundModel;
import com.longjun.cto.framework.sm.pay.union.entity.view.UnionRefundView;
import com.longjun.cto.framework.sm.pay.union.mapper.UnionRefundMapper;
import com.longjun.cto.framework.sm.pay.union.service.IUnionRefundService;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * UnionRefundServiceImpl
 * 
 * @author yangxuan
 * @date 2019-11-02 10:59:36
 */
@Service
public class UnionRefundServiceImpl extends BaseServiceImpl<UnionRefundMapper, UnionRefundModel>
		implements IUnionRefundService {

	@Autowired
	UnionRefundMapper mapper;

	@Override
	public UnionRefundView findViewById(long id) throws BusinessException {
		UnionRefundView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public UnionRefundModel findModelById(long id) throws BusinessException {
		UnionRefundModel model = this.selectById(id);
		if (model == null) {
			log.warn("UnionRefund 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(UnionRefundModel model) throws BusinessException {
		log.info("UnionRefund 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		UnionRefundModel model = super.selectById(id);
		if (model == null) {
			log.error("UnionRefund 开启操作,ID[{}]未查询到数据信息", id);
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
		UnionRefundModel model = super.selectById(id);
		if (model == null) {
			log.error("UnionRefund 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<UnionRefundView> getByPage(UnionRefundDto dto) throws BusinessException {
		startPage(dto);
		List<UnionRefundView> ret = this.mapper.getByPage(dto);
		PageUtils<UnionRefundView> pages = new PageUtils<UnionRefundView>(ret);
		return pages;
	}

	@Override
	public List<UnionRefundView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<UnionRefundView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<UnionRefundView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<UnionRefundView> listAll() throws BusinessException {
		List<UnionRefundView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<UnionRefundView>();
		}
		return rets;
	}

	@Override
	public boolean modify(UnionRefundModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("UnionRefund 修改失败;传入对象为空");
			return false;
		}
		UnionRefundModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("UnionRefund 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		UnionRefundModel uModel = new UnionRefundModel();
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
	public UnionRefundModel findByOrderNo(String orderNo) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("order_no", orderNo);
		UnionRefundModel ret = super.selectOne(ew);
		return ret;
	}

}
