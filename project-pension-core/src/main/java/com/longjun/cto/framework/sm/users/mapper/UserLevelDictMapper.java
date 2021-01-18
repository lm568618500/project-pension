package com.longjun.cto.framework.sm.users.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.users.entity.dto.UserLevelDictDto;
import com.longjun.cto.framework.sm.users.entity.model.UserLevelDictModel;
import com.longjun.cto.framework.sm.users.entity.view.UserLevelDictView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * UserLevelDict Mapper
 * @author yangxuan
 * @date 2019-06-28 04:46:45
 */
public interface UserLevelDictMapper extends IMapper<UserLevelDictModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public UserLevelDictView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<UserLevelDictView> getByPage(UserLevelDictDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<UserLevelDictView> listModelMap(Map<String,Object> params);
	
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
	
}
