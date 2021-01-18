package com.longjun.cto.framework.sm.cms.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsFeedModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsFeedView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CmsFeed Mapper
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
public interface CmsFeedMapper extends IMapper<CmsFeedModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public CmsFeedView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<CmsFeedView> getByPage(CmsFeedDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<CmsFeedView> listModelMap(Map<String,Object> params);
	
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
