package com.longjun.cto.framework.sm.cms.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentTypeDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentTypeModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsContentTypeModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsContentTypeView;

import java.util.List;

/**
 * CmsContentTypeModel
 * 
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
public interface ICmsContentTypeService extends BaseService<CmsContentTypeModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsContentTypeView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsContentTypeModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(CmsContentTypeModel model) throws BusinessException;

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
	public PageUtils<CmsContentTypeView> getByPage(CmsContentTypeDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsContentTypeView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<CmsContentTypeView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(CmsContentTypeModifyDto dto) throws BusinessException;

	/**
	 * 首页推荐集合
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsContentTypeModel> listByIndex() throws BusinessException;

	/**
	 * 通过分类查询集合
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsContentTypeView> listByClassId(long classID) throws BusinessException;

	/**
	 * 帮助中心。支持2级分类数据
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsContentTypeView> helpCenter() throws BusinessException;

}
