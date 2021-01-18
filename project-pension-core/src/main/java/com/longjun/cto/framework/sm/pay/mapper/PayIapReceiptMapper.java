package com.longjun.cto.framework.sm.pay.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.entity.dto.PayIapReceiptDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayIapReceiptModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayIapReceiptView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayIapReceipt Mapper
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
public interface PayIapReceiptMapper extends IMapper<PayIapReceiptModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	PayIapReceiptView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<PayIapReceiptView> getByPage(PayIapReceiptDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<PayIapReceiptModel> listModelMap(Map<String,Object> params);
	
	/**
	 *  条件总数
	 * @param id
	 * @return
	 */
	int countMap(Map<String,Object> params);

	
}
