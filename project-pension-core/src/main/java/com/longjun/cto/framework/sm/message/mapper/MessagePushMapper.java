package com.longjun.cto.framework.sm.message.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.message.entity.dto.MessagePushDto;
import com.longjun.cto.framework.sm.message.entity.model.MessagePushModel;
import com.longjun.cto.framework.sm.message.entity.view.MessagePushView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * MessagePush Mapper
 * @author yangxuan
 * @date 2019-05-30 09:21:36
 */
public interface MessagePushMapper extends IMapper<MessagePushModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	MessagePushView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<MessagePushView> getByPage(MessagePushDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<MessagePushView> listModelMap(Map<String,Object> params);
	
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
