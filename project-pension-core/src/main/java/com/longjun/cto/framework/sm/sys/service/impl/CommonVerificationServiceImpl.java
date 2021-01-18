package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonVerificationDto;
import com.longjun.cto.framework.sm.sys.entity.dto.CommonVerificationModifyDto;
import com.longjun.cto.framework.sm.sys.entity.dto.VerificationCodeSmsRetDto;
import com.longjun.cto.framework.sm.sys.entity.es.CommonVerificationRetEnums;
import com.longjun.cto.framework.sm.sys.entity.model.CommonVerificationModel;
import com.longjun.cto.framework.sm.sys.entity.model.CommonVerificationTypeModel;
import com.longjun.cto.framework.sm.sys.entity.view.CommonOptionView;
import com.longjun.cto.framework.sm.sys.entity.view.CommonVerificationView;
import com.longjun.cto.framework.sm.sys.mapper.CommonVerificationMapper;
import com.longjun.cto.framework.sm.sys.service.ICommonOptionService;
import com.longjun.cto.framework.sm.sys.service.ICommonVerificationService;
import com.longjun.cto.framework.sm.sys.service.ICommonVerificationTypeService;
import com.longjun.cto.framework.sm.sys.service.ISysService;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

/**
 * CommonVerificationServiceImpl
 * 
 * @author yangxuan
 * @date 2019-06-04 05:39:27
 */
