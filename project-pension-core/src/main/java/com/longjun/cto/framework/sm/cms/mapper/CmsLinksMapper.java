package com.longjun.cto.framework.sm.cms.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsLinksDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsLinksModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsLinksView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CmsLinks Mapper
 * @author yangxuan
 * @date 2019-06-18 03:18:47
 */
public interface CmsLinksMapper extends IMapper<CmsLinksModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public CmsLinksView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<CmsLinksView> getByPage(CmsLinksDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<CmsLinksView> listModelMap(Map<String,Object> params);
	
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
