package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonAreaDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonAreaModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonAreaView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CommonArea Mapper
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
public interface CommonAreaMapper extends IMapper<CommonAreaModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	CommonAreaView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<CommonAreaView> getByPage(CommonAreaDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<CommonAreaView> listModelMap(Map<String,Object> params);
	
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
	List<Map<String,Object>> getAreaByCId(String cityId);
	
}
