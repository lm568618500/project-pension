package com.longjun.cto.framework.sm.sys.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsDto;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.SysSensiWordsModel;
import com.longjun.cto.framework.sm.sys.entity.view.SysSensiWordsView;

import java.util.List;

/**
 * SysSensiWordsModel
 * @author yangxuan
 * @date 2019-04-03 08:38:00
 */
public interface ISysSensiWordsService extends BaseService<SysSensiWordsModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SysSensiWordsView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SysSensiWordsModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(SysSensiWordsModel model)throws BusinessException;
	
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
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<SysSensiWordsView> getByPage(SysSensiWordsDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	List<SysSensiWordsModel> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	List<SysSensiWordsModel> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	boolean modify(SysSensiWordsModifyDto dto)throws BusinessException;
	
}
