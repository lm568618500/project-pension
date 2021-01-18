package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.LogUserDto;
import com.longjun.cto.framework.sm.sys.entity.model.LogUserModel;
import com.longjun.cto.framework.sm.sys.entity.view.LogUserView;
import com.longjun.cto.framework.sm.sys.mapper.LogUserMapper;
import com.longjun.cto.framework.sm.sys.service.ILogUserService;

@Service	
public class LogUserServiceImpl extends BaseServiceImpl<LogUserMapper , LogUserModel> implements ILogUserService{
	
	@Autowired
	LogUserMapper logUserMapper;
	
	@Override
	public Long saveModel(LogUserModel model) throws BusinessException {
		try {
			return this.logUserMapper.saveModel(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public Long saveLog(long UserId, long eventUseId, String content, String ip) throws BusinessException {
		LogUserModel model = new LogUserModel();
		model.setOperaterId(UserId);
		model.setIp(ip);
		model.setEventUseId(eventUseId);
		model.setModuleName("");
		model.setEventContet(content);
		model.setStatus(USE);
		this.saveModel(model);
		return null;
	}

	@Override
	public LogUserView getById(long id) throws BusinessException {
		try {
			return this.logUserMapper.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public PageUtils<LogUserView> getByPage(LogUserDto dto) throws BusinessException {
		try {
			startPage(dto);
			List<LogUserView> ret = this.logUserMapper.getByPage(dto);
			return new PageUtils<>(ret);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

}
