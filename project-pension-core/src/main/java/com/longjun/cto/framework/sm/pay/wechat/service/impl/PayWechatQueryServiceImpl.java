package com.longjun.cto.framework.sm.pay.wechat.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatQueryDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatQueryModifyDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatQueryModel;
import com.longjun.cto.framework.sm.pay.wechat.entity.view.PayWechatQueryView;
import com.longjun.cto.framework.sm.pay.wechat.mapper.PayWechatQueryMapper;
import com.longjun.cto.framework.sm.pay.wechat.service.IPayWechatQueryService;

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
 * PayWechatQueryServiceImpl
 * 
 * @author yangxuan
 * @date 2019-11-07 04:30:51
 */
@Service
public class PayWechatQueryServiceImpl extends BaseServiceImpl<PayWechatQueryMapper, PayWechatQueryModel>
		implements IPayWechatQueryService {

	@Autowired
	PayWechatQueryMapper mapper;

	@Override
	public PayWechatQueryView findViewById(long id) throws BusinessException {
		PayWechatQueryView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayWechatQueryModel findModelById(long id) throws BusinessException {
		PayWechatQueryModel model = this.selectById(id);
		if (model == null) {
			log.warn("PayWechatQuery 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayWechatQueryModel model) throws BusinessException {
		log.info("PayWechatQuery 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		PayWechatQueryModel model = super.selectById(id);
		if (model == null) {
			log.error("PayWechatQuery 开启操作,ID[{}]未查询到数据信息", id);
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
		PayWechatQueryModel model = super.selectById(id);
		if (model == null) {
			log.error("PayWechatQuery 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<PayWechatQueryView> getByPage(PayWechatQueryDto dto) throws BusinessException {
		startPage(dto);
		List<PayWechatQueryView> ret = this.mapper.getByPage(dto);
		PageUtils<PayWechatQueryView> pages = new PageUtils<PayWechatQueryView>(ret);
		return pages;
	}

	@Override
	public List<PayWechatQueryView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayWechatQueryView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<PayWechatQueryView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayWechatQueryView> listAll() throws BusinessException {
		List<PayWechatQueryView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<PayWechatQueryView>();
		}
		return rets;
	}

	@Override
	public boolean modify(PayWechatQueryModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("PayWechatQuery 修改失败;传入对象为空");
			return false;
		}
		PayWechatQueryModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("PayWechatQuery 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayWechatQueryModel uModel = new PayWechatQueryModel();
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
	public PayWechatQueryModel findBySuccessOutTradeNo(String outTradeNo) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("out_trade_no", outTradeNo).eq("trade_state", "SUCCESS");
		PayWechatQueryModel ret = super.selectOne(ew);
		return ret;
	}

}
