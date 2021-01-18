package com.longjun.cto.framework.sm.cms.service.impl;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import java.util.List;
import java.util.Date;
import  com.longjun.cto.framework.sm.cms.service.IImageService;
import  com.longjun.cto.framework.sm.cms.mapper.ImageMapper;
import  com.longjun.cto.framework.sm.cms.entity.model.ImageModel;
import  com.longjun.cto.framework.sm.cms.entity.view.ImageView;
import com.longjun.cto.framework.common.utils.security.RandomUtil;
import  com.longjun.cto.framework.sm.cms.entity.dto.ImageDto;
import  com.longjun.cto.framework.sm.cms.entity.dto.ImageModifyDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.hibernate.hql.internal.ast.util.PathHelper;

/**
 * ImageServiceImpl
 * @author liuming
 * @date 2019-12-11 04:05:22
 */
 @Service
public class ImageServiceImpl  extends 
					BaseServiceImpl<ImageMapper , ImageModel> 
						implements IImageService {

	@Autowired
	ImageMapper mapper;
	
	@Override
	public ImageView findViewById(long id) throws BusinessException {
		ImageView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public ImageModel findModelById(long id) throws BusinessException {
		ImageModel model = this.selectById(id);
		if(model == null) {
			log.warn("Image 通过ID查询结果为空");
			return null;
		}
		return model;
	}
	
	@Override
	public boolean start(long id) throws BusinessException {
		ImageModel model = super.selectById(id);
		if(model == null) {
			log.error("Image 开启操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == USE){
			return true;
		}
		model.setStatus(USE);
		model.setLastupdate(new Date());
		boolean ret = super.updateById(model);
		return ret;
	}
	
	@Override
	public boolean del(long id) throws BusinessException {
		int ret = this.mapper.del(id);
		return ret > 0 ? true : false;
	}

	@Override
	public boolean stop(long id) throws BusinessException {
		ImageModel model = super.selectById(id);
		if(model == null) {
			log.error("Image 停止操作,ID[{}]未查询到数据信息" , id);
			return false;
		}
		if(model.getStatus() == UNUSE){
			return true;
		}
		model.setStatus(UNUSE);
		model.setLastupdate(new Date());
		boolean ret = super.updateById(model);
		return ret;
	}
	
	@Override
	public PageUtils<ImageView> getByPage(ImageDto dto) throws BusinessException {
		startPage(dto);
		List<ImageView> ret = this.mapper.getByPage(dto);
		PageUtils<ImageView> pages =  new PageUtils<ImageView>(ret);
		return pages;
	}
	
	@Override
	public List<ImageView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String , Object> params = new HashMap<String , Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<ImageView> rets = this.mapper.listModelMap(params);
		if(rets == null) {
			return new ArrayList<ImageView>();
		}
		return rets;
	}
	
	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<ImageView> listAll() throws BusinessException {
		List<ImageView> rets = this.mapper.listModelMap(new HashMap<>());
		if(rets == null) {
			return new ArrayList<ImageView>();
		}
		return rets;
	}
	
	@Override
	public boolean modify(ImageModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("Image 修改失败;传入对象为空");
			return false;
		}
		ImageModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("Image 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		ImageModel uModel = new ImageModel();
		try {
			BeanUtils.copyProperties(uModel, dto);
			boolean ret = super.updateById(uModel);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	  @Override
	  public ImageModel save(MultipartFile imageFile) {
	    String uuid = RandomUtil.createUUID();
	    File fileUploadPath = com.longjun.cto.framework.common.utils.security.PathHelper.getAttachmentUploadLocation();  // 获取文件上传文件夹
	    File filePath = new File(fileUploadPath,uuid);  // 获取文件上传完整路径
	    ImageModel image = new ImageModel();
	    try {
	      FileUtils.copyInputStreamToFile(imageFile.getInputStream(),filePath);  //存储图片文件
	      image.setUuid(uuid);image.setSize(imageFile.getSize());
	      image.setContentType(imageFile.getContentType());
	      image.setOriginalName(imageFile.getOriginalFilename());
	      image.setSuffix(FilenameUtils.getExtension(imageFile.getOriginalFilename()));
	      image.setStorePath(filePath.getPath());
	      image.setUrl("/common/image?uuid="+uuid);
	      image.setWidth(0);
	      image.setHeight(0);
	      mapper.insert(image);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    return image;
	  }

	  @Override
	  public ImageModel selectById(Long id) {
	    return mapper.selectById(id);
	  }

	  @Override
	  public ImageModel selectByUuid(String uuid) {
		  ImageModel entity=new ImageModel();
		  entity.setUuid(uuid);
	    return mapper.selectOne(entity);
	  }
}
