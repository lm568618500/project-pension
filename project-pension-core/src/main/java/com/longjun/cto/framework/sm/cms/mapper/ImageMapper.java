package com.longjun.cto.framework.sm.cms.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.cms.entity.dto.ImageDto;
import com.longjun.cto.framework.sm.cms.entity.model.ImageModel;
import com.longjun.cto.framework.sm.cms.entity.view.ImageView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * Image Mapper
 * @author liuming
 * @date 2019-12-11 04:05:22
 */
public interface ImageMapper extends IMapper<ImageModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public ImageView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<ImageView> getByPage(ImageDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<ImageView> listModelMap(Map<String,Object> params);
	
	/**
	 *  条件总数
	 * @param id
	 * @return
	 */
	public int countMap(Map<String,Object> params);
	
	/**
	 * 软删除
	 * @param id
	 * @return
	 */
	public int del(@Param("id")long id);
	
}
