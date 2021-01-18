package com.longjun.cto.framework.sm.pay.wechat.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatQueryDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatQueryModel;
import com.longjun.cto.framework.sm.pay.wechat.entity.view.PayWechatQueryView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayWechatQuery Mapper
 * @author yangxuan
 * @date 2019-11-07 04:30:51
 */
public interface PayWechatQueryMapper extends IMapper<PayWechatQueryModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public PayWechatQueryView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<PayWechatQueryView> getByPage(PayWechatQueryDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<PayWechatQueryView> listModelMap(Map<String,Object> params);
	
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
