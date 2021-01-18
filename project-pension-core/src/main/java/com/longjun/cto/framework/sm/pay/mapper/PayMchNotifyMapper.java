package com.longjun.cto.framework.sm.pay.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.entity.dto.PayMchNotifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayMchNotifyModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayMchNotifyView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayMchNotify Mapper
 * @author yangxuan
 * @date 2019-03-31 05:17:13
 */
public interface PayMchNotifyMapper extends IMapper<PayMchNotifyModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	PayMchNotifyView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<PayMchNotifyView> getByPage(PayMchNotifyDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<PayMchNotifyModel> listModelMap(Map<String,Object> params);
	
	/**
	 *  条件总数
	 * @param id
	 * @return
	 */
	int countMap(Map<String,Object> params);

	
}
