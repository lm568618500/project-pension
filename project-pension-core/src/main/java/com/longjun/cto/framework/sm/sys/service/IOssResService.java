package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResDto;
import com.longjun.cto.framework.sm.sys.entity.model.OssResModel;
import com.longjun.cto.framework.sm.sys.entity.view.OssResView;

/**
 * Oss资源业务
 * @author yangxuan
 * @date 2018年11月8日 下午1:41:50
 */
public interface IOssResService extends BaseService<OssResModel>{

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	OssResView getById(long id)throws BusinessException;
	
	/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	void saveModel(OssResModel model)throws BusinessException;
	
	/**
	 * 分页查询
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<OssResView> getByPage(OssResDto dto)throws BusinessException;
	
}
