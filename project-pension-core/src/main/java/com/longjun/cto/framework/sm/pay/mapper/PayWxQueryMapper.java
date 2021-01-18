package com.longjun.cto.framework.sm.pay.mapper;

import java.util.List;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.pay.entity.dto.PayWxQueryDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayWxQueryModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayWxQueryView;

/**
 * 微信支付-查询Mapper
 * @author yangxuan
 * @date 2019-02-23 09:05:59
 */
public interface PayWxQueryMapper extends IMapper<PayWxQueryModel> {

	List<PayWxQueryView> getByPage(PayWxQueryDto dto)throws Exception;

	

}
