package com.longjun.cto.framework.sm.cms.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsContentModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsContentView;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CmsContent Mapper
 * 
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
public interface CmsContentMapper extends IMapper<CmsContentModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 */
	public CmsContentView findViewById(@Param("id") long id);

	/**
	 * 分页查询
	 * 
	 * @param id
	 * @return
	 */
	public List<CmsContentView> getByPage(CmsContentDto dto);

	/**
	 * 条件
	 * 
	 * @param id
	 * @return
	 */
	public List<CmsContentView> listModelMap(Map<String, Object> params);

	/**
	 * 条件总数
	 * 
	 * @param id
	 * @return
	 */
	public int countMap(Map<String, Object> params);

	/**
	 * 软删除
	 * 
	 * @param id
	 * @return
	 */
	public int del(@Param("id") long id);

	/**
	 * 首页推荐
	 * 
	 * @param type
	 * @return
	 */
	List<CmsContentView> listByIndex(@Param("type") int type, @Param("size") int size);

	/**
	 * 获取上一条新闻数据
	 * 
	 * @param id
	 * @return
	 */
	public CmsContentView findLastOne(@Param("id") Long id);

	/**
	 * 获取下一条新闻数据
	 * 
	 * @param id
	 * @return
	 */
	public CmsContentView findNextOne(@Param("id") Long id);

}
