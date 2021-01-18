package com.longjun.cto.framework.sm.pay.logs.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.logs.entity.dto.PayApiLogsDto;
import com.longjun.cto.framework.sm.pay.logs.entity.model.PayApiLogsModel;
import com.longjun.cto.framework.sm.pay.logs.entity.view.PayApiLogsView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayApiLogs Mapper
 * @author yangxuan
 * @date 2019-11-07 05:48:12
 */
public interface PayApiLogsMapper extends IMapper<PayApiLogsModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public PayApiLogsView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<PayApiLogsView> getByPage(PayApiLogsDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<PayApiLogsView> listModelMap(Map<String,Object> params);
	
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
