package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.LogAdminDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminModel;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleModel;
import com.longjun.cto.framework.sm.sys.entity.model.LogAdminModel;
import com.longjun.cto.framework.sm.sys.entity.model.LogEventModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminView;
import com.longjun.cto.framework.sm.sys.entity.view.LogAdminView;
import com.longjun.cto.framework.sm.sys.mapper.LogAdminMapper;
import com.longjun.cto.framework.sm.sys.service.IAdminService;
import com.longjun.cto.framework.sm.sys.service.IAuthRoleService;
import com.longjun.cto.framework.sm.sys.service.ILogAdminService;
import com.longjun.cto.framework.sm.sys.service.ILogEventService;

import cn.hutool.core.util.StrUtil;

@Service
public class LogAdminServiceImpl extends BaseServiceImpl<LogAdminMapper, LogAdminModel> implements ILogAdminService {

	@Autowired
	private LogAdminMapper logAdminMapper;

	@Autowired
	private IAdminService iAdminService;

	@Autowired
	private IAuthRoleService iAuthRoleService;

	@Autowired
	private ILogAdminService iLogAdminService;

	@Autowired
	private ILogEventService iLogEventService;

	@Override
	public Long saveModel(LogAdminModel model) throws BusinessException {
		try {
			return this.logAdminMapper.saveModel(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public Long saveLog(long adminId, long eventUseId, String content, String ip) throws BusinessException {
		if (adminId <= 0L) {
			log.error("管理员操作日志添加失败;传入管理员账号非法 adminId -> {}", adminId);
			return 0L;
		}
		if (eventUseId <= 0L) {
			log.error("管理员操作日志添加失败;传入操作事件非法 eventUseId -> {}", eventUseId);
			return 0L;
		}
//		if (StrUtil.isBlank(content)) {
//			log.error("管理员操作日志添加失败;传入操作事件内容为空 content -> {}", content);
//			return 0L;
//		}
		if (StrUtil.isBlank(ip)) {
			log.error("管理员操作日志添加失败;传入操作事件IP为空 ip -> {}", ip);
			return 0L;
		}
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("use_id", eventUseId);
		LogEventModel logEventModel = this.iLogEventService.selectOne(ew);
		if (logEventModel == null) {
			log.error("管理员操作日志添加失败;事件类型未在t_log_event找到 ; eventUseId -> {}", eventUseId);
			return 0L;
		}

		AdminView adminView = this.iAdminService.getById(adminId);
		if (adminView == null) {
			return 0L;
		}
		LogAdminModel model = new LogAdminModel();
		model.setOperaterId(adminView.getId());
		model.setOperaterName(adminView.getRealName());
		model.setOperaterRoleId(adminView.getRoleUseId());
		model.setOperaterRoleName(adminView.getRoleName());
		model.setIp(ip);
		model.setEventUseId(eventUseId);
		model.setModuleName(logEventModel.getBeyondModule());
		model.setEventContet(logEventModel.getBeyondModule() +"参数" +content);
		model.setStatus(USE);
		this.saveModel(model);
		return adminId;

	}

	@Override
	public LogAdminView getById(long id) throws BusinessException {
		try {
			return this.logAdminMapper.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public PageUtils<LogAdminView> getByPage(LogAdminDto dto) throws BusinessException {
		try {
			startPage(dto);
			List<LogAdminView> ret = this.logAdminMapper.getByPage(dto);
			return new PageUtils<>(ret);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

}
