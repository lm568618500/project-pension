package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.LogEventDto;
import com.longjun.cto.framework.sm.sys.entity.model.LogEventModel;
import com.longjun.cto.framework.sm.sys.entity.view.LogEventView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * LogEvent Mapper
 * @author yangxuan
 * @date 2019-04-09 01:48:27
 */
public interface LogEventMapper extends IMapper<LogEventModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	LogEventView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<LogEventView> getByPage(LogEventDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<LogEventView> listModelMap(Map<String,Object> params);
	
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
