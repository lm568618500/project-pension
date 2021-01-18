package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminTokenDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminTokenModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminTokenView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * AdminToken Mapper
 * @author EIMS-CODE-BUILD
 * @date 2019-04-01 08:42:03
 */
public interface AdminTokenMapper extends IMapper<AdminTokenModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	AdminTokenView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<AdminTokenView> getByPage(AdminTokenDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<AdminTokenModel> listModelMap(Map<String,Object> params);
	
	/**
	 *  条件总数
	 * @param id
	 * @return
	 */
	int countMap(Map<String,Object> params);

	
}