@Service
public class CommonVerificationServiceImpl extends BaseServiceImpl<CommonVerificationMapper, CommonVerificationModel>
		implements ICommonVerificationService {

	@Autowired
	private CommonVerificationMapper mapper;

	@Autowired
	private ICommonVerificationTypeService iCommonVerificationTypeService;

	@Autowired
	private ICommonOptionService iCommonOptionService;

	@Autowired
	private ISysService iSysService;

	@Override
	public CommonVerificationView findViewById(long id) throws BusinessException {
		CommonVerificationView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public CommonVerificationModel findModelById(long id) throws BusinessException {
		CommonVerificationModel model = this.selectById(id);
		if (model == null) {
			log.warn("CommonVerification 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(CommonVerificationModel model) throws BusinessException {
		log.info("CommonVerification 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		CommonVerificationModel model = super.selectById(id);
		if (model == null) {
			log.error("CommonVerification 开启操作,ID[{}]未查询到数据信息", id);
			return false;
		}
		if (model.getStatus() == USE) {
			return true;
		}
		model.setStatus(USE);
		model.setLastupdate(new Date());
		boolean ret = super.updateById(model);
		return ret;
	}

	@Override
	public boolean del(long id) throws BusinessException {
		int ret = this.mapper.del(id);
		return ret > 0 ? true : false;
	}

	@Override
	public boolean stop(long id) throws BusinessException {
		CommonVerificationModel model = super.selectById(id);
		if (model == null) {
			log.error("CommonVerification 停止操作,ID[{}]未查询到数据信息", id);
			return false;
		}
		if (model.getStatus() == UNUSE) {
			return true;
		}
		model.setStatus(UNUSE);
		model.setLastupdate(new Date());
		boolean ret = super.updateById(model);
		return ret;
	}

	@Override
	public PageUtils<CommonVerificationView> getByPage(CommonVerificationDto dto) throws BusinessException {
		startPage(dto);
		List<CommonVerificationView> ret = this.mapper.getByPage(dto);
		PageUtils<CommonVerificationView> pages = new PageUtils<CommonVerificationView>(ret);
		return pages;
	}

	@Override
	public List<CommonVerificationView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<CommonVerificationView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<CommonVerificationView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<CommonVerificationView> listAll() throws BusinessException {
		List<CommonVerificationView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<CommonVerificationView>();
		}
		return rets;
	}

	@Override
	public boolean modify(CommonVerificationModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("CommonVerification 修改失败;传入对象为空");
			return false;
		}
		CommonVerificationModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("CommonVerification 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		CommonVerificationModel uModel = new CommonVerificationModel();
		try {
			BeanUtils.copyProperties(uModel, dto);
			boolean ret = super.updateById(uModel);
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String createVerificationCode(long codeType, String codeKey, String codeVal) throws BusinessException {

		if (codeType <= 0 || StrUtil.isBlank(codeKey) || StrUtil.isBlank(codeVal)) {
			log.error("验证码创建失败;传入codeType、codeKey,codeVal存在非法值 codeType - > {} codeKey-> {} codeVal-> {}", codeType,
					codeKey, codeVal);
			throw new BusinessException("验证码创建失败;传入codeType、codeKey,codeVal存在非法值");
		}
		CommonVerificationTypeModel commonVerificationTypeModel = this.iCommonVerificationTypeService
				.selectById(codeType);
		if (commonVerificationTypeModel == null) {
			log.error("验证码创建失败;未查询到验证码场景值; codeType(t_common_verification_type ID) -> {}", codeType);
			throw new BusinessException("验证码创建失败;未查询到验证码场景值;");
		}
		CommonVerificationModel model = new CommonVerificationModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setStatus(0);
		model.setIsDel(0);
		model.setCodeType(codeType);
		model.setCodeKey(codeKey);
		model.setCodeVal(codeVal);
		model.setMobile("0");
		model.setCodeEs(0);
		model.setMemo("图片验证码生成");
		model.setMark(commonVerificationTypeModel.getTypeName());
		long exprireTimestamp = System.currentTimeMillis() + (commonVerificationTypeModel.getExpireUnit() * 1000);
		model.setExpireTime(new Date(exprireTimestamp));
		model.setExpireTimestamp(exprireTimestamp);
		super.insert(model);
		return codeVal;
	}

	@Override
	public CommonVerificationRetEnums vlidate(long codeType, String codeKey, String codeVal, boolean reTry)
			throws BusinessException {
		CommonVerificationRetEnums ret = CommonVerificationRetEnums.FAIL;
		if (codeType <= 0 || StrUtil.isBlank(codeKey) || StrUtil.isBlank(codeVal)) {

			log.error("验证码验证失败;传入codeType、codeKey,codeVal存在非法值 codeType - > {} codeKey-> {} codeVal-> {}", codeType,
					codeKey, codeVal);
			ret = CommonVerificationRetEnums.FAIL;
			return ret;
		}
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("code_type", codeType).eq("code_key", codeKey).eq("status", 0).eq("is_del", 0).eq("code_es", 0)
				.orderBy("id", false);
		CommonVerificationModel commonVerificationModel = super.selectOne(ew);
		if (commonVerificationModel == null) {
			log.error("验证码验证失败;未查询到code_type -> {} code_key -> {}  status-> 0 is_del-> 0数据", codeType, codeKey);
			ret = CommonVerificationRetEnums.FAIL;
			return ret;

		}
		log.info("验证码信息 -> {}", JSONObject.toJSONString(commonVerificationModel));
		boolean isExpire = System.currentTimeMillis() > commonVerificationModel.getExpireTimestamp();
		// 超时情况;直接将状态修改为超时;
		if (isExpire) {
			commonVerificationModel.setLastupdate(new Date());
			commonVerificationModel.setStatus(CommonVerificationRetEnums.EXPRIRE.getCode());
			ret = CommonVerificationRetEnums.EXPRIRE;
			super.updateById(commonVerificationModel);
			return ret;
		}

		boolean validaRet = codeVal.equalsIgnoreCase(commonVerificationModel.getCodeVal());
		if (!reTry) {
			if (validaRet) {
				ret = CommonVerificationRetEnums.OK;
				commonVerificationModel.setLastupdate(new Date());
				commonVerificationModel.setStatus(ret.getCode());
				super.updateById(commonVerificationModel);
				return ret;
			} else {
				ret = CommonVerificationRetEnums.FAIL;
				commonVerificationModel.setLastupdate(new Date());
				commonVerificationModel.setStatus(ret.getCode());
				super.updateById(commonVerificationModel);
				return ret;
			}
		} else {
			// 可重复尝试;不做数据库修改;
			if (!validaRet) {
				return CommonVerificationRetEnums.FAIL;
			}
		}

		return CommonVerificationRetEnums.OK;
	}

	@Override
	public VerificationCodeSmsRetDto createVerificationCodeSms(long codeType, String mobile, String ip)
			throws BusinessException {
		if (!Validator.isMobile(mobile)) {
			log.error("短信发送,手机号码非法 -> {}", mobile);
			throw new BusinessException("短信发送,手机号码非法");
		}
		long timestamp = System.currentTimeMillis();
		// 一分钟内发送短信条数
		int mCountount = this.findCountByCodeEsIp(1, ip, (timestamp - (60 * 1000)), (timestamp));
		CommonOptionView minOpt = this.iCommonOptionService.findByKey("SYS_MOBILE_SEND_IP_MIN");// 分钟IP频率
		if (mCountount > Convert.toInt(minOpt.getValue(), 5)) {
			log.error("短信发送,ip分钟频率限制, 分钟内已发送 -> {}", mCountount);
			throw new BusinessException("频率限制,请稍后发送");
		}
		// 一小时内
		int hCountount = this.findCountByCodeEsIp(1, ip, (timestamp - (60 * 1000 * 60)), (timestamp));
		CommonOptionView hourOpt = this.iCommonOptionService.findByKey("SYS_MOBILE_SEND_IP_HOUR");// 小时IP频率
		if (hCountount > Convert.toInt(hourOpt.getValue(), 20)) {
			log.error("短信发送,ip小时频率限制, 小时内已发送 -> {}", mCountount);
			throw new BusinessException("频率限制,请稍后发送");
		}
		// 一天内
		int dCountount = this.findCountByCodeEsIp(1, ip, (timestamp - (60 * 1000 * 60 * 24)), (timestamp));
		CommonOptionView dayOpt = this.iCommonOptionService.findByKey("SYS_MOBILE_SEND_IP_DAY");// 小时IP频率
		if (dCountount > Convert.toInt(dayOpt.getValue(), 50)) {
			log.error("短信发送,ip天频率限制, 天内已发送 -> {}", mCountount);
			throw new BusinessException("频率限制,请稍后发送");
		}
		int mmCountount = this.findCountByCodeEsMobile(1, mobile, (timestamp - (60 * 1000)), (timestamp));
		CommonOptionView minMobileOpt = this.iCommonOptionService.findByKey("SYS_MOBILE_SEND_MOBILE_MIN");// 分钟手机频率
		if (mmCountount > Convert.toInt(minMobileOpt.getValue(), 5)) {
			log.error("短信发送,手机分钟频率限制, 分钟内已发送 -> {}", mCountount);
			throw new BusinessException("频率限制,请稍后发送");
		}
		int mhCountount = this.findCountByCodeEsMobile(1, mobile, (timestamp - (60 * 1000 * 60)), (timestamp));
		CommonOptionView hourMobileOpt = this.iCommonOptionService.findByKey("SYS_MOBILE_SEND_MOBILE_HOUR");// 小时手机频率
		if (mhCountount > Convert.toInt(hourMobileOpt.getValue(), 20)) {
			log.error("短信发送,手机小时频率限制, 分钟内已发送 -> {}", mCountount);
			throw new BusinessException("频率限制,请稍后发送");
		}
		int mdCountount = this.findCountByCodeEsMobile(1, mobile, (timestamp - (60 * 1000 * 60 * 24)), (timestamp));
		CommonOptionView dayMobileOpt = this.iCommonOptionService.findByKey("SYS_MOBILE_SEND_MOBILE_DAY");// 天手机频率
		if (mdCountount > Convert.toInt(dayMobileOpt.getValue(), 50)) {
			log.error("短信发送,手机天频率限制, 分钟内已发送 -> {}", mCountount);
			throw new BusinessException("频率限制,请稍后发送");
		}
		// key
		String codeKey = "SMS_" + codeType + "_" + mobile;
		String codeVal = RandomUtil.randomInt(100000, 999999) + "";
		// 开发环境默认验证码为123456
		if (iSysService.isDev()) {
			codeVal = "123456";
		}
		log.info("短信验证码生成中, codeType -> {} mobile -> {}", codeType, mobile);
		if (codeType <= 0) {
			log.error("短信验证码创建失败;传入codeType存在非法值 codeType - > {}", codeType);
			throw new BusinessException("短信验证码创建失败;传入codeType存在非法值");
		}
		CommonVerificationTypeModel commonVerificationTypeModel = this.iCommonVerificationTypeService
				.selectById(codeType);
		if (commonVerificationTypeModel == null) {
			log.error("短信验证码创建失败;未查询到验证码场景值; codeType(t_common_verification_type ID) -> {}", codeType);
			throw new BusinessException("短信验证码创建失败;未查询到验证码场景值;");
		}
		CommonVerificationModel model = new CommonVerificationModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setStatus(0);
		model.setIsDel(0);
		model.setCodeType(codeType);
		model.setCodeKey(codeKey);
		model.setCodeVal(codeVal);
		model.setMark(commonVerificationTypeModel.getTypeName());
		long exprireTimestamp = System.currentTimeMillis() + (commonVerificationTypeModel.getExpireUnit() * 1000);
		model.setExpireTime(new Date(exprireTimestamp));
		model.setExpireTimestamp(exprireTimestamp);
		model.setIp(ip);
		model.setCodeEs(1);
		model.setMobile(mobile);
		super.insert(model);
		VerificationCodeSmsRetDto ret = new VerificationCodeSmsRetDto();
		ret.setCodeVal(codeVal);
		ret.setToken(codeKey);
		return ret;
	}

	@Override
	public CommonVerificationRetEnums vlidateSms(long codeType, String mobile, String codeVal)
			throws BusinessException {
		String codeKey = "SMS_" + codeType + "_" + mobile;
		CommonVerificationRetEnums ret = CommonVerificationRetEnums.FAIL;
		if (codeType <= 0 || StrUtil.isBlank(codeKey) || StrUtil.isBlank(codeVal)) {
			log.error("短信验证码验证失败;传入codeType、codeKey,codeVal存在非法值 codeType - > {} codeKey-> {} codeVal-> {}", codeType,
					codeKey, codeVal);
			ret = CommonVerificationRetEnums.FAIL;
			return ret;
		}

		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("code_type", codeType).eq("code_key", codeKey).eq("status", 0).eq("is_del", 0).eq("code_es", 1)
				.eq("mobile", mobile).orderBy("id", false);
		CommonVerificationModel commonVerificationModel = super.selectOne(ew);
		if (commonVerificationModel == null) {
			log.error("短信验证码验证失败;未查询到code_type -> {} code_key -> {}  status-> 0 is_del-> 0数据", codeType, codeKey);
			ret = CommonVerificationRetEnums.FAIL;
			return ret;
		}
		log.info("短信验证码信息 -> {}", JSONObject.toJSONString(commonVerificationModel));
		boolean isExpire = System.currentTimeMillis() > commonVerificationModel.getExpireTimestamp();
		// 超时情况;直接将状态修改为超时;
		if (isExpire) {
			commonVerificationModel.setLastupdate(new Date());
			commonVerificationModel.setStatus(CommonVerificationRetEnums.EXPRIRE.getCode());
			ret = CommonVerificationRetEnums.EXPRIRE;
			super.updateById(commonVerificationModel);
			return ret;
		}

		boolean validaRet = codeVal.equalsIgnoreCase(commonVerificationModel.getCodeVal());
		if (validaRet) {
			ret = CommonVerificationRetEnums.OK;
			commonVerificationModel.setLastupdate(new Date());
			commonVerificationModel.setStatus(ret.getCode());
			super.updateById(commonVerificationModel);
			return ret;
		} else {
			ret = CommonVerificationRetEnums.FAIL;
//			commonVerificationModel.setLastupdate(new Date());
//			commonVerificationModel.setStatus(ret.getCode());
//			super.updateById(commonVerificationModel);
			return ret;
		}
	}

	@Override
	public int findCountByCodeEsIp(Integer codeEs, String ip, long start, long end) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_is_del", 0);
		params.put("c_ip", ip);
		params.put("c_start", new Date(start));
		params.put("c_end", new Date(end));
		params.put("c_code_es", codeEs);
		int count = this.mapper.countMap(params);
		return count;
	}

	@Override
	public int findCountByCodeEsMobile(Integer codeEs, String mobile, long start, long end) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_is_del", 0);
		params.put("c_mobile", mobile);
		params.put("c_start", new Date(start));
		params.put("c_end", new Date(end));
		params.put("c_code_es", codeEs);
		int count = this.mapper.countMap(params);
		return count;
	}

	@Override
	public String createVerificationCode(long codeType, String codeKey) throws BusinessException {
		String codeVal = RandomUtil.randomInt(1000 , 9999) + "";
		if (iSysService.isDev()) {
			codeVal = "1234";
		}
		this.createVerificationCode(codeType, codeKey, codeVal);
		return codeVal;
	}

	@Override
	public VerificationCodeSmsRetDto createVerificationCodeEmail(long codeType, String email) throws BusinessException {
		if (!Validator.isEmail(email)) {
			log.error("邮件发送,邮箱号码非法 -> {}", email);
			throw new BusinessException("邮件发送,邮箱号码非法");
		}
		// key
		String codeKey = email;
		String codeVal = RandomUtil.randomInt(100000, 999999) + "";
		// 开发环境默认验证码为123456
		if (iSysService.isDev()) {
			codeVal = "123456";
		}
		log.info("邮箱验证码生成中, codeType -> {} email -> {}", codeType, email);
		if (codeType <= 0) {
			log.error("邮箱验证码创建失败;传入codeType存在非法值 codeType - > {}", codeType);
			throw new BusinessException("邮箱验证码创建失败;传入codeType存在非法值");
		}
		CommonVerificationTypeModel commonVerificationTypeModel = this.iCommonVerificationTypeService
				.selectById(codeType);
		if (commonVerificationTypeModel == null) {
			log.error("邮箱验证码创建失败;未查询到验证码场景值; codeType(t_common_verification_type ID) -> {}", codeType);
			throw new BusinessException("邮箱验证码创建失败;未查询到验证码场景值;");
		}
		CommonVerificationModel model = new CommonVerificationModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setStatus(0);
		model.setIsDel(0);
		model.setCodeType(codeType);
		model.setCodeKey(codeKey);
		model.setCodeVal(codeVal);
		model.setMark(commonVerificationTypeModel.getTypeName());
		long exprireTimestamp = System.currentTimeMillis() + (commonVerificationTypeModel.getExpireUnit() * 1000);
		model.setExpireTime(new Date(exprireTimestamp));
		model.setExpireTimestamp(exprireTimestamp);
		model.setIp(null);
		model.setCodeEs(2);
		model.setMobile(null);
		super.insert(model);
		VerificationCodeSmsRetDto ret = new VerificationCodeSmsRetDto();
		ret.setCodeVal(codeVal);
		ret.setToken(codeKey);
		return ret;
	}

	@Override
	public CommonVerificationRetEnums vlidateEmail(long codeType, String email, String codeVal)
			throws BusinessException {
		String codeKey = email;
		CommonVerificationRetEnums ret = CommonVerificationRetEnums.FAIL;
		if (codeType <= 0 || StrUtil.isBlank(codeKey) || StrUtil.isBlank(codeVal)) {
			log.error("邮件验证码验证失败;传入codeType、codeKey,codeVal存在非法值 codeType - > {} codeKey-> {} codeVal-> {}", codeType,
					codeKey, codeVal);
			ret = CommonVerificationRetEnums.FAIL;
			return ret;
		}

		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("code_type", codeType).eq("code_key", codeKey).eq("status", 0).eq("is_del", 0).eq("code_es", 2).orderBy("id", false);
		CommonVerificationModel commonVerificationModel = super.selectOne(ew);
		if (commonVerificationModel == null) {
			log.error("邮件验证码验证失败;未查询到code_type -> {} code_key -> {}  status-> 0 is_del-> 0数据", codeType, codeKey);
			ret = CommonVerificationRetEnums.FAIL;
			return ret;
		}
		log.info("邮件验证码信息 -> {}", JSONObject.toJSONString(commonVerificationModel));
		boolean isExpire = System.currentTimeMillis() > commonVerificationModel.getExpireTimestamp();
		// 超时情况;直接将状态修改为超时;
		if (isExpire) {
			commonVerificationModel.setLastupdate(new Date());
			commonVerificationModel.setStatus(CommonVerificationRetEnums.EXPRIRE.getCode());
			ret = CommonVerificationRetEnums.EXPRIRE;
			super.updateById(commonVerificationModel);
			return ret;
		}

		boolean validaRet = codeVal.equalsIgnoreCase(commonVerificationModel.getCodeVal());
		if (validaRet) {
			ret = CommonVerificationRetEnums.OK;
			commonVerificationModel.setLastupdate(new Date());
			commonVerificationModel.setStatus(ret.getCode());
			super.updateById(commonVerificationModel);
			return ret;
		} else {
			ret = CommonVerificationRetEnums.FAIL;
//			commonVerificationModel.setLastupdate(new Date());
//			commonVerificationModel.setStatus(ret.getCode());
//			super.updateById(commonVerificationModel);
			return ret;
		}
	}

}
