package com.longjun.cto.framework.sm.users.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.users.entity.dto.UserScoreRecordDto;
import com.longjun.cto.framework.sm.users.entity.model.UserScoreRecordModel;
import com.longjun.cto.framework.sm.users.entity.view.UserScoreRecordView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * UserScoreRecord Mapper
 * @author yangxuan
 * @date 2019-06-28 04:46:45
 */
public interface UserScoreRecordMapper extends IMapper<UserScoreRecordModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public UserScoreRecordView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<UserScoreRecordView> getByPage(UserScoreRecordDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<UserScoreRecordView> listModelMap(Map<String,Object> params);
	
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
	
}
