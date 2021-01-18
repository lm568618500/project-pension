package com.longjun.cto.framework.sm.users.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.users.entity.dto.UserAttributeDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserAttributeModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserAttributeModel;
import com.longjun.cto.framework.sm.users.entity.view.UserAttributeView;
import com.longjun.cto.framework.sm.users.service.IUserAttributeService;

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
import java.util.List;

/**
 * UserAttribute Controller
 * @author qiujunbo
 * @date 2019-07-05 05:36:06
 */
@RequestMapping("/mgn/sm/users/userAttribute")
@Controller
public class UserAttributeController extends StandardBaseController {

	@Autowired
	IUserAttributeService iUserAttributeService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userAttributeListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userAttributeListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/users/userAttribute/userAttributeListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userAttributeAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userAttributeAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/users/userAttribute/userAttributeAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userAttributeEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userAttributeEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/users/userAttribute/userAttributeEditInit");
		UserAttributeView ret = this.iUserAttributeService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userAttributeShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userAttributeShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/users/userAttribute/userAttributeShowInit");
		UserAttributeView ret = this.iUserAttributeService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<UserAttributeView>> getByPage(UserAttributeDto dto){
		PageUtils<UserAttributeView> ret = this.iUserAttributeService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<UserAttributeView> getViewById(Long id){
		UserAttributeView ret = this.iUserAttributeService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<UserAttributeModel> findModelById(Long id){
		UserAttributeModel ret = this.iUserAttributeService.findModelById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 停用
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/stop" , method = {RequestMethod.POST})
	public ApiResult stop(Long id){
		Boolean ret = this.iUserAttributeService.stop(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 开启
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/start" , method = {RequestMethod.POST})
	public ApiResult start(Long id ){
		Boolean ret = this.iUserAttributeService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(UserAttributeModel model){
		this.iUserAttributeService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(UserAttributeModifyDto model){
		this.iUserAttributeService.modify(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/del" , method = {RequestMethod.POST})
	public ApiResult del(Long id){
		Boolean ret = this.iUserAttributeService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
