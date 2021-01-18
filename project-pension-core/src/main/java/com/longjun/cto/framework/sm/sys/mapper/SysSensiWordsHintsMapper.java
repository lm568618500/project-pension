package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsHintsDto;
import com.longjun.cto.framework.sm.sys.entity.model.SysSensiWordsHintsModel;
import com.longjun.cto.framework.sm.sys.entity.view.SysSensiWordsHintsView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * SysSensiWordsHints Mapper
 * @author yangxuan
 * @date 2019-04-03 08:38:00
 */
public interface SysSensiWordsHintsMapper extends IMapper<SysSensiWordsHintsModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	SysSensiWordsHintsView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<SysSensiWordsHintsView> getByPage(SysSensiWordsHintsDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<SysSensiWordsHintsModel> listModelMap(Map<String,Object> params);
	
	/**
	 *  条件总数
	 * @param id
	 * @return
	 */
	int countMap(Map<String,Object> params);

	
}
