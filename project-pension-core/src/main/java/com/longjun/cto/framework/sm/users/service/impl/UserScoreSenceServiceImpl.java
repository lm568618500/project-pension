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
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.users.entity.dto.UserScoreSenceDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserScoreSenceModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserScoreSenceModel;
import com.longjun.cto.framework.sm.users.entity.view.UserScoreSenceView;
import com.longjun.cto.framework.sm.users.mapper.UserScoreSenceMapper;
import com.longjun.cto.framework.sm.users.service.IUserScoreSenceService;

/**
 * UserScoreSenceServiceImpl
 * 
 * @author yangxuan
 * @date 2019-07-01 05:05:46
 */
@Service
public class UserScoreSenceServiceImpl extends BaseServiceImpl<UserScoreSenceMapper, UserScoreSenceModel>
		implements IUserScoreSenceService {

	@Autowired
	UserScoreSenceMapper mapper;

	@Override
	public UserScoreSenceView findViewById(long id) throws BusinessException {
		UserScoreSenceView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public UserScoreSenceModel findModelById(long id) throws BusinessException {
		UserScoreSenceModel model = this.selectById(id);
		if (model == null) {
			log.warn("UserScoreSence 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(UserScoreSenceModel model) throws BusinessException {
		log.info("UserScoreSence 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		UserScoreSenceModel model = super.selectById(id);
		if (model == null) {
			log.error("UserScoreSence 开启操作,ID[{}]未查询到数据信息", id);
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
		UserScoreSenceModel model = super.selectById(id);
		if (model == null) {
			log.error("UserScoreSence 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<UserScoreSenceView> getByPage(UserScoreSenceDto dto) throws BusinessException {
		startPage(dto);
		List<UserScoreSenceView> ret = this.mapper.getByPage(dto);
		PageUtils<UserScoreSenceView> pages = new PageUtils<UserScoreSenceView>(ret);
		return pages;
	}

	@Override
	public List<UserScoreSenceView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<UserScoreSenceView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<UserScoreSenceView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<UserScoreSenceView> listAll() throws BusinessException {
		List<UserScoreSenceView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<UserScoreSenceView>();
		}
		return rets;
	}

	@Override
	public boolean modify(UserScoreSenceModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("UserScoreSence 修改失败;传入对象为空");
			return false;
		}
		UserScoreSenceModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("UserScoreSence 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		UserScoreSenceModel uModel = new UserScoreSenceModel();
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
	public UserScoreSenceModel findBySenceNo(Long senceNo) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 1).eq("is_del", 0).eq("sence_no", senceNo);
		UserScoreSenceModel ret = super.selectOne(ew);
		return ret;
	}

}
