package com.longjun.cto.framework.sm.cms.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedAckDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsFeedAckModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsFeedAckView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CmsFeedAck Mapper
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
public interface CmsFeedAckMapper extends IMapper<CmsFeedAckModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public CmsFeedAckView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<CmsFeedAckView> getByPage(CmsFeedAckDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<CmsFeedAckView> listModelMap(Map<String,Object> params);
	
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
