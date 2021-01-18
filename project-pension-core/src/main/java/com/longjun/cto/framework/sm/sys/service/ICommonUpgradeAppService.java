package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeAppDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonUpgradeAppModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonUpgradeAppModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonUpgradeAppView;

import java.util.List;

/**
 * CommonUpgradeAppModel
 * @author yangxuan
 * @date 2019-04-09 08:42:08
 */
public interface ICommonUpgradeAppService extends BaseService<CommonUpgradeAppModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CommonUpgradeAppView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CommonUpgradeAppModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(CommonUpgradeAppModel model)throws BusinessException;
	
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
	PageUtils<CommonUpgradeAppView> getByPage(CommonUpgradeAppDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	List<CommonUpgradeAppView> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	List<CommonUpgradeAppView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	boolean modify(CommonUpgradeAppModifyDto dto)throws BusinessException;
	
}
