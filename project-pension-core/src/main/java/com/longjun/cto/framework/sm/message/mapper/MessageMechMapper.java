package com.longjun.cto.framework.sm.message.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.message.entity.dto.MessageMechDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageMechModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageMechView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * MessageMech Mapper
 * @author yangxuan
 * @date 2019-04-05 05:39:44
 */
public interface MessageMechMapper extends IMapper<MessageMechModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	MessageMechView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<MessageMechView> getByPage(MessageMechDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<MessageMechView> listModelMap(Map<String,Object> params);
	
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
