package com.longjun.cto.framework.sm.users.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.users.entity.dto.UserAddressDto;
import com.longjun.cto.framework.sm.users.entity.model.UserAddressModel;
import com.longjun.cto.framework.sm.users.entity.view.UserAddressView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * UserAddress Mapper
 * @author heqiang
 * @date 2019-07-03 06:22:57
 */
public interface UserAddressMapper extends IMapper<UserAddressModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public UserAddressView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<UserAddressView> getByPage(UserAddressDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<UserAddressView> listModelMap(Map<String,Object> params);
	
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
