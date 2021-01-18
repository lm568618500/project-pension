package com.longjun.cto.framework.sm.sys.web;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.eims.cto.framework.common.base.exception.BusinessException;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;
import com.longjun.cto.framework.sm.sys.annotation.Log;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminModifyPasswordDto;
import com.longjun.cto.framework.sm.sys.entity.dto.AdminMotifyDto;
import com.longjun.cto.framework.sm.sys.entity.model.AdminRoleModel;
import com.longjun.cto.framework.sm.sys.entity.model.AuthRoleModel;
import com.longjun.cto.framework.sm.sys.entity.view.AdminView;
import com.longjun.cto.framework.sm.sys.entity.view.ShowMenuView;
import com.longjun.cto.framework.sm.sys.service.IAdminOperRecordService;
import com.longjun.cto.framework.sm.sys.service.IAdminRoleService;
import com.longjun.cto.framework.sm.sys.service.IAdminService;
import com.longjun.cto.framework.sm.sys.service.IAdminTokenService;
import com.longjun.cto.framework.sm.sys.service.IAuthResourcesService;
import com.longjun.cto.framework.sm.sys.service.IAuthRoleService;

import io.swagger.annotations.ApiOperation;

/**
 * 管理员Controller
 * 
 * @author lp
 * @date 2018-12-20 20:10:49
 */
@RequestMapping("/mgn/sys/admin")
@Controller
public class AdminController extends SmBaseController {

	@Autowired
	IAdminService iAdminService;

	@Autowired
	IAdminOperRecordService iAdminOperRecordService;

	@Autowired
	IAuthResourcesService iAuthResourcesService;

	@Autowired
	IAuthRoleService iAuthRoleService;

	@Autowired
	IAdminTokenService iAdminTokenService;
	@Autowired
	IAdminRoleService iAdminRoleService;
	/**
	 * 列表页面初始化
	 * 
	 * @return
	 */
	@ApiOperation(value = "列表页面初始化", notes = "")
	@RequestMapping(value = "/adminInitPage", method = { RequestMethod.GET })
	public ModelAndView AdminInitPage() {
		ModelAndView model = getModelAndView("/mgn/sys/admin/adminInitPage");
		return model;
	}
	
	/**
	 * 列表页面初始化
	 * 
	 * @return
	 */
	@ApiOperation(value = "列表页面初始化", notes = "")
	@RequestMapping(value = "/adminSingle", method = { RequestMethod.GET })
	public ModelAndView AdminSingle() {
		ModelAndView model = getModelAndView("/mgn/sys/admin/adminSingle");
		return model;
	}
	
	/**
	 * 列表页面初始化
	 * 
	 * @return
	 */
	@ApiOperation(value = "列表页面初始化", notes = "")
	@RequestMapping(value = "/adminMultiple", method = { RequestMethod.GET })
	public ModelAndView AdminMultiple() {
		ModelAndView model = getModelAndView("/mgn/sys/admin/adminMultiple");
		return model;
	}
	
