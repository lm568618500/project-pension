package com.longjun.cto.framework.sm.sys.service;

import java.util.List;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonDictDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonDictModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonDictView;

/**
 * 通用字典表Service
 * 
 * @author jerry
 * @date 2018-11-29 21:59:28
 */
public interface ICommonDictService extends BaseService<CommonDictModel> {

	/**
	 * 通过ID修改信息状态
	 * 
	 * @param id
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	public boolean setStatusById(long id, int status) throws BusinessException;

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public Long saveModel(CommonDictModel model) throws BusinessException;

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
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public PageUtils<CommonDictView> getByPage(CommonDictDto dto) throws BusinessException;

	/**
	 * 通过ID查询View
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CommonDictView getById(long id) throws BusinessException;

	/**
	 * 保存数据
	 */
	public boolean saveModel(long typeId, long useId, String name, int sort, int isUse, String description,
			java.util.Date time, java.util.Date lastupdate, int status) throws BusinessException;

	/**
	 * 保存数据
	 */
	public boolean modify(CommonDictModel commonDictModel) throws BusinessException;

	/**
	 * 根据tyepId获取字典集合数据
	 * 
	 * @param tyepId
	 * @return
	 * @throws BusinessException
	 */
	public List<CommonDictView> selectListByTypeId(long tyepId) throws BusinessException;

	/**
	 * 根据parentUseId获取字典集合数据
	 * 
	 * @param parentUseId
	 * @return
	 * @throws BusinessException
	 */
	public List<CommonDictModel> selectListByParentUseId(long parentUseId) throws BusinessException;

	/**
	 * 通过类型ID名称查询
	 * 
	 * @param typeId
	 * @param showName
	 * @return
	 * @throws BusinessException
	 */
	public CommonDictModel findByTypeId2ShowName(long typeId, String showName) throws BusinessException;

}
