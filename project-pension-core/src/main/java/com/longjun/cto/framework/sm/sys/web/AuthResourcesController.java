package com.longjun.cto.framework.sm.sys.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mapstruct.BeforeMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.longjun.cto.framework.sm.sys.entity.model.AuthResourcesModel;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleResourcesModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminView;
import com.longjun.cto.framework.sm.sys.entity.view.AuthResourcesView;
import com.longjun.cto.framework.sm.sys.service.IAuthResourcesService;
import com.longjun.cto.framework.sm.sys.service.IAuthRoleResourcesService;

import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSON;

@RequestMapping("/mgn/sys/authResources")
@Controller
public class AuthResourcesController extends SmBaseController{
	
	@Autowired
	IAuthResourcesService iAuthResourcesService;
	
	@Autowired
	IAuthRoleResourcesService iAuthRoleResourcesService;
	
	/**
	 * 左侧菜单
	 */
	@ResponseBody
	@RequestMapping(value = "/getLeftMenuData"  , method = {RequestMethod.GET , RequestMethod.POST})
	public JSONArray getLeftMenuData(HttpServletRequest request , HttpServletResponse response) {
		//后续做成通用的
    	String topMenuId = (String)request.getParameter("topMenuId");
    	AdminView adminView = currentAdmin();
//    	List<AuthResourcesView> rets = this.iAuthResourcesService.leftMenusByTopId(Convert.toLong(topMenuId,-1L));
    	List<AuthResourcesView> rets = this.iAuthResourcesService.leftMenusByTopId(Convert.toLong(topMenuId,-1L),adminView.getId());
    	JSONArray arr = new JSONArray();
    	if(rets == null) {
    		return arr;
    	}
    	arr.addAll(rets);
//    	JSONObject temJson = null;
//    	for(AuthResourcesView ret : rets) {
//    		temJson = new JSONObject();
//    		temJson.put("spread", false);
//    		temJson.put("title", ret.getName());
//    		temJson.put("href", ret.getUrl());
//    		temJson.put("id", ret.getId());
//    		temJson.put("icon", ret.getIcon());
//    		arr.add(temJson);
//    	}
    	return arr;
	}
	
	/**
	 * 获取所有菜单。主要在角色添加使用
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllMenus"  , method = {RequestMethod.GET , RequestMethod.POST})
	public JSONObject getAllMenus(HttpServletRequest request , HttpServletResponse response) {
		JSONObject result = new JSONObject();
    	String topMenuId = "0";
    	List<AuthResourcesView> rets = this.iAuthResourcesService.leftMenusByTopId(Convert.toLong(topMenuId,-1L));
    	JSONArray  menus = new JSONArray();
    	JSONObject json = null;
    	for(AuthResourcesView ret : rets) {
    		json = new JSONObject();
    		json.put("name", ret.getName());
    		json.put("value", ret.getId());
    		json.put("checked", false);
    		if(ret.getChildren() != null && ret.getChildren().size() >0 ) {
    			this.deepCmenus(json, ret);
    		}
    		menus.add(json);
    	}
    	result.put("code", 0);
    	result.put("msg", "获取菜单成功");
    	
    	JSONObject dataJson = new JSONObject();
    	dataJson.put("trees", menus);
    	result.put("data", dataJson);
    	return result;
	}
	
	void deepCmenus(JSONObject json ,AuthResourcesView rets) {
		if(rets.getChildren() == null || rets.getChildren().size() == 0)  {
			return;
		}
		JSONObject temp = null;
		JSONArray arr = new JSONArray();
		for(AuthResourcesView ret : rets.getChildren()) {
			temp = new JSONObject();
			temp.put("name", ret.getName());
			temp.put("value", ret.getId());
			temp.put("checked", false);
			arr.add(temp);
			if(ret.getChildren() != null && rets.getChildren().size() > 0) {
				this.deepCmenus(json, ret);
			}
		}
		json.put("list", arr);
	}
	

	/**
	 * 获取所有菜单。主要在角色添加使用
	 */
	@ResponseBody
	@RequestMapping(value = "/getOwnerAllMenus"  , method = {RequestMethod.GET , RequestMethod.POST})
	public JSONObject getOwnerAllMenus(long roleUseId) {
		JSONObject result = new JSONObject();
    	String topMenuId = "0";
    	List<AuthResourcesView> rets = this.iAuthResourcesService.leftMenusByTopId(Convert.toLong(topMenuId,-1L));
    	JSONArray  menus = new JSONArray();
    	JSONObject json = null;
    	Map<Long , AuthRoleResourcesModel> maps = this.iAuthRoleResourcesService.findMenusByRoleId(roleUseId);
    	for(AuthResourcesView ret : rets) {
    		json = new JSONObject();
    		json.put("name", ret.getName());
    		json.put("value", ret.getId());
    		json.put("checked", maps.get(ret.getId()) == null?false:true );
    		if(ret.getChildren() != null && ret.getChildren().size() >0 ) {
    			this.deepOwnerCmenus(json, ret , maps);
    		}
    		menus.add(json);
    	}
    	result.put("code", 0);
    	result.put("msg", "获取菜单成功");
    	
    	JSONObject dataJson = new JSONObject();
    	dataJson.put("trees", menus);
    	result.put("data", dataJson);
    	return result;
	}
	
	void deepOwnerCmenus(JSONObject json ,AuthResourcesView rets, Map<Long , AuthRoleResourcesModel> maps) {
		if(rets.getChildren() == null || rets.getChildren().size() == 0)  {
			return;
		}
		JSONObject temp = null;
		JSONArray arr = new JSONArray();
		for(AuthResourcesView ret : rets.getChildren()) {
			temp = new JSONObject();
			temp.put("name", ret.getName());
			temp.put("value", ret.getId());
			temp.put("checked", maps.get(ret.getId()) == null?false:true);
			arr.add(temp);
			if(ret.getChildren() != null && rets.getChildren().size() > 0) {
				this.deepOwnerCmenus(json, ret,maps);
			}
		}
		json.put("list", arr);
	}
	
	

}
