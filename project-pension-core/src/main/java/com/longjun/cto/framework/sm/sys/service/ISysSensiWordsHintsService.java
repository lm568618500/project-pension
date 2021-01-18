package com.longjun.cto.framework.sm.sys.service;

import java.util.List;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.plugins.sensiwords.BannerResp;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsHintsDto;
import com.longjun.cto.framework.sm.sys.entity.dto.SysSensiWordsHintsModifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.SysSensiWordsHintsModel;
import com.longjun.cto.framework.sm.sys.entity.view.SysSensiWordsHintsView;


/**
 * SysSensiWordsHintsModel
 * @author yangxuan
 * @date 2019-04-03 08:38:00
 */
public interface ISysSensiWordsHintsService extends BaseService<SysSensiWordsHintsModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SysSensiWordsHintsView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public SysSensiWordsHintsModel findModelById(long id)throws BusinessException;
	
		/**
	 * 保存
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(SysSensiWordsHintsModel model)throws BusinessException;
	
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
	PageUtils<SysSensiWordsHintsView> getByPage(SysSensiWordsHintsDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	List<SysSensiWordsHintsModel> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	List<SysSensiWordsHintsModel> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	boolean modify(SysSensiWordsHintsModifyDto dto)throws BusinessException;
	
	/**
	 * 击中
	 * @param words
	 * @throws BusinessException
	 */
	BannerResp hints(String words)throws BusinessException;
	
}
