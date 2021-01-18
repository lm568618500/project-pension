package com.longjun.cto.framework.sm.pay.union.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionPayNotifyDto;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionPayNotifyModel;
import com.longjun.cto.framework.sm.pay.union.entity.view.UnionPayNotifyView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * UnionPayNotify Mapper
 * @author yangxuan
 * @date 2019-10-30 07:39:43
 */
public interface UnionPayNotifyMapper extends IMapper<UnionPayNotifyModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public UnionPayNotifyView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<UnionPayNotifyView> getByPage(UnionPayNotifyDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<UnionPayNotifyView> listModelMap(Map<String,Object> params);
	
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
