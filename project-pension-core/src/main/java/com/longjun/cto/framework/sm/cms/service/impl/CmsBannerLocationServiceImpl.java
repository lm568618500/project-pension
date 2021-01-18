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
import com.longjun.cto.framework.sm.cms.entity.dto.CmsBannerLocationDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsBannerLocationModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsBannerLocationModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsBannerLocationView;
import com.longjun.cto.framework.sm.cms.mapper.CmsBannerLocationMapper;
import com.longjun.cto.framework.sm.cms.service.ICmsBannerLocationService;

/**
 * CmsBannerLocationServiceImpl
 * 
 * @author yangxuan
 * @date 2019-06-19 08:33:45
 */
@Service
public class CmsBannerLocationServiceImpl extends BaseServiceImpl<CmsBannerLocationMapper, CmsBannerLocationModel>
		implements ICmsBannerLocationService {

	@Autowired
	CmsBannerLocationMapper mapper;

	@Override
	public CmsBannerLocationView findViewById(long id) throws BusinessException {
		CmsBannerLocationView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CmsBannerLocationModel findModelById(long id) throws BusinessException {
		CmsBannerLocationModel model = this.selectById(id);
		if (model == null) {
			log.warn("CmsBannerLocation 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CmsBannerLocationModel model) throws BusinessException {
		log.info("CmsBannerLocation 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		CmsBannerLocationModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsBannerLocation 开启操作,ID[{}]未查询到数据信息", id);
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
		CmsBannerLocationModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsBannerLocation 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<CmsBannerLocationView> getByPage(CmsBannerLocationDto dto) throws BusinessException {
		startPage(dto);
		List<CmsBannerLocationView> ret = this.mapper.getByPage(dto);
		PageUtils<CmsBannerLocationView> pages = new PageUtils<CmsBannerLocationView>(ret);
		return pages;
	}

	@Override
	public List<CmsBannerLocationView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CmsBannerLocationView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<CmsBannerLocationView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CmsBannerLocationView> listAll() throws BusinessException {
		List<CmsBannerLocationView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<CmsBannerLocationView>();
		}
		return rets;
	}

	@Override
	public boolean modify(CmsBannerLocationModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("CmsBannerLocation 修改失败;传入对象为空");
			return false;
		}
		CmsBannerLocationModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("CmsBannerLocation 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		CmsBannerLocationModel uModel = new CmsBannerLocationModel();
		try {
			BeanUtils.copyProperties(uModel, dto);
			boolean ret = super.updateById(uModel);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
