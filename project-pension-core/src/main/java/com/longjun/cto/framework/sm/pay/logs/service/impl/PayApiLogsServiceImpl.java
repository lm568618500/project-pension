package com.longjun.cto.framework.sm.pay.logs.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.pay.logs.PayApiCmd;
import com.longjun.cto.framework.sm.pay.logs.entity.dto.PayApiLogsDto;
import com.longjun.cto.framework.sm.pay.logs.entity.dto.PayApiLogsModifyDto;
import com.longjun.cto.framework.sm.pay.logs.entity.model.PayApiLogsModel;
import com.longjun.cto.framework.sm.pay.logs.entity.view.PayApiLogsView;
import com.longjun.cto.framework.sm.pay.logs.mapper.PayApiLogsMapper;
import com.longjun.cto.framework.sm.pay.logs.service.IPayApiLogsService;

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
 * PayApiLogsServiceImpl
 * 
 * @author yangxuan
 * @date 2019-11-07 05:48:12
 */
@Service
public class PayApiLogsServiceImpl extends BaseServiceImpl<PayApiLogsMapper, PayApiLogsModel>
		implements IPayApiLogsService {

	@Autowired
	PayApiLogsMapper mapper;

	@Override
	public void writeLogs(int payChannal, PayApiCmd cmd, String outTradeNo, String tradeNo, String request,
			String response) throws BusinessException {
		PayApiLogsModel model = new PayApiLogsModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setStatus(1);
		model.setIsDel(0);
		model.setRequest(request);
		model.setResponse(response);
		model.setPayChannal(payChannal);
		model.setApiCmd(cmd.getCmd());
		model.setOutTradeNo(outTradeNo);
		model.setTradeNo(tradeNo);
		super.insert(model);
	}

}
