package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.dto.LogAdminDto;
import com.longjun.cto.framework.sm.sys.entity.model.LogAdminModel;
import com.longjun.cto.framework.sm.sys.entity.view.LogAdminView;

/**
 * 日志-管理员Mapper
 * @author yangxuan
 * @date 2018年11月8日 下午6:19:49
 */
public interface LogAdminMapper extends IMapper<LogAdminModel>{

	/**
	 * 保存
	 * @param model
	 * @return
	 * @throws Exception
	 */
	Long saveModel(LogAdminModel model)throws Exception;
	
	/**
	 * 通过ID查询数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	LogAdminView getById(long id)throws Exception;
	
	/**
	 * 分页查看
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	List<LogAdminView> getByPage(LogAdminDto dto)throws Exception;

}
