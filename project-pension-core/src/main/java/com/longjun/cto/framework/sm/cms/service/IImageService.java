package com.longjun.cto.framework.sm.cms.service;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.cms.entity.model.ImageModel;
import com.longjun.cto.framework.sm.cms.entity.view.ImageView;
import com.longjun.cto.framework.sm.cms.entity.dto.ImageDto;
import com.longjun.cto.framework.sm.cms.entity.dto.ImageModifyDto;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * ImageModel
 * @author liuming
 * @date 2019-12-11 04:05:22
 */
public interface IImageService extends BaseService<ImageModel> {
	String THUMBNAIL_NAME_SUFFIX = "_thumbnail";  //生成的缩略图的originalName拼接的后缀
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public ImageView findViewById(long id)throws BusinessException;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public ImageModel findModelById(long id)throws BusinessException;
	
	
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
	public PageUtils<ImageView> getByPage(ImageDto dto) throws BusinessException;
	
	/**
	 * limit , status查询
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<ImageView> listByLimitStatus(int status , int limit)throws BusinessException;
	
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
	public List<ImageView> listAll()throws BusinessException;
	
	/**
	 * 修改数据
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(ImageModifyDto dto)throws BusinessException;
	


	  /**
	   * 通过图片id获取图片对象
	   * @param id
	   * @return
	   */
	public ImageModel selectById(Long id);

	  /**
	   * 通过uuid获取图片对象
	   * @param uuid
	   * @return
	   */
	public ImageModel selectByUuid(String uuid);

	  /**
	   * 保存图片文件
	   * @param imageFile
	   * @return
	   */
	public  ImageModel save(MultipartFile imageFile);

}
