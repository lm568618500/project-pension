package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleResourcesModel;
import com.longjun.cto.framework.sm.sys.entity.view.AuthRoleResourcesView;
import com.longjun.cto.framework.sm.sys.mapper.AuthRoleResourcesMapper;
import com.longjun.cto.framework.sm.sys.service.IAuthRoleResourcesService;

/**
 * 鉴权资源业务实现
 * @author yangxuan
 * @date 2018年11月6日 下午11:25:50
 */
@Service
public class AuthRoleResourcesServiceImpl extends BaseServiceImpl<AuthRoleResourcesMapper, AuthRoleResourcesModel>
	implements IAuthRoleResourcesService{
	
	@Autowired
	AuthRoleResourcesMapper authRoleResourcesMapper; 

	@Cacheable(value = "buz-cache-standard-com.eims.cto.framework.project.ds.sys.user.service.impl.AuthRoleResourcesServiceImpl"
			+ "",keyGenerator = "keyGenerator",unless = "#result == null")
	@Override
	public List<AuthRoleResourcesView> getListByAdminId(long adminId) throws BusinessException {
		try {
			return this.authRoleResourcesMapper.getListByAdminId(adminId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Cacheable(value = "buz-cache-standard-com.eims.cto.framework.project.ds.sys.user.service.impl.AuthRoleResourcesServiceImpl"
			+ "",keyGenerator = "keyGenerator",unless = "#result == null")
	@Override
	public AuthRoleResourcesView getByAdminIdAndUrl(long adminId, String url) throws BusinessException {
		try {
			return this.authRoleResourcesMapper.getByAdminIdAndUrl(adminId, url);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Cacheable(value = "buz-cache-standard-buz-cache-standard-com.eims.cto.framework.project.ds.sys.user.service.impl.AuthRoleResourcesServiceImpl"
			+ "",keyGenerator = "keyGenerator",unless = "#result == null")
	@Override
	public List<AuthRoleResourcesView> menus(long adminId) throws BusinessException {
		List<AuthRoleResourcesView> allMenus = this.getListByAdminId(adminId);
		
		List<AuthRoleResourcesView> rootMenus = new ArrayList<AuthRoleResourcesView>();
		for(AuthRoleResourcesView m : allMenus){
			//一级菜单
			if(m.getType() == 1 && m.getParentId() == 0){
				rootMenus.add(m);
			}
		}
		//遍历一级菜单
		for(AuthRoleResourcesView entity : rootMenus){
			entity.setcMenus(childMenus(allMenus, entity.getResourcesId()));
		}
		return rootMenus;
	}
	
	/**
	 * 获取子节点
	 * @param menus 所有菜单列表
	 * @param parentId 父节点id
	 * @return
	 */
	private List<AuthRoleResourcesView> childMenus(List<AuthRoleResourcesView> menus , long parentId){
		List<AuthRoleResourcesView> cMenu = new ArrayList<AuthRoleResourcesView>();
		for(AuthRoleResourcesView entity : menus){
			if(entity.getType() != 1){
				continue;
			}
			if(parentId == entity.getParentId()){
				cMenu.add(entity);
			}
		}
		for(AuthRoleResourcesView c :  cMenu){
			if(c.getType() != 1){
				continue;
			}
			c.setcMenus(childMenus(menus, c.getResourcesId()));
		}
		if(cMenu.size() == 0){
			return new ArrayList<>();
		}
		return cMenu;
	}

	@Override
	public Long saveModel(AuthRoleResourcesModel model) throws BusinessException {
		try {
			this.authRoleResourcesMapper.saveModel(model);
			return model.getId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public boolean setStatusByRoleId(long roleId, int status) throws BusinessException {
		try {
			return this.authRoleResourcesMapper.setStatusByRoleId(roleId, status) > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public boolean setStatusByResourcesId(long resourcesId, int status) throws BusinessException {
		try {
			return this.authRoleResourcesMapper.setStatusByResourcesId(resourcesId, status) > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public void saveModel(List<AuthRoleResourcesModel> model) throws BusinessException {
 		this.insertBatch(model);
	}

	@Override
	public Map<Long, AuthRoleResourcesView> mapByRoleId(long roleId) throws BusinessException {
		EntityWrapper wrapper = new EntityWrapper<>();
		wrapper.eq("status", USE)
		.eq("roleId", roleId);
		List<AuthRoleResourcesModel> models = this.selectList(wrapper);
//		List<AuthRoleResourcesView> views = super.modelListToViewLists(models, AuthRoleResourcesView.class);
		List<AuthRoleResourcesView> views = new ArrayList<AuthRoleResourcesView>();
		for(AuthRoleResourcesModel model : models){
			views.add(new AuthRoleResourcesView(model));
		}
		Map<Long, AuthRoleResourcesView> ret = new HashMap<Long, AuthRoleResourcesView>();
		for(AuthRoleResourcesView view : views){
			ret.put(view.getResourcesId(), view);
		}
		return ret;
	}

	@Override
	public boolean controlModel(AuthRoleResourcesModel model) throws BusinessException {
		if(model == null){
			return true;
		}
		EntityWrapper wrapper = new EntityWrapper();
		wrapper.eq("roleId", model.getRoleId()).eq("resourcesId", model.getResourcesId());
		AuthRoleResourcesModel ret = this.selectOne(wrapper);
		if(ret == null){
			this.insert(model);
			return true;
		}else{
			ret.setStatus(USE);
			ret.setLastupdate(new Date());
			this.updateById(ret);
			return true;
		}
	}

	@Cacheable(value = "buz-cache-standard-com.eims.cto.framework.project.ds.sys.user.service.impl.AuthRoleResourcesServiceImpl"
			+ "",keyGenerator = "keyGenerator",unless = "#result == null")
	@Override
	public List<AuthRoleResourcesView> topMenus(long adminId) throws BusinessException {
		List<AuthRoleResourcesView> allMenus = this.getListByAdminId(adminId);
		List<AuthRoleResourcesView> rootMenus = new ArrayList<AuthRoleResourcesView>();
		for(AuthRoleResourcesView m : allMenus){
			//一级菜单
			if(m.getType() == 1 && m.getParentId() == 0){
				rootMenus.add(m);
			}
		}
		List<AuthRoleResourcesView> cItems = null;
		for(AuthRoleResourcesView r : rootMenus){
			cItems = this.topChidrenMenus(adminId, r.getResourcesId());
			if(cItems != null && cItems.size() > 0){
				for(AuthRoleResourcesView authRoleResourcesView:cItems){
					if(StringUtils.isNotBlank(authRoleResourcesView.getResUrl()) && !"#".equals(authRoleResourcesView.getResUrl())){
						r.setResUrl(authRoleResourcesView.getResUrl());
						break;
					}
				}
			}
		}
		
		return rootMenus;
	}

	@Override
	public List<AuthRoleResourcesView> topChidrenMenus(long adminId, long parentId) throws BusinessException {
		if(parentId == 0L){
			return new ArrayList<AuthRoleResourcesView>();
		}
		List<AuthRoleResourcesView> allMenus = this.getListByAdminId(adminId);
		
		List<AuthRoleResourcesView> rootMenus = new ArrayList<AuthRoleResourcesView>();
		for(AuthRoleResourcesView m : allMenus){
			//一级菜单
			if(m.getType() == 1 && m.getParentId() == parentId){
				rootMenus.add(m);
			}
		}
		//遍历一级菜单
		for(AuthRoleResourcesView entity : rootMenus){
			entity.setcMenus(childMenus(allMenus, entity.getResourcesId()));
		}
		return rootMenus;
	}

	@Override
	public Map<Long, AuthRoleResourcesModel> findMenusByRoleId(long roleId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("role_id", roleId).eq("status", 1);
		List<AuthRoleResourcesModel> rets = super.selectList(ew);
		if(rets == null) {
			return new HashMap<>();
		}
		Map<Long ,AuthRoleResourcesModel > maps = new HashMap<>();
		for(AuthRoleResourcesModel ret : rets) {
			maps.put(ret.getResourcesId(), ret);
		}
		return maps;
	}

	@Override
	public void initAuthRolesByRoleId(long roleId) throws BusinessException {
		this.authRoleResourcesMapper.updateInitAuthRolesByRoleId(roleId);
	}

}
