package com.longjun.cto.framework.sm.pay.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayChannelModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayChannelModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayChannelView;

import java.util.List;

/**
 * PayChannelModel
 * 
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
public interface IPayChannelService extends BaseService<PayChannelModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayChannelView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayChannelModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(PayChannelModel model) throws BusinessException;

	/**
	 * 启动/开始
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean start(long id) throws BusinessException;

	/**
	 * 停止/关闭
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean stop(long id) throws BusinessException;

	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public PageUtils<PayChannelView> getByPage(PayChannelDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<PayChannelModel> listByLimitStatus(int status, int limit) throws BusinessException;

	/**
	 * 查询总数
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public int countAll() throws BusinessException;

	/**
	 * 全部记录
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<PayChannelModel> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(PayChannelModifyDto dto) throws BusinessException;

	/**
	 * 通过渠道ID查询
	 * 
	 * @param channelId
	 * @return
	 * @throws BusinessException
	 */
	public List<PayChannelModel> findByChannelId(long mchId, long channelId) throws BusinessException;

	/**
	 * 通过支付渠道-支付方式-商户查询
	 * 
	 * @param channelId
	 * @param channelItemsId
	 * @return
	 * @throws BusinessException
	 */
	public PayChannelModel findByChannelId2ItemId2MchId(long channelId, long channelItemsId, long mchId)
			throws BusinessException;

	/**
	 * 支付宝支付配置文件校验
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public JSONObject checkAliPayProfile(PayChannelModel model) throws BusinessException;

	/**
	 * 微信支付配置文件校验
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public JSONObject checkWechatPayProfile(PayChannelModel model) throws BusinessException;

}
