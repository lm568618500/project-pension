package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonUpgradeModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonUpgradeView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CommonUpgrade Mapper
 * @author yangxuan
 * @date 2019-04-04 07:49:24
 */
public interface CommonUpgradeMapper extends IMapper<CommonUpgradeModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	CommonUpgradeView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<CommonUpgradeView> getByPage(CommonUpgradeDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<CommonUpgradeModel> listModelMap(Map<String,Object> params);
	
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
