package com.longjun.cto.framework.sm.pay.alipay.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayQueryDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.dto.PayAlipayQueryModifyDto;
import com.longjun.cto.framework.sm.pay.alipay.entity.model.PayAlipayQueryModel;
import com.longjun.cto.framework.sm.pay.alipay.entity.view.PayAlipayQueryView;
import com.longjun.cto.framework.sm.pay.wechat.entity.model.PayWechatQueryModel;

import java.util.List;

/**
 * PayAlipayQueryModel
 * @author yangxuan
 * @date 2019-11-07 06:58:15
 */
public interface IPayAlipayQueryService extends BaseService<PayAlipayQueryModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayAlipayQueryView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayAlipayQueryModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(PayAlipayQueryModel model)throws BusinessException;
	
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
	public PageUtils<PayAlipayQueryView> getByPage(PayAlipayQueryDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<PayAlipayQueryView> listByLimitStatus(int status , int limit)throws BusinessException;
	
	/**
	 * 查询总数
	 * @return
	 * @throws BusinessException
	 */
	public int countAll()throws BusinessException;
	
	
	/**
	 * 全部记录
	 * @return
	 * @throws BusinessException
	 */
	public List<PayAlipayQueryView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(PayAlipayQueryModifyDto dto)throws BusinessException;
	

	/**
	 * 是否成功
	 * 
	 * @param outTradeNo
	 * @return
	 * @throws BusinessException
	 */
	public PayAlipayQueryModel findBySuccessOutTradeNo(String outTradeNo) throws BusinessException;
}
