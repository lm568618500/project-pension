package com.longjun.cto.framework.sm.pay.union.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionQueryDto;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionQueryModel;
import com.longjun.cto.framework.sm.pay.union.entity.view.UnionQueryView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * UnionQuery Mapper
 * @author yangxuan
 * @date 2019-11-02 02:52:27
 */
public interface UnionQueryMapper extends IMapper<UnionQueryModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public UnionQueryView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<UnionQueryView> getByPage(UnionQueryDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<UnionQueryView> listModelMap(Map<String,Object> params);
	
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
