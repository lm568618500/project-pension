package com.longjun.cto.framework.sm.users.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.users.entity.dto.UserAttributeDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserAttributeModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserAttributeModel;
import com.longjun.cto.framework.sm.users.entity.view.UserAttributeView;

import java.util.List;

/**
 * UserAttributeModel
 * @author qiujunbo
 * @date 2019-07-05 05:36:06
 */
public interface IUserAttributeService extends BaseService<UserAttributeModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UserAttributeView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UserAttributeModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(UserAttributeModel model)throws BusinessException;
	
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
	public PageUtils<UserAttributeView> getByPage(UserAttributeDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<UserAttributeView> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	public List<UserAttributeView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(UserAttributeModifyDto dto)throws BusinessException;
	
	
	/**
	 * 通过userId和 attr_type查询所有属性数据
	 * @return
	 * @throws BusinessException
	 */
	public List<UserAttributeView> listByUserIdandAttrType(long userId,long attrType) throws BusinessException;
	
	public boolean delByUserIdandAttrType(long userId,long attrType) throws BusinessException;
}
