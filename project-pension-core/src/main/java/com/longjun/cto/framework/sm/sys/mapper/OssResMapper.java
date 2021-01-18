package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResDto;
import com.longjun.cto.framework.sm.sys.entity.model.OssResModel;
import com.longjun.cto.framework.sm.sys.entity.view.OssResView;

/**
 * Oss Mapper
 * @author yangxuan
 * @date 2018年11月8日 下午1:51:36
 */
public interface OssResMapper extends IMapper<OssResModel>{

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	OssResView getById(@Param("id")long id)throws Exception;
	
	/**
	 * 保存
	 * @param model
	 * @return
	 * @throws Exception
	 */
	Long saveModel(OssResModel model)throws Exception;
	
	/**
	 * 分页查询
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	List<OssResView> getByPage(OssResDto dto)throws Exception;
}
