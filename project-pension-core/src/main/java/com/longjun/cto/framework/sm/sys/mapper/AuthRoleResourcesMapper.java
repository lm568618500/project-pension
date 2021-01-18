package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleResourcesModel;
import com.longjun.cto.framework.sm.sys.entity.view.AuthRoleResourcesView;

/**
 * 鉴权资源Mapper
 * @author yangxuan
 * @date 2018年11月5日 下午5:08:32
 */
public interface AuthRoleResourcesMapper extends BaseMapper<AuthRoleResourcesModel>{

	/**
	 * 通过AdminId查询鉴权资源
	 * @param adminId
	 * @return
	 * @throws Exception
	 */
	public List<AuthRoleResourcesView> getListByAdminId(@Param("adminId")long adminId)throws Exception;
	
	/**
	 * 通过AdminId查询鉴权资源
	 * @param adminId
	 * @return
	 * @throws Exception
	 */
	public AuthRoleResourcesView getByAdminIdAndUrl(@Param("adminId")long adminId , @Param("resUrl")String url)throws Exception;
	
	/**
	 * 通过RoleId修改状态
	 * @param roleId
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public int setStatusByRoleId(@Param("roleId")long roleId , @Param("status")int status)throws Exception;
	
	/**
	 * 通过resourcesId 修改状态
	 * @param resourcesId
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	public int setStatusByResourcesId(@Param("resourcesId")long resourcesId , @Param("status")int status)throws Exception;
	
	/**
	 * 保存
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Long saveModel(AuthRoleResourcesModel model)throws Exception;
	
	
	/**
	 * 初始化信息
	 * @param roleId
	 */
	public void updateInitAuthRolesByRoleId(@Param("roleId")long roleId);
	
}
