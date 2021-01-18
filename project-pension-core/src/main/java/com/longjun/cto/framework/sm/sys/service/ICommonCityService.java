package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonCityDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonCityModifyDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonProvinceDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonCityModel;
import com.longjun.cto.framework.sm.sys.entity.model.CommonProvinceModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonCityView;

import java.util.List;
import java.util.Map;

/**
 * CommonCityModel
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
public interface ICommonCityService extends BaseService<CommonCityModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CommonCityView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CommonCityModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(CommonCityModel model)throws BusinessException;
	
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
	public PageUtils<CommonCityView> getByPage(CommonCityDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<CommonCityView> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	public List<CommonCityView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(CommonCityModifyDto dto)throws BusinessException;

	/**
	 * 可用省份
	 * @return
	 * @throws BusinessException
	 */
	public List<CommonCityModel> listByUse()throws BusinessException;
	
	/**
	 * 通过省份UseId查询可用省份
	 * @return
	 * @throws BusinessException
	 */
	public List<CommonCityModel> listByUseProvinceId(long provinceId)throws BusinessException;
	
	/**
	 * 通用API接口查询-根据省Id
	 * @return
	 */
	public List<Map<String,Object>> getCityByPId(String proviceId) throws BusinessException;
	
	/**
	 * 通过UseId查询
	 * @param useId
	 * @return
	 * @throws BusinessException
	 */
	public CommonCityModel findByUseId(long useId) throws BusinessException;
	
	
}
