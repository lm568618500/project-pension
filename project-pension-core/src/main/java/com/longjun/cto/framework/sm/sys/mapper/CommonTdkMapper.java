package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonTdkDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonTdkModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonTdkView;

/**
 * Mapper
 * @author yangxuan
 * @date 2018-11-26 10:56:04
 */
public interface CommonTdkMapper extends IMapper<CommonTdkModel> {

	List<CommonTdkView> getByPage(CommonTdkDto dto)throws Exception;

	

}
