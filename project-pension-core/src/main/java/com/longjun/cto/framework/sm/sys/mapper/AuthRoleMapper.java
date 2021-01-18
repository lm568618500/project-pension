package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.AuthRoleDto;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleModel;
import com.longjun.cto.framework.sm.sys.entity.view.AuthRoleView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * AuthRole Mapper
 * @author yangxuan
 * @date 2019-04-07 03:17:44
 */
public interface AuthRoleMapper extends IMapper<AuthRoleModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	AuthRoleView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<AuthRoleView> getByPage(AuthRoleDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<AuthRoleView> listModelMap(Map<String,Object> params);
	
	/**
	 *  条件总数
	 * @param id
	 * @return
	 */
	int countMap(Map<String,Object> params);
	
	/**
	 * 软删除
	 * @param id
	 * @return
	 */
	int del(@Param("id")long id);
	
}
