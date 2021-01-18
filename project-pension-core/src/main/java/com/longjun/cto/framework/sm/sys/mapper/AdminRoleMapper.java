package com.longjun.cto.framework.sm.sys.mapper;

import org.apache.ibatis.annotations.Param;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.model.AdminRoleModel;

/**
 * 管理员-角色Mapper
 * @author yangxuan
 * @date 2018年11月15日下午7:49:10
 */
public interface AdminRoleMapper extends IMapper<AdminRoleModel>{

	/**
	 * 保存
	 * @param model
	 * @return
	 * @throws Exception
	 */
	Long saveModel(AdminRoleModel model)throws Exception;
	
	/**
	 * 通过AdminId修改状态
	 * @param adminId
	 * @param status
	 * @return
	 * @throws Exception
	 */
	int setStatusByAdminId(@Param("adminId")long adminId , @Param("status")int status)throws Exception;
	
	/**
	 * 通过RoleId修改状态, 可能会删除角色
	 * @param roleId
	 * @param status
	 * @return
	 * @throws Exception
	 */
	int setStatusByRoleId(@Param("roleId")long roleId ,@Param("status")int status)throws Exception;
}
