package com.longjun.cto.framework.sm.users.mapper;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.users.entity.dto.UserDto;
import com.longjun.cto.framework.sm.users.entity.model.UserModel;
import com.longjun.cto.framework.sm.users.entity.view.UserView;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * User Mapper
 * 
 * @author yangxuan
 * @date 2019-06-19 02:29:35
 */
public interface UserMapper extends IMapper<UserModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 */
	public UserView findViewById(@Param("id") long id);

	/**
	 * 分页查询
	 * 
	 * @param id
	 * @return
	 */
	public List<UserView> getByPage(UserDto dto);

	/**
	 * 条件
	 * 
	 * @param id
	 * @return
	 */
	public List<UserView> listModelMap(Map<String, Object> params);

	/**
	 * 条件总数
	 * 
	 * @param id
	 * @return
	 */
	public int countMap(Map<String, Object> params);

	/**
	 * 软删除
	 * 
	 * @param id
	 * @return
	 */
	public int del(@Param("id") long id);

	/**
	 * 修改积分
	 * 
	 * @param userId
	 * @param score
	 * @return
	 */
	public int updateScore(@Param("id") long userId, @Param("score") long score);

}
