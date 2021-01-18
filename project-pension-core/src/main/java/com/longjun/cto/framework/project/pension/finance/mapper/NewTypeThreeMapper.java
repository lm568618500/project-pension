package com.longjun.cto.framework.project.pension.finance.mapper;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.project.pension.finance.entity.dto.NewTypeThreeDto;
import com.longjun.cto.framework.project.pension.finance.entity.model.NewTypeThreeModel;
import com.longjun.cto.framework.project.pension.finance.entity.view.NewTypeThreeView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * NewTypeThree Mapper
 * @author liuming
 * @date 2021-01-09 09:55:08
 */
public interface NewTypeThreeMapper extends IMapper<NewTypeThreeModel> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public NewTypeThreeView findViewById(@Param("id") long id);
	
	/**
	 *  分页查询
	 * @param
	 * @return
	 */
	public List<NewTypeThreeView> getByPage(NewTypeThreeDto dto);
	
	/**
	 *  条件
	 * @param
	 * @return
	 */
	public List<NewTypeThreeView> listModelMap(Map<String, Object> params);
	
	/**
	 *  条件总数
	 * @param
	 * @return
	 */
	public int countMap(Map<String, Object> params);
	
	/**
	 * 软删除
	 * @param id
	 * @return
	 */
	public int del(@Param("id") long id);
	
}
