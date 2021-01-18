package com.longjun.cto.framework.sm.sys.service.impl;

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
import com.longjun.cto.framework.sm.sys.entity.dto.CommonVerificationTypeDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonVerificationTypeModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonVerificationTypeModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonVerificationTypeView;
import com.longjun.cto.framework.sm.sys.mapper.CommonVerificationTypeMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonVerificationTypeService;

/**
 * CommonVerificationTypeServiceImpl
 * 
 * @author yangxuan
 * @date 2019-06-04 05:50:42
 */
@Service
public class CommonVerificationTypeServiceImpl
		extends BaseServiceImpl<CommonVerificationTypeMapper, CommonVerificationTypeModel>
		implements ICommonVerificationTypeService {

	@Autowired
	CommonVerificationTypeMapper mapper;

	@Override
	public CommonVerificationTypeView findViewById(long id) throws BusinessException {
		CommonVerificationTypeView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CommonVerificationTypeModel findModelById(long id) throws BusinessException {
		CommonVerificationTypeModel model = this.selectById(id);
		if (model == null) {
			log.warn("CommonVerificationType 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CommonVerificationTypeModel model) throws BusinessException {
		log.info("CommonVerificationType 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		CommonVerificationTypeModel model = super.selectById(id);
		if (model == null) {
			log.error("CommonVerificationType 开启操作,ID[{}]未查询到数据信息", id);
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
		CommonVerificationTypeModel model = super.selectById(id);
		if (model == null) {
			log.error("CommonVerificationType 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<CommonVerificationTypeView> getByPage(CommonVerificationTypeDto dto) throws BusinessException {
		startPage(dto);
		List<CommonVerificationTypeView> ret = this.mapper.getByPage(dto);
		PageUtils<CommonVerificationTypeView> pages = new PageUtils<CommonVerificationTypeView>(ret);
		return pages;
	}

	@Override
	public List<CommonVerificationTypeView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CommonVerificationTypeView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<CommonVerificationTypeView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CommonVerificationTypeView> listAll() throws BusinessException {
		List<CommonVerificationTypeView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<CommonVerificationTypeView>();
		}
		return rets;
	}

	@Override
	public boolean modify(CommonVerificationTypeModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("CommonVerificationType 修改失败;传入对象为空");
			return false;
		}
		CommonVerificationTypeModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("CommonVerificationType 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		CommonVerificationTypeModel uModel = new CommonVerificationTypeModel();
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
