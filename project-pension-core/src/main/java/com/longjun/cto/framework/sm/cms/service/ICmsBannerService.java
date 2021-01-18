package com.longjun.cto.framework.sm.cms.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsBannerDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsBannerModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsBannerModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsBannerView;

import java.util.List;

/**
 * CmsBannerModel
 * 
 * @author yangxuan
 * @date 2019-06-19 08:33:45
 */
public interface ICmsBannerService extends BaseService<CmsBannerModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsBannerView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsBannerModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(CmsBannerModel model) throws BusinessException;

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
	public PageUtils<CmsBannerView> getByPage(CmsBannerDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsBannerView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<CmsBannerView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(CmsBannerModifyDto dto) throws BusinessException;

	/**
	 * 通过位置ID查询列表集合
	 * 
	 * @param locationId
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsBannerView> listByLocation(long locationId) throws BusinessException;

}
