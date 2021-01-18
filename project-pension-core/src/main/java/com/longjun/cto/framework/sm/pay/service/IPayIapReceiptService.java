package com.longjun.cto.framework.sm.pay.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.entity.dto.PayIapReceiptDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayIapReceiptModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayIapReceiptModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayIapReceiptView;

import java.util.List;

/**
 * PayIapReceiptModel
 * @author yangxuan
 * @date 2019-03-31 05:17:12
 */
public interface IPayIapReceiptService extends BaseService<PayIapReceiptModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayIapReceiptView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayIapReceiptModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(PayIapReceiptModel model)throws BusinessException;
	
	/**
	 * 启动/开始
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	boolean start(long id) throws BusinessException;

	/**
	 * 停止/关闭
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	boolean stop(long id) throws BusinessException;
	
	
	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<PayIapReceiptView> getByPage(PayIapReceiptDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	List<PayIapReceiptModel> listByLimitStatus(int status , int limit)throws BusinessException;
	
	/**
	 * 查询总数
	 * @return
	 * @throws BusinessException
	 */
	int countAll()throws BusinessException;
	
	
	/**
	 * 全部记录
	 * @return
	 * @throws BusinessException
	 */
	List<PayIapReceiptModel> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	boolean modify(PayIapReceiptModifyDto dto)throws BusinessException;
	
}
