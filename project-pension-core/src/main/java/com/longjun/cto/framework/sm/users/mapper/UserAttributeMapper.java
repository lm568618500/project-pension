package com.longjun.cto.framework.sm.users.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.users.entity.dto.UserAttributeDto;
import com.longjun.cto.framework.sm.users.entity.model.UserAttributeModel;
import com.longjun.cto.framework.sm.users.entity.view.UserAttributeView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * UserAttribute Mapper
 * @author qiujunbo
 * @date 2019-07-05 05:36:06
 */
public interface UserAttributeMapper extends IMapper<UserAttributeModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public UserAttributeView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<UserAttributeView> getByPage(UserAttributeDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<UserAttributeView> listModelMap(Map<String,Object> params);
	
	/**
	 *  条件总数
	 * @param id
	 * @return
	 */
	public int countMap(Map<String,Object> params);
	
	/**
	 * 软删除
	 * @param id
	 * @return
	 */
	public int del(@Param("id")long id);
	
	
	public List<UserAttributeView> listByUserIdandAttrType(Map<String,Object> params);
	
	public int delByUserIdandAttrType(Map<String,Object> params);
}
