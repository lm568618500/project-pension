package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonBanksDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonBanksModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonBanksView;

/**
 * 通用-银行表Mapper
 * @author yangxuan
 * @date 2018-11-24 13:39:27
 */
public interface CommonBanksMapper extends IMapper<CommonBanksModel> {

	List<CommonBanksView> getByPage(CommonBanksDto dto)throws Exception;

	

}
