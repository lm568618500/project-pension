package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.AuthRoleDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AuthRoleModifyDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AuthRoleSaveDto;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleModel;
import com.longjun.cto.framework.sm.sys.entity.view.AuthRoleView;

import java.util.List;

/**
 * AuthRoleModel
 * @author yangxuan
 * @date 2019-04-07 03:17:44
 */
public interface IAuthRoleService extends BaseService<AuthRoleModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public AuthRoleView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public AuthRoleModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(AuthRoleSaveDto authRoleSaveDto)throws BusinessException;
	
	/**
	 * 启动/开始
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	boolean start(long id) throws BusinessException;

	/**
	 * 停止/关闭
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	boolean stop(long id) throws BusinessException;
	
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	boolean del(long id) throws BusinessException;
	
	
	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public PageUtils<AuthRoleView> getByPage(AuthRoleDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<AuthRoleView> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	 List<AuthRoleView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(AuthRoleModifyDto dto)throws BusinessException;
	
	public List<AuthRoleModel> listByUse() throws BusinessException;
	
	public List<AuthRoleModel> listByUse1(long userId) throws BusinessException;
	
	/**
	 * 通过使用ID查询对象
	 * @param useId
	 * @return
	 * @throws BusinessException
	 */
	public AuthRoleModel findByUseId(long useId)throws BusinessException;
	
}
