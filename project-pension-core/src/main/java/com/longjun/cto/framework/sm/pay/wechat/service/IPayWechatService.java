package com.longjun.cto.framework.sm.pay.wechat.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatModifyDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatModel;
import com.longjun.cto.framework.sm.pay.wechat.entity.view.PayWechatView;

import java.util.List;

/**
 * PayWechatModel
 * 
 * @author yangxuan
 * @date 2019-11-07 02:13:18
 */
public interface IPayWechatService extends BaseService<PayWechatModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayWechatView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayWechatModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(PayWechatModel model) throws BusinessException;

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
	 * 删除
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean del(long id) throws BusinessException;

	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public PageUtils<PayWechatView> getByPage(PayWechatDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<PayWechatView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<PayWechatView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(PayWechatModifyDto dto) throws BusinessException;

	/**
	 * 作废数据
	 * 
	 * @param outTradeNo
	 * @return
	 * @throws BusinessException
	 */
	public boolean failOutTradeNo(String outTradeNo) throws BusinessException;

	/**
	 * 修改支付成功信息
	 * 
	 * @param transactionId
	 * @return
	 * @throws BusinessException
	 */
	public boolean updatePaySuccessInfo(String outTradeNo, String transactionId) throws BusinessException;

	/**
	 * 通过outTradeNo查询
	 * 
	 * @param outTradeNo
	 * @return
	 * @throws BusinessException
	 */
	public PayWechatModel findByOutTradeNo(String outTradeNo) throws BusinessException;

}
