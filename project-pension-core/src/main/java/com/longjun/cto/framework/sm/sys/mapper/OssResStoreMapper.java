package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResStoreDto;
import com.longjun.cto.framework.sm.sys.entity.model.OssResStoreModel;
import com.longjun.cto.framework.sm.sys.entity.view.OssResStoreView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * OssResStore Mapper
 * @author yangxuan
 * @date 2019-04-16 06:45:47
 */
public interface OssResStoreMapper extends IMapper<OssResStoreModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	OssResStoreView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<OssResStoreView> getByPage(OssResStoreDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<OssResStoreView> listModelMap(Map<String,Object> params);
	
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
