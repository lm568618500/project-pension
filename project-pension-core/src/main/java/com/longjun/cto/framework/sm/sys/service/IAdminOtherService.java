package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminOtherDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminOtherModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminOtherModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminOtherView;

import java.util.List;

/**
 * AdminOtherModel
 * @author liuming
 * @date 2019-10-05 04:51:18
 */
public interface IAdminOtherService extends BaseService<AdminOtherModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public AdminOtherView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public AdminOtherModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(AdminOtherModel model)throws BusinessException;
	
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
	public PageUtils<AdminOtherView> getByPage(AdminOtherDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<AdminOtherView> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	public List<AdminOtherView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(AdminOtherModifyDto dto)throws BusinessException;
	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public PageUtils<AdminOtherView> getByAdminPage(AdminOtherDto dto);
	
}
