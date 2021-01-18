package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.model.AdminRoleModel;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleModel;
import com.longjun.cto.framework.sm.sys.entity.view.AuthRoleView;
import com.longjun.cto.framework.sm.sys.mapper.AdminRoleMapper;
import com.longjun.cto.framework.sm.sys.service.IAdminRoleService;
import com.longjun.cto.framework.sm.sys.service.IAuthRoleService;

/**
 * 管理员-角色业务实现
 * 
 * @author yangxuan
 * @date 2018年11月15日下午7:54:42
 */
@Service
public class AdminRoleServiceImpl extends BaseServiceImpl<AdminRoleMapper, AdminRoleModel>
		implements IAdminRoleService {

	@Autowired
	AdminRoleMapper adminRoleMapper;

	@Autowired
	IAuthRoleService iAuthRoleService;

	@Override
	public Long saveModel(AdminRoleModel model) throws BusinessException {
		try {
			return this.adminRoleMapper.saveModel(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public boolean setStatusByAdminId(long adminId, int status) throws BusinessException {
		try {
			return this.adminRoleMapper.setStatusByAdminId(adminId, status) > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public boolean setStatusByRoleId(long roleId, int status) throws BusinessException {
		try {
			return this.adminRoleMapper.setStatusByRoleId(roleId, status) > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public boolean setAdminRole(long adminId, long roleId) throws BusinessException {
		AuthRoleModel aurhRoleModel = this.iAuthRoleService.selectById(roleId);
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("admin_id", adminId);
		ew.eq("role_id", aurhRoleModel.getUseId());
		AdminRoleModel adminRoleModel = super.selectOne(ew);
		if (adminRoleModel == null) {
			adminRoleModel = new AdminRoleModel();
			adminRoleModel.setTime(new Date());
			adminRoleModel.setLastupdate(new Date());
			adminRoleModel.setAdminId(adminId);
			adminRoleModel.setRoleId(aurhRoleModel.getUseId());
			adminRoleModel.setStatus(1);
			super.insert(adminRoleModel);
			return true;
		}
		adminRoleModel.setRoleId(aurhRoleModel.getUseId());
		adminRoleModel.setStatus(1);
		adminRoleModel.setLastupdate(new Date());
		super.updateById(adminRoleModel);
		return true;
	}

}
