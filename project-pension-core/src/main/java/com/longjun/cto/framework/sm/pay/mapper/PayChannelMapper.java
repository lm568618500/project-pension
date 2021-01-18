package com.longjun.cto.framework.sm.pay.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayChannelView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayChannel Mapper
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
public interface PayChannelMapper extends IMapper<PayChannelModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	PayChannelView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	List<PayChannelView> getByPage(PayChannelDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<PayChannelModel> listModelMap(Map<String,Object> params);
	
	/**
	 *  条件总数
	 * @param id
	 * @return
	 */
	int countMap(Map<String,Object> params);

	
}
