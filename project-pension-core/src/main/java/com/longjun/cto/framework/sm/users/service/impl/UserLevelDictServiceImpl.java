package com.longjun.cto.framework.sm.users.service.impl;

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
import com.longjun.cto.framework.sm.users.entity.dto.UserLevelDictDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserLevelDictModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserLevelDictModel;
import com.longjun.cto.framework.sm.users.entity.view.UserLevelDictView;
import com.longjun.cto.framework.sm.users.mapper.UserLevelDictMapper;
import com.longjun.cto.framework.sm.users.service.IUserLevelDictService;

/**
 * UserLevelDictServiceImpl
 * 
 * @author yangxuan
 * @date 2019-06-28 04:46:45
 */
@Service
public class UserLevelDictServiceImpl extends BaseServiceImpl<UserLevelDictMapper, UserLevelDictModel>
		implements IUserLevelDictService {

	@Autowired
	UserLevelDictMapper mapper;

	@Override
	public UserLevelDictView findViewById(long id) throws BusinessException {
		UserLevelDictView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public UserLevelDictModel findModelById(long id) throws BusinessException {
		UserLevelDictModel model = this.selectById(id);
		if (model == null) {
			log.warn("UserLevelDict 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(UserLevelDictModel model) throws BusinessException {
		log.info("UserLevelDict 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		UserLevelDictModel model = super.selectById(id);
		if (model == null) {
			log.error("UserLevelDict 开启操作,ID[{}]未查询到数据信息", id);
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
		UserLevelDictModel model = super.selectById(id);
		if (model == null) {
			log.error("UserLevelDict 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<UserLevelDictView> getByPage(UserLevelDictDto dto) throws BusinessException {
		startPage(dto);
		List<UserLevelDictView> ret = this.mapper.getByPage(dto);
		PageUtils<UserLevelDictView> pages = new PageUtils<UserLevelDictView>(ret);
		return pages;
	}

	@Override
	public List<UserLevelDictView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<UserLevelDictView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<UserLevelDictView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<UserLevelDictView> listAll() throws BusinessException {
		List<UserLevelDictView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<UserLevelDictView>();
		}
		return rets;
	}

	@Override
	public boolean modify(UserLevelDictModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("UserLevelDict 修改失败;传入对象为空");
			return false;
		}
		UserLevelDictModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("UserLevelDict 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		try {
			model.setLastupdate(new Date());
			model.setLevelName(dto.getLevelName());
			model.setSocre(dto.getSocre());
			boolean ret = super.updateById(model);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
