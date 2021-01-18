package com.longjun.cto.framework.sm.pay.logs.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.logs.PayApiCmd;
import com.longjun.cto.framework.sm.pay.logs.entity.model.PayApiLogsModel;

/**
 * PayApiLogsModel
 * 
 * @author yangxuan
 * @date 2019-11-07 05:48:12
 */
public interface IPayApiLogsService extends BaseService<PayApiLogsModel> {

	/**
	 * 记录日志
	 * 
	 * @param payChannel 1、微信 2、支付宝 3、银联
	 * @param cmd
	 * @param out_trade_no
	 * @param trade_no
	 * @param request
	 * @param response
	 * @throws BusinessException
	 */
	public void writeLogs(int payChannal, PayApiCmd cmd, String out_trade_no, String trade_no, String request,
			String response) throws BusinessException;
}
