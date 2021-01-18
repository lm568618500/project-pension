package com.longjun.cto.framework.sm.sys.service;

import java.util.List;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonBanksDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonBanksModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonBanksView;

/**
 * 通用-银行表Service
 * @author yangxuan
 * @date 2018-11-24 13:39:27
 */
public interface ICommonBanksService extends BaseService<CommonBanksModel> {

	/**
	 * 通过ID修改信息状态
	 * @param id
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	boolean setStatusById(long id ,int status)throws BusinessException;
	
	/**
	 * 保存数据
	 * @param model 
	 * @return
	 * @throws BusinessException
	 */
	Long saveModel(CommonBanksModel model)throws BusinessException;
	
	
	/**
	 * 启动/开始
	 * @param id 
	 * @return
	 * @throws BusinessException
	 */
	boolean start(long id)throws BusinessException;
	
	/**
	 * 停止/关闭
	 * @param id 
	 * @return
	 * @throws BusinessException
	 */
	boolean stop(long id)throws BusinessException;
	
	/**
	 * 分页查询
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<CommonBanksView> getByPage(CommonBanksDto dto)throws BusinessException;
	
	/**
	 * 通过ID查询View
	 * @param id 
	 * @return
	 * @throws BusinessException
	 */
	CommonBanksView getById(long id)throws BusinessException;
	
	
	/**
	*保存数据
	*/
	boolean saveModel(
		String bankCode,  
		String bankName,  
		String bankLogo,  
		int sort,  
		int status ,
		int cash , 
		int withdraw
		)throws BusinessException;
		
		
		/**
	*保存数据
	*/
	boolean modify(
		long id,  
		String bankCode,  
		String bankName,  
		String bankLogo,  
		int sort,  
		int status ,
		int cash , 
		int withdraw
		)throws BusinessException;

	
	/**
	 * 通过状态查询
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	List<CommonBanksView> listByStatus(int status)throws BusinessException;
	

}
