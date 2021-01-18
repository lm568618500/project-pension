package com.longjun.cto.framework.sm.cms.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsLinksDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsLinksModifyDto;
import com.longjun.cto.framework.sm.cms.entity.es.CmsLinksEnums;
import com.longjun.cto.framework.sm.cms.entity.model.CmsLinksModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsLinksView;

import java.util.List;

/**
 * CmsLinksModel
 * 
 * @author yangxuan
 * @date 2019-06-18 03:18:47
 */
public interface ICmsLinksService extends BaseService<CmsLinksModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsLinksView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsLinksModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(CmsLinksModel model) throws BusinessException;

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
	public PageUtils<CmsLinksView> getByPage(CmsLinksDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsLinksView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<CmsLinksView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(CmsLinksModifyDto dto) throws BusinessException;

	/**
	 * 获取首页信息
	 * 
	 * @param cmsLinksEnums
	 * @param size
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsLinksView> listByIndex(CmsLinksEnums cmsLinksEnums) throws BusinessException;
	
	/**
	 * 获取首页信息
	 * 
	 * @param cmsLinksEnums
	 * @param size
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsLinksView> listByIndex(int size , CmsLinksEnums cmsLinksEnums) throws BusinessException;

}
