package com.longjun.cto.framework.sm.message.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.message.entity.dto.MessageSmsDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageSmsModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageSmsView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * MessageSms Mapper
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public interface MessageSmsMapper extends IMapper<MessageSmsModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	MessageSmsView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<MessageSmsView> getByPage(MessageSmsDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<MessageSmsModel> listModelMap(Map<String,Object> params);
	
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
