package com.longjun.cto.framework.sm.sys.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.sys.annotation.Log;
import com.longjun.cto.framework.sm.sys.entity.dto.AuthRoleDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AuthRoleModifyDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AuthRoleSaveDto;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleModel;
import com.longjun.cto.framework.sm.sys.entity.view.AuthRoleView;
import com.longjun.cto.framework.sm.sys.service.IAuthRoleService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;

/**
 * AuthRole Controller
 * @author yangxuan
 * @date 2019-04-07 03:17:44
 */
@RequestMapping("/mgn/sys/authRole")
@Controller
public class AuthRoleController extends StandardBaseController {

	@Autowired
	IAuthRoleService iAuthRoleService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequiresPermissions("sys:authRole:authRoleListInit")
	@RequestMapping(value = "/authRoleListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView authRoleListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/authRole/authRoleListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/authRoleAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView authRoleAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/authRole/authRoleAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/authRoleEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView authRoleEditInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/authRole/authRoleEditInit");
		AuthRoleView ret = this.iAuthRoleService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/authRoleShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView authRoleShowInit(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/authRole/authRoleShowInit");
		AuthRoleView ret = this.iAuthRoleService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<AuthRoleView>> getByPage(AuthRoleDto dto){
		PageUtils<AuthRoleView> ret = this.iAuthRoleService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<AuthRoleView> getViewById(long id){
		AuthRoleView ret = this.iAuthRoleService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<AuthRoleModel> findModelById(long id){
		AuthRoleModel ret = this.iAuthRoleService.findModelById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 停用
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 2000000L)
	@ResponseBody
	@RequestMapping(value = "/stop" , method = {RequestMethod.POST})
	public ApiResult stop(long id){
		Boolean ret = this.iAuthRoleService.stop(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 开启
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 2000001L)
	@ResponseBody
	@RequestMapping(value = "/start" , method = {RequestMethod.POST})
	public ApiResult start(long id ){
		Boolean ret = this.iAuthRoleService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存 
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 2000002L)
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel( AuthRoleSaveDto authRoleSaveDto){
		log.info("角色添加 - > [{}]" , JSONObject.toJSONString(authRoleSaveDto));
		this.iAuthRoleService.saveModel(authRoleSaveDto);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 2000003L)
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(AuthRoleModifyDto model){
		this.iAuthRoleService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 2000004L)
	@ResponseBody
	@RequestMapping(value = "/del" , method = {RequestMethod.POST})
	public ApiResult del(long id){
		Boolean ret = this.iAuthRoleService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
