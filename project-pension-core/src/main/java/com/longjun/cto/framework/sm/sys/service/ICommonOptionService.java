package com.longjun.cto.framework.sm.sys.service;

import java.util.List;
import java.util.Map;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonOptionDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonOptionModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonOptionView;

/**
 * 通用-设置
 * 
 * @author yangxuan
 * @date 2018年11月7日 下午5:39:39
 */
public interface ICommonOptionService extends BaseService<CommonOptionModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CommonOptionView getById(long id) throws BusinessException;

	/**
	 * 通过使用ID查询
	 * 
	 * @param useId
	 * @return
	 * @throws BusinessException
	 */
	public CommonOptionView getByUseId(long useId) throws BusinessException;

	/**
	 * 修改信息
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public boolean setInfo(CommonOptionModel model) throws BusinessException;

	/**
	 * 查询所有信息
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<CommonOptionView> getList() throws BusinessException;

	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public PageUtils<CommonOptionView> getByPage(CommonOptionDto dto) throws BusinessException;

	/**
	 * Map init
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> initMap() throws BusinessException;

	/**
	 * 通过key - value修改
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws BusinessException
	 */
	public boolean updateModelByKeyVal(String key, String value) throws BusinessException;

	/**
	 * 通过key查询
	 * 
	 * @param key
	 * @return
	 * @throws BusinessException
	 */
	public CommonOptionView findByKey(String key) throws BusinessException;

}
