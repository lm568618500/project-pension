package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminTokenDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminTokenModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminTokenModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminTokenView;

import java.util.List;

/**
 * AdminTokenModel
 * @author EIMS-CODE-BUILD
 * @date 2019-04-01 08:42:03
 */
public interface IAdminTokenService extends BaseService<AdminTokenModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public AdminTokenView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public AdminTokenModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(AdminTokenModel model)throws BusinessException;
	
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
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<AdminTokenView> getByPage(AdminTokenDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	List<AdminTokenModel> listByLimitStatus(int status , int limit)throws BusinessException;
	
	/**
	 * 查询总数
	 * @return
	 * @throws BusinessException
	 */
	int countAll()throws BusinessException;
	
	
	/**
	 * 全部记录
	 * @return
	 * @throws BusinessException
	 */
	List<AdminTokenModel> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	boolean modify(AdminTokenModifyDto dto)throws BusinessException;
	
	/**
	 * 创建管理员登录令牌
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	String createToken(long userId , String token)throws BusinessException;
	
	/**
	 * token失败
	 * @param token
	 * @throws BusinessException
	 */
	void failureToken(String token)throws BusinessException;
	
}
