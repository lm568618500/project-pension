package com.longjun.cto.framework.sm.cms.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsBannerLocationDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsBannerLocationModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsBannerLocationView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CmsBannerLocation Mapper
 * @author yangxuan
 * @date 2019-06-19 08:33:45
 */
public interface CmsBannerLocationMapper extends IMapper<CmsBannerLocationModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public CmsBannerLocationView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<CmsBannerLocationView> getByPage(CmsBannerLocationDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<CmsBannerLocationView> listModelMap(Map<String,Object> params);
	
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
