package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResSettingDto;
import com.longjun.cto.framework.sm.sys.entity.model.OssResSettingModel;
import com.longjun.cto.framework.sm.sys.entity.view.OssResSettingView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * OssResSetting Mapper
 * @author yangxuan
 * @date 2019-04-16 06:45:48
 */
public interface OssResSettingMapper extends IMapper<OssResSettingModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	OssResSettingView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<OssResSettingView> getByPage(OssResSettingDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<OssResSettingView> listModelMap(Map<String,Object> params);
	
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
