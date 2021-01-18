package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonWorldMapDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonWorldMapModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonWorldMapView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CommonWorldMap Mapper
 * @author liuming
 * @date 2019-11-08 03:56:49
 */
public interface CommonWorldMapMapper extends IMapper<CommonWorldMapModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public CommonWorldMapView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<CommonWorldMapView> getByPage(CommonWorldMapDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<CommonWorldMapView> listModelMap(Map<String,Object> params);
	
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
