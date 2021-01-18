package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResourceDto;
import com.longjun.cto.framework.sm.sys.entity.model.OssResourceModel;
import com.longjun.cto.framework.sm.sys.entity.view.OssResourceView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * OssResource Mapper
 * @author yangxuan
 * @date 2019-04-01 07:19:42
 */
public interface OssResourceMapper extends IMapper<OssResourceModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	OssResourceView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<OssResourceView> getByPage(OssResourceDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<OssResourceModel> listModelMap(Map<String,Object> params);
	
	/**
	 *  条件总数
	 * @param id
	 * @return
	 */
	int countMap(Map<String,Object> params);

	
}
