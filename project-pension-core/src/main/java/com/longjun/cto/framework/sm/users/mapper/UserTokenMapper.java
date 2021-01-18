package com.longjun.cto.framework.sm.users.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.users.entity.dto.UserTokenDto;
import com.longjun.cto.framework.sm.users.entity.model.UserTokenModel;
import com.longjun.cto.framework.sm.users.entity.view.UserTokenView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * UserToken Mapper
 * @author yangxuan
 * @date 2019-05-31 05:43:41
 */
public interface UserTokenMapper extends IMapper<UserTokenModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	UserTokenView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<UserTokenView> getByPage(UserTokenDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<UserTokenView> listModelMap(Map<String,Object> params);
	
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
