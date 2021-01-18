package com.longjun.cto.framework.sm.pay.union.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.union.bean.UnionPayNotifyBean;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionPayNotifyDto;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionPayNotifyModifyDto;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionPayNotifyModel;
import com.longjun.cto.framework.sm.pay.union.entity.view.UnionPayNotifyView;

import java.util.List;

/**
 * UnionPayNotifyModel
 * 
 * @author yangxuan
 * @date 2019-10-30 07:39:43
 */
public interface IUnionPayNotifyService extends BaseService<UnionPayNotifyModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UnionPayNotifyView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UnionPayNotifyModel findModelById(long id) throws BusinessException;

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
	public PageUtils<UnionPayNotifyView> getByPage(UnionPayNotifyDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<UnionPayNotifyView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<UnionPayNotifyView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(UnionPayNotifyModifyDto dto) throws BusinessException;

	/**
	 * 通过订单号查询
	 * 
	 * @param orderNo
	 * @param transtype P036 退款异步通知 P033 支付异步通知
	 * @return
	 * @throws BusinessException
	 */
	public UnionPayNotifyModel findByOrderNo(String orderNo, String transtype) throws BusinessException;

}