	/**
	 * 新增页面初始化
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addAdminInitPage", method = { RequestMethod.GET })
	public ModelAndView addAdminInitPage() {
		ModelAndView model = getModelAndView("/mgn/sys/admin/addAdminInitPage");
		// 可用角色列表
		List<AuthRoleModel> roles = this.iAuthRoleService.listByUse();
		model.addObject("roles", roles);
		return model;
	}

	/**
	 * 编辑页面初始化
	 * 
	 * @return
	 */
	@RequestMapping(value = "/editAdminInitPage", method = { RequestMethod.GET })
	public ModelAndView editAdminInitPage(long id) {
		ModelAndView model = getModelAndView("/mgn/sys/admin/editAdminInitPage");
		AdminView view = this.iAdminService.getById(id);
		List<AuthRoleModel> roleList = iAuthRoleService.listByUse1(id);
		EntityWrapper<AdminRoleModel> roleWrapper=new EntityWrapper<AdminRoleModel>();
		roleWrapper.eq("admin_id", id);
		roleWrapper.eq("status", 1);
		List<AdminRoleModel> adminRoleList=this.iAdminRoleService.selectList(roleWrapper);
		model.addObject("roleList", roleList);
		model.addObject("view", view);
		model.addObject("adminRoleList", adminRoleList);
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/getById/{id}", method = { RequestMethod.GET })
	public ActionResult<AdminView> getById(@PathVariable("id") long id) {
		AdminView ret = this.iAdminService.getById(id);
		return ActionResult.ok(ret);
	}

	@ResponseBody
	@RequestMapping(value = "/setStatusById", method = { RequestMethod.POST })
	public ActionResult<Boolean> setStatusById(long id, int status) {
		Boolean ret = this.iAdminService.setStatusById(id, status);
		return ActionResult.ok(ret);
	}

	@Log(eventUseId = 2001000L)
	@ResponseBody
	@RequestMapping(value = "/saveModel", method = { RequestMethod.POST })
	public ActionResult<Boolean> saveModel(@RequestParam(required = true) String account,
			@RequestParam(required = true) String realName, @RequestParam(required = true) String jobNumber,
			@RequestParam(required = true) long mobile, @RequestParam(required = true) long roleid,
			@RequestParam(required = true) int status, @RequestParam(required = true) String password,
			@RequestParam(required = true) int type) {
		boolean f = this.iAdminService.saveModel(account, realName, jobNumber, mobile, roleid, status, password, type);
//		if (f) {// 添加操作日志
//			iAdminOperRecordService.saveModel(currentAdmin().getId(), "权限", "管理员管理", "添加账号为：" + account + " 的管理员", 1);
//		}
		return ActionResult.ok(f);
	}

	@Log(eventUseId = 2001001L)
	@ResponseBody
	@RequestMapping(value = "/modify", method = { RequestMethod.POST })
	public ActionResult<Boolean> modify(@RequestParam(required = true) long id,
			@RequestParam(required = true) String account, @RequestParam(required = true) String realName,
			@RequestParam(required = true) String jobNumber, @RequestParam(required = true) long mobile,
			@RequestParam(required = true) long roleid, @RequestParam(required = true) int status,
			@RequestParam(required = true) String password, @RequestParam(required = true) int type) {
		boolean f = this.iAdminService.modify(id, account, realName, jobNumber, mobile, roleid, status, password, type);

		return ActionResult.ok(f);
	}

	/**
	 * 修改管理员信息
	 * 
	 * @param dto
	 * @return
	 */
	@Log(eventUseId = 2001002L)
	@ResponseBody
	@RequestMapping(value = "/modifyModel", method = { RequestMethod.POST })
	public ActionResult<Boolean> modifyModel(AdminMotifyDto dto) {
		boolean f = this.iAdminService.modify(dto);
		return ActionResult.ok(f);
	}

	@Log(eventUseId = 2001003L)
	@ResponseBody
	@RequestMapping(value = "/start", method = { RequestMethod.POST })
	public ActionResult<Boolean> start(long id) {
		Boolean ret = this.iAdminService.start(id);
		return ActionResult.ok(ret);
	}

	@Log(eventUseId = 2001004L)
	@ResponseBody
	@RequestMapping(value = "/stop", method = { RequestMethod.POST })
	public ActionResult<Boolean> stop(long id) {
		Boolean ret = this.iAdminService.stop(id);
		return ActionResult.ok(ret);
	}

	@ResponseBody
	@RequestMapping(value = "/getByPage", method = { RequestMethod.POST, RequestMethod.GET })
	public ActionResult<PageUtils<AdminView>> getByPage(AdminDto dto) {
		PageUtils<AdminView> ret = this.iAdminService.getByPage(dto);
		for (AdminView admin:ret.getList()) {
			EntityWrapper<AdminRoleModel> roleWrappe=new EntityWrapper<AdminRoleModel>();
			roleWrappe.eq("admin_id", admin.getId()).eq("status", 1);
			List<AdminRoleModel> arList=this.iAdminRoleService.selectList(roleWrappe);
			String roleName="";
			for (AdminRoleModel ar:arList) {
				EntityWrapper<AuthRoleModel> arWrappe=new EntityWrapper<AuthRoleModel>();
				arWrappe.eq("use_id", ar.getRoleId()).eq("status", 1).eq("is_del", 0);
				AuthRoleModel arm=this.iAuthRoleService.selectOne(arWrappe);
				if(arm!=null){
					if(roleName==""){
						roleName=arm.getRolename();
					}else{
						roleName=roleName+","+arm.getRolename();;
					}
				}
			}
			admin.setRoleName(roleName);
		}
		return ActionResult.ok(ret);
	}

	/**
	 * （逻辑）删除/批量删除
	 * 
	 * @param id
	 * @return
	 */
	@Log(eventUseId = 2001005L)
	@ResponseBody
	@RequestMapping(value = "/deletes", method = { RequestMethod.POST })
	public ActionResult<Boolean> deletes(long[] id) {
		Integer ret = this.iAdminService.deletes(id);
		boolean f = false;
		if (ret > 0) {
			f = true;
			// 添加操作日志
			iAdminOperRecordService.saveModel(currentAdmin().getId(), "权限", "管理员管理",
					"删除了 [" + id.length + "] 条管理员记录 ，被删管理员记录id为：[" + Arrays.toString(id) + "]", 1);
		}

		return ActionResult.ok(f);
	}

	/***
	 * 获得用户所拥有的菜单列表
	 * 
	 * @return
	 */
	@GetMapping("/getUserMenu")
	@ResponseBody
	public List<ShowMenuView> getUserMenu() {
		AdminView adminView = currentAdmin();
		List<ShowMenuView> list = iAuthResourcesService.getShowMenuByUser(adminView.getId());
		return list;
	}

	/**
	 * 解锁管理员
	 * 
	 * @param adminId
	 * @return
	 */
	@Log(eventUseId = 2001006L)
	@ResponseBody
	@PostMapping("/unlock")
	public ApiResult unlock(@RequestParam(required = true, defaultValue = "-1") long adminId) {
		boolean ret = this.iAdminService.unlock(adminId);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 锁定管理员
	 * 
	 * @param adminId
	 * @return
	 */
	@Log(eventUseId = 2001007L)
	@ResponseBody
	@PostMapping("/lock")
	public ApiResult lock(@RequestParam(required = true, defaultValue = "-1") long adminId) {
		boolean ret = this.iAdminService.lock(adminId);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 删除管理员
	 * 
	 * @param adminId
	 * @return
	 */
	@Log(eventUseId = 2001008L)
	@ResponseBody
	@PostMapping("/del")
	public ApiResult del(@RequestParam(required = true, defaultValue = "-1") long adminId) {
		boolean ret = this.iAdminService.del(adminId);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 列表渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/adminListInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView adminListInit() {
		ModelAndView model = getModelAndView("/mgn/sys/admin/adminInitPage");
		return model;
	}

	/**
	 * 新增渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/adminAddInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView adminAddInit() {
		ModelAndView model = getModelAndView("/mgn/sys/admin/adminAddInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/adminEditInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView adminEditInit() {
		ModelAndView model = getModelAndView("/mgn/sys/admin/adminEditInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/adminShowInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView adminShowInit() {
		ModelAndView model = getModelAndView("/mgn/sys/admin/adminShowInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/adminChangePwdInit", method = { RequestMethod.GET })
	public ModelAndView adminChangePwdInit() {
		AdminView adminView = currentAdmin();
		ModelAndView model = getModelAndView("/mgn/sys/admin/adminChangePwdInit");
		model.addObject("adminView", adminView);
		return model;
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	@Log(eventUseId = 2001009L)
	@ResponseBody
	@RequestMapping(value = "/modifyPassword", method = { RequestMethod.POST })
	public ActionResult modifyPassword(AdminModifyPasswordDto dto, HttpServletRequest request) {
		AdminView adminView = currentAdmin();
		if (dto == null) {
			throw new BusinessException("修改密码失败;传入参数为空");
		}
		dto.setAdminId(adminView.getId());
		boolean ret = this.iAdminService.modifyPassword(dto);
		String token = request.getSession().getId();
		// iAdminTokenService.failureToken(token);
		return ActionResult.ok(ret);
	}

	/**
	 * 添加管理员
	 * 
	 * @return
	 */
	@Log(eventUseId = 2001010L)
	@ResponseBody
	@RequestMapping(value = "/addAdminAction", method = { RequestMethod.POST })
	public ActionResult addAdminAction(String account, String realName, String password, String rePassword,
			String email, String mobile, String roleId,String remarks) {
		AdminView adminView = currentAdmin();
		boolean ret = this.iAdminService.addAdminAction(account, realName, password, rePassword, email, mobile, roleId,remarks);
		return ActionResult.ok(ret);
	}

}
