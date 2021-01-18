package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsDto;
import com.longjun.cto.framework.sm.sys.entity.model.SysSensiWordsModel;
import com.longjun.cto.framework.sm.sys.entity.view.SysSensiWordsView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * SysSensiWords Mapper
 * @author yangxuan
 * @date 2019-04-03 08:38:00
 */
public interface SysSensiWordsMapper extends IMapper<SysSensiWordsModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	SysSensiWordsView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<SysSensiWordsView> getByPage(SysSensiWordsDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<SysSensiWordsModel> listModelMap(Map<String,Object> params);
	
	/**
	 *  条件总数
	 * @param id
	 * @return
	 */
	int countMap(Map<String,Object> params);

	
}
