package com.longjun.cto.framework.project.pension.finance.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeFourDto;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeFourModifyDto;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeFourModel;
import com.longjun.cto.framework.project.pension.finance.entity.view.NewTypeFourView;

import java.util.List;

/**
 * NewTypeFourModel
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
public interface INewTypeFourService extends BaseService<NewTypeFourModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public NewTypeFourView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public NewTypeFourModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(NewTypeFourModel model)throws BusinessException;
	
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
	public PageUtils<NewTypeFourView> getByPage(NewTypeFourDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<NewTypeFourView> listByLimitStatus(int status, int limit)throws BusinessException;
	
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
	public List<NewTypeFourView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(NewTypeFourModifyDto dto)throws BusinessException;
	
}
