package com.longjun.cto.framework.sm.cms.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedInputDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsFeedModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsFeedModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsFeedView;

import java.util.List;

/**
 * CmsFeedModel
 * 
 * @author yangxuan
 * @date 2019-06-23 09:43:05
 */
public interface ICmsFeedService extends BaseService<CmsFeedModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsFeedView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsFeedModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(CmsFeedModel model) throws BusinessException;

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
	public PageUtils<CmsFeedView> getByPage(CmsFeedDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsFeedView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<CmsFeedView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(CmsFeedModifyDto dto) throws BusinessException;

	/**
	 * 保存意见反馈
	 * 
	 * @param cmsFeedInputDto
	 * @return
	 * @throws BusinessException
	 */
	public boolean saveFeed(CmsFeedInputDto cmsFeedInputDto) throws BusinessException;

	/**
	 * 通过feedNo查询
	 * 
	 * @param feedNo
	 * @return
	 * @throws BusinessException
	 */
	public CmsFeedModel findByFeedNo(long feedNo) throws BusinessException;

}
