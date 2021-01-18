package com.longjun.cto.framework.sm.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eims.cto.framework.common.core.mybatis.IMapper;
import com.longjun.cto.framework.sm.sys.entity.dto.BannerDto;
import com.longjun.cto.framework.sm.sys.entity.model.BannerModel;
import com.longjun.cto.framework.sm.sys.entity.view.BannerView;
import com.longjun.cto.framework.sm.sys.entity.view.NewBannerView;

/**
 * 广告条信息表Mapper
 * @author heqiang
 * @date 2018-12-08 08:44:03
 */
public interface BannerMapper extends IMapper<BannerModel> {

	List<BannerView> getByPage(BannerDto dto)throws Exception;

	void delete(BannerModel model)throws Exception;

	BannerView selectBannerById(BannerModel model)throws Exception;
	
	/**
	 * 根据父级id查询
	 * @param parent_id
	 * @return
	 * @throws Exception
	 */
	List<BannerView> selectByParentId(@Param("parent_id")long parent_id)throws Exception;
	
	/**
	 * 根据类型查询
	 * @param type
	 * @return
	 * @throws Exception
	 */
	List<BannerView> selectByType(@Param("type")int type)throws Exception;

	/**
	 * 根据plateid查询
	 * @param plateId
	 * @return
	 * @throws Exception
	 */
	List<NewBannerView> selectListByPlateId(@Param("plateId")Long plateId)throws Exception;
}
