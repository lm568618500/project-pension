package ${codeParentPakage}.${codePakage}.mapper;

import com.eims.cto.framework.module.base.model.BaseDTO;
import ${codeParentPakage}.${codePakage}.entity.dto.${className}Dto;
import ${codeParentPakage}.${codePakage}.entity.model.${className}Model;
import ${codeParentPakage}.${codePakage}.entity.view.${className}View;
import com.eims.cto.framework.common.core.mybatis.IMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * ${className} Mapper
 * @author ${author}
 * @date ${crateDate}
 */
public interface ${className}Mapper extends IMapper<${className}Model> {

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	public ${className}View findViewById(@Param("id")long id);
	
	/**
	 *  分页查询
	 * @param id
	 * @return
	 */
	public List<${className}View> getByPage(${className}Dto dto);
	
	/**
	 *  条件
	 * @param id
	 * @return
	 */
	public List<${className}View> listModelMap(Map<String,Object> params);
	
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
