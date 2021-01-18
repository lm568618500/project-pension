package com.longjun.cto.framework.sm.pay.mapper;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.pay.entity.dto.PayOrderDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayOrderModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayOrderView;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 支付订单 Mapper
 * 
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
public interface PayOrderMapper extends IMapper<PayOrderModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 */
	PayOrderView findViewById(@Param("id") long id);

	/**
	 * 分页查询
	 * 
	 * @param id
	 * @return
	 */
	List<PayOrderView> getByPage(PayOrderDto dto);

	/**
	 * 条件
	 * 
	 * @param id
	 * @return
	 */
	List<PayOrderView> listModelMap(Map<String, Object> params);

	/**
	 * 条件总数
	 * 
	 * @param id
	 * @return
	 */
	int countMap(Map<String, Object> params);

	/**
	 * 软删除
	 * 
	 * @param id
	 * @return
	 */
	int del(@Param("id") long id);

}
