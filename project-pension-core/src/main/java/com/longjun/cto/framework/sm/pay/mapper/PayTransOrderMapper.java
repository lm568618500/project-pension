package com.longjun.cto.framework.sm.pay.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.entity.dto.PayTransOrderDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayTransOrderModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayTransOrderView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayTransOrder Mapper
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
public interface PayTransOrderMapper extends IMapper<PayTransOrderModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	PayTransOrderView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<PayTransOrderView> getByPage(PayTransOrderDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<PayTransOrderView> listModelMap(Map<String,Object> params);
	
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
