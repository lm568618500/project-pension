package com.longjun.cto.framework.sm.users.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.users.entity.dto.UserDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserModel;
import com.longjun.cto.framework.sm.users.entity.view.UserView;
import com.longjun.cto.framework.sm.users.service.IUserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.eims.cto.framework.common.base.page.PageUtils;
import com.eims.cto.framework.common.base.ret.ActionResult;
import com.eims.cto.framework.common.base.ret.ApiResult;

import java.lang.Long;

/**
 * User Controller
 * 
 * @author yangxuan
 * @date 2019-06-19 02:29:35
 */
@RequestMapping("/mgn/sm/users/user")
@Controller
public class UserController extends StandardBaseController {

	@Autowired
	IUserService iUserService;

	/**
	 * 列表渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/userListInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView userListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/users/user/userListInit");
		return model;
	}

	/**
	 * 新增渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/userAddInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView userAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/users/user/userAddInit");
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/userEditInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView userEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/users/user/userEditInit");
		UserView ret = this.iUserService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/userShowInit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView userShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/users/user/userShowInit");
		UserView ret = this.iUserService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage", method = { RequestMethod.POST, RequestMethod.GET })
	public ActionResult<PageUtils<UserView>> getByPage(UserDto dto) {
		PageUtils<UserView> ret = this.iUserService.getByPage(dto);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询View数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById", method = { RequestMethod.GET })
	public ActionResult<UserView> getViewById(Long id) {
		UserView ret = this.iUserService.findViewById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 查询Model数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById", method = { RequestMethod.GET })
	public ActionResult<UserModel> findModelById(Long id) {
		UserModel ret = this.iUserService.findModelById(id);
		return ActionResult.ok(ret);
	}

	/**
	 * 停用
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/stop", method = { RequestMethod.POST })
	public ApiResult stop(Long id) {
		Boolean ret = this.iUserService.stop(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 开启
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/start", method = { RequestMethod.POST })
	public ApiResult start(Long id) {
		Boolean ret = this.iUserService.start(id);
		return ApiResult.instance().ok("ret", ret);
	}

	/**
	 * 保存
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel", method = { RequestMethod.POST })
	public ApiResult saveModel(UserModel model) {
		this.iUserService.saveModel(model);
		return ApiResult.instance().ok("ret", true);
	}

	/**
	 * 修改
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify", method = { RequestMethod.POST })
	public ApiResult modify(UserModifyDto model) {
		this.iUserService.modify(model);
		return ApiResult.instance().ok("ret", true);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del", method = { RequestMethod.POST })
	public ApiResult del(Long id) {
		Boolean ret = this.iUserService.del(id);
		return ApiResult.instance().ok("ret", ret);
	}

}
