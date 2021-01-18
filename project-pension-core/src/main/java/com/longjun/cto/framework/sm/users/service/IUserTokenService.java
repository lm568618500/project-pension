package com.longjun.cto.framework.sm.users.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.users.entity.dto.UserTokenDto;
import com.longjun.cto.framework.sm.users.entity.model.UserTokenModel;
import com.longjun.cto.framework.sm.users.entity.view.UserTokenView;

import java.util.List;

/**
 * UserTokenModel
 * @author yangxuan
 * @date 2019-05-31 05:43:41
 */
public interface IUserTokenService extends BaseService<UserTokenModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UserTokenView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UserTokenModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(UserTokenModel model)throws BusinessException;
	
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
	public PageUtils<UserTokenView> getByPage(UserTokenDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<UserTokenView> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	public List<UserTokenView> listAll()throws BusinessException;
	
	
	/**
	 * 创建用户登录令牌
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	public String createToken(long userId , String token)throws BusinessException; 
	
	/**
	 * 通过token查询
	 * @param token
	 * @return
	 * @throws BusinessException
	 */
	public UserTokenModel findByToken(String token)throws BusinessException;
	
	/**
	 * 刷新token
	 * @param token
	 * @throws BusinessException
	 */
	public void flushToken(String token)throws BusinessException;
	
	/**
	 * token失败
	 * @param token
	 * @throws BusinessException
	 */
	void failureToken(String token)throws BusinessException;

	/**
	 * token失败
	 * @param token
	 * @throws BusinessException
	 */
	void failureToken(UserTokenModel userTokenModel)throws BusinessException;
	
}
