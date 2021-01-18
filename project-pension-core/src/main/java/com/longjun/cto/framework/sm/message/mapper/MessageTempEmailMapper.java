package com.longjun.cto.framework.sm.message.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.message.entity.dto.MessageTempEmailDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageTempEmailModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageTempEmailView;

/**
 * MessageTempEmail Mapper
 * @author yangxuan
 * @date 2019-04-06 09:59:14
 */
public interface MessageTempEmailMapper extends IMapper<MessageTempEmailModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	MessageTempEmailView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<MessageTempEmailView> getByPage(MessageTempEmailDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<MessageTempEmailView> listModelMap(Map<String,Object> params);
	
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
