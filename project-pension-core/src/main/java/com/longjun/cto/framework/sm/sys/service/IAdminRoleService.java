package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.model.AdminRoleModel;

/**
 * 管理员-角色业务
 * @author yangxuan
 * @date 2018年11月15日下午7:48:36
 */
public interface IAdminRoleService extends BaseService<AdminRoleModel>{

	/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	Long saveModel(AdminRoleModel model)throws BusinessException;
	
	/**
	 * 通过AdminId修改状态
	 * @param adminId
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	boolean setStatusByAdminId(long adminId , int status)throws BusinessException;
	
	/**
	 * 通过RoleId修改状态, 可能会删除角色
	 * @param roleId
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	boolean setStatusByRoleId(long roleId ,int status)throws BusinessException;
	
	/**
	 * 设置管理员角色
	 * @param adminId
	 * @param roleId
	 * @return
	 * @throws BusinessException
	 */
	boolean setAdminRole(long adminId ,long roleId)throws BusinessException;
	
}
