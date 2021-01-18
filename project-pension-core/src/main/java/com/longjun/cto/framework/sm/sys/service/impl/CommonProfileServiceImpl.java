package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonProfileDto;
import com.longjun.cto.framework.sm.sys.entity.model.CommonProfileModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonProfileView;
import com.longjun.cto.framework.sm.sys.mapper.CommonProfileMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonProfileService;


/**
 * 通用profile实现
 * @author yangxuan
 * @date 2018年11月13日 下午12:05:54
 */
@Service
public class CommonProfileServiceImpl extends BaseServiceImpl<CommonProfileMapper,CommonProfileModel> implements ICommonProfileService{
	
	@Autowired
	CommonProfileMapper commonProfileMapper;

	@Override
	public CommonProfileView getByProfileKey(String profileKey) throws BusinessException {
		CommonProfileView ret;
		try {
			ret = this.commonProfileMapper.getByProfileKey(profileKey);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public CommonProfileView getById(long id) throws BusinessException {
		CommonProfileView ret;
		try {
			ret = this.commonProfileMapper.getById(id);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public PageUtils<CommonProfileView> getByPage(CommonProfileDto dto) throws BusinessException {
		try {
			startPage(dto);
			List<CommonProfileView> ret = this.commonProfileMapper.getByPage(dto);
			return new PageUtils<CommonProfileView>(ret);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public boolean setValByKey(String val, String profileKey) throws BusinessException {
		try {
			this.commonProfileMapper.setValByKey(val, profileKey);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

}
