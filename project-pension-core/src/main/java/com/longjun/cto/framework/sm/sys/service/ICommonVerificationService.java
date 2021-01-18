package com.longjun.cto.framework.sm.sys.service;

import java.util.List;

import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseService;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonVerificationDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonVerificationModifyDto;
import com.longjun.cto.framework.sm.sys.entity.dto.VerificationCodeSmsRetDto;
import com.longjun.cto.framework.sm.sys.entity.es.CommonVerificationRetEnums;
import com.longjun.cto.framework.sm.sys.entity.model.CommonVerificationModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonVerificationView;

/**
 * CommonVerificationModel
 * 
 * @author yangxuan
 * @date 2019-06-04 05:39:27
 */
public interface ICommonVerificationService extends BaseService<CommonVerificationModel> {

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CommonVerificationView findViewById(long id) throws BusinessException;

	/**
	 * 通过ID查询
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public CommonVerificationModel findModelById(long id) throws BusinessException;

	/**
	 * 保存
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException
	 */
	public void saveModel(CommonVerificationModel model) throws BusinessException;

	/**
	 * 启动/开始
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean start(long id) throws BusinessException;

	/**
	 * 停止/关闭
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean stop(long id) throws BusinessException;

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public boolean del(long id) throws BusinessException;

	/**
	 * 分页查询
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public PageUtils<CommonVerificationView> getByPage(CommonVerificationDto dto) throws BusinessException;

	/**
	 * limit , status查询
	 * 
	 * @param status
	 * @param limit
	 * @return
	 * @throws BusinessException
	 */
	public List<CommonVerificationView> listByLimitStatus(int status, int limit) throws BusinessException;

	/**
	 * 查询总数
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public int countAll() throws BusinessException;

	/**
	 * 全部记录
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<CommonVerificationView> listAll() throws BusinessException;

	/**
	 * 修改数据
	 * 
	 * @param dto
	 * @return
	 * @throws BusinessException
	 */
	public boolean modify(CommonVerificationModifyDto dto) throws BusinessException;

	/**
	 * 创建验证码(图片)
	 * 
	 * @param codeType t_common_verification_type表中获取;开发人员定义
	 * @param codeKey  比如手机号/邮件
	 * @param codeVal  指;业务层传入;
	 * @return
	 * @throws BusinessException
	 */
	public String createVerificationCode(long codeType, String codeKey, String codeVal) throws BusinessException;

	/**
	 * 创建验证码(图片)
	 * 
	 * @param codeType t_common_verification_type表中获取;开发人员定义
	 * @param codeKey  比如手机号/邮件
	 * @param codeVal  指;业务层传入;
	 * @return
	 * @throws BusinessException
	 */
	public String createVerificationCode(long codeType, String codeKey) throws BusinessException;

	/**
	 * 验证码验证(图片)
	 * 
	 * @param codeType 类型 t_common_verification_type表中获取;开发人员定义
	 * @param codeKey  key
	 * @param codeVal  val
	 * @param reTry    重复尝试
	 * @return
	 * @throws BusinessException
	 */
	public CommonVerificationRetEnums vlidate(long codeType, String codeKey, String codeVal, boolean reTry)
			throws BusinessException;

	/**
	 * 发送短信验证码,验证码值有方法生产,然后通过返回值返回给业务
	 * 
	 * @param codeType
	 * @param mobile
	 * @return
	 * @throws BusinessException
	 */
	public VerificationCodeSmsRetDto createVerificationCodeSms(long codeType, String mobile, String ip)
			throws BusinessException;

	/**
	 * 短信验证码校验
	 * 
	 * @param codeType 场景类型
	 * @param mobile   手机号码
	 * @param reTry    是否重复尝试
	 * @return
	 * @throws BusinessException
	 */
	public CommonVerificationRetEnums vlidateSms(long codeType, String mobile, String codeVal) throws BusinessException;

	/**
	 * 通过类型、IP查询时间范围内数量
	 * 
	 * @param codeEs
	 * @param ip
	 * @param start
	 * @param end
	 * @return
	 * @throws BusinessException
	 */
	public int findCountByCodeEsIp(Integer codeEs, String ip, long start, long end) throws BusinessException;

	/**
	 * 通过类型、手机号查询时间范围内数量
	 * 
	 * @param codeEs
	 * @param mobile
	 * @param start
	 * @param end
	 * @return
	 * @throws BusinessException
	 */
	public int findCountByCodeEsMobile(Integer codeEs, String mobile, long start, long end) throws BusinessException;
	

	/**
	 * 发送邮箱验证码,验证码值有方法生产,然后通过返回值返回给业务
	 * 
	 * @param codeType
	 * @param email
	 * @return
	 * @throws BusinessException
	 */
	public VerificationCodeSmsRetDto createVerificationCodeEmail(long codeType, String email)
			throws BusinessException;

	/**
	 * 邮件验证码校验
	 * 
	 * @param codeType 场景类型
	 * @param email   邮箱
	 * @param codeVal   传入校验值
	 * @return
	 * @throws BusinessException
	 */
	public CommonVerificationRetEnums vlidateEmail(long codeType, String email, String codeVal) throws BusinessException;


}
