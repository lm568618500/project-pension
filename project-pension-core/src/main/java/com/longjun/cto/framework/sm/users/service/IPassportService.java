package com.longjun.cto.framework.sm.users.service;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.longjun.cto.framework.sm.users.entity.dto.LoginInputDto;
import com.longjun.cto.framework.sm.users.entity.view.UserView;

/**
 * passport业务接口
 * 
 * @author yangxuan
 * @date Jun 26, 2019 - 10:11:35 AM
 */
public interface IPassportService {

	/**
	 * 发送邮箱验证码-注册场景
	 * 
	 * @param email
	 * @return
	 * @throws BusinessException
	 */
	public String sendEmailCodeByReg(String email) throws BusinessException;

	/**
	 * 校验邮箱注册验证码
	 * 
	 * @param email
	 * @param code
	 * @return
	 * @throws BusinessException
	 */
	public boolean validateEmailCodeByReg(String email, String codeKey, String code) throws BusinessException;

	/**
	 * 登录
	 * 
	 * @param loginInputDto
	 * @return
	 * @throws BusinessException
	 */
	public UserView login(LoginInputDto loginInputDto) throws BusinessException;

}
