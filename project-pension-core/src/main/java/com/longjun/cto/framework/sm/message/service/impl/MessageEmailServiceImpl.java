package com.longjun.cto.framework.sm.message.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.message.entity.dto.MessageEmailDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageEmailModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageEmailModel;
import com.longjun.cto.framework.sm.message.entity.model.MessageMechModel;
import com.longjun.cto.framework.sm.message.entity.model.MessageSettingModel;
import com.longjun.cto.framework.sm.message.entity.model.MessageTempEmailModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageEmailView;
import com.longjun.cto.framework.sm.message.es.SettingTypeEnums;
import com.longjun.cto.framework.sm.message.mapper.MessageEmailMapper;
import com.longjun.cto.framework.sm.message.service.IMessageApiService;
import com.longjun.cto.framework.sm.message.service.IMessageEmailService;
import com.longjun.cto.framework.sm.message.service.IMessageMechService;
import com.longjun.cto.framework.sm.message.service.IMessageSettingService;
import com.longjun.cto.framework.sm.message.service.IMessageTempEmailService;

import cn.hutool.core.util.StrUtil;

/**
 * MessageEmailServiceImpl
 * 
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
@Service
public class MessageEmailServiceImpl extends BaseServiceImpl<MessageEmailMapper, MessageEmailModel>
		implements IMessageEmailService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MessageEmailMapper mapper;

	@Autowired
	private IMessageApiService iMessageApiService;

	@Autowired
	private IMessageMechService iMessageMechService;

	@Autowired
	private IMessageSettingService iMessageSettingService;

	@Autowired
	private IMessageTempEmailService iMessageTempEmailService;

	@Override
	public MessageEmailView findViewById(long id) throws BusinessException {
		MessageEmailView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public MessageEmailModel findModelById(long id) throws BusinessException {
		MessageEmailModel model = this.selectById(id);
		if (model == null) {
			log.warn("MessageEmail 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(MessageEmailModel model) throws BusinessException {
		model.setTempId(9999L); //自定义
		log.info("MessageEmail 数据新增 -> [{}]", JSONObject.toJSONString(model));
		Long tempId = model.getTempId();
		if (tempId < 0) {
			logger.error("邮件发送;模板tempId异常");
			throw new BusinessException("邮件发送;模板tempId异常");
		}
		// 获取商户信息
		MessageMechModel messageMechModel = this.iMessageMechService.getByOneUse();
		if (messageMechModel.getStatus() == 0) {
			logger.error("邮件发送失败,未查询到可用商户信息 ");
			throw new BusinessException("邮件发送失败,未查询到可用商户信息 ");
		}
		if (messageMechModel.getIsDel() == -1) {
			logger.error("邮件发送失败,商户信息已删除 ");
			throw new BusinessException("邮件发送失败,商户信息已删除 ");
		}
		if (messageMechModel.getSupportEmail() != 1) {
			logger.error("邮件发送失败;商户不支持邮件发送;商户ID -> {}", messageMechModel.getId());
			throw new BusinessException("邮件发送失败;商户不支持邮件发送;商户ID -> {}", messageMechModel.getId());
		}
		MessageSettingModel settingModel = this.iMessageSettingService.findByMchId2SettingType(messageMechModel.getId(),
				SettingTypeEnums.EMAIL);
		if (settingModel == null) {
			logger.error("邮件发送失败,未查询到商户接口设置信息-> [{}] ", JSONObject.toJSONString(settingModel));
			throw new BusinessException("邮件发送失败,未查询到商户接口设置信息-> [{}] ", JSONObject.toJSONString(settingModel));
		}
		EntityWrapper mtEw = new EntityWrapper<>();
		mtEw.eq("temp_uid", tempId).eq("status", 1).eq("is_del", 0);
		MessageTempEmailModel messageTempEmailModel = this.iMessageTempEmailService.selectOne(mtEw);
		if (messageTempEmailModel == null) {
			logger.error("邮件发送失败;邮件模板未查询到结果;tempId -> {}", tempId);
			throw new BusinessException("邮件发送失败;邮件模板未查询到结果;tempId -> {}", tempId);
		}

		String emails = model.getEmail();
		String[] emailArr = emails.split("\n");
		if (emailArr != null) {
			MessageEmailModel m = null;
			List<MessageEmailModel> ms = new ArrayList<MessageEmailModel>();
			for (String emailAccount : emailArr) {
				if(StrUtil.isBlank(emailAccount.trim())) {
					continue;
				}
				m = new MessageEmailModel();
				m.setTitle(model.getTitle());
				m.setContent(model.getContent());
				m.setEmail(emailAccount);
				m.setTime(new Date());
				m.setLastupdate(new Date());
				m.setStatus(0);
				m.setTempId(tempId);
				m.setMechId(messageMechModel.getId());
				m.setSettingId(settingModel.getId());
				m.setCreateTime(System.currentTimeMillis());
				ms.add(m);
			}
			super.insertBatch(ms);
		}
	}

	@Override
	public boolean start(long id) throws BusinessException {
		MessageEmailModel model = super.selectById(id);
		if (model == null) {
			log.error("MessageEmail 开启操作,ID[{}]未查询到数据信息", id);
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
		MessageEmailModel model = super.selectById(id);
		if (model == null) {
			log.error("MessageEmail 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<MessageEmailView> getByPage(MessageEmailDto dto) throws BusinessException {
		startPage(dto);
		List<MessageEmailView> ret = this.mapper.getByPage(dto);
		PageUtils<MessageEmailView> pages = new PageUtils<MessageEmailView>(ret);
		return pages;
	}

	@Override
	public List<MessageEmailModel> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<MessageEmailModel> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<MessageEmailModel>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<MessageEmailModel> listAll() throws BusinessException {
		List<MessageEmailModel> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<MessageEmailModel>();
		}
		return rets;
	}

	@Override
	public boolean modify(MessageEmailModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("MessageEmail 修改失败;传入对象为空");
			return false;
		}
		MessageEmailModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("MessageEmail 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		MessageEmailModel uModel = new MessageEmailModel();
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
	public synchronized void sendJobs() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 0);
		Page<MessageEmailModel> pages = super.selectPage(new Page<>(0, 50), ew);
		if (pages == null) {
			return;
		}
		List<MessageEmailModel> records = pages.getRecords();
		if (records == null) {
			return;
		}
		boolean ret = false;
		for (MessageEmailModel record : records) {
			ret = this.iMessageApiService.sendEmail(record);
			record.setSendTime(new Date());
			record.setStatus(ret ? 1 : -1);
			record.setLastupdate(new Date());
			super.updateById(record);
		}
	}

}
