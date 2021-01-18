package com.longjun.cto.framework.sm.sys.service;

import java.util.List;
import java.util.Map;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleResourcesModel;
import com.longjun.cto.framework.sm.sys.entity.view.AuthRoleResourcesView;

/**
 * 鉴权资源服务
 * @author yangxuan
 * @date 2018年11月6日 下午11:08:55
 */
public interface IAuthRoleResourcesService extends BaseService<AuthRoleResourcesModel>{
	
	/**
	 * 通过AdminId查询鉴权资源
	 * @param adminId
	 * @return
	 * @throws BusinessException
	 */
	public List<AuthRoleResourcesView> getListByAdminId(long adminId)throws BusinessException;
	

	/**
	 * 通过AdminId查询鉴权资源
	 * @param adminId
	 * @return
	 * @throws BusinessException
	 */
	public AuthRoleResourcesView getByAdminIdAndUrl(long adminId , String url)throws BusinessException;
	
	/**
	 * 管理员菜单
	 * @param adminId
	 * @return
	 * @throws BusinessException
	 */
	public List<AuthRoleResourcesView> menus(long adminId)throws BusinessException;
	
	/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public Long saveModel(AuthRoleResourcesModel model)throws BusinessException;
	

	/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(List<AuthRoleResourcesModel> model)throws BusinessException;
	
	/**
	 * 通过RoleId修改状态
	 * @param roleId
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	public boolean setStatusByRoleId(long roleId , int status)throws BusinessException;
	
	/**
	 * 通过resourcesId 修改状态
	 * @param resourcesId
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	public boolean setStatusByResourcesId(long resourcesId , int status)throws BusinessException;
	
	/**
	 * 健 - resourcesId - 为编辑权限组使用
	 * @param roleId
	 * @return
	 * @throws BusinessException
	 */
	public Map<Long ,AuthRoleResourcesView> mapByRoleId(long roleId)throws BusinessException;
	
	/**
	 * 控制模型-不做全部初始化，此方法对已存在的数据进行更新，不存在的进行新增
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public boolean controlModel(AuthRoleResourcesModel model)throws BusinessException;
	
	
	/**
	 * 管理员顶部
	 * @param adminId
	 * @return
	 * @throws BusinessException
	 */
	public List<AuthRoleResourcesView> topMenus(long adminId)throws BusinessException;
	

	
	/**
	 * 管理员顶部子菜单
	 * @param adminId
	 * @return
	 * @throws BusinessException
	 */
	public List<AuthRoleResourcesView> topChidrenMenus(long adminId, long parentId)throws BusinessException;
	
	/**
	 * 获取我的菜单集合Map。用于权限编辑使用
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	public Map<Long , AuthRoleResourcesModel> findMenusByRoleId(long roleId) throws BusinessException;
	
	/**
	 * 初始化角色信息
	 * @param roleId
	 * @throws BusinessException
	 */
	public void initAuthRolesByRoleId(long roleId)throws BusinessException;
	
	

}
