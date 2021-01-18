package com.longjun.cto.framework.sm.pay.wechat.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatQueryDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.dto.PayWechatQueryModifyDto;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatQueryModel;
import com.longjun.cto.framework.sm.pay.wechat.entity.view.PayWechatQueryView;

import java.util.List;

/**
 * PayWechatQueryModel
 * 
 * @author yangxuan
 * @date 2019-11-07 04:30:51
 */
public interface IPayWechatQueryService extends BaseService<PayWechatQueryModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayWechatQueryView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayWechatQueryModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(PayWechatQueryModel model) throws BusinessException;

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
	public PageUtils<PayWechatQueryView> getByPage(PayWechatQueryDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<PayWechatQueryView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<PayWechatQueryView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(PayWechatQueryModifyDto dto) throws BusinessException;

	/**
	 * 是否成功
	 * 
	 * @param outTradeNo
	 * @return
	 * @throws BusinessException
	 */
	public PayWechatQueryModel findBySuccessOutTradeNo(String outTradeNo) throws BusinessException;

}
