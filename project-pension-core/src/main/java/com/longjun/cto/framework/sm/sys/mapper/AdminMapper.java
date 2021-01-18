package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminView;

/**
 * 管理员Mapper
 * @author lp
 * @date 2018-12-20 20:10:49
 */
public interface AdminMapper extends IMapper<AdminModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	AdminView findViewById(@Param("id")long id);
	
	List<AdminView> getByPage(AdminDto dto);
	List<AdminView> getOtherByPage(AdminDto dto);
	List<AdminView> getExpertByPage(AdminDto dto);
	List<AdminView> getPersonnelByPage(AdminDto dto);
	
	Integer updates(long[] id)throws Exception;
	
	List<Map<String,Object>> getRolList()throws BusinessException;
	
	List<AdminModel> listModelMap(Map<String,Object> params);
	
	int countMap(Map<String,Object> params);
	
	AdminView getById(@Param("id")long id);
	
	void insertAdmin(AdminModel adminModel);

}
