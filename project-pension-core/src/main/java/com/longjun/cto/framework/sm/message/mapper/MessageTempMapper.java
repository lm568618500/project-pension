package com.longjun.cto.framework.sm.message.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageTempModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageTempView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * MessageTemp Mapper
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public interface MessageTempMapper extends IMapper<MessageTempModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	MessageTempView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<MessageTempView> getByPage(MessageTempDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<MessageTempView> listModelMap(Map<String,Object> params);
	
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
