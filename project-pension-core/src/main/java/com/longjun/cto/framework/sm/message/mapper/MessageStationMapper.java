package com.longjun.cto.framework.sm.message.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.message.entity.dto.MessageStationDto;
import com.longjun.cto.framework.sm.message.entity.model.MessageStationModel;
import com.longjun.cto.framework.sm.message.entity.view.MessageStationView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * MessageStation Mapper
 * @author yangxuan
 * @date 2019-07-04 07:33:46
 */
public interface MessageStationMapper extends IMapper<MessageStationModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public MessageStationView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<MessageStationView> getByPage(MessageStationDto dto);

	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<MessageStationView> getMngByPage(MessageStationDto dto);


	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<MessageStationView> listModelMap(Map<String,Object> params);
	
	/**
	 *  条件总数
	 * @param id
	 * @return
	 */
	public int countMap(Map<String,Object> params);
	
	/**
	 * 软删除
	 * @param id
	 * @return
	 */
	public int del(@Param("id")long id);


	/**
	 * 标记全部已读
	 * @param id
	 * @return
	 */
	int updateByUserNo(@Param("userNo")long id);
	
}
