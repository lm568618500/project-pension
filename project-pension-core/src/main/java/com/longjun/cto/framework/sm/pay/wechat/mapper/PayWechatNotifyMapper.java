package com.longjun.cto.framework.sm.pay.wechat.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatNotifyDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatNotifyModel;
import com.longjun.cto.framework.sm.pay.wechat.entity.view.PayWechatNotifyView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * PayWechatNotify Mapper
 * @author yangxuan
 * @date 2019-11-07 02:51:58
 */
public interface PayWechatNotifyMapper extends IMapper<PayWechatNotifyModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public PayWechatNotifyView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<PayWechatNotifyView> getByPage(PayWechatNotifyDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<PayWechatNotifyView> listModelMap(Map<String,Object> params);
	
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
