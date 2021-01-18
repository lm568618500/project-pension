package com.longjun.cto.framework.sm.cms.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentDto;
import com.longjun.cto.framework.sm.cms.entity.dto.CmsContentModifyDto;
import com.longjun.cto.framework.sm.cms.entity.model.CmsContentModel;
import com.longjun.cto.framework.sm.cms.entity.view.CmsContentView;

import java.util.List;

/**
 * CmsContentModel
 * 
 * @author yangxuan
 * @date 2019-06-18 04:55:15
 */
public interface ICmsContentService extends BaseService<CmsContentModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsContentView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsContentModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(CmsContentModel model) throws BusinessException;

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
	 * 首页推荐
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean toIndex(long id) throws BusinessException;

	/**
	 * 首页推荐
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean toUnIndex(long id) throws BusinessException;

	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public PageUtils<CmsContentView> getByPage(CmsContentDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsContentView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<CmsContentView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(CmsContentModifyDto dto) throws BusinessException;

	/**
	 * 首页文章推荐
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsContentView> listByIndex(int type, int size) throws BusinessException;

	/**
	 * 首页文章推荐
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsContentView> listByIndex(int size) throws BusinessException;

	/**
	 * 通过类型ID查询集合
	 * 
	 * @param typeId
	 * @return
	 * @throws BusinessException
	 */
	public List<CmsContentView> listByTypeId(long typeId) throws BusinessException;

	/**
	 * 修改协议内容
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public boolean modifyPact(CmsContentModifyDto model) throws BusinessException;

	/**
	 * 修改单篇文章内容
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public boolean modifySingle(CmsContentModifyDto model) throws BusinessException;

	/**
	 * 修改单篇文章内容
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public boolean modifyHelper(CmsContentModifyDto model) throws BusinessException;

	/**
	 * 获取上一条新闻数据
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsContentView findLastOne(Long id) throws BusinessException;

	/**
	 * 获取下一条新闻数据
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CmsContentView findNextOne(Long id) throws BusinessException;
}
