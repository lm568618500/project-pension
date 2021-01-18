package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.dto.AuthResourcesDto;
import com.longjun.cto.framework.sm.sys.entity.model.AuthResourcesModel;
import com.longjun.cto.framework.sm.sys.entity.view.AuthResourcesView;
import com.longjun.cto.framework.sm.sys.entity.view.ShowMenuView;

/**
 * 资源Mapper
 * @author yangxuan
 * @date 2018年11月5日 下午5:08:32
 */
public interface AuthResourcesMapper extends IMapper<AuthResourcesModel>{

	/**
	 * 保存资源信息
	 * @param model
	 * @return
	 * @throws Exception
	 */
	Long saveModel(AuthResourcesModel model)throws Exception;

	/**
	 * 通过ID查询资源视图
	 * @param id
	 * @return
	 * @throws Exception
	 */
	AuthResourcesView getById(@Param("id")long id)throws Exception;
	
	/**
	 * 通过ID删除资源信息
	 * @param id
	 * @param operaterId
	 * @return
	 * @throws Exception
	 */
	int del(@Param("id")long id)throws Exception;
	
	/**
	 * 修改资源信息
	 * @param model
	 * @return
	 * @throws Exception
	 */
	int setResInfo(AuthResourcesModel model)throws Exception;
	
	/**
	 * 分页查询资源视图
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	List<AuthResourcesView> getByPage(AuthResourcesDto dto)throws Exception;

	List<AuthResourcesView> listTopByAdminId(Map<String,Object> params);
	
	

	List<ShowMenuView> selectShowMenuByUser(Map<String,Object> map)throws Exception;
	
	
	
}
