package com.longjun.cto.framework.sm.sys.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonVerificationDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonVerificationModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonVerificationView;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * CommonVerification Mapper
 * @author yangxuan
 * @date 2019-06-04 05:39:27
 */
public interface CommonVerificationMapper extends IMapper<CommonVerificationModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public CommonVerificationView findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<CommonVerificationView> getByPage(CommonVerificationDto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<CommonVerificationView> listModelMap(Map<String,Object> params);
	
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
