package com.longjun.cto.framework.sm.pay.wechat.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatModifyDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatModel;
import com.longjun.cto.framework.sm.pay.wechat.entity.view.PayWechatView;
import com.longjun.cto.framework.sm.pay.wechat.mapper.PayWechatMapper;
import com.longjun.cto.framework.sm.pay.wechat.service.IPayWechatService;

/**
 * PayWechatServiceImpl
 * 
 * @author yangxuan
 * @date 2019-11-07 02:13:18
 */
@Service
public class PayWechatServiceImpl extends BaseServiceImpl<PayWechatMapper, PayWechatModel>
		implements IPayWechatService {

	@Autowired
	PayWechatMapper mapper;

	@Override
	public PayWechatView findViewById(long id) throws BusinessException {
		PayWechatView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayWechatModel findModelById(long id) throws BusinessException {
		PayWechatModel model = this.selectById(id);
		if (model == null) {
			log.warn("PayWechat 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayWechatModel model) throws BusinessException {
		log.info("PayWechat 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		PayWechatModel model = super.selectById(id);
		if (model == null) {
			log.error("PayWechat 开启操作,ID[{}]未查询到数据信息", id);
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
		PayWechatModel model = super.selectById(id);
		if (model == null) {
			log.error("PayWechat 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<PayWechatView> getByPage(PayWechatDto dto) throws BusinessException {
		startPage(dto);
		List<PayWechatView> ret = this.mapper.getByPage(dto);
		PageUtils<PayWechatView> pages = new PageUtils<PayWechatView>(ret);
		return pages;
	}

	@Override
	public List<PayWechatView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayWechatView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<PayWechatView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayWechatView> listAll() throws BusinessException {
		List<PayWechatView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<PayWechatView>();
		}
		return rets;
	}

	@Override
	public boolean modify(PayWechatModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("PayWechat 修改失败;传入对象为空");
			return false;
		}
		PayWechatModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("PayWechat 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayWechatModel uModel = new PayWechatModel();
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
	public boolean updatePaySuccessInfo(String outTradeNo, String transactionId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("out_trade_no", outTradeNo).eq("is_del", 0);
		PayWechatModel ret = super.selectOne(ew);
		if (ret != null) {
			ret.setPayStatus(1);
			ret.setPaySuccessTime(new Date());
			ret.setTransactionId(transactionId);
			super.updateById(ret);
		}
		return true;
	}

	@Override
	public boolean failOutTradeNo(String outTradeNo) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("out_trade_no", outTradeNo).eq("is_del", 0);
		List<PayWechatModel> rets = super.selectList(ew);
		if (rets == null) {
			return true;
		}
		for (PayWechatModel model : rets) {
			model.setLastupdate(new Date());
			model.setIsDel(-1);
			super.updateById(model);
		}
		return true;
	}

	@Override
	public PayWechatModel findByOutTradeNo(String outTradeNo) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("out_trade_no", outTradeNo).eq("is_del", 0).eq("status", 1);
		PayWechatModel ret = super.selectOne(ew);

		return ret;
	}

}
