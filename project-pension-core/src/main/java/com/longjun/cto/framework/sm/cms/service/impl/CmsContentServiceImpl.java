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
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsContentModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsContentView;
import com.longjun.cto.framework.sm.cms.mapper.CmsContentMapper;
import com.longjun.cto.framework.sm.cms.service.ICmsContentService;

/**
 * CmsContentServiceImpl
 * 
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
@Service
public class CmsContentServiceImpl extends BaseServiceImpl<CmsContentMapper, CmsContentModel>
		implements ICmsContentService {

	@Autowired
	CmsContentMapper mapper;

	@Override
	public CmsContentView findViewById(long id) throws BusinessException {
		CmsContentView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CmsContentModel findModelById(long id) throws BusinessException {
		CmsContentModel model = this.selectById(id);
		if (model == null) {
			log.warn("CmsContent 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CmsContentModel model) throws BusinessException {
		if(model != null && model.getViewcount()!= null && model.getViewcount().longValue() <0) {
			throw new BusinessException("添加资讯失败,浏览量不能小于0");
		}
		log.info("CmsContent 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		CmsContentModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsContent 开启操作,ID[{}]未查询到数据信息", id);
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
		CmsContentModel model = super.selectById(id);
		if (model == null) {
			log.error("CmsContent 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<CmsContentView> getByPage(CmsContentDto dto) throws BusinessException {
		startPage(dto);
		List<CmsContentView> ret = this.mapper.getByPage(dto);
		PageUtils<CmsContentView> pages = new PageUtils<CmsContentView>(ret);
		return pages;
	}

	@Override
	public List<CmsContentView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CmsContentView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<CmsContentView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CmsContentView> listAll() throws BusinessException {
		List<CmsContentView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<CmsContentView>();
		}
		return rets;
	}

	@Override
	public boolean modify(CmsContentModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("CmsContent 修改失败;传入对象为空");
			return false;
		}
		if(dto != null && dto.getViewcount()!= null && dto.getViewcount().longValue() <0) {
			throw new BusinessException("编辑资讯失败,浏览量不能小于0");
		}
		CmsContentModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("CmsContent 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		try {
			model.setLastupdate(new Date());
			model.setTypeId(dto.getTypeId());
			model.setTitle(dto.getTitle());
			model.setRemark(dto.getRemark());
			model.setContents(dto.getContents());
			model.setIsTop(dto.getIsTop());
			model.setSeoTitle(dto.getSeoTitle());
			model.setSeoDescription(dto.getSeoDescription());
			model.setSeoKeywords(dto.getSeoKeywords());
			model.setViewcount(dto.getViewcount());
			model.setThumbimg(dto.getThumbimg());
			boolean ret = super.updateById(model);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<CmsContentView> listByIndex(int type, int size) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_type_id", type);
		params.put("c_is_index", 1);
		params.put("c_limit", size);
		params.put("c_is_del", 0);
		params.put("c_status", 1);
		List<CmsContentView> ret = this.mapper.listModelMap(params);
		return ret;
	}
	

	@Override
	public List<CmsContentView> listByIndex(int size) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_is_index", 1);
		params.put("c_limit", size);
		params.put("c_is_del", 0);
		params.put("c_status", 1);
		List<CmsContentView> ret = this.mapper.listModelMap(params);
		return ret;
	}

	@Override
	public List<CmsContentView> listByTypeId(long typeId) throws BusinessException {
		Map<String, Object> params = new HashMap<>();
		params.put("status", 1);
		params.put("c_type_id", typeId);
		List<CmsContentView> ret = this.mapper.listModelMap(params);
		return ret;
	}

	@Override
	public boolean modifyPact(CmsContentModifyDto model) throws BusinessException {
		if (model == null) {
			log.error("修改协议内容失败;传入对象为空");
			return false;
		}
		if (model.getId() == null) {
			log.error("修改协议内容失败;传入对象ID为空");
			return false;
		}
		CmsContentModel ret = super.selectById(model.getId());
		if (ret == null) {
			log.error("修改协议内容失败;传入对象ID 未查询到数据 id -> {}", model.getId().longValue());
			return false;
		}
		ret.setLastupdate(new Date());
		ret.setContents(model.getContents());
		super.updateById(ret);
		return true;
	}

	@Override
	public boolean modifySingle(CmsContentModifyDto model) throws BusinessException {
		if (model == null) {
			log.error("修改单篇内容失败;传入对象为空");
			return false;
		}
		if (model.getId() == null) {
			log.error("修改单篇内容失败;传入对象ID为空");
			return false;
		}
		CmsContentModel ret = super.selectById(model.getId());
		if (ret == null) {
			log.error("修改单篇内容失败;传入对象ID 未查询到数据 id -> {}", model.getId().longValue());
			return false;
		}
		ret.setLastupdate(new Date());
		ret.setContents(model.getContents() == null ? "" : model.getContents());
		super.updateById(ret);
		return true;
	}

	@Override
	public boolean modifyHelper(CmsContentModifyDto model) throws BusinessException {
		if (model == null) {
			log.error("修改帮助中心内容失败;传入对象为空");
			return false;
		}
		if (model.getId() == null) {
			log.error("修改帮助中心内容失败;传入对象ID为空");
			return false;
		}
		CmsContentModel ret = super.selectById(model.getId());
		if (ret == null) {
			log.error("修改帮助中心内容失败;传入对象ID 未查询到数据 id -> {}", model.getId().longValue());
			return false;
		}
		ret.setLastupdate(new Date());
		ret.setContents(model.getContents());
		super.updateById(ret);
		return true;
	}

	@Override
	public boolean toIndex(long id) throws BusinessException {
		CmsContentModel model = super.selectById(id);
		if (model == null) {
			return false;
		}
		model.setLastupdate(new Date());
		model.setIsIndex(1);
		super.updateById(model);
		return true;
	}

	@Override
	public boolean toUnIndex(long id) throws BusinessException {
		CmsContentModel model = super.selectById(id);
		if (model == null) {
			return false;
		}
		model.setLastupdate(new Date());
		model.setIsIndex(0);
		super.updateById(model);
		return true;
	}

	@Override
	public CmsContentView findLastOne(Long id) throws BusinessException {
		CmsContentView ret = this.mapper.findLastOne(id);
		return ret;
	}

	@Override
	public CmsContentView findNextOne(Long id) throws BusinessException {
		CmsContentView ret = this.mapper.findNextOne(id);
		return ret;
	}


}
