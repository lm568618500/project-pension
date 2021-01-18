package com.longjun.cto.framework.sm.message.service.impl;

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
import com.longjun.cto.framework.sm.message.entity.dto.MessageStationDto;
import com.longjun.cto.framework.sm.message.entity.dto.MessageStationModifyDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageEmailModel;
import com.longjun.cto.framework.sm.message.entity.model.MessageStationModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageStationView;
import com.longjun.cto.framework.sm.message.mapper.MessageStationMapper;
import com.longjun.cto.framework.sm.message.service.IMessageStationService;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;

/**
 * MessageStationServiceImpl
 * 
 * @author yangxuan
 * @date 2019-07-04 07:33:46
 */
@Service
public class MessageStationServiceImpl extends BaseServiceImpl<MessageStationMapper, MessageStationModel>
		implements IMessageStationService {

	@Autowired
	MessageStationMapper mapper;

	@Override
	public MessageStationView findViewById(long id) throws BusinessException {
		MessageStationView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public MessageStationModel findModelById(long id) throws BusinessException {
		MessageStationModel model = this.selectById(id);
		if (model == null) {
			log.warn("MessageStation 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(String userNos , String creator , String title , String content) throws BusinessException {
		String[] userNosArr = userNos.split("\n");
		if (userNosArr != null) {
			MessageStationModel m = null;
			List<MessageStationModel> ms = new ArrayList<MessageStationModel>();
			for (String userNo : userNosArr) {
				if(StrUtil.isBlank(userNo.trim())) {
					continue;
				}
				m = new MessageStationModel();
				m.setTime(new Date());
				m.setLastupdate(new Date());
				m.setStatus(1);
				m.setIsDel(0);
				m.setIsRead(0);
				m.setUserNo(Convert.toLong(userNo, -1L));
				m.setSendTime(new Date());
				m.setSendTimestamp(System.currentTimeMillis());
				m.setContent(content);
				m.setCreator(creator);
				m.setTitle(title);
				ms.add(m);
			}
			super.insertBatch(ms);
		}
	}

	@Override
	public boolean start(long id) throws BusinessException {
		MessageStationModel model = super.selectById(id);
		if (model == null) {
			log.error("MessageStation 开启操作,ID[{}]未查询到数据信息", id);
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
		MessageStationModel model = super.selectById(id);
		if (model == null) {
			log.error("MessageStation 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<MessageStationView> getByPage(MessageStationDto dto) throws BusinessException {
		startPage(dto);
		List<MessageStationView> ret = this.mapper.getByPage(dto);
		PageUtils<MessageStationView> pages = new PageUtils<MessageStationView>(ret);
		return pages;
	}

	@Override
	public PageUtils<MessageStationView> getMngByPage(MessageStationDto dto) throws BusinessException {
		startPage(dto);
		List<MessageStationView> ret = this.mapper.getMngByPage(dto);
		PageUtils<MessageStationView> pages = new PageUtils<MessageStationView>(ret);
		return pages;
	}


	@Override
	public List<MessageStationView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<MessageStationView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<MessageStationView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<MessageStationView> listAll() throws BusinessException {
		List<MessageStationView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<MessageStationView>();
		}
		return rets;
	}

	@Override
	public boolean modify(MessageStationModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("MessageStation 修改失败;传入对象为空");
			return false;
		}
		MessageStationModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("MessageStation 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		MessageStationModel uModel = new MessageStationModel();
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
	public int unReadNum(Long userNo) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 1).eq("is_del", 0).eq("user_no", userNo);
		int count = super.selectCount(ew);
		return count;
	}

	@Override
	public boolean readMsg(Long userNo, Long msgId) throws BusinessException {
		synchronized (userNo + "_" + msgId) {
			MessageStationModel model = super.selectById(msgId);
			if (model.getUserNo().longValue() == userNo.longValue()) {
				model.setLastupdate(new Date());
				model.setIsRead(1);
				super.updateById(model);
			}
			return true;
		}
	}

	@Override
	public boolean delMsg(Long userNo, Long msgId) throws BusinessException {
		synchronized (userNo + "_" + msgId) {
			MessageStationModel model = super.selectById(msgId);
			if (model.getUserNo().longValue() == userNo.longValue()) {
				model.setLastupdate(new Date());
				model.setIsDel(-1);
				model.setIsRead(1);
				super.updateById(model);
			}
			return true;
		}
	}

	@Override
	public List<MessageStationView> listTop(Long userNo, int size, boolean unRead) throws BusinessException {
		Map<String, Object> params = new HashMap<>();
		params.put("c_userNo", userNo);
		if (unRead) {
			params.put("c_is_read", 0);
		}
		params.put("c_limit", size);
		List<MessageStationView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			rets = new ArrayList<>();
		}
		return rets;
	}

	@Override
	public boolean sendMsg(Long userNo, String title, String content, String creator) throws BusinessException {
		log.info("发布站点信 userNo -> {} title -> {} content -> {} creator -> {}", userNo, title, content, creator);
		MessageStationModel model = new MessageStationModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setStatus(1);
		model.setIsDel(0);
		model.setUserNo(userNo);
		model.setTitle(title);
		model.setContent(content);
		model.setIsRead(0);
		model.setCreator(creator);
		model.setSendTime(new Date());
		model.setSendTimestamp(System.currentTimeMillis());
		super.insert(model);
		return true;
	}

	/**
	 * 标记全部已读
	 *
	 * @param userNo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public boolean allSignRead(Long userNo) throws BusinessException {

		this.mapper.updateByUserNo(userNo);
		return false;
	}

}
