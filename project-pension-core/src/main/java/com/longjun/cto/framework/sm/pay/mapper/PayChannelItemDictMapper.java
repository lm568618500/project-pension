package com.longjun.cto.framework.sm.pay.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelItemDictDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelItemDictModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayChannelItemDictView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayChannelItemDict Mapper
 * @author yangxuan
 * @date 2019-04-11 09:14:27
 */
public interface PayChannelItemDictMapper extends IMapper<PayChannelItemDictModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	PayChannelItemDictView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<PayChannelItemDictView> getByPage(PayChannelItemDictDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<PayChannelItemDictView> listModelMap(Map<String,Object> params);
	
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
