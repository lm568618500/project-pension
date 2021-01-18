package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminOtherDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminOtherModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminOtherView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * AdminOther Mapper
 * @author liuming
 * @date 2019-10-05 04:51:18
 */
public interface AdminOtherMapper extends IMapper<AdminOtherModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public AdminOtherView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<AdminOtherView> getByPage(AdminOtherDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<AdminOtherView> listModelMap(Map<String,Object> params);
	
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
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<AdminOtherView> getByAdminPage(AdminOtherDto dto);
	
}
