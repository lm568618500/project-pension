package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonDictDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonDictModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonDictView;

/**
 * 通用字典表Mapper
 * @author jerry
 * @date 2018-11-29 10:08:33
 */
public interface CommonDictMapper extends IMapper<CommonDictModel> {

	List<CommonDictView> getByPage(CommonDictDto dto) throws Exception;

}
