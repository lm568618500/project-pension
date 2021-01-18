package com.longjun.cto.framework.sm.pay.alipay.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayNotifyDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayNotifyModel;
import com.longjun.cto.framework.sm.pay.alipay.entity.view.PayAlipayNotifyView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayAlipayNotify Mapper
 * @author yangxuan
 * @date 2019-11-07 06:58:15
 */
public interface PayAlipayNotifyMapper extends IMapper<PayAlipayNotifyModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public PayAlipayNotifyView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<PayAlipayNotifyView> getByPage(PayAlipayNotifyDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<PayAlipayNotifyView> listModelMap(Map<String,Object> params);
	
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
