package com.longjun.cto.framework.sm.pay.alipay.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayOrderDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayOrderModel;
import com.longjun.cto.framework.sm.pay.alipay.entity.view.PayAlipayOrderView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayAlipayOrder Mapper
 * @author yangxuan
 * @date 2019-11-07 05:39:27
 */
public interface PayAlipayOrderMapper extends IMapper<PayAlipayOrderModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public PayAlipayOrderView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<PayAlipayOrderView> getByPage(PayAlipayOrderDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<PayAlipayOrderView> listModelMap(Map<String,Object> params);
	
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
