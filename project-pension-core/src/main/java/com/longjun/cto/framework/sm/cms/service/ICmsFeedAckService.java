package com.longjun.cto.framework.sm.cms.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedAckDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedAckModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsFeedAckModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsFeedAckView;

import java.util.List;

/**
 * CmsFeedAckModel
 * 
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
public interface ICmsFeedAckService extends BaseService<CmsFeedAckModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsFeedAckView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsFeedAckModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(CmsFeedAckModel model) throws BusinessException;

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
	public PageUtils<CmsFeedAckView> getByPage(CmsFeedAckDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsFeedAckView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<CmsFeedAckView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(CmsFeedAckModifyDto dto) throws BusinessException;

	/**
	 * 管理员回复
	 * 
	 * @param adminId
	 * @param feedNo
	 * @param ackContent
	 * @return
	 * @throws BusinessException
	 */
	public boolean ackFeed(long adminId, long feedNo, String ackContent) throws BusinessException;

	/**
	 * 通过feedNo查询对象
	 * 
	 * @param feedNo
	 * @return
	 * @throws BusinessException
	 */
	public CmsFeedAckView findByFeedNo(Long feedNo) throws BusinessException;

}
