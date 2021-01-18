package com.longjun.cto.framework.sm.sys.service;

import java.util.List;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonKvDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonKvModel;
import com.longjun.cto.framework.sm.sys.entity.model.CommonOptionModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonKvView;

/**
 * K - v 业务
 * @author yangxuan
 * @date 2018年11月10日 上午7:52:32
 */
public interface ICommonKvService extends BaseService<CommonKvModel> {
	
	/**
	 * 
	 * @param key
	 * @return
	 * @throws BusinessException
	 */
	List<CommonKvView> listByK(String key)throws BusinessException;
	
	/**
	 * 
	 * @param key
	 * @return
	 * @throws BusinessException
	 */
	CommonKvView getByK(String key)throws BusinessException;
	

	/**
	 * 分页查询
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<CommonKvView> getByPage(CommonKvDto dto)throws BusinessException;

}
