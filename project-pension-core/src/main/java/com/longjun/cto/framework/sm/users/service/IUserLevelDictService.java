package com.longjun.cto.framework.sm.users.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.users.entity.dto.UserLevelDictDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserLevelDictModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserLevelDictModel;
import com.longjun.cto.framework.sm.users.entity.view.UserLevelDictView;

import java.util.List;

/**
 * UserLevelDictModel
 * @author yangxuan
 * @date 2019-06-28 04:46:45
 */
public interface IUserLevelDictService extends BaseService<UserLevelDictModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UserLevelDictView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UserLevelDictModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(UserLevelDictModel model)throws BusinessException;
	
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
	public PageUtils<UserLevelDictView> getByPage(UserLevelDictDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<UserLevelDictView> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	public List<UserLevelDictView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(UserLevelDictModifyDto dto)throws BusinessException;
	
}
