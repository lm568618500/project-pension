package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonOptionDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonOptionModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonCityView;
import com.longjun.cto.framework.sm.sys.entity.view.CommonOptionView;

/**
 * 通用-设置
 * @author yangxuan
 * @date 2018年11月7日 下午5:49:17
 */
public interface CommonOptionMapper extends IMapper<CommonOptionModel>{
	

	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public CommonOptionView getById(@Param("id")long id)throws Exception;

	/**
	 * 通过使用ID查询
	 * @param useId
	 * @return
	 * @throws Exception
	 */
	public CommonOptionView getByUseId(@Param("useId")long useId)throws Exception;
	
	/**
	 * 修改信息
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int setInfo(CommonOptionModel model)throws Exception;
	
	/**
	 * 查询所有信息
	 * @return
	 * @throws Exception
	 */
	public List<CommonOptionView> getList()throws Exception;
	
	/**
	 * 分页查询
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public List<CommonOptionView> getByPage(CommonOptionDto dto)throws Exception;
	
	/**
	 * 通过key- value修改
	 * @param key
	 * @param value
	 * @return
	 */
	public int updateModelByKeyVal(@Param("key")String key, @Param("value")String value);
	
	

	/**
	 *  条件
	 * @param id
	 * @return
	 */
	List<CommonOptionView> listModelMap(Map<String,Object> params);
	

}
