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
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsLinksDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsLinksModifyDto;
import com.longjun.cto.framework.sm.cms.entity.es.CmsLinksEnums;
import com.longjun.cto.framework.sm.cms.entity.model.CmsLinksModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsLinksView;
import com.longjun.cto.framework.sm.cms.mapper.CmsLinksMapper;
import com.longjun.cto.framework.sm.cms.service.ICmsLinksService;

/**
 * CmsLinksServiceImpl
 * 
 * @author yangxuan
 * @date 2019-06-18 03:18:47
 */
@Service
public class CmsLinksServiceImpl extends BaseServiceImpl<CmsLinksMapper, CmsLinksModel> implements ICmsLinksService {

	@Autowired
	CmsLinksMapper mapper;

	@Override
	public CmsLinksView findViewById(long id) throws BusinessException {
		CmsLinksView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CmsLinksModel findModelById(long id) throws BusinessException {
		CmsLinksModel model = this.selectById(id);
		if (model == null) {
			log.warn("CmsLinks 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CmsLinksModel model) throws BusinessException {
		log.info("CmsLinks 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		CmsLinksModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsLinks 开启操作,ID[{}]未查询到数据信息", id);
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
		CmsLinksModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsLinks 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<CmsLinksView> getByPage(CmsLinksDto dto) throws BusinessException {
		startPage(dto);
		List<CmsLinksView> ret = this.mapper.getByPage(dto);
		PageUtils<CmsLinksView> pages = new PageUtils<CmsLinksView>(ret);
		return pages;
	}

	@Override
	public List<CmsLinksView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CmsLinksView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<CmsLinksView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CmsLinksView> listAll() throws BusinessException {
		List<CmsLinksView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<CmsLinksView>();
		}
		return rets;
	}

	@Override
	public boolean modify(CmsLinksModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("CmsLinks 修改失败;传入对象为空");
			return false;
		}
		CmsLinksModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("CmsLinks 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		try {
			model.setLastupdate(new Date());
			model.setIsRecommend(dto.getIsRecommend());
			model.setLinkName(dto.getLinkName());
			model.setLinkImg(dto.getLinkImg());
			model.setLinkHref(dto.getLinkHref());
			model.setLinkType(dto.getLinkType());
			boolean ret = super.updateById(model);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<CmsLinksView> listByIndex(CmsLinksEnums cmsLinksEnums) throws BusinessException {
		Map<String, Object> params = new HashMap<>();
		params.put("c_status", 1);
		params.put("c_is_del", 0);
		params.put("c_is_recommend", 1);
		List<CmsLinksView> rets = this.mapper.listModelMap(params);
		return rets;
	}

	@Override
	public List<CmsLinksView> listByIndex(int size, CmsLinksEnums cmsLinksEnums) throws BusinessException {
		Map<String, Object> params = new HashMap<>();
		params.put("c_status", 1);
		params.put("c_is_del", 0);
		params.put("c_is_recommend", 1);
		params.put("c_limit", size);
		List<CmsLinksView> rets = this.mapper.listModelMap(params);
		return rets;
	}

}
