package com.longjun.cto.framework.sm.users.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.users.entity.dto.UserScoreSenceDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserScoreSenceModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserScoreSenceModel;
import com.longjun.cto.framework.sm.users.entity.view.UserScoreSenceView;

import java.util.List;

/**
 * UserScoreSenceModel
 * 
 * @author yangxuan
 * @date 2019-07-01 05:05:46
 */
public interface IUserScoreSenceService extends BaseService<UserScoreSenceModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UserScoreSenceView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public UserScoreSenceModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(UserScoreSenceModel model) throws BusinessException;

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
	public PageUtils<UserScoreSenceView> getByPage(UserScoreSenceDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<UserScoreSenceView> listByLimitStatus(int status, int limit) throws BusinessException;

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
	public List<UserScoreSenceView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(UserScoreSenceModifyDto dto) throws BusinessException;

	/**
	 * 通过场景编号查询对象
	 * 
	 * @param senceNo
	 * @return
	 * @throws BusinessException
	 */
	public UserScoreSenceModel findBySenceNo(Long senceNo) throws BusinessException;

}
