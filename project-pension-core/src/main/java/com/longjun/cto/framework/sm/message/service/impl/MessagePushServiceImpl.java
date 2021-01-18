package com.longjun.cto.framework.sm.message.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.message.entity.dto.MessagePushDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessagePushModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageEmailModel;
import com.longjun.cto.framework.sm.message.entity.model.MessagePushModel;
import com.longjun.cto.framework.sm.message.entity.view.MessagePushView;
import com.longjun.cto.framework.sm.message.mapper.MessagePushMapper;
import com.longjun.cto.framework.sm.message.service.IMessageApiService;
import com.longjun.cto.framework.sm.message.service.IMessagePushService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;

/**
 * MessagePushServiceImpl
 * 
 * @author yangxuan
 * @date 2019-05-30 09:21:36
 */
@Service
public class MessagePushServiceImpl extends BaseServiceImpl<MessagePushMapper, MessagePushModel>
		implements IMessagePushService {

	@Autowired
	private MessagePushMapper mapper;

	@Autowired
	private IMessageApiService iMessageApiService;

	@Override
	public MessagePushView findViewById(long id) throws BusinessException {
		MessagePushView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public MessagePushModel findModelById(long id) throws BusinessException {
		MessagePushModel model = this.selectById(id);
		if (model == null) {
			log.warn("MessagePush 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(MessagePushModel model) throws BusinessException {
		log.info("MessagePush 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		MessagePushModel model = super.selectById(id);
		if (model == null) {
			log.error("MessagePush 开启操作,ID[{}]未查询到数据信息", id);
			return false;
		}
		if (model.getStatus() == USE) {
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
		MessagePushModel model = super.selectById(id);
		if (model == null) {
			log.error("MessagePush 停止操作,ID[{}]未查询到数据信息", id);
			return false;
		}
		if (model.getStatus() == UNUSE) {
			return true;
		}
		model.setStatus(UNUSE);
		boolean ret = super.updateById(model);
		return ret;
	}

	@Override
	public PageUtils<MessagePushView> getByPage(MessagePushDto dto) throws BusinessException {
		startPage(dto);
		List<MessagePushView> ret = this.mapper.getByPage(dto);
		PageUtils<MessagePushView> pages = new PageUtils<MessagePushView>(ret);
		return pages;
	}

	@Override
	public List<MessagePushView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<MessagePushView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<MessagePushView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<MessagePushView> listAll() throws BusinessException {
		List<MessagePushView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<MessagePushView>();
		}
		return rets;
	}

	@Override
	public boolean modify(MessagePushModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("MessagePush 修改失败;传入对象为空");
			return false;
		}
		MessagePushModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("MessagePush 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		MessagePushModel uModel = new MessagePushModel();
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
	public void sendJobs() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 0).eq("is_plain", 0);
		Page<MessagePushModel> pages = super.selectPage(new Page<>(0, 50), ew);
		if (pages == null) {
			return;
		}
		List<MessagePushModel> records = pages.getRecords();
		if (records == null) {
			return;
		}
		for (MessagePushModel record : records) {
			this.iMessageApiService.sendPush(record);
		}
	}

	@Override
	public void sendPushPlainJobs() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 0).eq("is_plain", 1).le("plain_time", new Date());
		Page<MessagePushModel> pages = super.selectPage(new Page<>(0, 50), ew);
		if (pages == null) {
			return;
		}
		List<MessagePushModel> records = pages.getRecords();
		if (records == null) {
			return;
		}
		for (MessagePushModel record : records) {
			this.iMessageApiService.sendPush(record);
		}
	}

}
