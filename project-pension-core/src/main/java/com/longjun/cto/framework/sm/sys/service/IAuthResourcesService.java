package com.longjun.cto.framework.sm.sys.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.AuthResourcesDto;
import com.longjun.cto.framework.sm.sys.entity.model.AuthResourcesModel;
import com.longjun.cto.framework.sm.sys.entity.view.AuthResourcesView;
import com.longjun.cto.framework.sm.sys.entity.view.ShowMenuView;

/**
 * 资源业务
 * @author yangxuan
 * @date 2018年11月5日 下午5:00:26
 */
public interface IAuthResourcesService extends BaseService<AuthResourcesModel>{
	
	/**
	 * 保存资源信息
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	Long saveModel(AuthResourcesModel model)throws BusinessException;

	/**
	 * 通过ID查询资源视图
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	AuthResourcesView getById(long id)throws BusinessException;
	
	/**
	 * 通过ID删除资源信息
	 * @param id
	 * @param operaterId
	 * @return
	 * @throws BusinessException
	 */
	boolean del(long id, long operaterId)throws BusinessException;
	
	/**
	 * 修改资源信息
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	boolean setResInfo(AuthResourcesModel model, long operaterId)throws BusinessException;
	
	/**
	 * 分页查询资源视图
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<AuthResourcesView> getByPage(AuthResourcesDto dto)throws BusinessException;
	
	/**
	 * 集合列表
	 * @return
	 * @throws BusinessException
	 */
	List<AuthResourcesView> listAll()throws BusinessException;
	
	/**
	 * 通过URI查询
	 * @param uri
	 * @return
	 * @throws BusinessException
	 */
	AuthResourcesView getByUrl(String uri)throws BusinessException;
	
	public List<ShowMenuView> getShowMenuByUser(Long id) throws BusinessException;
	
	/**
	 * 顶部菜单
	 * @return
	 * @throws BusinessException
	 */
	List<AuthResourcesModel> topMenus(long adminId)throws BusinessException;
	
	/**
	 * 左侧菜单
	 * @return
	 * @throws BusinessException
	 */
	List<AuthResourcesView> leftMenusByTopId(long topId)throws BusinessException;
	
	List<AuthResourcesView> leftMenusByTopId(long topId, Long adminId)throws BusinessException;
	
}
