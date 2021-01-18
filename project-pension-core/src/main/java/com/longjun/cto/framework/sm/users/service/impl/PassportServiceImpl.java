package com.longjun.cto.framework.sm.users.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.longjun.cto.framework.sm.sys.entity.es.CommonVerificationRetEnums;
import com.longjun.cto.framework.sm.sys.service.ICommonVerificationService;
import com.longjun.cto.framework.sm.sys.service.ICommonVerificationTypeService;
import com.longjun.cto.framework.sm.users.entity.dto.LoginInputDto;
import com.longjun.cto.framework.sm.users.entity.view.UserView;
import com.longjun.cto.framework.sm.users.service.IPassportService;
import com.longjun.cto.framework.sm.users.service.IUserService;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

/**
 * passport接口实现
 * 
 * @author yangxuan
 * @date Jun 26, 2019 - 10:12:00 AM
 */
@Service
public class PassportServiceImpl implements IPassportService {

	private Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ICommonVerificationTypeService iCommonVerificationTypeService;

	@Autowired
	private ICommonVerificationService iCommonVerificationService;

	@Autowired
	private IUserService iUserService;

	@Override
	public String sendEmailCodeByReg(String email) throws BusinessException {
		String codeVal = RandomUtil.randomInt(100000, 999999) + "";
		String codeKey = email;
		long codeType = 10001L;
		String ret = this.iCommonVerificationService.createVerificationCode(codeType, codeKey, codeVal);
		return ret;
	}

	@Override
	public boolean validateEmailCodeByReg(String email, String codeKey, String code) throws BusinessException {
		CommonVerificationRetEnums ret = this.iCommonVerificationService.vlidate(10001L, codeKey, code, true);
		if (ret.getCode() == 1) {
			return true;
		}
		return false;
	}

	@Override
	public UserView login(LoginInputDto loginInputDto) throws BusinessException {
		LOG.info("用户登录 -> {}", JSONObject.toJSONString(loginInputDto));
		if (loginInputDto == null) {
			LOG.error("登录失败,传入登录对象为空");
			return null;
		}
		String mobile = loginInputDto.getMobile();
		if (StrUtil.isBlank(mobile)) {
			LOG.error("登录失败,手机号不能为空");
			throw new BusinessException("登录失败,手机号不能为空");
		}
		String password = loginInputDto.getPassword();
		if (StrUtil.isBlank(password)) {
			LOG.error("登录失败,密码不能为空");
			throw new BusinessException("登录失败,密码不能为空");
		}
		UserView userView = this.iUserService.findViewByUserName(loginInputDto.getMobile());
		if (userView == null) {
			LOG.error("登录失败,未查询到用户信息");
			throw new BusinessException("登录失败,账号/密码错误");
		}

		String encryPassword = this.iUserService.encryPassword(password);
		if (!userView.getPassword().equals(encryPassword)) {
			LOG.error("登录失败,密码错误");
			throw new BusinessException("登录失败,账号/密码错误");
		}

		return userView;
	}

}
