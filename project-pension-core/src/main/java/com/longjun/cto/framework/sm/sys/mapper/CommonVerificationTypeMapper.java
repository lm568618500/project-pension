package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonVerificationTypeDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonVerificationTypeModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonVerificationTypeView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CommonVerificationType Mapper
 * @author yangxuan
 * @date 2019-06-04 05:50:42
 */
public interface CommonVerificationTypeMapper extends IMapper<CommonVerificationTypeModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public CommonVerificationTypeView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<CommonVerificationTypeView> getByPage(CommonVerificationTypeDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<CommonVerificationTypeView> listModelMap(Map<String,Object> params);
	
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
