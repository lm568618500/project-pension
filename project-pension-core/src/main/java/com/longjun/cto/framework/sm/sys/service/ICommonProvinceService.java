package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonProvinceDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonProvinceModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonProvinceModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonProvinceView;

import java.util.List;
import java.util.Map;

/**
 * CommonProvinceModel
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
public interface ICommonProvinceService extends BaseService<CommonProvinceModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CommonProvinceView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CommonProvinceModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(CommonProvinceModel model)throws BusinessException;
	
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
	public PageUtils<CommonProvinceView> getByPage(CommonProvinceDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<CommonProvinceView> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	public List<CommonProvinceView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(CommonProvinceModifyDto dto)throws BusinessException;
	
	/**
	 * 可用省份
	 * @return
	 * @throws BusinessException
	 */
	public List<CommonProvinceModel> listByUse()throws BusinessException;
	
	/**
	 * 通用API接口查询全部
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String,Object>> getProvice(CommonProvinceDto dto) throws BusinessException;
	
	/**
	 * 通过使用ID查询
	 * @param useId
	 * @return
	 * @throws BusinessException
	 */
	public CommonProvinceModel findByUseId(long useId)throws BusinessException;
}
