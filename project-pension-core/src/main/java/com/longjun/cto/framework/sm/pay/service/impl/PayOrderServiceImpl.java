package com.longjun.cto.framework.sm.pay.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.entity.dto.PayOrderDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayOrderModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayOrderModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayOrderView;
import com.longjun.cto.framework.sm.pay.mapper.PayOrderMapper;
import com.longjun.cto.framework.sm.pay.service.IPayOrderService;

import java.util.List;

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
 * PayOrderServiceImpl
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
 @Service
public class PayOrderServiceImpl  extends 
					BaseServiceImpl<PayOrderMapper , PayOrderModel> 
						implements IPayOrderService {

	@Autowired
	PayOrderMapper mapper;
	
	@Override
	public PayOrderView findViewById(long id) throws BusinessException {
		PayOrderView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public PayOrderModel findModelById(long id) throws BusinessException {
		PayOrderModel model = this.selectById(id);
		if(model == null) {
			log.warn("PayOrder 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(PayOrderModel model) throws BusinessException {
		log.info("PayOrder 数据新增 -> [{}]" , JSONObject.toJSONString(model));
		super.insert(model);	
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		PayOrderModel model = super.selectById(id);
		if(model == null) {
			log.error("PayOrder 开启操作,ID[{}]未查询到数据信息" , id);
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
		PayOrderModel model = super.selectById(id);
		if(model == null) {
			log.error("PayOrder 停止操作,ID[{}]未查询到数据信息" , id);
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
	public PageUtils<PayOrderView> getByPage(PayOrderDto dto) throws BusinessException {
		startPage(dto);
		List<PayOrderView> ret = this.mapper.getByPage(dto);
		PageUtils<PayOrderView> pages =  new PageUtils<PayOrderView>(ret);
		return pages;
	}
	
	@Override
	public List<PayOrderView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<PayOrderView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<PayOrderView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<PayOrderView> listAll() throws BusinessException {
		List<PayOrderView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<PayOrderView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(PayOrderModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("PayOrder 修改失败;传入对象为空");
			return false;
		}
		PayOrderModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("PayOrder 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		PayOrderModel uModel = new PayOrderModel();
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
	public synchronized boolean orderNotify(long id) throws BusinessException {
		boolean ret = this.orderNotify(id);
		return ret;
	}
	
	synchronized boolean buzNotify(long id) {
		if(id < 1) {
			log.error("订单业务通知失败;未查询到ID[{}]支付订单记录",id);
			throw new BusinessException("订单业务通知失败;未查询到ID["+id+"]支付订单记录");
		}
		PayOrderModel ret = super.selectById(id);
		if(ret == null) {
			log.error("订单业务通知失败;未查询到ID[{}]支付订单记录",id);
			throw new BusinessException("订单业务通知失败;未查询到ID["+id+"]支付订单记录");
		}
		
		//支付状态,0-订单生成,1-支付中(目前未使用),2-支付成功,3-业务处理完成
		int status = ret.getStatus();
		if(status == 3 || status == 2) {
			
			//TODO 异步通知
			
		}else {
			log.error("订单业务通知失败;订单ID[{}]支付订单状态异常",id);
			throw new BusinessException("订单业务通知失败;订单ID["+id+"]支付订单状态异常");
		}
		return true;
	}

	@Override
	public PayOrderModel findByMchOrderNo(long mchOrderNo) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("mch_order_no", mchOrderNo).orderBy("id", true);
		PayOrderModel ret = super.selectOne(ew);
		return ret;
	}

	@Override
	public PayOrderModel findByPayOrderId(long payOrderId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("pay_order_id", payOrderId).orderBy("id", true);
		PayOrderModel ret = super.selectOne(ew);
		return ret;
	}

	@Override
	public synchronized boolean orderPaySuccess(long outTradeNo, String body) throws BusinessException {
		if(outTradeNo < 0) {
			log.error("订单支付失败;订单号非法;outTradeNo[{}]", outTradeNo);
			
			return false;
		}
		//支付状态,0-订单生成,1-支付中(目前未使用),2-支付成功,3-业务处理完成
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("pay_order_id", outTradeNo);
		PayOrderModel payOrderModel = super.selectOne(ew);
		if(payOrderModel == null) {
			log.error("订单支付失败;未查询到订单号数据;支付订单号pay_order_id(outTradeNo)[{}]",outTradeNo);
			return false;
		}
		int status = payOrderModel.getStatus().intValue();
		if(status == 2 || status == 3) {
			String statusStr = status == 2 ? "已支付成功" : "业务处理完成";
			log.info("订单支付成功；支付订单[{}]业务已经处理完成;订单状态[{}]" , outTradeNo , statusStr);
			return true;
		}
		//处理成功;将支付状态修改为已支付
		if(status == 1) {
			payOrderModel.setStatus(2);
			payOrderModel.setPaySuccTime(new Date());
			payOrderModel.setNotifyCount(payOrderModel.getNotifyCount() + 1);
			payOrderModel.setNotifyXml(body);
			payOrderModel.setLastNotifyTime(new Date());
			payOrderModel.setLastupdate(new Date());
			super.updateById(payOrderModel);
			return true;
		}
		return false;
	}
	
}
