package com.longjun.cto.framework.project.pension.userManagement.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.project.pension.userManagement.entity.dto.UsersDto;
import com.longjun.cto.framework.project.pension.userManagement.entity.model.UsersModel;
import com.longjun.cto.framework.project.pension.userManagement.entity.view.UsersView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * Users Mapper
 * @author carson
 * @date 2019-10-19 07:48:34
 */
public interface UsersMapper extends IMapper<UsersModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public UsersView findViewById(@Param("id") long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<UsersView> getByPage(UsersDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<UsersView> listModelMap(Map<String, Object> params);
	
	/**
	 *  条件总数
	 * @param id
	 * @return
	 */
	public int countMap(Map<String, Object> params);
	
	/**
	 * 软删除
	 * @param id
	 * @return
	 */
	public int del(@Param("id") long id);
	
}
