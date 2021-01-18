package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonProvinceDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonProvinceModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonProvinceView;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CommonProvince Mapper
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
public interface CommonProvinceMapper extends IMapper<CommonProvinceModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	CommonProvinceView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<CommonProvinceView> getByPage(CommonProvinceDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<CommonProvinceView> listModelMap(Map<String,Object> params);
	
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
	
	/**
	 *  通用API接口查询全部
	 * @param id
	 * @return
	 */
	List<Map<String,Object>> getProvice(CommonProvinceDto dto);
	
}
