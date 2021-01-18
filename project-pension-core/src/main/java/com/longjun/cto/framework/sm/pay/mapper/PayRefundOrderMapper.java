package com.longjun.cto.framework.sm.pay.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.entity.dto.PayRefundOrderDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayRefundOrderModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayRefundOrderView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayRefundOrder Mapper
 * @author yangxuan
 * @date 2019-04-11 07:03:47
 */
public interface PayRefundOrderMapper extends IMapper<PayRefundOrderModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	PayRefundOrderView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<PayRefundOrderView> getByPage(PayRefundOrderDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<PayRefundOrderView> listModelMap(Map<String,Object> params);
	
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
