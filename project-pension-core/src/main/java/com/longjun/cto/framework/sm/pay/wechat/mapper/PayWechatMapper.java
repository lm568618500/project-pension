package com.longjun.cto.framework.sm.pay.wechat.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatModel;
import com.longjun.cto.framework.sm.pay.wechat.entity.view.PayWechatView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayWechat Mapper
 * @author yangxuan
 * @date 2019-11-07 02:13:18
 */
public interface PayWechatMapper extends IMapper<PayWechatModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public PayWechatView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<PayWechatView> getByPage(PayWechatDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<PayWechatView> listModelMap(Map<String,Object> params);
	
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
