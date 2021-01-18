package com.longjun.cto.framework.sm.pay.alipay.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayOrderDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayOrderModifyDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayOrderModel;
import com.longjun.cto.framework.sm.pay.alipay.entity.view.PayAlipayOrderView;
import com.longjun.cto.framework.sm.pay.alipay.mapper.PayAlipayOrderMapper;
import com.longjun.cto.framework.sm.pay.alipay.service.IPayAlipayOrderService;

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
 * PayAlipayOrderServiceImpl
 * 
 * @author yangxuan
 * @date 2019-11-07 05:39:27
 */
@Service
public class PayAlipayOrderServiceImpl extends BaseServiceImpl<PayAlipayOrderMapper, PayAlipayOrderModel>
		implements IPayAlipayOrderService {

	@Autowired
	PayAlipayOrderMapper mapper;

	@Override
	public PayAlipayOrderView findViewById(long id) throws BusinessException {
		PayAlipayOrderView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayAlipayOrderModel findModelById(long id) throws BusinessException {
		PayAlipayOrderModel model = this.selectById(id);
		if (model == null) {
			log.warn("PayAlipayOrder 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayAlipayOrderModel model) throws BusinessException {
		log.info("PayAlipayOrder 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		PayAlipayOrderModel model = super.selectById(id);
		if (model == null) {
			log.error("PayAlipayOrder 开启操作,ID[{}]未查询到数据信息", id);
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
		PayAlipayOrderModel model = super.selectById(id);
		if (model == null) {
			log.error("PayAlipayOrder 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<PayAlipayOrderView> getByPage(PayAlipayOrderDto dto) throws BusinessException {
		startPage(dto);
		List<PayAlipayOrderView> ret = this.mapper.getByPage(dto);
		PageUtils<PayAlipayOrderView> pages = new PageUtils<PayAlipayOrderView>(ret);
		return pages;
	}

	@Override
	public List<PayAlipayOrderView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayAlipayOrderView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<PayAlipayOrderView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayAlipayOrderView> listAll() throws BusinessException {
		List<PayAlipayOrderView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<PayAlipayOrderView>();
		}
		return rets;
	}

	@Override
	public boolean modify(PayAlipayOrderModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("PayAlipayOrder 修改失败;传入对象为空");
			return false;
		}
		PayAlipayOrderModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("PayAlipayOrder 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayAlipayOrderModel uModel = new PayAlipayOrderModel();
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
	public boolean updateSuccInfo(String outTradeNo, String tradeNo) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("out_trade_no", outTradeNo).eq("is_del", 0).eq("pay_status", 0);
		PayAlipayOrderModel ret = super.selectOne(ew);
		if (ret != null) {
			ret.setLastupdate(new Date());
			ret.setPaySuccessTime(new Date());
			ret.setTransactionId(tradeNo);
			ret.setPayStatus(1);
			super.updateById(ret);
		}
		return true;
	}

	@Override
	public PayAlipayOrderModel findByOutTradeNo(String outTradeNo) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("out_trade_no", outTradeNo).eq("is_del", 0);
		PayAlipayOrderModel ret = super.selectOne(ew);
		return ret;
	}

}
