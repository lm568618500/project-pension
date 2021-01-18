package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.OssResDto;
import com.longjun.cto.framework.sm.sys.entity.model.OssResModel;
import com.longjun.cto.framework.sm.sys.entity.view.OssResView;
import com.longjun.cto.framework.sm.sys.mapper.OssResMapper;
import com.longjun.cto.framework.sm.sys.service.IOssResService;

/**
 * Oss资源业务实现
 * @author yangxuan
 * @date 2018年11月8日 下午2:01:58
 */
@Service
public class OssResServiceImpl extends BaseServiceImpl<OssResMapper,OssResModel> implements IOssResService{
	
	@Autowired
	OssResMapper ossResMapper;

	@Override
	public OssResView getById(long id) throws BusinessException {
		try {
			return this.ossResMapper.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public void saveModel(OssResModel model) throws BusinessException {
		model.setLastupdate(new Date());
		super.insert(model);
	}

	@Override
	public PageUtils<OssResView> getByPage(OssResDto dto) throws BusinessException {
		try {
			startPage(dto);
			List<OssResView> ret = this.ossResMapper.getByPage(dto);
			return new PageUtils<>(ret);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

}
