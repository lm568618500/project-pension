package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonProfileDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonProfileModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonProfileView;

/**
 * 通用profile
 * @author yangxuan
 * @date 2018年11月13日 下午12:00:12
 */
public interface ICommonProfileService extends BaseService<CommonProfileModel>{
	
	/**
	 * 通过key查询
	 * @param profileKey
	 * @return
	 * @throws BusinessException
	 */
	CommonProfileView getByProfileKey(String profileKey)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	CommonProfileView getById(long id)throws BusinessException;
	
	/**
	 * 分页
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<CommonProfileView> getByPage(CommonProfileDto dto)throws BusinessException;
	
	/**
	 * 通过Key修改值
	 * @param val
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	boolean setValByKey(String val , String profileKey)throws BusinessException;
	
}
