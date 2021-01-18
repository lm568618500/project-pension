package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminOperRecordDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminOperRecordModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminOperRecordView;

/**
 * 操作日志Mapper
 * @author lp
 * @date 2018-12-13 15:54:41
 */
public interface AdminOperRecordMapper extends IMapper<AdminOperRecordModel> {

	List<AdminOperRecordView> getByPage(AdminOperRecordDto dto)throws Exception;

	Integer updates(long[] id)throws Exception;

}
