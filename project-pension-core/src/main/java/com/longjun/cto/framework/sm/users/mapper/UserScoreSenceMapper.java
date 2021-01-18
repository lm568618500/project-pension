package com.longjun.cto.framework.sm.users.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.users.entity.dto.UserScoreSenceDto;
import com.longjun.cto.framework.sm.users.entity.model.UserScoreSenceModel;
import com.longjun.cto.framework.sm.users.entity.view.UserScoreSenceView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * UserScoreSence Mapper
 * @author yangxuan
 * @date 2019-07-01 05:05:46
 */
public interface UserScoreSenceMapper extends IMapper<UserScoreSenceModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public UserScoreSenceView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<UserScoreSenceView> getByPage(UserScoreSenceDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<UserScoreSenceView> listModelMap(Map<String,Object> params);
	
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
