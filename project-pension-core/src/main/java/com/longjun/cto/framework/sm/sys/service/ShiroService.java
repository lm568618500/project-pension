package com.longjun.cto.framework.sm.sys.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.conf.SysSetting;
import com.longjun.cto.framework.sm.sys.entity.model.AdminTokenModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminView;
import com.longjun.cto.framework.sm.sys.entity.view.AuthResourcesView;

import cn.hutool.core.util.StrUtil;

@Service
public class ShiroService {
	
	static Logger LOG = LoggerFactory.getLogger(ShiroService.class);

	@Autowired
	IAdminService iAdminService;
	
	@Autowired
	IAdminTokenService iAdminTokenService;
	
	@Autowired
	IAuthResourcesService iAuthResourcesService;
	
	/**
	 * 通过ID查询管理员视图信息
	 * @param userId
	 * @return
	 */
	public AdminView queryUser(long userId){
		AdminView ret = this.iAdminService.getById(userId);
		if(ret == null) {
			LOG.error("通过ID查询管理员信息失败，未查询到ID[{}]管理员信息" , userId);
			return null;
		}
		return ret;
	}
	
	/**
	 * 通过token查询管理员登录访问信息
	 * @param accessToken
	 * @return
	 */
	public AdminTokenModel queryByToken(String accessToken) {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("token", accessToken).eq("status", 1).eq("is_del", 0);
		AdminTokenModel ret = this.iAdminTokenService.selectOne(ew);
		if(ret == null) {
			LOG.error("通过Token 查询AdminToken未查询到记录, token [{}]" , accessToken);
			return null;
		}
		return ret;
	}
	
	
	/**
	 * 通过token查询管理员登录访问信息
	 * @param accessToken
	 * @return
	 */
	public void refreshToken( AdminTokenModel tokenEntity) {
		Date now = new Date();
		Date expireTime = new Date(now.getTime() + SysSetting.PASSPORT_EXPIRETIME);
		tokenEntity.setExpireTime(expireTime);
		tokenEntity.setLastupdate(new Date());
		this.iAdminTokenService.updateById(tokenEntity);
	}

	/**
	 * 通过用户查询权限
	 * @param userId
	 * @return
	 */
	public Set<String> getUserPermissions(Long userId) {
		//目前查询所有。测试使用
		List<AuthResourcesView> rets = this.iAuthResourcesService.listAll();
		if(rets == null) {
			return new HashSet<>();
		}
		Set<String> roles = new HashSet<>();
		for(AuthResourcesView ret : rets) {
			if(StrUtil.isBlank(ret.getPermission())) {
				continue;
			}
			roles.add(ret.getPermission());
		}
		return roles;
	}
	
}
