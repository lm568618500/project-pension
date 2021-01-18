package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonKvDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonKvModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonDictView;
import com.longjun.cto.framework.sm.sys.entity.view.CommonKvView;
import com.longjun.cto.framework.sm.sys.mapper.CommonKvMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonKvService;

/**
 * K-v业务实现
 * @author yangxuan
 * @date 2018年11月10日 上午7:53:18
 */
@Service
public class CommonKvServiceImpl extends BaseServiceImpl<CommonKvMapper , CommonKvModel> implements ICommonKvService{
	
	@Autowired
	CommonKvMapper commonKvMapper;

	@Override
	public List<CommonKvView> listByK(String key) throws BusinessException {
		try {
			return this.commonKvMapper.listByK(key);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public CommonKvView getByK(String key) throws BusinessException {
		List<CommonKvView> retList = this.listByK(key);
		if(retList != null && retList.size() > 0){
			return retList.get(0);
		}
		return null;
	}

	@Override
	public PageUtils<CommonKvView> getByPage(CommonKvDto dto) throws BusinessException {
		try {
			startPage(dto);
			List<CommonKvView> ret = this.commonKvMapper.getByPage(dto);
			return new PageUtils<CommonKvView>(ret);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

}
