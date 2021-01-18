package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonAreaDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonAreaModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonAreaModel;
import com.longjun.cto.framework.sm.sys.entity.model.CommonProvinceModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonAreaView;

import java.util.List;
import java.util.Map;

/**
 * CommonAreaModel
 * @author yangxuan
 * @date 2019-04-04 06:13:35
 */
public interface ICommonAreaService extends BaseService<CommonAreaModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CommonAreaView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CommonAreaModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(CommonAreaModel model)throws BusinessException;
	
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
	public PageUtils<CommonAreaView> getByPage(CommonAreaDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<CommonAreaView> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	public List<CommonAreaView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(CommonAreaModifyDto dto)throws BusinessException;
	
	/**
	 * 可用区域
	 * @return
	 * @throws BusinessException
	 */
	public List<CommonAreaModel> listByUse()throws BusinessException;
	

	/**
	 * 通过城市ID查询可用区域
	 * @return
	 * @throws BusinessException
	 */
	public List<CommonAreaModel> listByUseCityId(long cityId)throws BusinessException;
	
	/**
	 * 通用API接口查询-根据省Id
	 * @return
	 */
	public List<Map<String,Object>> getAreaByCId(String cityId) throws BusinessException;
	
	/**
	 * 通过UseId查询
	 * @param uesId
	 * @return
	 * @throws BusinessException
	 */
	public CommonAreaModel findByUseId(long uesId)throws BusinessException;
	
}
