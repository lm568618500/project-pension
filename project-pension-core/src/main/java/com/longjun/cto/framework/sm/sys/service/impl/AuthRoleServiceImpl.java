package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.AuthRoleDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AuthRoleModifyDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AuthRoleSaveDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminRoleModel;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleModel;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleResourcesModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminView;
import com.longjun.cto.framework.sm.sys.entity.view.AuthRoleView;
import com.longjun.cto.framework.sm.sys.mapper.AuthRoleMapper;
import com.longjun.cto.framework.sm.sys.service.IAdminRoleService;
import com.longjun.cto.framework.sm.sys.service.IAuthRoleResourcesService;
import com.longjun.cto.framework.sm.sys.service.IAuthRoleService;

import cn.hutool.core.convert.Convert;

/**
 * AuthRoleServiceImpl
 * @author yangxuan
 * @date 2019-04-07 03:17:44
 */
 @Service
public class AuthRoleServiceImpl  extends 
					BaseServiceImpl<AuthRoleMapper , AuthRoleModel> 
						implements IAuthRoleService {

	@Autowired
	AuthRoleMapper mapper;
	
	@Autowired
	IAuthRoleResourcesService iAuthRoleResourcesService;
	@Autowired
	IAdminRoleService iAdminRoleService;
	
	@Override
	public AuthRoleView findViewById(long id) throws BusinessException {
		AuthRoleView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public AuthRoleModel findModelById(long id) throws BusinessException {
		AuthRoleModel model = this.selectById(id);
		if(model == null) {
			log.warn("AuthRole 通过ID查询结果为空");
			return null;
		}
		return model;
	}
	
	synchronized  long getUseId() {
		long useId = Convert.toLong((System.currentTimeMillis()+ "").substring(7));
		return useId;
	}

	@Override
	public void saveModel(AuthRoleSaveDto authRoleSaveDto) throws BusinessException {
		log.info("AuthRole 数据新增 -> [{}]" , JSONObject.toJSONString(authRoleSaveDto));
		
		AuthRoleModel model = new AuthRoleModel();
		model.setTime(new Date());
		model.setUseId(getUseId());
		model.setRolename(authRoleSaveDto.getRolename());
		model.setParentId(0L);
		model.setRoleDesc(authRoleSaveDto.getRoleDesc());
		model.setLastupdate(new Date());
		model.setStatus(1);
		model.setIsDel(0);
		super.insert(model);	
		List<Long> auths = authRoleSaveDto.getAuthids();
		if(auths != null) {
			AuthRoleResourcesModel authRoleResourcesModel = null;
			for(Long auth : auths) {
				if(auth == null) {
					continue;
				}
				authRoleResourcesModel = new AuthRoleResourcesModel();
				authRoleResourcesModel.setTime(new Date());
				authRoleResourcesModel.setRoleId(model.getUseId());
				authRoleResourcesModel.setResourcesId(auth);
				authRoleResourcesModel.setLastupdate(new Date());
				authRoleResourcesModel.setStatus(1);
				this.iAuthRoleResourcesService.insert(authRoleResourcesModel);
			}
		}
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		AuthRoleModel model = super.selectById(id);
		if(model == null) {
			log.error("AuthRole 开启操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == USE){
			return true;
		}
		model.setStatus(USE);
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
		AuthRoleModel model = super.selectById(id);
		if(model == null) {
			log.error("AuthRole 停止操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == UNUSE){
			return true;
		}
		model.setStatus(UNUSE);
		boolean ret = super.updateById(model);
		return ret;
	}
	
	@Override
	public PageUtils<AuthRoleView> getByPage(AuthRoleDto dto) throws BusinessException {
		startPage(dto);
		List<AuthRoleView> ret = this.mapper.getByPage(dto);
		PageUtils<AuthRoleView> pages =  new PageUtils<AuthRoleView>(ret);
		return pages;
	}
	
	@Override
	public List<AuthRoleView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<AuthRoleView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<AuthRoleView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<AuthRoleView> listAll() throws BusinessException {
		List<AuthRoleView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<AuthRoleView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(AuthRoleModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("AuthRole 修改失败;传入对象为空");
			return false;
		}
		if(dto.getId() == 10000) {
			throw new BusinessException("修改权限异常;超级管理员权限禁止编辑");
		}
		
		AuthRoleModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("AuthRole 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		try {
			
			model.setLastupdate(new Date());
			model.setRolename(dto.getRolename());
			model.setRoleDesc(dto.getRoleDesc());
			//修改主体信息
			boolean ret = super.updateById(model);
			
			List<Long> auths = dto.getAuthids();
			if(auths != null) {
				//初始化角色信息
				this.iAuthRoleResourcesService.initAuthRolesByRoleId(model.getUseId());
				AuthRoleResourcesModel authRoleResourcesModel = null;
				for(Long auth : auths) {
					if(auth == null) {
						continue;
					}
					authRoleResourcesModel = new AuthRoleResourcesModel();
					authRoleResourcesModel.setTime(new Date());
					authRoleResourcesModel.setRoleId(model.getUseId());
					authRoleResourcesModel.setResourcesId(auth);
					authRoleResourcesModel.setLastupdate(new Date());
					authRoleResourcesModel.setStatus(1);
					this.iAuthRoleResourcesService.insert(authRoleResourcesModel);
				}
			}
			
			
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}

	@Override
	public List<AuthRoleModel> listByUse() throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 1).eq("is_del", 0);
		List<AuthRoleModel> rets = super.selectList(ew);
		if(rets == null) {
			rets = new ArrayList<AuthRoleModel>();
		}
		return rets;
	}
	public List<AuthRoleModel> listByUse1(long userId) throws BusinessException{
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 1).eq("is_del", 0);
		List<AuthRoleModel> rets = super.selectList(ew);
		if(rets == null) {
			rets = new ArrayList<AuthRoleModel>();
		}else{
			for (AuthRoleModel role:rets) {
				EntityWrapper<AdminRoleModel> armWrapper=new EntityWrapper<AdminRoleModel>();
				armWrapper.eq("admin_id", userId);
				armWrapper.eq("role_id", role.getUseId());
				armWrapper.eq("status", 1);
				AdminRoleModel arm=this.iAdminRoleService.selectOne(armWrapper);
				if(arm!=null){
					role.setIsUse(1);
				}else{
					role.setIsUse(0);
				}
			}
		}
		return rets;
	}
	
	@Override
	public AuthRoleModel findByUseId(long useId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("status", 1).eq("is_del", 0).eq("use_id", useId);
		AuthRoleModel ret = super.selectOne(ew);
		return ret;
	}
	
}
