package com.longjun.cto.framework.sm.pay.alipay.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayQueryDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayQueryModel;
import com.longjun.cto.framework.sm.pay.alipay.entity.view.PayAlipayQueryView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayAlipayQuery Mapper
 * @author yangxuan
 * @date 2019-11-07 06:58:15
 */
public interface PayAlipayQueryMapper extends IMapper<PayAlipayQueryModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public PayAlipayQueryView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<PayAlipayQueryView> getByPage(PayAlipayQueryDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<PayAlipayQueryView> listModelMap(Map<String,Object> params);
	
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
