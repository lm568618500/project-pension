package com.longjun.cto.framework.sm.cms.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentTypeDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsContentTypeModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsContentTypeView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CmsContentType Mapper
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
public interface CmsContentTypeMapper extends IMapper<CmsContentTypeModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public CmsContentTypeView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<CmsContentTypeView> getByPage(CmsContentTypeDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<CmsContentTypeView> listModelMap(Map<String,Object> params);
	
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
