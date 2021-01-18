package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminLoginDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminModifyDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminModifyPasswordDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminMotifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminModel;
import com.longjun.cto.framework.sm.sys.entity.model.AdminRoleModel;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminView;
import com.longjun.cto.framework.sm.sys.mapper.AdminMapper;
import com.longjun.cto.framework.sm.sys.service.IAdminRoleService;
import com.longjun.cto.framework.sm.sys.service.IAdminService;
import com.longjun.cto.framework.sm.sys.service.IAuthRoleService;
import com.longjun.cto.framework.sm.sys.utils.PasswordEncryKit;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;

/**
 * 管理员Service Impl
 * 
 * @author lp
 * @date 2018-12-20 20:10:49
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<AdminMapper, AdminModel> implements IAdminService {

	@Autowired
	AdminMapper mapper;

	@Autowired
	IAdminRoleService iAdminRoleService;

	@Autowired
	IAuthRoleService iAuthRoleService;

	@Override
	public AdminView findViewById(long id) throws BusinessException {
		AdminView ret = this.mapper.findViewById(id);
		return ret;
	}

	@Override
	public AdminModel findModelById(long id) throws BusinessException {
		AdminModel model = this.selectById(id);
		if(model == null) {
			log.warn("Admin 通过ID查询结果为空");
			return null;
		}
		return model;
	}
	@Override
	public boolean setStatusById(long id, int status) throws BusinessException {
		try {
			AdminModel model = this.selectById(id);
			model.setId(id);
			model.setStatus(status);
			this.updateById(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
		return false;
	}

	void saveModelBefore(AdminModel model) throws BusinessException {
		// TOOD 校验等操作
	}

	void saveModelAfter(AdminModel model) throws BusinessException {
		// TOOD 校验等操作
	}

	@Override
	public Long saveModel(AdminModel model) throws BusinessException {
		try {
			this.saveModelBefore(model);
			this.insert(model);
			this.saveModelAfter(model);
			return model.getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public boolean start(long id) throws BusinessException {
		AdminModel model = super.selectById(id);
		if (model == null) {
			log.error("AdminModel 开启操作,ID[{}]未查询到数据信息", id);
			return false;
		}
		if (model.getStatus() == USE) {
			return true;
		}
		model.setStatus(USE);
		boolean ret = super.updateById(model);
		return ret;
	}

	@Override
	public boolean stop(long id) throws BusinessException {
		return this.setStatusById(id, UNUSE);
	}

	@Override
	public PageUtils<AdminView> getByPage(AdminDto dto) throws BusinessException {
		startPage(dto);
		List<AdminView> ret = this.mapper.getByPage(dto);
		PageUtils<AdminView> pages = new PageUtils<AdminView>(ret);
		return pages;
	}
	@Override
	public PageUtils<AdminView> getOtherByPage(AdminDto dto) throws BusinessException {
		startPage(dto);
		List<AdminView> ret = this.mapper.getOtherByPage(dto);
		PageUtils<AdminView> pages = new PageUtils<AdminView>(ret);
		return pages;
	}
	@Override
	public PageUtils<AdminView> getExpertByPage(AdminDto dto) throws BusinessException {
		startPage(dto);
		List<AdminView> ret = this.mapper.getExpertByPage(dto);
		PageUtils<AdminView> pages = new PageUtils<AdminView>(ret);
		return pages;
	}
	@Override
	public PageUtils<AdminView> getPersonnelByPage(AdminDto dto) throws BusinessException {
		startPage(dto);
		List<AdminView> ret = this.mapper.getPersonnelByPage(dto);
		PageUtils<AdminView> pages = new PageUtils<AdminView>(ret);
		return pages;
	}
	
	@Override
	public AdminView getById(long id) throws BusinessException {
		AdminView view = this.mapper.getById(id);
		return view;
	}

	@Override
	public boolean saveModel(String account, String realName, String jobNumber, long mobile, long roleid, int status,
			String password, int type) throws BusinessException {

		// 字段校验
		if (account == null || account.equals("")) {
			throw new BusinessException("请输入账号");
		}
		if (realName == null || realName.equals("")) {
			throw new BusinessException("请输入姓名");
		}
		if (jobNumber == null || jobNumber.equals("")) {
			throw new BusinessException("请输入工号");
		}
		if (password == null || password.equals("")) {
			throw new BusinessException("请输入密码");
		}
		if (mobile < 0) {
			throw new BusinessException("请输入手机号码");
		}
		if (roleid < 0) {
			throw new BusinessException("请选择角色类型");
		}
		if (type < 0) {
			throw new BusinessException("请选择管理员类型");
		}
		AdminModel model = new AdminModel();
//		try{
		model.setAccount(account);
		model.setRealName(realName);
		model.setJobNumber(jobNumber);
		model.setMobile(mobile);
		model.setTime(new Date());
		model.setStatus(status);
		String encryPwd = PasswordEncryKit.encry(password);
		model.setPassword(encryPwd);
		model.setType(type);
		this.insert(model);
		return true;
	}

	@Override
	public boolean modify(long id, String account, String realName, String jobNumber, long mobile, long roleid,
			int status, String password, int type) throws BusinessException {

		// 字段校验
		if (account == null || account.equals("")) {
			throw new BusinessException("请输入账号");
		}
		if (realName == null || realName.equals("")) {
			throw new BusinessException("请输入姓名");
		}
		if (jobNumber == null || jobNumber.equals("")) {
			throw new BusinessException("请输入工号");
		}
		if (password == null || password.equals("")) {
			throw new BusinessException("请输入密码");
		}
		if (mobile < 0) {
			throw new BusinessException("请输入手机号码");
		}
		if (roleid < 0) {
			throw new BusinessException("请选择角色类型");
		}
		if (type < 0) {
			throw new BusinessException("请选择管理员类型");
		}
		AdminModel model = this.selectById(id);
		model.setAccount(account);
		model.setRealName(realName);
		model.setJobNumber(jobNumber);
		model.setMobile(mobile);
		model.setStatus(status);
		String encryPwd = PasswordEncryKit.encry(password);
		model.setPassword(encryPwd);
		model.setType(type);
		model.setLastupdate(new Date());
		this.updateById(model);
		return true;
	}
	@Override
	public boolean modify(AdminModifyDto dto) throws BusinessException {
		if(dto == null) {
			log.error("Admin 修改失败;传入对象为空");
			return false;
		}
		AdminModel model = super.selectById(dto.getId());
		if(model == null) {
			log.error("Admin 修改失败;通过ID[{}]未查询到数据", dto.getId());
			return false;
		}
		AdminModel uModel = new AdminModel();
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
	public Integer deletes(long[] id) throws BusinessException {

		try {
			return this.mapper.updates(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return UNUSE;
	}

	@Override
	public List<Map<String, Object>> getRolList() throws BusinessException {
		return this.mapper.getRolList();
	}

	@Override
	public AdminModel loginAction(AdminLoginDto dto) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("account", dto.getUsername());
		AdminModel ret = super.selectOne(ew);
		if (ret == null) {
			return null;
		}
		if (ret.getPassword().equalsIgnoreCase(PasswordEncryKit.encry(dto.getPassword()))) {
			return ret;
		}
		return null;
	}

	@Override
	public void logOut(String key, long userId) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean unlock(long adminId) throws BusinessException {
		AdminModel ret = super.selectById(adminId);
		if (ret == null) {
			log.error("解锁管理员;未查询到管理员[{}]信息", adminId);
			return false;
		}
		ret.setLastupdate(new Date());
		ret.setStatus(1);
		super.updateById(ret);
		return true;
	}

	@Override
	public boolean lock(long adminId) throws BusinessException {
		AdminModel ret = super.selectById(adminId);
		if (ret == null) {
			log.error("锁定管理员;未查询到管理员[{}]信息", adminId);
			return false;
		}
		ret.setLastupdate(new Date());
		ret.setStatus(0);
		super.updateById(ret);
		return true;
	}

	@Override
	public boolean del(long adminId) throws BusinessException {
		AdminModel ret = super.selectById(adminId);
		if (ret == null) {
			log.error("删除管理员;未查询到管理员[{}]信息", adminId);
			return false;
		}
		ret.setLastupdate(new Date());
		ret.setIsDel(1);
		super.updateById(ret);
		return true;
	}

	@Override
	public boolean modify(AdminMotifyDto adminMotifyDto) throws BusinessException {
		long id = adminMotifyDto.getId();
		AdminModel ret = super.selectById(id);
		if (ret == null) {
			log.error("修改管理员;未查询到ADMINID[{}]记录", id);
			throw new BusinessException("修改管理员;未查询到ADMINID[%s]记录", id);
		}
		if (StrUtil.isBlank(adminMotifyDto.getRealName())) {
			log.error("修改管理员信息失败;姓名不能为空");
			throw new BusinessException("修改管理员信息失败;姓名不能为空");
		}
		if (StrUtil.isBlank(adminMotifyDto.getPassword())) {
			log.error("修改管理员失败;密码不能为空");
			throw new BusinessException("修改管理员失败;密码不能为空");
		}
		if (StrUtil.isBlank(adminMotifyDto.getRePassword())) {
			log.error("修改管理员失败;密码不能为空");
			throw new BusinessException("修改管理员失败;密码不能为空");
		}
		if (!adminMotifyDto.getPassword().equals(adminMotifyDto.getRePassword())) {
			log.error("修改管理员失败;密码不一致");
			throw new BusinessException("修改管理员失败;密码不一致");
		}
		if (ret.getPassword().equals(adminMotifyDto.getPassword())) {
			// 未修改密码
		} else {
			ret.setPassword(PasswordEncryKit.encry(adminMotifyDto.getPassword()));
		}
		if (adminMotifyDto.getMobile() > 0) {
			boolean isMobile = Validator.isMobile(adminMotifyDto.getMobile() + "");
			if (!isMobile) {
				throw new BusinessException("修改管理员信息失败;手机格式非法");
			}
		}
		if (StrUtil.isNotBlank(adminMotifyDto.getEmail())) {
			boolean isEmail = Validator.isEmail(adminMotifyDto.getEmail());
			if (!isEmail) {
				throw new BusinessException("修改管理员信息失败;邮箱格式非法");
			}
		}
		ret.setMobile(adminMotifyDto.getMobile());
		ret.setEmail(adminMotifyDto.getEmail());
		ret.setRemarks(adminMotifyDto.getRemarks());
		ret.setRealName(adminMotifyDto.getRealName());
		//ret.setIsuse(adminMotifyDto.getIsuse());
		boolean modifyRet = super.updateById(ret);

		// 前台传入是使用ID
		String[] rolieds =adminMotifyDto.getRoleid().split(",");
		long[] roleId=new long[rolieds.length];
		for (int i = 0; i < rolieds.length; i++) {
			AuthRoleModel authRoleModel = this.iAuthRoleService.findByUseId(Long.parseLong(rolieds[i]));
			if(authRoleModel!=null){
				// 修改管理员权限
				this.iAdminRoleService.setAdminRole(adminMotifyDto.getId(), authRoleModel.getId());
				roleId[i]=authRoleModel.getUseId();
			}
		}
		//删除去掉的权限
		EntityWrapper<AdminRoleModel> roleWrappe=new EntityWrapper<AdminRoleModel>();
		roleWrappe.eq("admin_id", ret.getId());
		for (int i = 0; i < roleId.length; i++) {
			roleWrappe.notIn("role_id", roleId[i]);
		}
		List<AdminRoleModel> arList=this.iAdminRoleService.selectList(roleWrappe);
		for (AdminRoleModel ar :arList) {
			ar.setStatus(0);
			this.iAdminRoleService.insertOrUpdate(ar);
		}
		return modifyRet;
	}

	@Override
	public List<AdminModel> listByLimitStatus(int status, int limit) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("c_status", status);
		params.put("c_limit", limit);
		List<AdminModel> rets = this.mapper.listModelMap(params);
		if (rets == null) {
			return new ArrayList<AdminModel>();
		}
		return rets;
	}

	@Override
	public int countAll() throws BusinessException {
		int count = this.mapper.countMap(new HashMap<>());
		return count;
	}

	@Override
	public List<AdminModel> listAll() throws BusinessException {
		List<AdminModel> rets = this.mapper.listModelMap(new HashMap<>());
		if (rets == null) {
			return new ArrayList<AdminModel>();
		}
		return rets;
	}

	@Override
	public boolean modifyPassword(AdminModifyPasswordDto dto) throws BusinessException {
		if (dto == null) {
			throw new BusinessException("修改密码,传入对象为空");
		}
		if (StrUtil.isBlank(dto.getOldPassword())) {
			throw new BusinessException("修改密码失败;原始密码不能为空");
		}
		if (StrUtil.isBlank(dto.getNewPassword())) {
			throw new BusinessException("修改密码失败;新密码不能为空");
		}
		if (StrUtil.isBlank(dto.getReNewPassword())) {
			throw new BusinessException("修改密码失败;确认密码不能为空");
		}
		if (!dto.getReNewPassword().equals(dto.getNewPassword())) {
			throw new BusinessException("修改密码失败;新密码不相等");
		}
		if (dto.getOldPassword().equals(dto.getReNewPassword())) {
			throw new BusinessException("修改密码失败;新密码不能与旧密码相等");
		}

		AdminModel admin = super.selectById(dto.getAdminId());
		if (admin == null) {
			throw new BusinessException("修改密码失败;未查询到管理员信息");
		}
		if (!admin.getPassword().equals(PasswordEncryKit.encry(dto.getOldPassword()))) {
			throw new BusinessException("修改密码失败;原始密码错误");
		}

		admin.setPassword(PasswordEncryKit.encry(dto.getReNewPassword()));
		admin.setLastupdate(new Date());
		boolean ret = super.updateById(admin);
		return ret;
	}

	@Override
	public boolean addAdminAction(String account, String realName, String password, String rePassword, String email,
			String mobile, String roleId,String remarks) throws BusinessException {
		if (isBlank(account)) {
			throw new BusinessException("添加管理员失败;账号为空");
		}
		EntityWrapper<AdminModel> adminWrapper=new EntityWrapper<AdminModel>();
		adminWrapper.eq("account", account);
		adminWrapper.eq("is_del", 0);
		AdminModel admin=super.selectOne(adminWrapper);
		if(admin!=null){
			throw new BusinessException("添加管理员失败;用户名已存在");
		}
		if (isBlank(realName)) {
			throw new BusinessException("添加管理员失败;姓名为空");
		}
		if (isBlank(password)) {
			throw new BusinessException("添加管理员失败;密码为空");
		}
		if (isBlank(rePassword)) {
			throw new BusinessException("添加管理员失败;密码为空");
		}
		if (isBlank(roleId)) {
			throw new BusinessException("添加管理员失败;角色为空");
		}
		if (!password.equalsIgnoreCase(rePassword)) {
			throw new BusinessException("添加管理员失败;两次密码不一致");
		}
		AdminModel model = new AdminModel();
		model.setTime(new Date());
		model.setAccount(account);
		model.setRealName(realName);
		model.setPassword(PasswordEncryKit.encry(password));
		model.setEmail(email);
		model.setRemarks(remarks);
		model.setMobile(Convert.toLong(mobile));
		this.mapper.insertAdmin(model);
		long adminId = model.getId();
		String[] roleIds=roleId.split(",");
		for (int i = 0; i < roleIds.length; i++) {
			this.iAdminRoleService.setAdminRole(adminId, Convert.toLong(roleIds[i]));
		}
		return true;
	}
}
