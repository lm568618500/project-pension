package com.longjun.cto.framework.sm.sys.service;

import java.util.Date;
import java.util.List;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.BannerDto;
import com.longjun.cto.framework.sm.sys.entity.model.BannerModel;
import com.longjun.cto.framework.sm.sys.entity.view.BannerView;
import com.longjun.cto.framework.sm.sys.entity.view.NewBannerView;

/**
 * 广告条信息表Service
 * 
 * @author heqiang
 * @date 2018-12-08 08:44:03
 */
public interface IBannerService extends BaseService<BannerModel> {

	/**
	 * 通过ID修改信息状态
	 * 
	 * @param id
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	boolean setStatusById(long id, int status) throws BusinessException;

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	Long saveModel(BannerModel model) throws BusinessException;

	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	PageUtils<BannerView> getByPage(BannerDto dto) throws BusinessException;

	/**
	 * 通过ID查询View
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	BannerView getById(long id) throws BusinessException;

	/**
	 * 保存数据
	 * @param description 
	 */
	boolean saveModel(int type, String name,  String location, long plateId,
			String fileSize, String fileFormat, String imgUrl,int target, int sort,
			long jumpId, int jumpType, String jumpUrl, java.util.Date startTime, java.util.Date endTime, String content
			,long parent_id,int status,int client_type,String description) throws BusinessException;

	/**
	 * 保存数据
	 */
	boolean modify(int id, int type, String name, String location, long plateId, String fileSize, String fileFormat,
			String imgUrl, int target, int sort, long jumpId, int jumpType,String jumpUrl, Date startTime, Date endTime,
			String content,long parent_id,int status,int client_type,String description) throws BusinessException;

	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	Boolean delete(long id)throws BusinessException;

	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	BannerView getBannerById(long id)throws BusinessException;
	
	/**
	 * 根据父级id查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	List<BannerView> selectByParentId(long parent_id)throws BusinessException;
	
	/**
	 * 首页广告轮播
	 * @param type
	 * @return
	 * @throws BusinessException
	 */
	List<BannerView> selectByType(int type)throws BusinessException;

	/**
	 * 根据plateid查询
	 * @param plateId
	 * @return
	 * @throws BusinessException
	 */
	List<NewBannerView> selectListByPlateId(Long plateId)throws BusinessException;


}
