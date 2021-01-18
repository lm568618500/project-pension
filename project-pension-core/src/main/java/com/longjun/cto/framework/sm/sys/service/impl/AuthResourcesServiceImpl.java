package com.longjun.cto.framework.sm.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.enums.ErrorTableEnum;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.module.base.service.BaseServiceImpl;
import com.google.common.collect.Maps;
import com.longjun.cto.framework.sm.sys.entity.dto.AuthResourcesDto;
import com.longjun.cto.framework.sm.sys.entity.model.AuthResourcesModel;
import com.longjun.cto.framework.sm.sys.entity.view.AuthResourcesView;
import com.longjun.cto.framework.sm.sys.entity.view.ShowMenuView;
import com.longjun.cto.framework.sm.sys.mapper.AuthResourcesMapper;
import com.longjun.cto.framework.sm.sys.service.IAuthResourcesService;

/**
 * 资源业务实现
 * @author yangxuan
 * @date 2018年11月5日 下午5:19:56
 */
@Service
public class AuthResourcesServiceImpl extends BaseServiceImpl<AuthResourcesMapper , AuthResourcesModel> implements IAuthResourcesService{
	
	@Autowired
	AuthResourcesMapper authResourcesMapper;

	@Override
	public Long saveModel(AuthResourcesModel model) throws BusinessException {
		try {
			return this.authResourcesMapper.saveModel(model);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public AuthResourcesView getById(long id) throws BusinessException {
		try {
			return this.authResourcesMapper.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public boolean del(long id, long operaterId) throws BusinessException {
		try {
			return this.authResourcesMapper.del(id) > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public boolean setResInfo(AuthResourcesModel model, long operaterId) throws BusinessException {
		try {
			return this.authResourcesMapper.setResInfo(model) > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public PageUtils<AuthResourcesView> getByPage(AuthResourcesDto dto) throws BusinessException {
		try {
			startPage(dto);
			List<AuthResourcesView> ret = this.authResourcesMapper.getByPage(dto);
			return new PageUtils<AuthResourcesView>(ret);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(ErrorTableEnum.G0000500);
		}
	}

	@Override
	public List<AuthResourcesView> listAll() throws BusinessException {
		EntityWrapper warpper = new EntityWrapper<>();
		warpper.eq("status", USE);
		List<AuthResourcesModel> models = this.selectList(warpper);
		List<AuthResourcesView> ret = new ArrayList<AuthResourcesView>();
		for(AuthResourcesModel model : models){
			ret.add(new AuthResourcesView(model));
		}
		return ret;
	}

	@Override
	public AuthResourcesView getByUrl(String uri) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("url", uri);
		return selectOneCondition(ew, AuthResourcesView.class);
	}

	@Override
	public List<ShowMenuView> getShowMenuByUser(Long id) throws BusinessException {
		Map<String,Object> map = Maps.newHashMap();
        map.put("userId",id);
        map.put("parentId",null);
        try {
			return this.authResourcesMapper.selectShowMenuByUser(map);
		} catch (Exception e) {
			e.printStackTrace();
			throw handleBusinessException(e);
		}
	}

	@Override
	public List<AuthResourcesModel> topMenus(long adminId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.where(" parent_id=0 AND id IN ( select resources_id from t_auth_role_resource WHERE `status`=1 and role_id in( SELECT role_id FROM t_admin_role WHERE admin_id = "+adminId+" AND STATUS = 1) ) and status=1 and is_show=1").orderBy("sort");
		List<AuthResourcesModel> rets = super.selectList(ew);
		return rets;
	}

	@Override
	public List<AuthResourcesView> leftMenusByTopId(long topId) throws BusinessException {
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("parent_id", topId).eq("status", 1).eq("is_show", 1).eq("type", 1).orderBy("sort");
		//顶部菜单s
		List<AuthResourcesView> rets = super.selectListCondition(ew, AuthResourcesView.class);
		for(AuthResourcesView ret : rets ) {
			ret.setChildren(this.deepMenus(ret));
		}
		return rets;
	}
	
	List<AuthResourcesView> deepMenus(AuthResourcesView menus){
		EntityWrapper ew = new EntityWrapper<>();
		ew.eq("parent_id", menus.getId()).eq("status", 1).eq("is_show", 1).eq("type", 1).orderBy("sort");
		List<AuthResourcesView> rets = super.selectListCondition(ew, AuthResourcesView.class);
		if(rets  == null) {
		}else {
			menus.setSpread(false);
			menus.setChildren(rets);
			for(AuthResourcesView v : rets) {
				this.deepMenus(v);
			}
		}
		return rets;
	}

	@Override
	public List<AuthResourcesView> leftMenusByTopId(long topId, Long adminId) throws BusinessException {
		Map<String,Object> params = new HashMap<>();
		params.put("parent_id", topId);
		params.put("admin_id", adminId);
		List<AuthResourcesView> rets = this.authResourcesMapper.listTopByAdminId(params);
		for(AuthResourcesView ret : rets ) {
			ret.setChildren(this.deepMenus(ret));
		}
		return rets;
	}
	
	List<AuthResourcesView> deepMenus(AuthResourcesView menus , Long adminId){
//		EntityWrapper ew = new EntityWrapper<>();
//		ew.eq("parent_id", menus.getId()).eq("status", 1).eq("is_show", 1).eq("type", 1).orderBy("sort");
//		List<AuthResourcesView> rets = super.selectListCondition(ew, AuthResourcesView.class);
		Map<String,Object> params = new HashMap<>();
		params.put("parent_id", menus.getId());
		params.put("admin_id", adminId);
		List<AuthResourcesView> rets = this.authResourcesMapper.listTopByAdminId(params);
		if(rets  == null) {
		}else {
			menus.setSpread(false);
			menus.setChildren(rets);
			for(AuthResourcesView v : rets) {
				this.deepMenus(v);
			}
		}
		return rets;
	}

}
