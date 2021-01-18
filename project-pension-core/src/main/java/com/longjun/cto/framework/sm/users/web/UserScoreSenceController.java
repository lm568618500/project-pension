package com.longjun.cto.framework.sm.users.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.eims.cto.framework.standard.base.StandardBaseController;
import com.longjun.cto.framework.sm.users.entity.dto.UserScoreSenceDto;
import com.longjun.cto.framework.sm.users.entity.dto.UserScoreSenceModifyDto;
import com.longjun.cto.framework.sm.users.entity.model.UserScoreSenceModel;
import com.longjun.cto.framework.sm.users.entity.view.UserScoreSenceView;
import com.longjun.cto.framework.sm.users.service.IUserScoreSenceService;

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
 * UserScoreSence Controller
 * @author yangxuan
 * @date 2019-07-01 05:05:46
 */
@RequestMapping("/mgn/sm/users/userScoreSence")
@Controller
public class UserScoreSenceController extends StandardBaseController {

	@Autowired
	IUserScoreSenceService iUserScoreSenceService;
	
	/**
	 * 列表渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userScoreSenceListInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userScoreSenceListInit() {
		ModelAndView model = getModelAndView("/mgn/sm/users/userScoreSence/userScoreSenceListInit");
		return model;
	}
	
	/**
	 * 新增渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userScoreSenceAddInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userScoreSenceAddInit() {
		ModelAndView model = getModelAndView("/mgn/sm/users/userScoreSence/userScoreSenceAddInit");
		return model;
	}
	
	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userScoreSenceEditInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userScoreSenceEditInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/users/userScoreSence/userScoreSenceEditInit");
		UserScoreSenceView ret = this.iUserScoreSenceService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}

	/**
	 * 编辑渲染页面
	 * @return
	 */
	@RequestMapping(value = "/userScoreSenceShowInit" , method = {RequestMethod.POST , RequestMethod.GET})
	public ModelAndView userScoreSenceShowInit(Long id) {
		ModelAndView model = getModelAndView("/mgn/sm/users/userScoreSence/userScoreSenceShowInit");
		UserScoreSenceView ret = this.iUserScoreSenceService.findViewById(id);
		model.addObject("view", ret);
		return model;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getByPage" , method = {RequestMethod.POST ,RequestMethod.GET})
	public ActionResult<PageUtils<UserScoreSenceView>> getByPage(UserScoreSenceDto dto){
		PageUtils<UserScoreSenceView> ret = this.iUserScoreSenceService.getByPage(dto);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询View数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getViewById" , method = {RequestMethod.GET})
	public ActionResult<UserScoreSenceView> getViewById(Long id){
		UserScoreSenceView ret = this.iUserScoreSenceService.findViewById(id);
		return ActionResult.ok(ret); 
	}
	
	/**
	 * 查询Model数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getModelById" , method = {RequestMethod.GET})
	public ActionResult<UserScoreSenceModel> findModelById(Long id){
		UserScoreSenceModel ret = this.iUserScoreSenceService.findModelById(id);
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
		Boolean ret = this.iUserScoreSenceService.stop(id);
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
		Boolean ret = this.iUserScoreSenceService.start(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
	/**
	 * 保存
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveModel" , method = {RequestMethod.POST})
	public ApiResult saveModel(UserScoreSenceModel model){
		this.iUserScoreSenceService.saveModel(model);
		return ApiResult.instance().ok("ret" , true); 
	}
	
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/modify" , method = {RequestMethod.POST})
	public ApiResult modify(UserScoreSenceModifyDto model){
		this.iUserScoreSenceService.modify(model);
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
		Boolean ret = this.iUserScoreSenceService.del(id);
		return ApiResult.instance().ok("ret" , ret); 
	}
	
}
