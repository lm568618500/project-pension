package com.longjun.cto.framework.sm.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.base.annotation.CacheEvictBatch;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsBannerDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsBannerModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsBannerModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsBannerView;
import com.longjun.cto.framework.sm.cms.mapper.CmsBannerMapper;
import com.longjun.cto.framework.sm.cms.service.ICmsBannerService;

/**
 * CmsBannerServiceImpl
 * 
 * @author yangxuan
 * @date 2019-06-19 08:33:45
 */
@Service
public class CmsBannerServiceImpl extends BaseServiceImpl<CmsBannerMapper, CmsBannerModel>
		implements ICmsBannerService {

	@Autowired
	CmsBannerMapper mapper;

	@Override
	public CmsBannerView findViewById(long id) throws BusinessException {
		CmsBannerView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CmsBannerModel findModelById(long id) throws BusinessException {
		CmsBannerModel model = this.selectById(id);
		if (model == null) {
			log.warn("CmsBanner 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@CacheEvictBatch
	@Override
	public void saveModel(CmsBannerModel model) throws BusinessException {
		log.info("CmsBanner 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		CmsBannerModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsBanner 开启操作,ID[{}]未查询到数据信息", id);
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
		CmsBannerModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsBanner 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<CmsBannerView> getByPage(CmsBannerDto dto) throws BusinessException {
		startPage(dto);
		List<CmsBannerView> ret = this.mapper.getByPage(dto);
		PageUtils<CmsBannerView> pages = new PageUtils<CmsBannerView>(ret);
		return pages;
	}

	@Override
	public List<CmsBannerView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CmsBannerView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<CmsBannerView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CmsBannerView> listAll() throws BusinessException {
		List<CmsBannerView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<CmsBannerView>();
		}
		return rets;
	}

	@CacheEvictBatch
	@Override
	public boolean modify(CmsBannerModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("CmsBanner 修改失败;传入对象为空");
			return false;
		}
		CmsBannerModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("CmsBanner 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		CmsBannerModel uModel = new CmsBannerModel();
		try {
			BeanUtils.copyProperties(uModel, dto);
			boolean ret = super.updateById(uModel);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Cacheable(value = "buz-cache-standard-com.eims.cto.framework.sm.cms.service.impl.CmsBannerServiceImpl",
	keyGenerator = "keyGenerator",unless = "#result == null")
	@Override
	public List<CmsBannerView> listByLocation(long locationId) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_locationId", locationId);
		List<CmsBannerView> rets = this.mapper.listModelMap(params);
		return rets;
	}

}
