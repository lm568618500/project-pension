package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.dto.LogUserDto;
import com.longjun.cto.framework.sm.sys.entity.model.LogUserModel;
import com.longjun.cto.framework.sm.sys.entity.view.LogUserView;

/**
 * 日志-用户Mapper
 * @author yangxuan
 * @date 2018年11月8日 下午6:19:49
 */
public interface LogUserMapper extends IMapper<LogUserModel>{

	/**
	 * 保存
	 * @param model
	 * @return
	 * @throws Exception
	 */
	Long saveModel(LogUserModel model)throws Exception;
	
	/**
	 * 通过ID查询数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	LogUserView getById(long id)throws Exception;
	
	/**
	 * 分页查看
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	List<LogUserView> getByPage(LogUserDto dto)throws Exception;

}
