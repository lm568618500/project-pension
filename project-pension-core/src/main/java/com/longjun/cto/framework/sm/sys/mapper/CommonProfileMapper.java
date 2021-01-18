package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonProfileDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonProfileModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonProfileView;

/**
 * 通用profile Mapper
 * @author yangxuan
 * @date 2018年11月13日 下午12:07:30
 */
public interface CommonProfileMapper extends IMapper<CommonProfileModel>{

	/**
	 * 通过key查询
	 * @param profileKey
	 * @return
	 * @throws Exception
	 */
	CommonProfileView getByProfileKey(@Param("profileKey")String profileKey)throws Exception;
	
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	CommonProfileView getById(@Param("id")long id)throws Exception;
	
	/**
	 * 分页
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	List<CommonProfileView> getByPage(CommonProfileDto dto)throws Exception;
	

	/**
	 * 通过Key修改值
	 * @param val
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int setValByKey(@Param("profileVal")String val , @Param("profileKey")String profileKey)throws Exception;

}
