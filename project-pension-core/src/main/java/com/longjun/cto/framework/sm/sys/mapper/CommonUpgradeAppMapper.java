package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeAppDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonUpgradeAppModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonUpgradeAppView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CommonUpgradeApp Mapper
 * @author yangxuan
 * @date 2019-04-09 08:42:08
 */
public interface CommonUpgradeAppMapper extends IMapper<CommonUpgradeAppModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	CommonUpgradeAppView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<CommonUpgradeAppView> getByPage(CommonUpgradeAppDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<CommonUpgradeAppView> listModelMap(Map<String,Object> params);
	
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
