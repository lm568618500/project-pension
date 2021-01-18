package com.longjun.cto.framework.sm.cms.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsBannerDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsBannerModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsBannerView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CmsBanner Mapper
 * @author yangxuan
 * @date 2019-06-19 08:33:45
 */
public interface CmsBannerMapper extends IMapper<CmsBannerModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public CmsBannerView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<CmsBannerView> getByPage(CmsBannerDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<CmsBannerView> listModelMap(Map<String,Object> params);
	
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
