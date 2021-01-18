package com.longjun.cto.framework.sm.pay.union.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionPayDto;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionPayModel;
import com.longjun.cto.framework.sm.pay.union.entity.view.UnionPayView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * UnionPay Mapper
 * @author yangxuan
 * @date 2019-10-30 04:21:52
 */
public interface UnionPayMapper extends IMapper<UnionPayModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public UnionPayView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<UnionPayView> getByPage(UnionPayDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<UnionPayView> listModelMap(Map<String,Object> params);
	
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
