package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonKvDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonKvModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonKvView;

/**
 * 通用-kv mapper
 * @author yangxuan
 * @date 2018年11月10日 上午7:56:57
 */
public interface CommonKvMapper extends IMapper<CommonKvModel>{

	/**
	 * 查询
	 * @param key
	 * @return
	 * @throws Exception
	 */
	List<CommonKvView> listByK(@Param("k")String key)throws Exception;

	List<CommonKvView> getByPage(CommonKvDto dto)throws Exception;
	
}
