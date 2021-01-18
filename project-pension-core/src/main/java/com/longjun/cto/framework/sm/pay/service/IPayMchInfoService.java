package com.longjun.cto.framework.sm.pay.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.entity.dto.PayMchInfoDto;
import com.longjun.cto.framework.sm.pay.entity.dto.PayMchInfoModifyDto;
import com.longjun.cto.framework.sm.pay.entity.model.PayMchInfoModel;
import com.longjun.cto.framework.sm.pay.entity.view.PayMchInfoView;

import java.util.List;

/**
 * PayMchInfoModel
 * @author yangxuan
 * @date 2019-03-31 05:17:13
 */
public interface IPayMchInfoService extends BaseService<PayMchInfoModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayMchInfoView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public PayMchInfoModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(PayMchInfoModel model)throws BusinessException;
	
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
	public PageUtils<PayMchInfoView> getByPage(PayMchInfoDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<PayMchInfoModel> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	public List<PayMchInfoModel> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(PayMchInfoModifyDto dto)throws BusinessException;
	
	/**
	 * 商户ID
	 * @param mchId
	 * @return
	 * @throws BusinessException
	 */
	public PayMchInfoModel getByMchId(long mchId)throws BusinessException;
	
	/**
	 * 获取默认单条商户信息-一个平台只有1个商户信息。开发人员维护
	 * @return
	 * @throws BusinessException
	 */
	public PayMchInfoModel defaultMchInfo()throws BusinessException;
	
}
