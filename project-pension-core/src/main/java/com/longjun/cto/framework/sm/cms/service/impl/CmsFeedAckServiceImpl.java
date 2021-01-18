package com.longjun.cto.framework.sm.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedAckDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedAckModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsFeedAckModel;
import com.longjun.cto.framework.sm.cms.entity.model.CmsFeedModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsFeedAckView;
import com.longjun.cto.framework.sm.cms.mapper.CmsFeedAckMapper;
import com.longjun.cto.framework.sm.cms.service.ICmsFeedAckService;
import com.longjun.cto.framework.sm.cms.service.ICmsFeedService;

/**
 * CmsFeedAckServiceImpl
 * 
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
@Service
public class CmsFeedAckServiceImpl extends BaseServiceImpl<CmsFeedAckMapper, CmsFeedAckModel>
		implements ICmsFeedAckService {

	@Autowired
	CmsFeedAckMapper mapper;

	@Autowired
	private ICmsFeedService iCmsFeedService;

	@Override
	public CmsFeedAckView findViewById(long id) throws BusinessException {
		CmsFeedAckView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CmsFeedAckModel findModelById(long id) throws BusinessException {
		CmsFeedAckModel model = this.selectById(id);
		if (model == null) {
			log.warn("CmsFeedAck 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CmsFeedAckModel model) throws BusinessException {
		log.info("CmsFeedAck 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		CmsFeedAckModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsFeedAck 开启操作,ID[{}]未查询到数据信息", id);
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
		CmsFeedAckModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsFeedAck 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<CmsFeedAckView> getByPage(CmsFeedAckDto dto) throws BusinessException {
		startPage(dto);
		List<CmsFeedAckView> ret = this.mapper.getByPage(dto);
		PageUtils<CmsFeedAckView> pages = new PageUtils<CmsFeedAckView>(ret);
		return pages;
	}

	@Override
	public List<CmsFeedAckView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CmsFeedAckView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<CmsFeedAckView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CmsFeedAckView> listAll() throws BusinessException {
		List<CmsFeedAckView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<CmsFeedAckView>();
		}
		return rets;
	}

	@Override
	public boolean modify(CmsFeedAckModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("CmsFeedAck 修改失败;传入对象为空");
			return false;
		}
		CmsFeedAckModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("CmsFeedAck 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		CmsFeedAckModel uModel = new CmsFeedAckModel();
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
	public boolean ackFeed(long adminId, long feedNo, String ackContent) throws BusinessException {
		log.info("回复意见反馈开始 , adminId - > {}  , feedNo -> {} ackContent -> {}", adminId, feedNo, ackContent);
		CmsFeedModel cmsFeedModel = this.iCmsFeedService.findByFeedNo(feedNo);
		if (cmsFeedModel == null) {
			return false;
		}
		if (isBlank(ackContent)) {
			throw new BusinessException("回复意见反馈失败;传入回复为空");
		}
		CmsFeedAckModel model = new CmsFeedAckModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setStatus(1);
		model.setIsDel(0);
		model.setFeedNo(feedNo);
		model.setAdminId(adminId);
		model.setAckContent(ackContent);
		super.insert(model);
		log.info("回复意见完毕 -> {}", JSONObject.toJSONString(model));
		return true;
	}

	@Override
	public CmsFeedAckView findByFeedNo(Long feedNo) throws BusinessException {
		Map<String, Object> params = new HashMap<>();
		params.put("c_feed_no", feedNo);
		CmsFeedAckView ret = this.mapper.listModelMap(params).get(0);
		return ret;
	}

}
