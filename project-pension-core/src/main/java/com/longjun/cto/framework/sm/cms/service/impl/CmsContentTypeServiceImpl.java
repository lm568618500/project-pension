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
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentTypeDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentTypeModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsContentTypeModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsContentTypeView;
import com.longjun.cto.framework.sm.cms.mapper.CmsContentTypeMapper;
import com.longjun.cto.framework.sm.cms.service.ICmsContentService;
import com.longjun.cto.framework.sm.cms.service.ICmsContentTypeService;

/**
 * CmsContentTypeServiceImpl
 * 
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
@Service
public class CmsContentTypeServiceImpl extends BaseServiceImpl<CmsContentTypeMapper, CmsContentTypeModel>
		implements ICmsContentTypeService {

	@Autowired
	CmsContentTypeMapper mapper;

	@Autowired
	private ICmsContentService iCmsContentService;

	@Override
	public CmsContentTypeView findViewById(long id) throws BusinessException {
		CmsContentTypeView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CmsContentTypeModel findModelById(long id) throws BusinessException {
		CmsContentTypeModel model = this.selectById(id);
		if (model == null) {
			log.warn("CmsContentType 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CmsContentTypeModel model) throws BusinessException {
		log.info("CmsContentType 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		CmsContentTypeModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsContentType 开启操作,ID[{}]未查询到数据信息", id);
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
		CmsContentTypeModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsContentType 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<CmsContentTypeView> getByPage(CmsContentTypeDto dto) throws BusinessException {
		startPage(dto);
		List<CmsContentTypeView> ret = this.mapper.getByPage(dto);
		PageUtils<CmsContentTypeView> pages = new PageUtils<CmsContentTypeView>(ret);
		return pages;
	}

	@Override
	public List<CmsContentTypeView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CmsContentTypeView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<CmsContentTypeView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CmsContentTypeView> listAll() throws BusinessException {
		List<CmsContentTypeView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<CmsContentTypeView>();
		}
		return rets;
	}

	@Override
	public boolean modify(CmsContentTypeModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("CmsContentType 修改失败;传入对象为空");
			return false;
		}
		CmsContentTypeModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("CmsContentType 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		CmsContentTypeModel uModel = new CmsContentTypeModel();
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
	public List<CmsContentTypeModel> listByIndex() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 1).eq("is_del", 0).eq("is_recommond", 1);
		List<CmsContentTypeModel> ret = super.selectList(ew);
		return ret;
	}

	@Override
	public List<CmsContentTypeView> listByClassId(long classID) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", 1);
		params.put("c_class_id", classID);
		List<CmsContentTypeView> ret = this.mapper.listModelMap(params);
		return ret;
	}

	@Override
	public List<CmsContentTypeView> helpCenter() throws BusinessException {
		List<CmsContentTypeView> ret = this.listByClassId(4L);
		for (CmsContentTypeView v : ret) {
			v.setCmsConentList(this.iCmsContentService.listByTypeId(v.getId()));
		}
		return ret;
	}

}
