package com.longjun.cto.framework.sm.pay.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelDictDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelDictModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayChannelDictView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayChannelDict Mapper
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
public interface PayChannelDictMapper extends IMapper<PayChannelDictModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	PayChannelDictView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<PayChannelDictView> getByPage(PayChannelDictDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<PayChannelDictView> listModelMap(Map<String,Object> params);
	
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
