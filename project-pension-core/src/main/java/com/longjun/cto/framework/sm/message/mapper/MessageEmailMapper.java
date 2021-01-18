package com.longjun.cto.framework.sm.message.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.message.entity.dto.MessageEmailDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageEmailModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageEmailView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * MessageEmail Mapper
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public interface MessageEmailMapper extends IMapper<MessageEmailModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	MessageEmailView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<MessageEmailView> getByPage(MessageEmailDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<MessageEmailModel> listModelMap(Map<String,Object> params);
	
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
