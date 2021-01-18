package com.longjun.cto.framework.sm.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedInputDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsFeedModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsFeedView;
import com.longjun.cto.framework.sm.cms.mapper.CmsFeedMapper;
import com.longjun.cto.framework.sm.cms.service.ICmsFeedAckService;
import com.longjun.cto.framework.sm.cms.service.ICmsFeedService;

import cn.hutool.core.lang.Validator;

/**
 * CmsFeedServiceImpl
 * 
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
@Service
public class CmsFeedServiceImpl extends BaseServiceImpl<CmsFeedMapper, CmsFeedModel> implements ICmsFeedService {

	@Autowired
	CmsFeedMapper mapper;

	@Autowired
	ICmsFeedAckService iCmsFeedAckService;

	@Override
	public CmsFeedView findViewById(long id) throws BusinessException {
		CmsFeedView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CmsFeedModel findModelById(long id) throws BusinessException {
		CmsFeedModel model = this.selectById(id);
		if (model == null) {
			log.warn("CmsFeed 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CmsFeedModel model) throws BusinessException {
		log.info("CmsFeed 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		CmsFeedModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsFeed 开启操作,ID[{}]未查询到数据信息", id);
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
		CmsFeedModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsFeed 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<CmsFeedView> getByPage(CmsFeedDto dto) throws BusinessException {
		startPage(dto);
		List<CmsFeedView> ret = this.mapper.getByPage(dto);
		PageUtils<CmsFeedView> pages = new PageUtils<CmsFeedView>(ret);
		return pages;
	}

	@Override
	public List<CmsFeedView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CmsFeedView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<CmsFeedView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CmsFeedView> listAll() throws BusinessException {
		List<CmsFeedView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<CmsFeedView>();
		}
		return rets;
	}

	@Override
	public boolean modify(CmsFeedModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("CmsFeed 修改失败;传入对象为空");
			return false;
		}
		CmsFeedModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("CmsFeed 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		try {
			model.setLastupdate(new Date());
			model.setStatus(1);
			boolean ret = super.updateById(model);
			this.iCmsFeedAckService.ackFeed(dto.getAdminId(), dto.getFeedNo(), dto.getFeedAck());
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveFeed(CmsFeedInputDto cmsFeedInputDto) throws BusinessException {
		log.info("意见反馈收集 ;传入对象 -> {}", JSONObject.toJSONString(cmsFeedInputDto));
		if (cmsFeedInputDto == null) {
			throw new BusinessException("意见反馈失败;传入对象为空");
		}
		if (isBlank(cmsFeedInputDto.getLinks())) {
			throw new BusinessException("意见反馈失败;联系方式为空");
		}
		if (isBlank(cmsFeedInputDto.getFeedContent())) {
			throw new BusinessException("意见反馈失败;意见描述为空");
		}
		int type = 0;
		if (Validator.isMobile(cmsFeedInputDto.getLinks())) {
			type = 1;
		} else if (Validator.isEmail(cmsFeedInputDto.getLinks())) {
			type = 2;
		}
		CmsFeedModel model = new CmsFeedModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setStatus(0); // 待处理反馈
		model.setIsDel(0);
		model.setLinks(cmsFeedInputDto.getLinks());
		model.setLinkName(cmsFeedInputDto.getLinkName());
		model.setFeedTitle(cmsFeedInputDto.getFeedTitle());
		model.setLinkType(type);
		model.setFeedType(0); // 默认值 后续进行扩展
		model.setFeedNo(sequenceId());
		model.setFeedContent(cmsFeedInputDto.getFeedContent());
		super.insert(model);
		log.info("意见反馈成功 -> {}", JSONObject.toJSONString(model));
		return true;
	}

	@Override
	public CmsFeedModel findByFeedNo(long feedNo) throws BusinessException {
		if (feedNo <= 0) {
			throw new BusinessException("查询意见反馈失败;传入编号非法");
		}
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("is_del", 0).eq("feed_no", feedNo);
		CmsFeedModel ret = super.selectOne(ew);
		return ret;
	}

}
