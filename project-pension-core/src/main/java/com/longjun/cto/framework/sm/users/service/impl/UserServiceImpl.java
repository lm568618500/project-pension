package com.longjun.cto.framework.sm.users.service.impl;

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
import com.eims.cto.framework.common.conf.SysSetting;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.users.entity.dto.FindPasswordInputDto;
import com.longjun.cto.framework.sm.users.entity.dto.RegisterInputDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserModifyDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserModifyInputDto;
import com.longjun.cto.framework.sm.users.entity.model.UserModel;
import com.longjun.cto.framework.sm.users.entity.model.UserScoreSenceModel;
import com.longjun.cto.framework.sm.users.entity.view.UserView;
import com.longjun.cto.framework.sm.users.mapper.UserMapper;
import com.longjun.cto.framework.sm.users.service.IUserScoreSenceService;
import com.longjun.cto.framework.sm.users.service.IUserService;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * UserServiceImpl
 * 
 * @author yangxuan
 * @date 2019-06-19 02:29:35
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserModel> implements IUserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private IUserScoreSenceService iUserScoreSenceService;

	@Override
	public UserView findViewById(long id) throws BusinessException {
		UserView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public UserModel findModelById(long id) throws BusinessException {
		UserModel model = this.selectById(id);
		if (model == null) {
			log.warn("User 通过ID查询结果为空");
			return null;
		}
		return model;
	}

	@Override
	public void saveModel(UserModel model) throws BusinessException {
		log.info("User 数据新增 -> [{}]", JSONObject.toJSONString(model));
		super.insert(model);
	}

	@Override
	public boolean start(long id) throws BusinessException {
		UserModel model = super.selectById(id);
		if (model == null) {
			log.error("User 开启操作,ID[{}]未查询到数据信息", id);
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
		UserModel model = super.selectById(id);
		if (model == null) {
			log.error("User 停止操作,ID[{}]未查询到数据信息", id);
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
	public PageUtils<UserView> getByPage(UserDto dto) throws BusinessException {
		startPage(dto);
		List<UserView> ret = this.mapper.getByPage(dto);
		PageUtils<UserView> pages = new PageUtils<UserView>(ret);
		return pages;
	}

	@Override
	public List<UserView> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<UserView> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<UserView>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<UserView> listAll() throws BusinessException {
		List<UserView> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<UserView>();
		}
		return rets;
	}

	@Override
	public boolean modify(UserModifyDto dto) throws BusinessException {
		if (dto == null) {
			log.error("User 修改失败;传入对象为空");
			return false;
		}
		UserModel model = super.selectById(dto.getId());
		if (model == null) {
			log.error("User 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		UserModel uModel = new UserModel();
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
	public boolean regAction(RegisterInputDto registerInputDto) throws BusinessException {
		log.info("用户注册操作 -> {}", JSONObject.toJSONString(registerInputDto));
		if (registerInputDto == null) {
			throw new BusinessException("用户注册失败;传入对象为空");
		}
		if (StrUtil.isBlank(registerInputDto.getMobile())) {
			throw new BusinessException("用户注册失败;手机号码不能为空");
		}
		if (!Validator.isMobile(registerInputDto.getMobile())) {
			throw new BusinessException("用户注册失败;手机号码非法");
		}
//		if (StrUtil.isBlank(registerInputDto.getKey())) {
//			throw new BusinessException("用户注册失败;验证码key不能为空");
//		}
		if (StrUtil.isBlank(registerInputDto.getSmsCode())) {
			throw new BusinessException("用户注册失败;短信验证码为空");
		}
		if (StrUtil.isBlank(registerInputDto.getPassword()) || StrUtil.isBlank(registerInputDto.getRePassword())) {
			throw new BusinessException("用户注册失败;密码不能为空");
		}
		if (!registerInputDto.getPassword().equals(registerInputDto.getRePassword())) {
			throw new BusinessException("用户注册失败;密码不一致");
		}
		if (registerInputDto.getAgreePact() == null) {
			throw new BusinessException("用户注册失败，请同意注册协议");
		}
		if (registerInputDto.getAgreePact().intValue() != 1) {
			throw new BusinessException("用户注册失败，请同意注册协议");
		}
		UserModel exist = this.findByMobileUserType(registerInputDto.getMobile(),
				Convert.toInt(registerInputDto.getUserType(), 1));
		if (exist != null) {
			throw new BusinessException("对不起,该账号以注册");
		}
		UserModel model = new UserModel();
		model.setTime(new Date());
		model.setLastupdate(new Date());
		model.setStatus(1);
		model.setIsDel(0);
		model.setPhoto(registerInputDto.getUserPhoto());
		model.setUserName(registerInputDto.getUserName());
		model.setRealName(registerInputDto.getRealName());
		model.setMobile(registerInputDto.getMobile());
		String password = encryPassword(registerInputDto.getPassword());
		model.setPassword(password);
		model.setUserType(Convert.toInt(registerInputDto.getUserType()));
		model.setOnline(0);
		model.setRemark(null);
		model.setIsBlack(0);
		model.setIsLock(0);
		model.setLoginErrorCount(0);
		model.setLockTime(null);
		model.setUserNo(super.sequenceId());
		model.setSex(0);
		super.insert(model);
		log.info("用户注册成功 ;mobile -> {}", registerInputDto.getMobile());
		return true;
	}

	@Override
	public UserModel findByMobileUserType(String mobile, int userType) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("mobile", mobile).eq("user_type", userType);
		UserModel ret = super.selectOne(ew);
		return ret;
	}

	/**
	 * 密码摘要
	 * 
	 * @param password
	 * @return
	 */
	@Override
	public String encryPassword(String password) throws BusinessException {
		Digester md5 = new Digester(DigestAlgorithm.MD5);
		String ret = md5.digestHex(password + SysSetting.PASSPORT_PASSWORDSERCRET);
		return ret;
	}

	@Override
	public boolean findPasspordAction(FindPasswordInputDto findPasswordInputDtos) throws BusinessException {
		log.info("用户找回密码操作 -> {}", JSONObject.toJSONString(findPasswordInputDtos));
		if (findPasswordInputDtos == null) {
			throw new BusinessException("用户找回密码失败;传入对象为空");
		}
		if (StrUtil.isBlank(findPasswordInputDtos.getMobile())) {
			throw new BusinessException("用户找回密码失败;手机号码不能为空");
		}
		if (!Validator.isMobile(findPasswordInputDtos.getMobile())) {
			throw new BusinessException("用户找回密码失败;手机号码非法");
		}
		if (StrUtil.isBlank(findPasswordInputDtos.getKey())) {
			throw new BusinessException("用户找回密码失败;验证码key不能为空");
		}
		if (StrUtil.isBlank(findPasswordInputDtos.getSmsCode())) {
			throw new BusinessException("用户找回密码失败;短信验证码为空");
		}
		if (StrUtil.isBlank(findPasswordInputDtos.getPassword())
				|| StrUtil.isBlank(findPasswordInputDtos.getRePassword())) {
			throw new BusinessException("用户找回密码失败;密码不能为空");
		}
		if (!findPasswordInputDtos.getPassword().equals(findPasswordInputDtos.getRePassword())) {
			throw new BusinessException("用户找回失败;密码不一致");
		}
		UserModel model = this.findByMobileUserType(findPasswordInputDtos.getMobile(),
				Convert.toInt(findPasswordInputDtos.getUserType(), 1));
		if (model == null) {
			throw new BusinessException("对不起,该账号不存在");
		}
		model.setLastupdate(new Date());
		String password = encryPassword(findPasswordInputDtos.getPassword());
		model.setPassword(password);
		super.updateById(model);
		log.info("用户找回密码成功 ;mobile -> {}", findPasswordInputDtos.getMobile());
		return true;
	}

	@Override
	public boolean modifyPhoto(long userId, String photo) throws BusinessException {
		UserModel userModel = super.selectById(userId);
		if (userModel == null) {
			log.error("修改用户头像,未查询到userId -> {} 用户数据", userId);
			return false;
		}
		userModel.setLastupdate(new Date());
		userModel.setPhoto(photo);
		boolean ret = super.updateById(userModel);
		return ret;
	}

	@Override
	public boolean modifyPassword(long userId, String password) throws BusinessException {
		UserModel userModel = super.selectById(userId);
		if (userModel == null) {
			log.error("修改用户密码,未查询到userId -> {} 用户数据", userId);
			return false;
		}
		userModel.setLastupdate(new Date());
		userModel.setPassword(this.encryPassword(password));
		boolean ret = super.updateById(userModel);
		return ret;
	}

	@Override
	public boolean modifyUserInfo(UserModifyInputDto userModifyInputDto) throws BusinessException {
		log.info("个人信息修改 -> {}", JSONObject.toJSONString(userModifyInputDto));
		if (userModifyInputDto == null) {
			log.error("个人信息修改失败,传入对象为空");
			return false;
		}
		if (userModifyInputDto.getId() != null && userModifyInputDto.getId() < 1) {
			log.error("个人信息修改失败,传入ID非法");
			return false;
		}
		UserModel userModel = super.selectById(userModifyInputDto.getId());
		if (userModel == null) {
			log.error("个人信息修改失败,未查询到用户信息");
			return false;
		}
		userModel.setLastupdate(new Date());
		userModel.setPhoto(userModifyInputDto.getPhoto());
		userModel.setSex(userModifyInputDto.getSex());
		userModel.setJob(userModifyInputDto.getJob());
		userModel.setpId(userModifyInputDto.getpId());
		userModel.setcId(userModifyInputDto.getcId());
		userModel.setaId(userModifyInputDto.getaId());
		userModel.setSignature(userModifyInputDto.getSignature());
		userModel.setBirthday(userModifyInputDto.getBirthday());
		userModel.setYear(userModifyInputDto.getYear());
		userModel.setMonth(userModifyInputDto.getMonth());
		userModel.setDay(userModifyInputDto.getDay());

		super.updateById(userModel);
		return true;
	}

	@Override
	public UserView findViewByUserName(String userName) throws BusinessException {
		Map<String, Object> params = new HashMap<>();
		params.put("c_user_name", userName);
		params.put("c_status", 1);
		params.put("c_is_del", 0);
		List<UserView> rets = this.mapper.listModelMap(params);
		if (rets == null || rets.size() == 0) {
			return null;
		}
		return rets.get(0);
	}

	@Override
	public boolean changeScore(Long userId, Long score, Long scoreSenceNo) throws BusinessException {
		synchronized (userId + "") {
			log.info("用户积分变动,userId -> {} , scoer -> {} , scoreSenceNo -> {}", userId, score, scoreSenceNo);
			if (userId <= 0L) {
				log.error("用户积分变动失败,传入userId 非法");
				return false;
			}
			UserModel userModel = super.selectById(userId);
			if (userModel == null) {
				log.error("用户积分变动失败,未查询到用户信息");
				return false;
			}
			UserScoreSenceModel userScoreSenceModel = this.iUserScoreSenceService.findBySenceNo(scoreSenceNo);
			if (userScoreSenceModel == null) {
				log.error("用户积分变动失败,未查询到积分场景信息");
				return false;
			}
			// 获取积分变动方式
			int income = userScoreSenceModel.getIncome().intValue();
			Long finalScore = 0L;
			if (income == 1) { // 积分入账
				finalScore = Math.abs(score);
			} else if (income == 2) { // 积分出账
				finalScore = Math.abs(score) * -1;
			}
			int ret = this.mapper.updateScore(userId, finalScore);
			return ret > 0 ? true : false;
		}
	}

	@Override
	public boolean modifyPhone(long userId, String mobile) throws BusinessException {
		UserModel userModel = super.selectById(userId);
		if (userModel == null) {
			log.error("修改用户手机,未查询到userId -> {} 用户数据", userId);
			return false;
		}
		userModel.setLastupdate(new Date());
		userModel.setMobile(mobile);
		boolean ret = super.updateById(userModel);
		return ret;
	}

	@Override
	public UserModel findModelByMobile(long mobile) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("mobile", mobile);
		UserModel ret = super.selectOne(ew);
		return ret;
	}

}
