package com.longjun.cto.framework.sm.message.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.message.entity.dto.MessageGatwayDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageGatwayModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageGatwayView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * MessageGatway Mapper
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
public interface MessageGatwayMapper extends IMapper<MessageGatwayModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	MessageGatwayView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<MessageGatwayView> getByPage(MessageGatwayDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<MessageGatwayView> listModelMap(Map<String,Object> params);
	
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
