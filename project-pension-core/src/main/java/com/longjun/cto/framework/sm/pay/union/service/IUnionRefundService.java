package com.longjun.cto.framework.sm.pay.union.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionRefundDto;
import com.longjun.cto.framework.sm.pay.union.entity.dto.UnionRefundModifyDto;
import com.longjun.cto.framework.sm.pay.union.entity.model.UnionRefundModel;
import com.longjun.cto.framework.sm.pay.union.entity.view.UnionRefundView;

import java.util.List;

/**
 * UnionRefundModel
 * 
 * @author yangxuan
 * @date 2019-11-02 10:59:36
 */
public interface IUnionRefundService extends BaseService<UnionRefundModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UnionRefundView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UnionRefundModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(UnionRefundModel model) throws BusinessException;

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
	public PageUtils<UnionRefundView> getByPage(UnionRefundDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<UnionRefundView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<UnionRefundView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(UnionRefundModifyDto dto) throws BusinessException;

	/**
	 * 通过订单号查询
	 * 
	 * @param orderNo
	 * @return
	 * @throws BusinessException
	 */
	public UnionRefundModel findByOrderNo(String orderNo) throws BusinessException;

}
